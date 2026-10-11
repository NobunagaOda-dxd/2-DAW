package org.daw.servlets;

import org.daw.servlets.crud.Libro;

public class XmlUtil {

    private XmlUtil() {
    }

    public static String escapar(String texto) {

        if (texto == null) {
            return "";
        }

        return texto
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }


    public static String libro(Libro libro) {

        return """
                <libro>
                    <id>%d</id>
                    <titulo>%s</titulo>
                    <anioPublicacion>%d</anioPublicacion>
                </libro>
                """.formatted(
                libro.getId(),
                escapar(libro.getTitulo()),
                libro.getAnioPublicacion()
        );
    }


    public static String error(String mensaje) {

        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <error>
                    <mensaje>%s</mensaje>
                </error>
                """.formatted(escapar(mensaje));
    }
}
