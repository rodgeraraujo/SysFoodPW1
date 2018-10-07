package com.ifpb.pw1.sysfood.dao.impl;

import com.ifpb.pw1.sysfood.dao.connect.ConFactory;
import com.ifpb.pw1.sysfood.dao.connect.DataBase;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.interfaces.EstabelecimentoDao;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;
import com.sun.javafx.embed.EmbeddedStageInterface;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstabelecimentoDaoBD implements EstabelecimentoDao {
    private DataBase props;
    private Connection conexao;

    public EstabelecimentoDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new DataBase();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getPassword());
    }

    @Override
    public Boolean criar(Estabelecimento novo) throws PersistenciaException {
        String sql = "INSERT INTO estabelecimento(nome, dataHoraFuncionamento, rua, numero, cidade, " +
                    "estado, cep, tipo, fotoPerfil, descricao, status) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1,novo.getNome());
            st.setString(2, novo.getRua());
            st.setInt(3, novo.getNumero());
            st.setString(4, novo.getCidade());
            st.setString(5, novo.getEstado());
            st.setString(6, novo.getCep());
            st.setString(7, novo.getTipo());
            st.setString(8, novo.getDescricao());
            st.setBytes(9, novo.getFotoPerfil());
            st.setInt(10, novo.getStatus());


            boolean inserted = st.executeUpdate() > 0;
            conexao.close();
            return inserted;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Estabelecimento buscar(String email) throws PersistenciaException, SQLException, IOException {
        return null;
    }
}
