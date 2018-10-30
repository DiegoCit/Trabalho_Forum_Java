package br.edu.java.poo.servlets.listar;

import br.edu.java.poo.dao.cliente.ClienteDAO;
import br.edu.java.poo.dao.cliente.impl.ClienteDAOImpl;
import br.edu.java.poo.model.cliente.ClienteDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (urlPatterns = "/listar")
public class ListarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tipo = req.getParameter("tipo");

        if ("clientes".equalsIgnoreCase(tipo)){
            ClienteDAO clienteDAO = new ClienteDAOImpl();
            List<ClienteDTO> listaClientes = clienteDAO.listarClientes();
            req.getSession().setAttribute("listaClientes", listaClientes);
            req.getRequestDispatcher("WEB-INF/listas/listaClientes.jsp").forward(req, resp);
        }
    }
}