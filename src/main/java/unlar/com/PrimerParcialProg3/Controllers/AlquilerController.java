package unlar.com.PrimerParcialProg3.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import unlar.com.PrimerParcialProg3.service.AlquilerService; // ← sin "s"
import java.util.Map;

@RestController
@RequestMapping("/api/alquileres")
public class AlquilerController {

    private final AlquilerService alquilerService;

    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @GetMapping("/desbloquear")
    public ResponseEntity<String> desbloquear(@RequestBody Map<String, String> body) {
        try {
            String resultado = alquilerService.desbloquear(
                body.get("idUsuario"),
                body.get("patente"),
                body.get("metodoPago")
            );
            return ResponseEntity.ok(resultado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}