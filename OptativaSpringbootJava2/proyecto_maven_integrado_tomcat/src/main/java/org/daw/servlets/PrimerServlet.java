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

@WebServlet("/miServlet")
public class PrimerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PrimerServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Configuramos la respuesta como HTML
        resp.setContentType("text/html;charset=UTF-8");
        // Escribimos el contenido que verá el navegador
        resp.getWriter().println("<h1>Hola desde miServlet</h1>");

        List<Libro> libros = ControladorLibro.listarLibros();

        for (Libro libro : libros) {
            resp.getWriter().println("<ul>");
            resp.getWriter().println("<li>");
            resp.getWriter().println("id:" + libro.getId());
            resp.getWriter().println("<br>");
            resp.getWriter().println("titulo: " + libro.getTitulo());
            resp.getWriter().println("<br>");
            resp.getWriter().println("año de lanzamiento: " + libro.getAnioPublicacion());
            resp.getWriter().println("</li>");
            resp.getWriter().println("</ul>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }
}