package br.com.fiap.globaljava.mensageria;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/climate")
@Tag(name = "Mensageria Climática", description = "Endpoints para envio de eventos climáticos")
public class ClimateController {

    private final ClimateEventProducer climateEventProducer;

    public ClimateController(ClimateEventProducer climateEventProducer) {
        this.climateEventProducer = climateEventProducer;
    }

    // Endpoint para enviar eventos climáticos
    @PostMapping("/send-event")
    @Operation(summary = "Enviar evento climático", description = "Envia um evento climático através do sistema de mensageria.")
    public String sendClimateEvent(@RequestParam String message) {
        climateEventProducer.sendClimateEvent(message);
        return "Evento enviado: " + message;
    }
}
