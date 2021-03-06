package com.ifpb.pw1.sysfood.entities;
import java.sql.Timestamp;

public class AvaliarEstabelecimento {
    private int id;
    private int idUsuario;
    private int idEstabelecimento;
    private float avaliacao;
    private String comentario;
    private Timestamp dataAvaliacao;

    public AvaliarEstabelecimento(int idUsuario, int idEstabelecimento, float avaliacao, String comentario,
                                  Timestamp dataAvaliacao) {
        this.idUsuario = idUsuario;
        this.idEstabelecimento = idEstabelecimento;
        this.avaliacao = avaliacao;
        this.comentario = comentario;
        this.dataAvaliacao = dataAvaliacao;
    }

    public AvaliarEstabelecimento(int id, int idUsuario, int idEstabelecimento, float avaliacao, String comentario,
                                  Timestamp dataAvaliacao) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idEstabelecimento = idEstabelecimento;
        this.avaliacao = avaliacao;
        this.comentario = comentario;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Timestamp getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Timestamp dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    @Override
    public String toString() {
        return "AvaliarEstabelecimento{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idEstabelecimento=" + idEstabelecimento +
                ", comentario=" + comentario +
                ", avaliacao=" + avaliacao +
                ", dataAvaliacao=" + dataAvaliacao +
                '}';
    }
}
