package org.daw.servlets;
import java.io.IOException;

import org.daw.servlets.crud.ControladorLibro;
import org.daw.servlets.crud.Libro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard/crear")
public class LibroAddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Procesa las peticiones HTTP POST.
     */
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Devolvemos una respuesta de texto.
        response.setContentType("text/plain;charset=UTF-8");

        // Obtenemos los datos enviados como query parameters.
        String titulo = request.getParameter("titulo");
        String anioParam = request.getParameter("anio");

        // Comprobamos que se hayan recibido los dos parámetros.
        if (titulo == null || anioParam == null) {

            response.setStatus(
                    HttpServletResponse.SC_BAD_REQUEST
            );

            response.getWriter().println(
                    "Faltan los parámetros titulo y año publicacíon."
            );

            return;
        }

        int anio = Integer.parseInt(anioParam);

        Libro libro =
                ControladorLibro.crear(titulo, anio);

        // HTTP 201 indica que se ha creado un nuevo recurso.
        response.setStatus(
                HttpServletResponse.SC_CREATED
        );

        response.getWriter().println(
                "Libro creado correctamente."
        );

        response.getWriter().println(
                "ID asignado: " + libro.getId()
        );
    }
}
