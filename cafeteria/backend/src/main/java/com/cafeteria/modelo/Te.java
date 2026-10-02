package com.cafeteria.modelo;

import java.math.BigDecimal;

public class Te implements Bebida {
    @Override public String getDescripcion() { return "Té"; }
    @Override public BigDecimal getCosto()   { return new BigDecimal("1.50"); }
}
