package br.edu.utfpr.dv.sireata.factory;

import br.edu.utfpr.dv.sireata.dao.AnexoDAO;
import br.edu.utfpr.dv.sireata.dao.AtaParticipanteDAO;
import br.edu.utfpr.dv.sireata.dao.CampusDAO;
import br.edu.utfpr.dv.sireata.dao.ComentarioDAO;
import br.edu.utfpr.dv.sireata.dao.DAO;
import br.edu.utfpr.dv.sireata.dao.DepartamentoDAO;
import br.edu.utfpr.dv.sireata.dao.OrgaoDAO;
import br.edu.utfpr.dv.sireata.dao.PautaDAO;
import br.edu.utfpr.dv.sireata.dao.UsuarioDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;
import br.edu.utfpr.dv.sireata.model.AtaParticipante;
import br.edu.utfpr.dv.sireata.model.Campus;
import br.edu.utfpr.dv.sireata.model.Comentario;
import br.edu.utfpr.dv.sireata.model.Departamento;
import br.edu.utfpr.dv.sireata.model.Orgao;
import br.edu.utfpr.dv.sireata.model.Pauta;
import br.edu.utfpr.dv.sireata.model.Usuario;

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
        if (clazz.isInstance(Campus.class)) {
            return new CampusDAO();
        }
        if (clazz.isInstance(Comentario.class)) {
            return new ComentarioDAO();
        }
        if (clazz.isInstance(Departamento.class)) {
            return new DepartamentoDAO();
        }
        if (clazz.isInstance(Orgao.class)) {
            return new OrgaoDAO();
        }
        if (clazz.isInstance(Pauta.class)) {
            return new PautaDAO();
        }
        if (clazz.isInstance(Usuario.class)) {
            return new UsuarioDAO();
        }
        throw new IllegalArgumentException("Classe nao mapeada: " + clazz.getName());
    }
}
