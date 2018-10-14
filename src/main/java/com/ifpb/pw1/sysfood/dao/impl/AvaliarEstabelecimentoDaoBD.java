package com.ifpb.pw1.sysfood.dao.impl;

import com.ifpb.pw1.sysfood.dao.connect.ConFactory;
import com.ifpb.pw1.sysfood.dao.connect.DataBase;
import com.ifpb.pw1.sysfood.dao.interfaces.AvaliaEstabelecimentoDao;
import com.ifpb.pw1.sysfood.entities.AvaliarEstabelecimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvaliarEstabelecimentoDaoBD implements AvaliaEstabelecimentoDao {
    private DataBase props;
    private Connection conexao;

    public AvaliarEstabelecimentoDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new DataBase();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getPassword());
    }

    @Override
    public Float MediaNOta() {
        try{
            String sql = "SELECT avaliacao FROM avaliarestabelecimento";
            int divisor =0;
            float media = 0;
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while(!resultado.isLast()){
                media += resultado.getFloat("avaliacao");
                divisor++;
                resultado.next();
            }
            return media/divisor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean Avaliar(AvaliarEstabelecimento avaliar) {
        String sql = "INSERT INTO avaliarestabelecimento(idusuario, idestabelecimento, avaliacao, dataavaliacao" +
                "VALUES(?,?,?,?)";

        try{
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, avaliar.getIdUsuario());
            st.setInt(2, avaliar.getIdEstabelecimento());
            st.setFloat(3, avaliar.getAvaliacao());
            st.setObject(4, avaliar.getDataAvaliacao());

            boolean inserted = st.executeUpdate() > 0;
            conexao.close();
            return  inserted;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
