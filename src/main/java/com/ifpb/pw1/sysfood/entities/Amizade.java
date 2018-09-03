package com.ifpb.pw1.sysfood.entities;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class Amizade {
    private static List<Solicitacao> solicitacoes = new ArrayList<>();

    public static void addSolicitacao(Usuario remetente, Usuario destinatario) throws PersistenceException{

    }

    public static void getSolicitacoesRecebidas(Usuario usuario) throws PersistenceException {

    }

    public static void aceitarSolicitacao(Solicitacao solicitacao) throws PersistenceException{

    }

    public static void getAmigos(Usuario usuario) throws PersistenceException{

    }

    public static void removerSolicitacão(String rem, String dest) throws PersistenceException{

    }
}
