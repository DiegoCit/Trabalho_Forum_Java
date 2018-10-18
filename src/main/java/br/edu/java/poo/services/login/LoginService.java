package br.edu.java.poo.services.login;

import br.edu.java.poo.business.UsuarioBusiness;
import br.edu.java.poo.business.impl.UsuarioBusinessImpl;
import br.edu.java.poo.dao.UsuarioDAO;
import br.edu.java.poo.dao.impl.UsuarioDAOImpl;
import br.edu.java.poo.model.usuario.UsuarioDTO;

public class LoginService {
    UsuarioDAO usuarioDAO;
    UsuarioBusiness usuarioBusiness;

    public LoginService() {
        this.usuarioDAO = new UsuarioDAOImpl();
        this.usuarioBusiness = new UsuarioBusinessImpl();
    }

    public String login(UsuarioDTO usuarioDTO) throws ClassNotFoundException {
        UsuarioDTO usuarioBusca = usuarioDAO.buscarUsuario(usuarioDTO);

        if (usuarioBusca != null) {
            boolean primeiroAcesso = usuarioBusiness.conferePrimeiroLogin(usuarioBusca);

            if (primeiroAcesso) {
                return "PrimeiroAcesso";
            }
            if ("administrador".equalsIgnoreCase(usuarioBusca.getTipoAcesso())) {
                return "administrador";
            }
        }
        return "usuarioInexistente";
    }

}
