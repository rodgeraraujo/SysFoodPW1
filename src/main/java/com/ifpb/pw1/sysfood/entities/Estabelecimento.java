package com.ifpb.pw1.sysfood.entities;

import java.util.Arrays;
import java.util.List;

public class Estabelecimento {
    private int id;
    private String nome;
    private String dataHoraFuncionamento;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    private String tipo;
    private String fotoPerfil;
    private String descricao;
    private String usuarioEmail;
    private int status;

    public static final int ATIVO = 1;
    public static final int INATIVO = 0;

    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String dataHoraFuncionamento, String rua, String numero, String cidade,
                           String estado, String cep, String tipo, String fotoPerfil, String descricao,
                           String usuarioEmail, int status) {
        this.nome = nome;
        this.dataHoraFuncionamento = dataHoraFuncionamento;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.tipo = tipo;
        this.fotoPerfil = fotoPerfil;
        this.descricao = descricao;
        this.usuarioEmail = usuarioEmail;
        this.status = status;
    }

    public Estabelecimento(int id, String nome, String dataHoraFuncionamento, String rua, String numero, String cidade,
                           String estado, String cep, String tipo, String fotoPerfil, String descricao,
                           String usuarioEmail, int status) {
        this.id = id;
        this.nome = nome;
        this.dataHoraFuncionamento = dataHoraFuncionamento;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.tipo = tipo;
        this.fotoPerfil = fotoPerfil;
        this.descricao = descricao;
        this.status = status;
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

    public String getDataHoraFuncionamento() {
        return dataHoraFuncionamento;
    }

    public void setDataHoraFuncionamento(String dataHoraFuncionamento) {
        this.dataHoraFuncionamento = dataHoraFuncionamento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static int getATIVO() {
        return ATIVO;
    }

    public static int getINATIVO() {
        return INATIVO;
    }

    @Override
    public String toString() {
        return "Estabelecimento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataHoraFuncionamento=" + dataHoraFuncionamento +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", tipo='" + tipo + '\'' +
                ", fotoPerfil=" + fotoPerfil + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                '}';
    }
}
