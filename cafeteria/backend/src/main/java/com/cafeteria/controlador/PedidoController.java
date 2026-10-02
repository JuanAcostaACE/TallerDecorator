package com.cafeteria.controlador;

import com.cafeteria.dto.PedidoRequest;
import com.cafeteria.dto.PedidoResponse;
import com.cafeteria.servicio.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService servicio;

    public PedidoController(PedidoService servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/preview")
    public PedidoResponse preview(@RequestBody PedidoRequest request) {
        return servicio.preview(request);
    }
}
