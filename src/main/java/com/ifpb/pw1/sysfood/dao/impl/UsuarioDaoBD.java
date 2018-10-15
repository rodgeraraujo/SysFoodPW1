package com.ifpb.pw1.sysfood.dao.impl;

import com.ifpb.pw1.sysfood.dao.connect.ConFactory;
import com.ifpb.pw1.sysfood.dao.connect.DataBase;
import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.interfaces.UsuarioDao;
import com.ifpb.pw1.sysfood.entities.Publicacao;
import com.ifpb.pw1.sysfood.entities.Usuario;

import javax.faces.convert.IntegerConverter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class UsuarioDaoBD implements UsuarioDao {
    private DataBase props;
    private Connection conexao;

    public UsuarioDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new DataBase();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getPassword());
    }



    @Override
    public Boolean criar(Usuario novo) throws PersistenciaException {
        String sql = "INSERT INTO usuario (nome, email, profissao, aniversario, sexo, fotoPerfil, descricao, rua, numero, " +
                "cidade, estado, cep, telefone, senha) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1,novo.getNome());
            st.setString(2, novo.getEmail());
            st.setString(3, novo.getProfissao());
            st.setString(4, novo.getAniversario());
            st.setString(5, novo.getSexo());
            st.setString(6, novo.getFotoPerfil());
            st.setString(7, novo.getDescricao());
            st.setString(8, novo.getRua());
            st.setString(9, novo.getNumero());
            st.setString(10, novo.getCidade());
            st.setString(11, novo.getEstado());
            st.setString(12, novo.getCep());
            st.setString(13, novo.getTelefone());
            st.setString(14, novo.getSenha());

            boolean inserted = st.executeUpdate() > 0;
            //conexao.close();
            return inserted;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Usuario buscar(String email) throws IOException {
        try {
            String sql = "SELECT * FROM Usuario WHERE email = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet resultado = stmt.executeQuery();

            if(resultado.next()){
                Usuario u = new Usuario(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("email"),
                        resultado.getString("profissao"),
                        resultado.getString("aniversario"),
                        resultado.getString("sexo"),
                        resultado.getString("fotoPerfil"),
                        resultado.getString("descricao"),
                        resultado.getString("rua"),
                        resultado.getString("numero"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"),
                        resultado.getString("cep"),
                        resultado.getString("telefone"),
                        resultado.getString("senha")
                );

                resultado.close();
                stmt.close();
                //conexao.close();
                return u;
            }
            resultado.close();
            stmt.close();
            //conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean autenticar(String email, String senha) throws SQLException {

        if (email != "" && senha != "") {
            String sql = "SELECT * FROM Usuario WHERE email = ? AND senha = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            if (stmt.executeQuery().next()) {
                //stmt.close();
                //conexao.close();
                return true;
            }
            stmt.close();
            //conexao.close();
        }
        return false;
    }

    @Override
    public boolean salvarPublicacao(Publicacao novo) throws PersistenciaException {
        try {
            String sql = "INSERT INTO publicacao (nomeusuario, conteudo, idusuario, datapublicacao, foto, usuariofoto) " +
                "VALUES (?,?,?,?,?,?)";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1,novo.getNomeUsuario());
            st.setString(2,novo.getConteudo());
            st.setInt(3,novo.getIdUsuario());
            st.setObject(4,novo.getDataPublicacao());
            st.setString(5,novo.getFoto());
            st.setString(6,novo.getUsuarioFoto());

            boolean inserted = st.executeUpdate() > 0;
            //conexao.close();
            return inserted;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Usuario buscarId(int id) throws  IOException{
        try {
            String sql = "SELECT * FROM Usuario WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();

            if(resultado.next()){
                Usuario u = new Usuario(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("email"),
                        resultado.getString("profissao"),
                        resultado.getString("aniversario"),
                        resultado.getString("sexo"),
                        resultado.getString("fotoPerfil"),
                        resultado.getString("descricao"),
                        resultado.getString("rua"),
                        resultado.getString("numero"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"),
                        resultado.getString("cep"),
                        resultado.getString("telefone"),
                        resultado.getString("senha")
                );

                resultado.close();
                stmt.close();
                //conexao.close();
                return u;
            }
            resultado.close();
            stmt.close();
//            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> buscarNome(String nome) {
        try {
            String sql = "SELECT * FROM Usuario WHERE nome = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet resultado = stmt.executeQuery();
            List<Usuario> user = new ArrayList<Usuario>();
            while (resultado.next()){
                Usuario u = new Usuario(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("email"),
                        resultado.getString("profissao"),
                        resultado.getString("aniversario"),
                        resultado.getString("sexo"),
                        resultado.getString("fotoPerfil"),
                        resultado.getString("descricao"),
                        resultado.getString("rua"),
                        resultado.getString("numero"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"),
                        resultado.getString("cep"),
                        resultado.getString("telefone"),
                        resultado.getString("senha")
                );
                user.add(u);
                //conexao.close();
            }
            resultado.close();
            stmt.close();
            return user;
//            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Publicacao> buscaPublicacao() {
        try {
            String sql = "SELECT * FROM publicacao ORDER BY id DESC";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            List<Publicacao> publicacaoList = new ArrayList<>();
            while (resultado.next()){

                Publicacao p = new Publicacao(
                        resultado.getInt("id"),
                        resultado.getString("nomeUsuario"),
                        resultado.getString("conteudo"),
                        resultado.getInt("idusuario"),
                        resultado.getString("datapublicacao"),
                        resultado.getString("foto"),
                        resultado.getString("usuarioFoto")
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
    public List<Publicacao> buscaPublicacaoID(int usuarioID) {
        try {
            String sql = "SELECT * FROM publicacao WHERE idusuario = '"+ usuarioID +"'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            List<Publicacao> publicacaoList = new ArrayList<>();
            while (resultado.next()){

                Publicacao p = new Publicacao(
                        resultado.getInt("id"),
                        resultado.getString("nomeUsuario"),
                        resultado.getString("conteudo"),
                        resultado.getInt("idusuario"),
                        resultado.getString("datapublicacao"),
                        resultado.getString("foto"),
                        resultado.getString("usuarioFoto")
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

    /*
    @Override
    public Usuario buscarId(String id) throws IOException {
        try {
            String sql = "SELECT * FROM Usuario WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet resultado = stmt.executeQuery();

            if(resultado.next()){

                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String profissao = resultado.getString("profissao");
                String sexo = resultado.getString("sexo");
                byte[] fotoPerfil = resultado.getBytes("fotoPerfil");
                String descricao = resultado.getString("descricao");
                String rua = resultado.getString("rua");
                String numero = resultado.getString("numero");
                String cidade = resultado.getString("cidade");
                String estado = resultado.getString("estado");
                String cep = resultado.getString("cep");
                String telefone = resultado.getString("telefone");
                String senha = resultado.getString("senha");

                Usuario u = new Usuario(parseInt(id), nome, email, profissao, sexo, fotoPerfil, descricao,
                        rua, numero, cidade, estado, cep, telefone, senha);

                resultado.close();
                stmt.close();
                conexao.close();
                return u;
            }
            resultado.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    */

}
