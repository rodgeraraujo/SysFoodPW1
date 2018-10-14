package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.Comida;

public interface ComidaDao {
    Boolean salvar(Comida comida) throws PersistenciaException;
}
