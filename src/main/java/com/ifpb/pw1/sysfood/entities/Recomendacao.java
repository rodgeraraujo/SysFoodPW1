package com.ifpb.pw1.sysfood.entities;

public class Recomendacao {
    private int id;
    private int idUsuario;
    private int idEstabelecimento;

    public Recomendacao() {
    }

    public Recomendacao(int ind, int idUsuario, int idEstabelecimento) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idEstabelecimento = idEstabelecimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int ind) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(int idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    @Override
    public String toString() {
        return "Recomendacao{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idEstabelecimento=" + idEstabelecimento +
                '}';
    }
}
