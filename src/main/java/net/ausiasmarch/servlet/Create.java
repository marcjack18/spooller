package net.ausiasmarch.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ausiasmarch.dao.UsuarioDao;
import net.ausiasmarch.model.UsuarioBean;

@WebServlet("/create")
public class Create extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para manejar la creación de un nuevo recurso

        String username=request.getParameter("username");
        String nombre=request.getParameter("nombre");
        String apellido1=request.getParameter("apellido1");
        String apellido2=request.getParameter("apellido2");

        UsuarioBean oUsuarioBean = new UsuarioBean( username, nombre, apellido1, apellido2 );
        UsuarioDao oUsuarioDao = new UsuarioDao();
        boolean exito=false;
        try {
            exito = oUsuarioDao.save(oUsuarioBean);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (exito) {
    request.setAttribute("username", username);
    request.getRequestDispatcher("usuarioCreado.jsp").forward(request, response);
} else {
    request.setAttribute("error", "No se pudo crear el usuario.");
    request.getRequestDispatcher("form-create.html").forward(request, response);
}
    }
}
