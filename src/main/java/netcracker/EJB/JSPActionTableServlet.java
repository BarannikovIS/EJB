/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netcracker.EJB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Иван
 */
@WebServlet("/jspactiontable")
public class JSPActionTableServlet extends HttpServlet {

    @EJB
    InitializationTableBean initializationService;
    @EJB
    TableActionBean concatenateService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Action> listJspActions = initializationService.getActionsTable();
        request.getSession().setAttribute("listJspActions", listJspActions);
        request.getRequestDispatcher("jspactiontable.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("concatenate") != null) {
            ArrayList<Action> listJspActions = (ArrayList<Action>) request.getSession().getAttribute("listJspActions");
            String concatenateString = concatenateService.concatenateColumns(listJspActions);
            request.getSession().setAttribute("concatenateString", concatenateString);
            request.getRequestDispatcher("jspactiontable.jsp").forward(request, response);
        }
        if(request.getParameter("remove")!=null && request.getParameter("index")!=null && !request.getParameter("index").equals("")){
            initializationService.removeTheIndex(Integer.parseInt(request.getParameter("index")));
            request.getRequestDispatcher("jspactiontable.jsp").forward(request, response);
        }
    }
}
