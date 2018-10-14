package com.ifpb.pw1.sysfood.dao.impl;

import com.ifpb.pw1.sysfood.dao.connect.ConFactory;
import com.ifpb.pw1.sysfood.dao.connect.DataBase;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.interfaces.ComidaDao;
import com.ifpb.pw1.sysfood.entities.Comida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComidaDaoBD implements ComidaDao {

    private DataBase props;
    private Connection conexao;

    public ComidaDaoBD() throws SQLException, ClassNotFoundException{
        this.props = new DataBase();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getPassword());
    }

    @Override
    public Boolean salvar(Comida comida) throws PersistenciaException {
        String sql = "INSERT INTO comida(nome, desscricao, idestabelecimento, foto, datapublicacao) " +
                "VALUES(?,?,?,?,?)";

        try{
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, comida.getNome());
            st.setString(2, comida.getDescricao());
            st.setInt(3, comida.getIdEstabelecimento());
            st.setBytes(4, comida.getFoto());
            st.setObject(5, comida.getDataPublicacao());

            boolean inserted = st.executeUpdate() > 0;
            conexao.close();
            return inserted;

        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }
}
