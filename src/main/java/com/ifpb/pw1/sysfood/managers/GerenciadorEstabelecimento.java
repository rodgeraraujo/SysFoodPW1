package com.ifpb.pw1.sysfood.managers;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.factory.Factory;
import com.ifpb.pw1.sysfood.dao.interfaces.EstabelecimentoDao;
import com.ifpb.pw1.sysfood.dao.interfaces.FactoryDao;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;

import java.sql.Time;

public class GerenciadorEstabelecimento {

    private FactoryDao factory = null;
    private EstabelecimentoDao dao = null;

    public GerenciadorEstabelecimento() {
        factory = Factory.createFactory();
        dao = factory.getDaoEstabelecimento();
    }

    public Boolean cadastrar(String nome, Time dataHoraFuncionamento, String rua, int numero, String cidade,
                             String estado, String cep, String tipo, byte[] fotoPerfil, String descricao, int status)
            throws PersistenciaException {

        Estabelecimento estabelecimento = new Estabelecimento(nome, dataHoraFuncionamento, rua, numero, cidade,
                estado, cep, tipo, fotoPerfil, descricao, status);

        return dao.criar(estabelecimento);
    }
}
