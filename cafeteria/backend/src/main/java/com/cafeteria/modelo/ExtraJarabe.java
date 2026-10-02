package com.cafeteria.modelo;

import java.math.BigDecimal;

public class ExtraJarabe extends BebidaDecorator {
    private static final BigDecimal COSTO_FIJO = new BigDecimal("0.50");
    private final String sabor;

    public ExtraJarabe(Bebida bebida, String sabor) {
        super(bebida);
        this.sabor = sabor;
    }

    @Override public String getDescripcion() { return bebida.getDescripcion() + " + Jarabe de " + sabor; }
    @Override public BigDecimal getCosto()   { return bebida.getCosto().add(COSTO_FIJO); }
}
