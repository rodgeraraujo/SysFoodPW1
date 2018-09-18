package com.ifpb.pw1.sysfood.dao.interfaces;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;
import com.ifpb.pw1.sysfood.entities.LoginBean;
import com.ifpb.pw1.sysfood.entities.Usuario;

public interface LoginDao {
    Usuario autentica(LoginBean login) throws PersistenciaException;
}
