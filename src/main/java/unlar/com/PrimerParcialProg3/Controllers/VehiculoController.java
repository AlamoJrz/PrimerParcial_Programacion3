package unlar.com.PrimerParcialProg3.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import unlar.com.PrimerParcialProg3.models.Vehiculo;
import unlar.com.PrimerParcialProg3.Dto.VehiculoResponseDTO;
import unlar.com.PrimerParcialProg3.service.AlquilerService;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final AlquilerService alquilerService;

    public VehiculoController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @GetMapping("/prioridad-carga")
    public ResponseEntity<List<VehiculoResponseDTO>> prioridadCarga() {
        List<Vehiculo> vehiculos = alquilerService.listarPorPrioridadCarga();
        return ResponseEntity.ok(convertirADTO(vehiculos));
    }

    @GetMapping("/tarifa-descendente")
    public ResponseEntity<List<VehiculoResponseDTO>> tarifaDescendente() {
        List<Vehiculo> vehiculos = alquilerService.listarPorTarifaDescendente();
        return ResponseEntity.ok(convertirADTO(vehiculos));
    }

    private List<VehiculoResponseDTO> convertirADTO(List<Vehiculo> vehiculos) {
        List<VehiculoResponseDTO> resultado = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            resultado.add(new VehiculoResponseDTO(
                v.getPatente(), v.getBateria(), v.getTarifabase(), v.getEstado().getNombre()
            ));
        }
        return resultado;
    }
}