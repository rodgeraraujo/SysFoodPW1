package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Estabelecimento;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface EstabelecimentoDao {
    Boolean criar(Estabelecimento novo) throws PersistenciaException;

    List<Estabelecimento> buscarEstabelecimento(String emailUsuario);

    Estabelecimento buscar(String email) throws PersistenciaException, SQLException, IOException;
}
