/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anoop S Kumar
 */
public class DeleteServlet extends HttpServlet {

   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
             String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        EmpDao.delete(id);  
        response.sendRedirect("ViewServlet");  
        }
    }

    


