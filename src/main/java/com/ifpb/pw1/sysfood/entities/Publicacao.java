package com.ifpb.pw1.sysfood.entities;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;

public class Publicacao {
    private int id;
    private String nomeUsuario;
    private String conteudo;
    private int idUsuario;
    private LocalDate dataPublicacao;
    private byte[] foto;


    public Publicacao(int id, String nomeUsuario, String conteudo, int idUsuario, LocalDate dataPublicacao, byte[] foto) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.conteudo = conteudo;
        this.idUsuario = idUsuario;
        this.dataPublicacao = dataPublicacao;
        this.foto = foto;
    }

    public Publicacao(String nomeUsuario, String conteudo, int id, LocalDate dataPublicacao, byte[] fotoPublicacao) {
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "PublicacaoController{" +
                "id=" + id +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", idUsuario=" + idUsuario +
                ", dataPublicacao=" + dataPublicacao +
                ", foto=" + Arrays.toString(foto) +
                '}';
    }
}
