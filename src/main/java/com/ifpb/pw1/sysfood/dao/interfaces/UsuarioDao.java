package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Publicacao;
import com.ifpb.pw1.sysfood.entities.Usuario;

import java.io.IOException;
import java.sql.SQLException;

public interface UsuarioDao {
    Boolean criar(Usuario novo) throws PersistenciaException;
    Usuario buscar(String email) throws PersistenciaException, SQLException, IOException;
    Boolean autenticar(String email, String senha) throws PersistenciaException, SQLException;
    boolean salvarPublicacao(Publicacao novo) throws PersistenciaException;
    Usuario buscarId(int value) throws IOException;
}

