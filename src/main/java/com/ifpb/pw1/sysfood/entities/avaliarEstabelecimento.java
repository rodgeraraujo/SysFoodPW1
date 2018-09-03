package com.ifpb.pw1.sysfood.entities;

import java.security.Timestamp;

public class avaliarEstabelecimento {
    private int id;
    private int idUsuario;
    private int idEstabelecimento;
    private float avaliacao;
    private Timestamp dataAvaliacao;

    public avaliarEstabelecimento() {
    }

    public avaliarEstabelecimento(int id, int idUsuario, int idEstabelecimento, float avaliacao, Timestamp dataAvaliacao) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idEstabelecimento = idEstabelecimento;
        this.avaliacao = avaliacao;
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

    public Timestamp getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Timestamp dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    @Override
    public String toString() {
        return "avaliarEstabelecimento{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idEstabelecimento=" + idEstabelecimento +
                ", avaliacao=" + avaliacao +
                ", dataAvaliacao=" + dataAvaliacao +
                '}';
    }
}
