package br.edu.utfpr.dv.sireata.dao;

import java.sql.SQLException;

public interface DAO<T> {
    void excluir(int id) throws SQLException;
}
