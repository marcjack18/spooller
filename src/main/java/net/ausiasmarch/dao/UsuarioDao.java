package net.ausiasmarch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.ausiasmarch.exception.ResourceNotFoundException;
import net.ausiasmarch.model.UsuarioBean;

public class UsuarioDao {

    private final Connection oConnection;

    public UsuarioDao(Connection oConnection) {
        this.oConnection = oConnection;
    }

    public UsuarioDao() {
        this.oConnection = null;
        //TODO Auto-generated constructor stub
    }

    public UsuarioBean get(Long id) throws SQLException, ResourceNotFoundException {
        String strSQL = "SELECT * FROM usuario WHERE id = ?";
        UsuarioBean oUsuarioBean = null;
        try (PreparedStatement oPreparedStatement = this.oConnection.prepareStatement(strSQL)) {
            oPreparedStatement.setLong(1, id);
            try (ResultSet oResultSet = oPreparedStatement.executeQuery()) {
                if (oResultSet.next()) {
                    oUsuarioBean = new UsuarioBean();
                    oUsuarioBean.setId(oResultSet.getLong("id"));
                    oUsuarioBean.setUsername(oResultSet.getString("username"));
                    oUsuarioBean.setNombre(oResultSet.getString("nombre"));
                    oUsuarioBean.setApellido1(oResultSet.getString("apellido1"));
                    oUsuarioBean.setApellido2(oResultSet.getString("apellido2"));                             
                } else{
                    throw new ResourceNotFoundException("User with id " + id + " not found.");
                }
            }
        }
        return oUsuarioBean;
    }

    public boolean save(UsuarioBean usuario) throws SQLException {
        String strSQL= "INSERT INTO usuarios (username, nombre, apellido1, apellido2) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = oConnection.prepareStatement(strSQL)) {
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido1());
            ps.setString(4, usuario.getApellido2());

            return ps.executeUpdate() > 0;
        }
    }
}
