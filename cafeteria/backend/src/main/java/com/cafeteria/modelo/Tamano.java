package com.cafeteria.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Decorador que multiplica el costo TOTAL de lo que envuelve. Debe ser el más externo. */
public class Tamano extends BebidaDecorator {

    public enum Medida {
        PEQUENO("Pequeño", "1.00"),
        MEDIANO("Mediano", "1.25"),
        GRANDE("Grande",   "1.50");

        private final String etiqueta;
        private final BigDecimal factor;

        Medida(String etiqueta, String factor) {
            this.etiqueta = etiqueta;
            this.factor = new BigDecimal(factor);
        }
    }

    private final Medida medida;

    public Tamano(Bebida bebida, Medida medida) {
        super(bebida);
        this.medida = medida;
    }

    @Override public String getDescripcion() { return bebida.getDescripcion() + " (" + medida.etiqueta + ")"; }
    @Override public BigDecimal getCosto() {
        return bebida.getCosto().multiply(medida.factor).setScale(2, RoundingMode.HALF_UP);
    }
}
