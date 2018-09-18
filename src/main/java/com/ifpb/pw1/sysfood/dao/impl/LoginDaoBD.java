package com.ifpb.pw1.sysfood.dao.impl;

import com.ifpb.pw1.sysfood.dao.connect.ConFactory;
import com.ifpb.pw1.sysfood.dao.connect.DataBase;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.interfaces.LoginDao;
import com.ifpb.pw1.sysfood.entities.LoginBean;
import com.ifpb.pw1.sysfood.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoBD implements LoginDao {
    private DataBase props;
    private Connection conexao;

    public LoginDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new DataBase();
        this.conexao = ConFactory.getConnection(props.getUrl(), props.getUser(), props.getPassword());
    }

    @Override
    public Usuario autentica(LoginBean login) throws PersistenciaException {
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

        try {
            PreparedStatement st = conexao.prepareStatement(sql);

            st.setString(1, login.getEmail());
            st.setString(2, login.getSenha());

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setNome(rs.getString("nome"));
                    usuario.setFotoPerfil(rs.getBytes("fotoPerfil"));
                    usuario.setDescricao(rs.getString("descricao"));

                    System.out.println("1 " + usuario);
                    return usuario;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
