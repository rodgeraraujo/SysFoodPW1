package com.ifpb.pw1.sysfood.entities;

import java.security.Timestamp;

public class avaliarComida {
    private int id;
    private int idUsuario;
    private int idEstabelecimento;
    private int idComida;
    private float avaliacao;
    private Timestamp dataAvaliacao;


    public avaliarComida() {
    }


    public avaliarComida(int id, int idUsuario, int idEstabelecimento, float avaliacao, int idComida, Timestamp dataAvaliacao) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idEstabelecimento = idEstabelecimento;
        this.avaliacao = avaliacao;
        this.idComida = idComida;
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public float getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public Timestamp getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Timestamp dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    @Override
    public String toString() {
        return "avaliarComida{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idEstabelecimento=" + idEstabelecimento +
                ", avaliacao=" + avaliacao +
                ", idComida=" + idComida +
                ", dataAvaliacao=" + dataAvaliacao +
                '}';
    }
}

