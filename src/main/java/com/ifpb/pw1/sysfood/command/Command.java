package com.ifpb.pw1.sysfood.command;

import com.ifpb.pw1.sysfood.dao.exceptions.PersistenciaException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface Command {
    void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, PersistenciaException, SQLException;
}
