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

        String sql = "SELECT * FROM usuario WHERE email = '"+email+"'";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        //stmt.setString(1, email);
        ResultSet resultado = stmt.executeQuery();

        if(resultado.next()){
            Usuario u = new Usuario(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("profissao"),
                    resultado.getString("sexo"),
                    resultado.getBytes("fotoPerfil"),
                    resultado.getString("descricao"),
                    resultado.getString("rua"),
                    resultado.getString("numero"),
                    resultado.getString("cidade"),
                    resultado.getString("estado"),
                    resultado.getString("cep"),
                    resultado.getString("telefone"),
                    resultado.getString("senha")
            );

            System.out.println("User from dao: " + u);
            resultado.close();
            stmt.close();
            conexao.close();
            return u;
        }
        return null;

    }


    @Override
    public Boolean autenticar(String email, String senha) throws SQLException {
        System.out.println("3");
        if (email != "" && senha != "") {
            System.out.println("2");
            String sql = "SELECT * FROM Usuario WHERE email = ? AND senha = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            if (stmt.executeQuery().next()) {
                System.out.println("2.1");
                stmt.close();
                conexao.close();
                return true;
            }
        }
        return false;
    }
}
