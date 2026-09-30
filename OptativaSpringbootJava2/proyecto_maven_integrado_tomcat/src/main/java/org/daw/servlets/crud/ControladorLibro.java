package org.daw.servlets.crud;

import java.util.ArrayList;
import java.util.List;

public class ControladorLibro {
    static List<Libro> libros = new ArrayList<>();

    static {
        libros.add(new Libro(1,"black water",2010));
        libros.add(new Libro(2,"fundacion",1970));
        libros.add(new Libro(3,"read dead 2",2018));
    }

    private static int siguienteId = 4;


    public static List<Libro> listarLibros(){
        return libros;
    }

    public static Libro aleterLibro( int id, String nombre, int anio){
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                libro.setTitulo(nombre);
                libro.setAnioPublicacion(anio);
                return libro;
            }
        }
        return null;
    }

    public static Libro crear(String nombre, int anio) {

        Libro libro = new Libro(
                siguienteId++,
                nombre,
                anio
        );

        libros.add(libro);

        return libro;
    }


    public static Libro buscarPorId(int id) {

        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }

        return null;
    }

      public static boolean eliminar(int id) {

        Libro libro = buscarPorId(id);

        if (libro == null) {
            return false;
        }

        libros.remove(libro);

        return true;
    }

}
