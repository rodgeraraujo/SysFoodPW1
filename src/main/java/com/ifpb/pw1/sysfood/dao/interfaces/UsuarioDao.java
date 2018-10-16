package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Publicacao;
import com.ifpb.pw1.sysfood.entities.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {
    Boolean criar(Usuario novo) throws PersistenciaException;

    Usuario buscar(String email) throws PersistenciaException, SQLException, IOException;

    Boolean autenticar(String email, String senha) throws PersistenciaException, SQLException;


    Usuario buscarId(int value) throws IOException;

    List<Usuario> buscarNome(String nome);


    boolean salvarPublicacao(Publicacao novo) throws PersistenciaException;

    List<Publicacao> buscaPublicacao();

    public List<Publicacao> buscaPublicacaoUsuario(int id);


    boolean excluirPublicacao(int id) throws PersistenciaException;
    boolean excluirUsuario(int id) throws PersistenciaException;
}

