package org.daw.servlets;
import java.io.IOException;
import java.util.List;

import org.daw.servlets.crud.ControladorLibro;
import org.daw.servlets.crud.Libro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class LibroGetServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Indicamos que devolveremos HTML utilizando UTF-8.
        response.setContentType("text/html;charset=UTF-8");

        // La consulta se ha realizado correctamente.
        response.setStatus(HttpServletResponse.SC_OK);

        String idParam = request.getParameter("id");

        response.getWriter().println("""
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8">
                <title>Biblioteca</title>
            </head>
            <body>
                <h1>Libros</h1>
            """);

        if (idParam != null) {

            int id = Integer.parseInt(idParam);

            Libro libro =
            ControladorLibro.buscarPorId(id);

            if (libro == null) {

                response.setStatus(
                        HttpServletResponse.SC_NOT_FOUND
                );

                response.getWriter().println(
                        "<p>Libro no encontrado en la biblioteca.</p>"
                );

            } else {

                response.getWriter().println(
                        "<h2>" + libro.getTitulo() + "</h2>"
                );

                response.getWriter().println(
                        "<p>ID: " + libro.getId() + "</p>"
                );

                response.getWriter().println(
                        "<p>Titulo: " + libro.getAnioPublicacion() + "</p>"
                );
            }

        } else {

            // Sin ID, devolvemos todas las personas.
            List<Libro> libros =
                    ControladorLibro.listarLibros();

            response.getWriter().println("<ul>");

            for (Libro libro : libros) {

                response.getWriter().println(
                    "<li>" +
                    libro.getId() +
                    " - " +
                    libro.getTitulo() +
                    " (" +
                    libro.getAnioPublicacion() +
                    " años)" +
                    "</li>"
                );
            }

            response.getWriter().println("</ul>");
        }

        response.getWriter().println("""
            </body>
            </html>
            """);
    }
}
