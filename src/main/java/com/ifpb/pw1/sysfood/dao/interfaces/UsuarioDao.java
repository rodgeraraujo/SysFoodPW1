package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Usuario;

import javax.persistence.PersistenceException;

public interface UsuarioDao {
    Boolean criar(Usuario novo) throws PersistenciaException;
    Usuario buscar(String email) throws PersistenciaException;
    Boolean autentica(String email, String senha) throws PersistenciaException;

}

