package com.cafeteria.modelo;

import java.math.BigDecimal;

public class Espresso implements Bebida {
    @Override public String getDescripcion() { return "Espresso"; }
    @Override public BigDecimal getCosto()   { return new BigDecimal("2.00"); }
}
