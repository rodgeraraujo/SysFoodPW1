package com.ifpb.pw1.sysfood.dao.impl;

import com.ifpb.pw1.sysfood.dao.connect.ConFactory;
import com.ifpb.pw1.sysfood.dao.connect.DataBase;
import com.ifpb.pw1.sysfood.dao.interfaces.AvaliarComidaDao;
import com.ifpb.pw1.sysfood.entities.AvaliarComida;

import java.sql.*;

public class AvaliarComidaDaoBD implements AvaliarComidaDao {

    private DataBase props;
    private Connection conexao;

    private AvaliarComidaDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new DataBase();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getPassword());
    }

    @Override
    public Float MediaNota() {
        try{
            String sql = "SELECT avaliacao FROM avaliarcomida";
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
    public boolean Avaliar(AvaliarComida avaliar) {
        String sql = "INSERT INTO avaliarcomida(idusuario, idestabelecimento, idcomida, avaliacao, dataavaliacao) " +
                "VALUES(?,?,?,?,?)";

        try{
            PreparedStatement st = conexao.prepareStatement(sql);

            st.setInt(1, avaliar.getIdUsuario());
            st.setInt(2, avaliar.getIdEstabelecimento());
            st.setInt(3, avaliar.getIdComida());
            st.setFloat(4, avaliar.getAvaliacao());
            st.setObject(5, avaliar.getDataAvaliacao());

            boolean inserted = st.executeUpdate() > 0;
            conexao.close();
            return inserted;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
