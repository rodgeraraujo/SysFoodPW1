package com.ifpb.pw1.sysfood.entities;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;

public class Publicacao {
    private int id;
    private String nomeUsuario;
    private String conteudo;
    private int idUsuario;
    private String dataPublicacao;
    private String foto;
    private String usuarioFoto;


    public Publicacao(int id, String nomeUsuario, String conteudo, int idUsuario, String dataPublicacao,
                      String foto, String usuarioFoto) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.conteudo = conteudo;
        this.idUsuario = idUsuario;
        this.dataPublicacao = dataPublicacao;
        this.foto = foto;
        this.usuarioFoto = usuarioFoto;
    }

    public Publicacao(String nomeUsuario, String conteudo, int idUsuario, String dataPublicacao,
                      String foto, String usuarioFoto) {
        this.nomeUsuario = nomeUsuario;
        this.conteudo = conteudo;
        this.idUsuario = idUsuario;
        this.dataPublicacao = dataPublicacao;
        this.foto = foto;
        this.usuarioFoto = usuarioFoto;
    }

    public Publicacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getUsuarioFoto() {
        return usuarioFoto;
    }

    public void setUsuarioFoto(String usuarioFoto) {
        this.usuarioFoto = usuarioFoto;
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                "id=" + id +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", idUsuario=" + idUsuario +
                ", dataPublicacao='" + dataPublicacao + '\'' +
                ", foto='" + foto + '\'' +
                ", usuarioFoto='" + usuarioFoto + '\'' +
                '}';
    }
}
