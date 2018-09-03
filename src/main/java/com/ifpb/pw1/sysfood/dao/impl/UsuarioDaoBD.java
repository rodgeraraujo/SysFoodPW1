package com.ifpb.pw1.sysfood.dao.impl;

import com.ifpb.pw1.sysfood.dao.connect.ConFactory;
import com.ifpb.pw1.sysfood.dao.connect.DataBase;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.interfaces.UsuarioDao;
import com.ifpb.pw1.sysfood.entities.Usuario;
import com.sun.org.apache.bcel.internal.generic.Select;

import javax.persistence.PersistenceException;
import java.sql.*;

public class UsuarioDaoBD implements UsuarioDao {
    private DataBase props;
    private Connection conexao;

    public UsuarioDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new DataBase();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getPassword());
    }



    @Override
    public Boolean criar(Usuario novo) throws PersistenciaException {
        String sql = "INSERT INTO usuario (nome, email, profissao, sexo, fotoPerfil, descricao, telefone, senha) " +
                "VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1,novo.getNome());
            st.setString(2, novo.getEmail());
            st.setString(3, novo.getProfissao());
            st.setString(4, novo.getSexo());
            st.setBytes(5, novo.getFotoPerfil());
            st.setString(6, novo.getDescricao());
            st.setString(7, novo.getTelefone());
            st.setString(8, novo.getSenha());

            boolean inserted = st.executeUpdate() > 0;
            conexao.close();
            return inserted;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Usuario buscar(String email) throws PersistenciaException {
        String sql = "SELECT * FROM usuario WHERE email = '" + email + "'";

        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Usuario usuario = null;
            if(rs.next()){
                usuario = new Usuario();
                //usuario.setId(rs.getInt("id"));
                usuario.setDescricao(rs.getNString("descricao"));
                usuario.setEmail(rs.getNString("email"));
                usuario.setFotoPerfil(rs.getBytes("fotoperfil"));
                usuario.setNome(rs.getString("nome"));
                usuario.setProfissao(rs.getString("profissao"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setTelefone(rs.getNString("telefone"));
            }
            System.out.println(usuario.getSenha());
            //System.out.println(usuario.getNome());
            st.close();
            rs.close();
            conexao.close();
            return usuario;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Boolean autentica(String email, String senha) throws PersistenciaException {
        Usuario usuario = buscar(email);
        if(usuario.getEmail() == null){
            return false;
        }
        return (usuario.getEmail() == email && usuario.getSenha() == senha);
    }
}
