package br.edu.utfpr.dv.sireata.factory;

import br.edu.utfpr.dv.sireata.dao.AnexoDAO;
import br.edu.utfpr.dv.sireata.dao.DAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

public final class DAOFactory {
    private DAOFactory() {
    }

    public static DAO<?> getInstance(Class<?> clazz) {
        if (clazz.isInstance(Anexo.class)) {
            return new AnexoDAO();
        }
        throw new IllegalArgumentException("Classe nao mapeada: " + clazz.getName());
    }
}
