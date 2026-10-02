package com.cafeteria.servicio;

import com.cafeteria.dto.PedidoRequest;
import com.cafeteria.dto.PedidoResponse;
import com.cafeteria.modelo.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Locale;

@Service
public class PedidoService {

    public PedidoResponse preview(PedidoRequest req) {
        if (req == null || req.base() == null) {
            throw error("Falta la bebida base");
        }

        // 1) Componente concreto
        Bebida bebida = switch (req.base().toLowerCase(Locale.ROOT)) {
            case "espresso" -> new Espresso();
            case "te"       -> new Te();
            default         -> throw error("Base desconocida: " + req.base());
        };

        // 2) Decoradores de extras (anidamiento dinámico)
        List<String> extras = req.extras() == null ? List.of() : req.extras();
        for (String extra : extras) {
            String[] partes = extra.split(":", 2);
            switch (partes[0].toLowerCase(Locale.ROOT)) {
                case "shot"   -> bebida = new ExtraShot(bebida);
                case "jarabe" -> {
                    if (partes.length < 2 || partes[1].isBlank()) throw error("Jarabe sin sabor");
                    bebida = new ExtraJarabe(bebida, partes[1].trim());
                }
                default -> throw error("Extra desconocido: " + extra);
            }
        }

        // 3) Tamaño siempre al final: multiplica el costo total acumulado
        Tamano.Medida medida;
        try {
            medida = Tamano.Medida.valueOf(
                    (req.tamano() == null ? "PEQUENO" : req.tamano()).toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            throw error("Tamaño desconocido: " + req.tamano());
        }
        bebida = new Tamano(bebida, medida);

        return new PedidoResponse(bebida.getDescripcion(), bebida.getCosto());
    }

    private ResponseStatusException error(String msg) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
    }
}
