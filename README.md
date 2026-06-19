EcoRide Pro — Anexo Técnico de Rendimiento

El documento explica, las decisiones de diseño y optimización
aplicadas en la evolución del sistema EcoRide hacia EcoRide Pro

---

## 1. Búsqueda de vehículos: de lista a HashMap

En la versión anterior del sistema, `EstacionAnclaje` guardaba los vehículos en una
`List<Vehiculo>`, y para encontrar uno por su patente había que recorrerla con un
`for`, comparando uno por uno hasta encontrar la coincidencia (o llegar al final sin
encontrarla). Esto es una búsqueda de complejidad **O(n)**: en el peor caso, el tiempo
que tarda crece de forma proporcional a la cantidad de vehículos. Con 100.000
vehículos registrados, en el peor caso se necesitan hasta 100.000 comparaciones.

Reemplazamos esa estructura por un `Map<String, Vehiculo>` (concretamente, un
`HashMap`), usando la patente como clave. Un `HashMap` no recorre nada para buscar:
calcula un valor numérico (un *hash*) a partir de la clave, y usa ese número para
saber directamente en qué posición interna de la tabla está guardado el valor. Por
eso, tanto insertar (`put`) como buscar (`get`) tienen complejidad **O(1)**: el tiempo
que tardan es constante, sin importar si hay 10 o 100.000 vehículos guardados.

En código, el cambio se ve así:

- Antes: `for (Vehiculo v : vehiculos) { if (v.getPatente().equals(patente)) ... }`
- Ahora: `return vehiculos.get(patente);`

Una sola línea, sin recorrido, porque toda la lógica de localización la resuelve
internamente la estructura de datos.

---

## 2. Deduplicación de alertas GPS: de bucles anidados a HashSet

Una forma intuitiva (pero ineficiente) de eliminar duplicados de una lista sería
comparar cada elemento contra todos los demás elementos ya procesados, usando un
bucle dentro de otro bucle. Esa solución tiene complejidad **O(n²)**: para una lista
de 10.000 reportes GPS, en el peor caso se realizarían hasta 100.000.000 de
comparaciones, lo cual bloquea innecesariamente el procesador.

En cambio, resolvimos la deduplicación con un `HashSet<CoordenadaGPS>`, recorriendo
la lista de reportes **una sola vez** con un único `for`. Al igual que con el
`HashMap`, el `HashSet` usa el *hash* de cada elemento para decidir, en tiempo
constante, si ya existe un elemento igual guardado. Si ya existe, simplemente no lo
agrega; si no existe, lo agrega. El resultado es un algoritmo de complejidad **O(n)**:
una sola pasada, sin comparar contra todo lo anterior.

Para que esto funcione correctamente, fue necesario sobreescribir los métodos
`equals()` y `hashCode()` en la clase `CoordenadaGPS`. Sin esa sobreescritura, Java
compara los objetos por su referencia en memoria (si son literalmente el mismo
objeto), y nunca detectaría que dos coordenadas con los mismos valores de latitud y
longitud representan, en realidad, el mismo punto GPS.

---

## 3. Ordenamiento de la flota: Comparable y Comparator en paralelo

La empresa necesita dos criterios de orden distintos para la flota: por prioridad de
carga (batería, de menor a mayor) y por costo base (tarifa, de mayor a menor). El
desafío de diseño es que ambos criterios deben poder aplicarse sobre la misma
colección de vehículos en memoria, sin que el uso de uno inhabilite o reemplace al
otro.

Resolvimos esto separando claramente dónde vive cada criterio. El de batería es el
**orden natural** del vehículo, así que `Vehiculo` implementa `Comparable<Vehiculo>`
con un único método `compareTo()`. El de tarifa es un criterio **externo**, así que lo
resolvimos con una clase aparte, `ComparadorPorTarifa`, que implementa
`Comparator<Vehiculo>` sin modificar la clase `Vehiculo` de ninguna forma.

Esta separación es justamente lo que permite que ambos criterios convivan "de forma
concurrente en memoria": los mismos objetos `Vehiculo`, sin clonarlos ni
modificarlos, pueden ordenarse de una forma u otra según se necesite en cada
momento:

- `Collections.sort(lista)` → usa el orden natural (Comparable, por batería)
- `Collections.sort(lista, new ComparadorPorTarifa())` → usa el orden externo
  (Comparator, por tarifa)

Ninguno de los dos mecanismos altera permanentemente el estado de los vehículos; cada
llamada a `Collections.sort()` simplemente reorganiza una lista en memoria según el
criterio indicado en ese momento. Por eso ambos criterios están siempre disponibles
al mismo tiempo, sobre la misma flota, sin necesidad de elegir uno de forma
permanente ni de tener estructuras duplicadas.

**Aclaración importante:** "concurrente" aquí no se refiere a hilos de ejecución
simultáneos (el sistema es puramente secuencial, sin concurrencia real,sino a que ambas capacidades de ordenamiento coexisten sobre los mismos
datos sin excluirse mutuamente.