package com.ifpb.pw1.sysfood.dao.impl;

import com.ifpb.pw1.sysfood.dao.connect.ConFactory;
import com.ifpb.pw1.sysfood.dao.connect.DataBase;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.interfaces.EstabelecimentoDao;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;
import com.ifpb.pw1.sysfood.entities.Publicacao;
import com.ifpb.pw1.sysfood.entities.PublicacaoEstabelecimento;
import com.sun.javafx.embed.EmbeddedStageInterface;

import javax.enterprise.inject.New;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstabelecimentoDaoBD implements EstabelecimentoDao {
    private DataBase props;
    private Connection conexao;

    public EstabelecimentoDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new DataBase();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getPassword());
    }

    @Override
    public Boolean criar(Estabelecimento novo) throws PersistenciaException {
        String sql = "INSERT INTO estabelecimento(nome, checkin, rua, numero, cidade, " +
                    "estado, cep, tipo, fotoPerfil, descricao, email_usuario, status, checkout) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1,novo.getNome());
            st.setString(2,novo.getCheckin());
            st.setString(3, novo.getRua());
            st.setString(4, novo.getNumero());
            st.setString(5, novo.getCidade());
            st.setString(6, novo.getEstado());
            st.setString(7, novo.getCep());
            st.setString(8, novo.getTipo());
            st.setString(9, novo.getFotoPerfil());
            st.setString(10, novo.getDescricao());
            st.setString(11, novo.getUsuarioEmail());
            st.setInt(12, novo.getStatus());
            st.setString(13, novo.getCheckout());



            boolean inserted = st.executeUpdate() > 0;
            conexao.close();
            return inserted;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public List<Estabelecimento> buscarEstabelecimento(String emailUsuario) {
        try {
            String sql = "SELECT * FROM estabelecimento WHERE email_usuario = '"+ emailUsuario +"'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            List<Estabelecimento> estabelecientoList = new ArrayList<>();
            while (resultado.next()){

                Estabelecimento e = new Estabelecimento(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("checkin"),
                        resultado.getString("checkout"),
                        resultado.getString("rua"),
                        resultado.getString("numero"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"),
                        resultado.getString("cep"),
                        resultado.getString("tipo"),
                        resultado.getString("fotoperfil"),
                        resultado.getString("descricao"),
                        resultado.getString("email_usuario"),
                        resultado.getInt("status")

                );

                estabelecientoList.add(e);
            }

            resultado.close();
            stmt.close();
            return estabelecientoList;
            // conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Estabelecimento> buscarNome(String nome) {

        try{
            String sql = "SELECT * FROM Estabelecimento WHERE nome = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet resultado = stmt.executeQuery();
            List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();

            while (resultado.next()){
                Estabelecimento e = new Estabelecimento(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("checkin"),
                        resultado.getString("checkout"),
                        resultado.getString("rua"),
                        resultado.getString("numero"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"),
                        resultado.getString("cep"),
                        resultado.getString("tipo"),
                        resultado.getString("fotoperfil"),
                        resultado.getString("descricao"),
                        resultado.getString("email_usuario"),
                        resultado.getInt("status")

                );
                estabelecimentos.add(e);
            }
            resultado.close();
            stmt.close();
            return estabelecimentos;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Estabelecimento buscar_id(int id) throws PersistenciaException, SQLException, IOException {
        try {
            String sql = "SELECT * FROM estabelecimento WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();

            if(resultado.next()){
                Estabelecimento novo = new Estabelecimento(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("checkin"),
                        resultado.getString("checkout"),
                        resultado.getString("rua"),
                        resultado.getString("numero"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"),
                        resultado.getString("cep"),
                        resultado.getString("tipo"),
                        resultado.getString("fotoperfil"),
                        resultado.getString("descricao"),
                        resultado.getString("email_usuario"),
                        resultado.getInt("status")
                );
                resultado.close();
                stmt.close();
                return novo;
            }

            resultado.close();
            stmt.close();
            // conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean salvarPublicacao(PublicacaoEstabelecimento novo) throws PersistenciaException {
        try {
            String sql = "INSERT INTO publicacaoEstabelecimento (nomeEstabelecimento, conteudo, idEstabelecimento, " +
                    "datapublicacao, foto, estabelecimentoFoto) " +
                    "VALUES (?,?,?,?,?,?)";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1,novo.getNomeEstabelecimento());
            st.setString(2,novo.getConteudo());
            st.setInt(3,novo.getIdEstabelecimento());
            st.setObject(4,novo.getDataPublicacao());
            st.setString(5,novo.getFoto());
            st.setString(6,novo.getEstabelecimentoFoto());


            boolean inserted = st.executeUpdate() > 0;
            //conexao.close();
            return inserted;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<PublicacaoEstabelecimento> buscaPublicacao() {
        try {
            String sql = "SELECT * FROM publicacaoEstabelecimento ORDER BY id DESC";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            List<PublicacaoEstabelecimento> publicacaoList = new ArrayList<>();
            while (resultado.next()){

                PublicacaoEstabelecimento p = new PublicacaoEstabelecimento(
                        resultado.getInt("id"),
                        resultado.getString("nomeEstabelecimento"),
                        resultado.getString("conteudo"),
                        resultado.getInt("idEstabelecimento"),
                        resultado.getString("datapublicacao"),
                        resultado.getString("foto"),
                        resultado.getString("estabelecimentoFoto"),
                        resultado.getString("tipo")
                );

                publicacaoList.add(p);
            }

            resultado.close();
            stmt.close();
            return publicacaoList;
            // conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PublicacaoEstabelecimento> buscaPublicacaoEstabelecimento(int id) {
        try {
            String sql = "SELECT * FROM publicacaoEstabelecimento WHERE  idestabelecimento = '"+id+"' ORDER BY id DESC";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            List<PublicacaoEstabelecimento> publicacaoList = new ArrayList<>();
            while (resultado.next()){

                PublicacaoEstabelecimento p = new PublicacaoEstabelecimento(
                        resultado.getInt("id"),
                        resultado.getString("nomeEstabelecimento"),
                        resultado.getString("conteudo"),
                        resultado.getInt("idEstabelecimento"),
                        resultado.getString("datapublicacao"),
                        resultado.getString("foto"),
                        resultado.getString("estabelecimentoFoto"),
                        resultado.getString("tipo")
                );
                publicacaoList.add(p);
            }

            resultado.close();
            stmt.close();
            return publicacaoList;
            // conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
