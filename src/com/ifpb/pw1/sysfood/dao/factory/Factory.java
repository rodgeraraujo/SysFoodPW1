package com.ifpb.pw1.sysfood.dao.factory;

import com.ifpb.pw1.sysfood.dao.interfaces.FactoryDao;

public class Factory {
    public static FactoryDao createFactory(){
        return new FactoryBD();
    }
}
