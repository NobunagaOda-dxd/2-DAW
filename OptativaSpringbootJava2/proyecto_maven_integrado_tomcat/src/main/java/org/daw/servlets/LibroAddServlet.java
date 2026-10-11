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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/xml;charset=UTF-8");

        String tituloParam = request.getParameter("titulo");

        String anioParam = request.getParameter("anioPublicacion");

        if (tituloParam == null || anioParam == null) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            response.getWriter().print(XmlUtil.error("Faltan los parámetros titulo y año."));

            return;
        }

        try {

            int anio = Integer.parseInt(anioParam);

            Libro libro = ControladorLibro.crear(tituloParam, anio);

            String xml = """
					<?xml version="1.0" encoding="UTF-8"?>
					<respuesta>
					    <operacion>crear</operacion>
					    <mensaje>Libro creado correctamente.</mensaje>
					    %s
					</respuesta>
					""".formatted(XmlUtil.libro(libro));

            response.setStatus(HttpServletResponse.SC_CREATED);

            response.getWriter().print(xml);

        } catch (NumberFormatException e) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            response.getWriter().print(XmlUtil.error("El año debe ser un número entero."));
        }
    }
}
