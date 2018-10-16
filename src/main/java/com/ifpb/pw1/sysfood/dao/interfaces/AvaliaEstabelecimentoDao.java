package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.AvaliarEstabelecimento;
import com.ifpb.pw1.sysfood.entities.Publicacao;

import java.sql.SQLException;
import java.util.List;

public interface AvaliaEstabelecimentoDao {

    Float MediaNota();

    boolean Avaliar(AvaliarEstabelecimento avaliar);

    List<AvaliarEstabelecimento> buscar(int id);

    boolean buscarAvaliacaoUsuario(int u_id, int e_id) throws SQLException;
}
