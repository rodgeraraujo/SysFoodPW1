package com.ifpb.pw1.sysfood.entities;

public class PublicacaoEstabelecimento {
    private int id;
    private String nomeEstabelecimento;
    private String conteudo;
    private int idEstabelecimento;
    private String dataPublicacao;
    private String foto;
    private String estabelecimentoFoto;
    private String tipo;


    public PublicacaoEstabelecimento(int id, String nomeEstabelecimento, String conteudo, int idEstabelecimento,
                                     String dataPublicacao, String foto, String estabelecimentoFoto, String tipo) {
        this.id = id;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.conteudo = conteudo;
        this.idEstabelecimento = idEstabelecimento;
        this.dataPublicacao = dataPublicacao;
        this.foto = foto;
        this.estabelecimentoFoto = estabelecimentoFoto;
        this.tipo = tipo;
    }

    public PublicacaoEstabelecimento(String nomeEstabelecimento, String conteudo, int idEstabelecimento,
                                     String dataPublicacao, String foto, String estabelecimentoFoto, String tipo) {
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.conteudo = conteudo;
        this.idEstabelecimento = idEstabelecimento;
        this.dataPublicacao = dataPublicacao;
        this.foto = foto;
        this.estabelecimentoFoto = estabelecimentoFoto;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(int idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
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

    public String getEstabelecimentoFoto() {
        return estabelecimentoFoto;
    }

    public void setEstabelecimentoFoto(String estabelecimentoFoto) {
        this.estabelecimentoFoto = estabelecimentoFoto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "PublicacaoEstabelecimento{" +
                "id=" + id +
                ", nomeEstabelecimento='" + nomeEstabelecimento + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", idEstabelecimento=" + idEstabelecimento +
                ", dataPublicacao='" + dataPublicacao + '\'' +
                ", foto='" + foto + '\'' +
                ", estabelecimentoFoto='" + estabelecimentoFoto + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
