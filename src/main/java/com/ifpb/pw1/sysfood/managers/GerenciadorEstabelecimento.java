package com.ifpb.pw1.sysfood.managers;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.dao.factory.Factory;
import com.ifpb.pw1.sysfood.dao.interfaces.EstabelecimentoDao;
import com.ifpb.pw1.sysfood.dao.interfaces.FactoryDao;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class GerenciadorEstabelecimento {

    private FactoryDao factory = null;
    private EstabelecimentoDao dao = null;

    public GerenciadorEstabelecimento() {
        factory = Factory.createFactory();
        dao = factory.getDaoEstabelecimento();
    }

    public Boolean cadastrar(String nome, String dataHoraFuncionamento, String rua, String numero, String cidade,
                             String estado, String cep, String tipo, String fotoPerfil, String descricao, String usuarioEmail, int status)
            throws PersistenciaException {

        Estabelecimento estabelecimento = new Estabelecimento(nome, dataHoraFuncionamento, rua, numero, cidade,
                estado, cep, tipo, fotoPerfil, descricao, usuarioEmail, status);

        return dao.criar(estabelecimento);
    }

    public Estabelecimento buscar_id(int id) throws PersistenciaException, IOException, SQLException {
        return dao.buscar_id(id);
    }

    public List<Estabelecimento> buscarNome(String nome){
        return dao.buscarNome(nome);
    }
}
