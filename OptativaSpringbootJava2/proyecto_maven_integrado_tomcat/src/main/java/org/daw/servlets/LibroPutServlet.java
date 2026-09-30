package org.daw.servlets;
import java.io.IOException;

import org.daw.servlets.crud.ControladorLibro;
import org.daw.servlets.crud.Libro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard/modificar")
public class LibroPutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Procesa las peticiones HTTP PUT.
     */
    @Override
    protected void doPut(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain;charset=UTF-8");

        String idParam = request.getParameter("id");

        if (idParam == null) {

            response.setStatus(
                    HttpServletResponse.SC_BAD_REQUEST
            );

            response.getWriter().println(
                    "Debe indicar el parámetro id."
            );

            return;
        }

        int id = Integer.parseInt(idParam);

        // Buscamos la persona.
        Libro libro =
                ControladorLibro.buscarPorId(id);

        // Si no existe, devolvemos HTTP 404.
        if (libro == null) {

            response.setStatus(
                    HttpServletResponse.SC_NOT_FOUND
            );

            response.getWriter().println(
                    "libro no encontrado en la biblioteca."
            );

            return;
        }

        String titulo = request.getParameter("titulo");
        String anioParam = request.getParameter("anio");

        if (titulo != null) {
            libro.setTitulo(titulo);
        }

        if (anioParam != null) {

            int anio = Integer.parseInt(anioParam);

            libro.setAnioPublicacion(anio);
        }

        // La modificación se ha realizado correctamente.
        response.setStatus(HttpServletResponse.SC_OK);

        response.getWriter().println(
                "libro modificado en la biblioteca"
        );

        // Devolvemos los datos actuales de la persona.
        response.getWriter().println(
                "ID: " + libro.getId()
        );

        response.getWriter().println(
                "Nombre: " + libro.getTitulo()
        );

        response.getWriter().println(
                "Edad: " + libro.getAnioPublicacion()
        );
    }
}
