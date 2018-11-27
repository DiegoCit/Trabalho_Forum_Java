package br.edu.java.poo.servlets.thread;

import br.edu.java.poo.dao.thread.ThreadDAO;
import br.edu.java.poo.dao.thread.impl.ThreadDAOImpl;
import br.edu.java.poo.model.thread.ThreadDTO;
import br.edu.java.poo.model.ticket.TicketDTO;
import br.edu.java.poo.model.topico.TopicoDTO;
import br.edu.java.poo.model.usuario.UsuarioDTO;
import br.edu.java.poo.model.usuario.UsuarioSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/thread")
public class ThreadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        String tt = (String) req.getSession().getAttribute("tt");

        if ("respostaPostagemThread".equalsIgnoreCase(acao)) {
            String id = (String) req.getSession().getAttribute("id");
            String tipo = req.getParameter("tipo");
            String mensagem = req.getParameter("mensagemResposta");
            UsuarioSession usuarioSession = (UsuarioSession) req.getSession().getAttribute("usuario");
            ThreadDAO threadDAO = new ThreadDAOImpl();
            String nomeAutor = threadDAO.buscaNomeAutor(tipo, Integer.parseInt(id));
            ThreadDTO threadDTO = new ThreadDTO();
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuarioSession.getId());
            threadDTO.setUsuarioDTO(usuarioDTO);
            threadDTO.setMensagem(mensagem);
            threadDTO.setAutor(usuarioSession.getNomeConta());
            if (nomeAutor.equalsIgnoreCase(usuarioSession.getNomeConta())) {
                threadDTO.setAutorPergunta(1);
            } else {
                threadDTO.setAutorPergunta(0);
            }
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String data = dateFormat.format(new Date());

            try {
                threadDTO.setDataPostagem(dateFormat.parse(data));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if ("topico".equalsIgnoreCase(tipo)) {
                TopicoDTO topicoDTO = new TopicoDTO();
                topicoDTO.setId(Integer.parseInt(id));
                threadDTO.setTicketDTO(null);
                threadDTO.setTopicoDTO(topicoDTO);
            } else {
                TicketDTO ticketDTO = new TicketDTO();
                ticketDTO.setId(Integer.parseInt(id));
                threadDTO.setTopicoDTO(null);
                threadDTO.setTicketDTO(ticketDTO);
            }

            threadDTO.setId(threadDAO.criarThread(threadDTO));

            List<ThreadDTO> listaThread = threadDAO.listarThread(tt, Integer.parseInt(id));
            req.setAttribute("listaThread", listaThread);

            req.getRequestDispatcher("WEB-INF/thread/mostraThread.jsp").forward(req, resp);


        }

        if ("threadTicket".equalsIgnoreCase(acao)) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tipo = req.getParameter("tipo");

        if ("mostrar".equalsIgnoreCase(tipo)) {
            String tt = (String) req.getSession().getAttribute("tt");
            ThreadDAO threadDAO = new ThreadDAOImpl();
            String id = req.getParameter("id");
            String titulo = req.getParameter("titulo");
            List<ThreadDTO> listaThread = threadDAO.listarThread(tt, Integer.parseInt(id));
            req.setAttribute("listaThread", listaThread);
            req.setAttribute("titulo", titulo);
            req.setAttribute("id", id);
            req.getRequestDispatcher("WEB-INF/thread/mostraThread.jsp").forward(req, resp);
        }

        if ("responderPostagem".equalsIgnoreCase(tipo)) {
            String autor = req.getParameter("autor");
            String titulo = req.getParameter("titulo");
            String mensagem = req.getParameter("mensagem");
            String id = req.getParameter("id");
            req.setAttribute("autor", autor);
            req.getSession().setAttribute("titulo", titulo);
            req.setAttribute("mensagem", mensagem);
            req.getSession().setAttribute("id", id);
            req.getRequestDispatcher("WEB-INF/thread/respostaThread.jsp").forward(req, resp);
        }

        if ("responder".equalsIgnoreCase(tipo)) {
            String titulo = req.getParameter("titulo");
            String id = req.getParameter("id");
            req.getSession().setAttribute("titulo", titulo);
            req.getSession().setAttribute("id", id);
            req.getRequestDispatcher("WEB-INF/thread/respostaThread.jsp").forward(req, resp);
        }
    }
}
