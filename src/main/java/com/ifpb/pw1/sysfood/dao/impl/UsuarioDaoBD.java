package com.ifpb.pw1.sysfood.dao.impl;

import com.ifpb.pw1.sysfood.dao.connect.ConFactory;
import com.ifpb.pw1.sysfood.dao.connect.DataBase;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.interfaces.UsuarioDao;
import com.ifpb.pw1.sysfood.entities.LoginBean;
import com.ifpb.pw1.sysfood.entities.Usuario;
import org.postgresql.core.ConnectionFactory;

import java.sql.*;
import java.util.logging.Logger;

public class UsuarioDaoBD implements UsuarioDao {
    private DataBase props;
    private Connection conexao;

    public UsuarioDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new DataBase();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getPassword());
    }



    @Override
    public Boolean criar(Usuario novo) throws PersistenciaException {
        String sql = "INSERT INTO usuario (nome, email, profissao, sexo, fotoPerfil, descricao, rua, numero, " +
                "cidade, estado, cep, telefone, senha) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1,novo.getNome());
            st.setString(2, novo.getEmail());
            st.setString(3, novo.getProfissao());
            st.setString(4, novo.getSexo());
            st.setBytes(5, novo.getFotoPerfil());
            st.setString(6, novo.getDescricao());
            st.setString(7, novo.getRua());
            st.setString(8, novo.getNumero());
            st.setString(9, novo.getCidade());
            st.setString(10, novo.getEstado());
            st.setString(11, novo.getCep());
            st.setString(12, novo.getTelefone());
            st.setString(13, novo.getSenha());

            boolean inserted = st.executeUpdate() > 0;
            conexao.close();
            return inserted;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Usuario buscar(String email) throws PersistenciaException, SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE email = ?";
        PreparedStatement st = null;

            try{
                st = this.conexao.prepareStatement(sql);
                st.setString(1,email);

                ResultSet rs = st.executeQuery(sql);
                if(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setDescricao(rs.getString("descricao"));
                usuario.setEmail(rs.getString("email"));
                usuario.setFotoPerfil(rs.getBytes("fotoperfil"));
                usuario.setNome(rs.getString("nome"));
                usuario.setProfissao(rs.getString("profissao"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setTelefone(rs.getNString("telefone"));
            }
            st.close();
            //rs.close();
            conexao.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }finally {
            return usuario;
        }

    }


    @Override
    public Boolean autenticar(String email, String senha) {
        System.out.println("3");
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

        try{
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, senha);

            ResultSet rs = st.executeQuery(sql);

            boolean updated = st.executeUpdate() > 0;

            System.out.println("2");
            if(rs.next()){
                return true;
            }
            st.close();
            rs.close();
            conexao.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return false;
    }
}
