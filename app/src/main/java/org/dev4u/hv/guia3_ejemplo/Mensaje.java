package org.dev4u.hv.guia3_ejemplo;

import java.util.Date;

public class Mensaje {
    public Date fecha;
    public String contenido;

    public Mensaje(Date fecha, String contenido) {
        this.fecha = fecha;
        this.contenido = contenido;
    }
}
