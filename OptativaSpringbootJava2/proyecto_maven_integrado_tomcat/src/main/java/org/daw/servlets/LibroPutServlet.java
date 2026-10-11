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

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/xml;charset=UTF-8");

        String idParam = request.getParameter("id");

        if (idParam == null) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            response.getWriter().print(XmlUtil.error("Debe indicar el parámetro id."));

            return;
        }

        try {

            int id = Integer.parseInt(idParam);

            Libro libro = ControladorLibro.buscarPorId(id);

            if (libro == null) {

                response.setStatus(HttpServletResponse.SC_NOT_FOUND);

                response.getWriter().print(XmlUtil.error("Libro no encontrado en la biblioteca."));

                return;
            }

            String titulo = request.getParameter("titulo");

            String anioParam = request.getParameter("anioPublicacion");



            if (anioParam != null) {

                int anio = Integer.parseInt(anioParam);

                libro.setAnioPublicacion(anio);
            }

            if (titulo != null) {

                libro.setTitulo(titulo);
            }

            String xml = """
					<?xml version="1.0" encoding="UTF-8"?>
					<respuesta>
					    <operacion>modificar</operacion>
					    <mensaje>Libro modificado correctamente en la biblioteca.</mensaje>
					    %s
					</respuesta>
					""".formatted(XmlUtil.libro(libro));

            response.setStatus(HttpServletResponse.SC_OK);

            response.getWriter().print(xml);

        } catch (NumberFormatException e) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            response.getWriter().print(XmlUtil.error("El id y el año deben ser números enteros."));
        }
    }
}
