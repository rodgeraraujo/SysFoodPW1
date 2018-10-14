package com.ifpb.pw1.sysfood.entities;

import java.sql.Timestamp;
import java.util.Arrays;

public class Comida {
    private int id;
    private String nome;
    private String descricao;
    private int idEstabelecimento;
    private String fotoComida;
    private Timestamp dataPublicacao;


    public Comida() {
    }

    public Comida(String nome, String descricao, int idEstabelecimento, String fotoComida, Timestamp dataPublicacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.idEstabelecimento = idEstabelecimento;
        this.fotoComida = fotoComida;
        this.dataPublicacao = dataPublicacao;
    }

    public Comida(int id, String nome, String descricao, int idEstabelecimento, String fotoComida, Timestamp dataPublicacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.idEstabelecimento = idEstabelecimento;
        this.fotoComida = fotoComida;
        this.dataPublicacao = dataPublicacao;
    }

    public Comida(int id, String nome, String descricao, String idEstabelecimento, byte fotoperfil, String dataPublicacao) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(int idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public String getFoto() {
        return fotoComida;
    }

    public void setFoto(String foto) {
        this.fotoComida = foto;
    }

    public Timestamp getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Timestamp dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", idEstabelecimento=" + idEstabelecimento +
                ", foto=" + fotoComida +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }
}
