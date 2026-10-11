package org.daw.servlets;

import java.io.IOException;

import org.daw.servlets.crud.ControladorLibro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard/eliminar")
public class LibroDeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
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

            boolean eliminado = ControladorLibro.eliminar(id);

            if (!eliminado) {

                response.setStatus(HttpServletResponse.SC_NOT_FOUND);

                response.getWriter().print(XmlUtil.error("LIbro no encontrado en la biblioteca."));

                return;
            }

            String xml = """
					<?xml version="1.0" encoding="UTF-8"?>
					<respuesta>
					    <operacion>eliminar</operacion>
					    <mensaje>Libro eliminado correctamente.</mensaje>
					    <id>%d</id>
					</respuesta>
					""".formatted(id);

            response.setStatus(HttpServletResponse.SC_OK);

            response.getWriter().print(xml);

        } catch (NumberFormatException e) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            response.getWriter().print(XmlUtil.error("El parámetro id debe ser un número entero."));
        }
    }
}