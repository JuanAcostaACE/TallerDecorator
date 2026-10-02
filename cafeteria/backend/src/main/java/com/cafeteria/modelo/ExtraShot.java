package com.cafeteria.modelo;

import java.math.BigDecimal;

public class ExtraShot extends BebidaDecorator {
    private static final BigDecimal COSTO_FIJO = new BigDecimal("0.75");

    public ExtraShot(Bebida bebida) { super(bebida); }

    @Override public String getDescripcion() { return bebida.getDescripcion() + " + Extra shot"; }
    @Override public BigDecimal getCosto()   { return bebida.getCosto().add(COSTO_FIJO); }
}
