package com.ifpb.pw1.sysfood.entities;

import java.security.Timestamp;

public class Solicitacao {
    private Usuario remetente;
    private Usuario destinatario;
    private int status;
    private Timestamp datahora;

    public static final int PENDENTE = 0;
    public static final int ACEITO = 1;

    public Solicitacao() {
    }

    public Solicitacao(Usuario remetente, Usuario destinatario) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.status = PENDENTE;

    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getDatahora() {
        return datahora;
    }

    public void setDatahora(Timestamp datahora) {
        this.datahora = datahora;
    }
}
