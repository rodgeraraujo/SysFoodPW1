package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.LoginBean;
import com.ifpb.pw1.sysfood.entities.Usuario;

import javax.persistence.PersistenceException;
import java.sql.SQLException;

public interface UsuarioDao {
    Boolean criar(Usuario novo) throws PersistenciaException;
    Usuario buscar(String email) throws PersistenciaException, SQLException;
    Boolean autenticar(String email, String senha) throws PersistenciaException, SQLException;
}

