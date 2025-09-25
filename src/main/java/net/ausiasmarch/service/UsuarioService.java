package net.ausiasmarch.service;

import java.sql.Connection;
import java.sql.SQLException;

import net.ausiasmarch.connection.HikariConfiguration;
import net.ausiasmarch.dao.UsuarioDao;
import net.ausiasmarch.exception.ResourceNotFoundException;
import net.ausiasmarch.model.UsuarioBean;

public class UsuarioService {

    public UsuarioBean get(Long id) throws SQLException, ResourceNotFoundException {
        // Es mejor crear la conexion a nivel de servicio y pasarla al DAO
        Connection oConnection = HikariConfiguration.getConnection();                        
        UsuarioDao oUsuarioDao = new UsuarioDao(oConnection);
        UsuarioBean oUsuarioBean = oUsuarioDao.get(id);
        return oUsuarioBean;
    }

}
