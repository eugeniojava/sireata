package br.edu.utfpr.dv.sireata.dao;

import java.sql.SQLException;

public interface DAO<T> {
    T buscarPorId(int id) throws SQLException;

    void excluir(int id) throws SQLException;
}
