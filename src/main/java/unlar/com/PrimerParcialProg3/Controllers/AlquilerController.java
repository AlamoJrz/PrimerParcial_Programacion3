package unlar.com.PrimerParcialProg3.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import unlar.com.PrimerParcialProg3.service.AlquilerService;
import unlar.com.PrimerParcialProg3.Dto.AlquilerResponseDTO;
import unlar.com.PrimerParcialProg3.Dto.ErrorResponseDTO;
import java.util.Map;

@RestController
@RequestMapping("/api/alquileres")
public class AlquilerController {

    private final AlquilerService alquilerService;

    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @GetMapping("/desbloquear")
    public ResponseEntity<?> desbloquear(@RequestBody Map<String, String> body) {
        try {
            AlquilerResponseDTO resultado = alquilerService.desbloquear(
                body.get("idUsuario"),
                body.get("patente"),
                body.get("metodoPago")
            );
            return ResponseEntity.ok(resultado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(e.getMessage(), 400));
        }
    }

    @GetMapping("/finalizar")
    public ResponseEntity<?> finalizar(@RequestBody Map<String, String> body) {
        try {
            String patente = body.get("patente");
            int minutos = Integer.parseInt(body.get("minutos"));
            AlquilerResponseDTO resultado = alquilerService.finalizar(patente, minutos);
            return ResponseEntity.ok(resultado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(e.getMessage(), 400));
        }
    }
}