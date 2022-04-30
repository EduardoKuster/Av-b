package controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import dao.sqlite.CompaniaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import modelo.Compania;

/**
 *
 * @author friend
 */
@WebServlet(urlPatterns = {"/compania"})
public class CompaniaControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // DAO para ser usado no servlet
    CompaniaDAO cdao = new CompaniaDAO();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ações get:
        // sem parâmetro: recuperar todos os elementos
        // com parâmetro r: recuperar elemento individual
        // com parâmetro d: excluir elemento
        // com parâmetro f: abrir formulário de inclusão
        
        String retrieve = request.getParameter("r");
        String delete = request.getParameter("d");
        String form = request.getParameter("f");
        String paginamais = request.getParameter("pmais");
        String paginamenos = request.getParameter("pmenos");


        
        if (retrieve != null) {
            // exibe alguém específico?
            try ( PrintWriter out = response.getWriter()) {
           //     Pessoa p = pdao.buscarPessoa(retrieve);
              //  request.setAttribute("alguem", p);
                getServletContext().getRequestDispatcher("/exibir.jsp")
                               .forward(request, response); 
            }
        } else if (delete != null) {
          //  if (pdao.removerPessoa(delete)) {
           //     request.setAttribute("msg", "Pessoa removida com sucesso");
           // } else {
                request.setAttribute("msg", "Ocorreu algum erro ao excluir a pessoa");
            //}
            getServletContext().getRequestDispatcher("/mensagem.jsp")
                               .forward(request, response);                                
        } else if (form != null) {
             getServletContext().getRequestDispatcher("/form.jsp")
                               .forward(request, response);   
        }else if(paginamais != null){
          { // exibe todos
            // obtém dados
            ArrayList<Compania> registros = cdao.retornarCompania(Integer.valueOf(paginamais)+10);
            
            // insere no request
            request.setAttribute("registros", registros);  
            request.setAttribute("pagina", Integer.valueOf(paginamais)+10);

            // encaminha a resposta 
            getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);            
            //response.sendRedirect(request.getContextPath() + "/listar.jsp");
          }
        }else if(paginamenos != null){
          { // exibe todos
            // obtém dados
            ArrayList<Compania> registros = cdao.retornarCompania(Integer.valueOf(paginamenos)-10);
            
            // insere no request
            request.setAttribute("registros", registros);  
            request.setAttribute("pagina", Integer.valueOf(paginamenos)-10);

            // encaminha a resposta 
            getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);            
            //response.sendRedirect(request.getContextPath() + "/listar.jsp");
          }
        }         
        else { // exibe todos
            // obtém dados
            ArrayList<Compania> registros = cdao.retornarCompania(0);
            // insere no request
            request.setAttribute("registros", registros);
            request.setAttribute("pagina", 0);
            // encaminha a resposta 
            getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);            
            //response.sendRedirect(request.getContextPath() + "/listar.jsp");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // configuração para corrigir questões de acento
        request.setCharacterEncoding("utf8");
        

        Compania nova = new Compania();
        nova.setId(request.getParameter("id"));
        nova.setId(request.getParameter("nome"));
        nova.setId(request.getParameter("dominio"));
        nova.setId(request.getParameter("ano"));
        nova.setId(request.getParameter("industria"));
        nova.setId(request.getParameter("tamanho"));
        nova.setId(request.getParameter("localizacao"));
        nova.setId(request.getParameter("pais"));
        nova.setId(request.getParameter("linkedin"));
        nova.setId(request.getParameter("empregados_atual"));
        nova.setId(request.getParameter("empregados_total"));

        cdao.incluirCompania(nova);

        request.setAttribute("msg", "Pessoa incluída com sucesso");
        getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);            
        //response.sendRedirect("mensagem.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
