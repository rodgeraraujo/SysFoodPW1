package com.ifpb.pw1.sysfood.dao.impl;

import com.ifpb.pw1.sysfood.dao.connect.ConFactory;
import com.ifpb.pw1.sysfood.dao.connect.DataBase;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.interfaces.AvaliaEstabelecimentoDao;
import com.ifpb.pw1.sysfood.entities.AvaliarEstabelecimento;
import com.ifpb.pw1.sysfood.entities.Comida;
import com.ifpb.pw1.sysfood.entities.Publicacao;
import com.ifpb.pw1.sysfood.entities.PublicacaoEstabelecimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliarEstabelecimentoDaoBD implements AvaliaEstabelecimentoDao {
    private DataBase props;
    private Connection conexao;

    public AvaliarEstabelecimentoDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new DataBase();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getPassword());
    }

    @Override
    public Float MediaNota() {
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
        String sql = "INSERT INTO avaliarestabelecimento(idusuario, idestabelecimento, avaliacao, comentario, dataavaliacao)" +
                "VALUES(?,?,?,?,?)";

        try{
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, avaliar.getIdUsuario());
            st.setInt(2, avaliar.getIdEstabelecimento());
            st.setFloat(3, avaliar.getAvaliacao());
            st.setString(4, avaliar.getComentario());
            st.setObject(5, avaliar.getDataAvaliacao());

            boolean inserted = st.executeUpdate() > 0;
            //conexao.close();
            return  inserted;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<AvaliarEstabelecimento> buscar(int id) {
        try {
            String sql = "SELECT * FROM avaliarestabelecimento where idestabelecimento = '" + id + "'"
                    + "ORDER BY dataavaliacao DESC ";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            List<AvaliarEstabelecimento> avaliacaoList = new ArrayList<>();
            while (resultado.next()){
                AvaliarEstabelecimento a = new AvaliarEstabelecimento(
                        resultado.getInt("id"),
                        resultado.getInt("idusuario"),
                        resultado.getInt("idestabelecimento"),
                        resultado.getFloat("avaliacao"),
                        resultado.getString("comentario"),
                        resultado.getTimestamp("dataavaliacao")
                );

                avaliacaoList.add(a);
            }

            System.out.println(avaliacaoList);
            resultado.close();
            stmt.close();
            return avaliacaoList;
            // conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean buscarAvaliacaoUsuario(int u_id, int e_id) throws SQLException {
            String sql = "SELECT * FROM avaliarestabelecimento WHERE idusuario = ? AND idestabelecimento = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, u_id);
            stmt.setInt(2, e_id);
            if (stmt.executeQuery().next()) {
                //stmt.close();
                //conexao.close();
                System.out.println("true");
                stmt.close();
                return true;
            }
            stmt.close();
            //conexao.close();
        System.out.println("false");
        return false;
    }

}
