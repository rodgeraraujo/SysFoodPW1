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

//    public Boolean autenticar(String email, String senha){
//        try{
//            return  dao.autentica(email, senha);
//        }catch (PersistenciaException e){
//            return false;
//        }
//    }

    public Boolean cadastrar(String nome, String email, String profissao, String sexo, byte[] fotoPerfil,
                             String descricao, String rua, String numero, String cidade, String estado, String cep,
                             String telefone, String senha){
        Usuario usuario = new Usuario(nome, email, profissao, sexo, fotoPerfil, descricao, rua, numero, cidade, estado,
                cep, telefone, senha);

        try {
            return dao.criar(usuario);
        } catch (PersistenciaException e) {
            return false;
        }
    }

    public boolean autenticar(String email, String senha) throws SQLException {
        System.out.println("4");
        try {
            return dao.autenticar(email, senha);
        } catch (PersistenciaException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Usuario buscaUsuario(String email) throws SQLException, PersistenciaException {
        return dao.buscar(email);
    }

}
