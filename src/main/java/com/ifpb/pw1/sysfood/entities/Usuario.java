package com.ifpb.pw1.sysfood.entities;

import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String profissao;
    private String sexo;
    private byte[] fotoPerfil;
    private String descricao;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    private String telefone;
    private String senha;


    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String profissao, String sexo, byte[] fotoPerfil,
                   String descricao,String rua, String numero, String cidade, String estado, String cep,
                   String telefone, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.profissao = profissao;
        this.sexo = sexo;
        this.fotoPerfil = fotoPerfil;
        this.descricao = descricao;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String profissao, String sexo, byte[] fotoPerfil,
                   String descricao,String rua, String numero, String cidade, String estado, String cep, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.profissao = profissao;
        this.sexo = sexo;
        this.fotoPerfil = fotoPerfil;
        this.descricao = descricao;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
        this.senha = senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profisao) {
        this.profissao = profisao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", profissao='" + profissao + '\'' +
                ", sexo='" + sexo + '\'' +
                ", fotoPerfil=" + Arrays.toString(fotoPerfil) +
                ", descricao='" + descricao + '\'' +
                ", telefone='" + telefone + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public String imageBase64(){
        String base64 = Base64.getEncoder().encodeToString(fotoPerfil);
        return base64;
    }
}
