package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;
import com.ifpb.pw1.sysfood.entities.Publicacao;
import com.ifpb.pw1.sysfood.entities.PublicacaoEstabelecimento;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface EstabelecimentoDao {
    Boolean criar(Estabelecimento novo) throws PersistenciaException;

    List<Estabelecimento> buscarEstabelecimento(String emailUsuario);

    List<Estabelecimento> buscarNome(String nome);

    Estabelecimento buscar_id(int id) throws PersistenciaException, SQLException, IOException;


    boolean salvarPublicacao(PublicacaoEstabelecimento novo) throws PersistenciaException;

    List<PublicacaoEstabelecimento> buscaPublicacao();

    public List<PublicacaoEstabelecimento> buscaPublicacaoEstabelecimento(int id);
}
