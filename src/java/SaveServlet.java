/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import static java.util.Collections.list;
import java.util.List;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")

/**
 *
 * @author Anoop S Kumar
 */
public class SaveServlet extends HttpServlet {

   
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
          
        Emp e=new Emp();  
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country);  
          
        int status=EmpDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
        
         List<Emp> list=EmpDao.getAllEmployeesByName(name); 
        
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");  
        for(Emp b:list){  
         out.print("<tr><td>"+b.getId()+"</td><td>"+b.getName()+"</td><td>"+b.getPassword()+"</td><td>"+b.getEmail()+"</td><td>"+b.getCountry()+"</td><td><a href='EditServlet?id="+b.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+b.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>"); 
        
        }

    }

}
