package com.ifpb.pw1.sysfood.entities;

public class Comentario {
    private int id;
    private String foto;
    private String nomeUsuario;
    private String comentario;
    private int idPublicacao;

    public Comentario(int id, String foto, String nomeUsuario, String comentario, int idPublicacao) {
        this.id = id;
        this.foto = foto;
        this.nomeUsuario = nomeUsuario;
        this.comentario = comentario;
        this.idPublicacao = idPublicacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(int idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", foto='" + foto + '\'' +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", comentario='" + comentario + '\'' +
                ", idPublicacao=" + idPublicacao +
                '}';
    }
}
