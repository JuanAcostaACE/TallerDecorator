package com.cafeteria.modelo;

import java.math.BigDecimal;

public abstract class BebidaDecorator implements Bebida {
    protected final Bebida bebida;

    protected BebidaDecorator(Bebida bebida) {
        this.bebida = bebida;
    }

    @Override public String getDescripcion() { return bebida.getDescripcion(); }
    @Override public BigDecimal getCosto()   { return bebida.getCosto(); }
}
