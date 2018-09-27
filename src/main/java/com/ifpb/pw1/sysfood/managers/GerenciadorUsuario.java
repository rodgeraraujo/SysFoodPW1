package com.ifpb.pw1.sysfood.managers;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.factory.Factory;
import com.ifpb.pw1.sysfood.dao.interfaces.FactoryDao;
import com.ifpb.pw1.sysfood.dao.interfaces.UsuarioDao;
import com.ifpb.pw1.sysfood.entities.LoginBean;
import com.ifpb.pw1.sysfood.entities.Usuario;

import java.sql.SQLException;

public class GerenciadorUsuario {

    private FactoryDao factory = null;
    private UsuarioDao dao = null;

    public GerenciadorUsuario() {
        factory = Factory.createFactory();
        dao = factory.getDaoUsuario();
    }

    public Boolean cadastrar(String nome, String email, String profissao, String sexo, byte[] fotoPerfil,
                             String descricao, String rua, String numero, String cidade, String estado, String cep,
                             String telefone, String senha) throws PersistenciaException {
        Usuario usuario = new Usuario(nome, email, profissao, sexo, fotoPerfil, descricao, rua, numero, cidade, estado,
                cep, telefone, senha);

        return dao.criar(usuario);
    }

    public boolean autenticar(String email, String senha) throws SQLException, PersistenciaException {
        System.out.println("4");
        return dao.autenticar(email, senha);
    }

    public Usuario buscaUsuario(String email) throws SQLException, PersistenciaException {
        return dao.buscar(email);
    }

}
