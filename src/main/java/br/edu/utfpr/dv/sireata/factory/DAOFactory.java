package br.edu.utfpr.dv.sireata.factory;

import br.edu.utfpr.dv.sireata.dao.AnexoDAO;
import br.edu.utfpr.dv.sireata.dao.AtaParticipanteDAO;
import br.edu.utfpr.dv.sireata.dao.DAO;
import br.edu.utfpr.dv.sireata.dao.PautaDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;
import br.edu.utfpr.dv.sireata.model.AtaParticipante;
import br.edu.utfpr.dv.sireata.model.Pauta;

public final class DAOFactory {
    private DAOFactory() {
    }

    public static DAO<?> getInstance(Class<?> clazz) {
        if (clazz.isInstance(Anexo.class)) {
            return new AnexoDAO();
        }
        if (clazz.isInstance(AtaParticipante.class)) {
            return new AtaParticipanteDAO();
        }
        if (clazz.isInstance(Pauta.class)) {
            return new PautaDAO();
        }
        throw new IllegalArgumentException("Classe nao mapeada: " + clazz.getName());
    }
}
