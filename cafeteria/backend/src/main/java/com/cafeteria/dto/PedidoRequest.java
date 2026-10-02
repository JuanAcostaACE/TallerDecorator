package com.cafeteria.dto;

import java.util.List;

public record PedidoRequest(String base, String tamano, List<String> extras) {}
