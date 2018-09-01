package com.ifpb.pw1.sysfood.managers;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.factory.Factory;
import com.ifpb.pw1.sysfood.dao.interfaces.FactoryDao;
import com.ifpb.pw1.sysfood.dao.interfaces.UsuarioDao;
import com.ifpb.pw1.sysfood.entities.Usuario;

public class GerenciadorUsuario {

    private FactoryDao factory = null;
    private UsuarioDao dao = null;

    public GerenciadorUsuario() {
        factory = Factory.createFactory();
        dao = factory.getDaoUsuario();
    }

    public Boolean cadastrar(String nome, String email, String profissao, String sexo, byte[] fotoPerfil,
                             String descricao, String telefone, String senha){
        Usuario usuario = new Usuario(fotoPerfil, nome, email, profissao, sexo, descricao, telefone, senha);
        try {
            return dao.criar(usuario);
        } catch (PersistenciaException e) {
            return false;
        }
    }

}
