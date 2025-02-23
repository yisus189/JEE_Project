/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.arquitectura.project.entity.Project;
import co.edu.unipiloto.arquitectura.project.session.ProjectFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juann
 */
@WebServlet(name = "ProjectServlet", urlPatterns = {"/ProjectServlet"})
public class ProjectServlet extends HttpServlet {

    @EJB
    private ProjectFacadeLocal projectFacade;

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String projectidStr = request.getParameter("projectId");
        Integer projectid = new Integer(projectidStr);
        String projectname = request.getParameter("projectName");
        String projectdesc = request.getParameter("projectDesc");
        String projectplace = request.getParameter("projectPlace");
        String projectbudget = request.getParameter("projectBudget");
        String projectpopStr = request.getParameter("projectPop");
        Integer projectpop = new Integer(projectpopStr);

        // Crear un objeto Project con los datos del formulario
        Project project = new Project(projectid, projectname, projectdesc, projectplace, projectbudget, projectpop);

        switch (action) {
            case "Agregar":
                projectFacade.create(project);
                break;
            case "Editar":
                projectFacade.edit(project);
                break;
            case "Eliminar":
                projectFacade.remove(project);
                break;
            case "Buscar":
                project = projectFacade.find(projectid);
                request.setAttribute("searchResult", project);
                break;
        }

        List<Project> allProjects = projectFacade.findAll();
        request.setAttribute("allProjects", allProjects);
        request.getRequestDispatcher("projectInfo.jsp").forward(request, response);

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProjectServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProjectServlet at " + action + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
