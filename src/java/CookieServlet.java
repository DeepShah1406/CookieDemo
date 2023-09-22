

import java.sql.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class CookieServlet extends HttpServlet {
    


protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookieServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            
            Cookie ck[] = request.getCookies();
            
            if(ck==null)
            {
                out.println("<h1 align='center'>No Cookie is Found!</h1>");
                out.println("<h1 align='center'>So, now creating two Cookie's.</h1>");
                
                //Code to create Cookie's.
                Cookie c1 = new Cookie("Name","XYZ");
                Cookie c2 = new Cookie("Gender","Male");
                
                //Making Cookie c1 persistent
                c1.setMaxAge(600);
                c2.setMaxAge(60);
                
                //Code to add Cookie's to the browser
                response.addCookie(c1);
                response.addCookie(c2);
                
                out.println("<h1 align='center'>Created and added two Cookie's.</h1>");
            }
            
            else
            {
                out.println("<h1 align='center'>No Cookie's are Found!</h1>");
                int count = ck.length;
                out.println("<h1 align='center'>No. of Cookie's found = "+count+"</h1>");
                for (Cookie c:ck)
                {
                    out.println("<h1 align='center'>Name = "+c.getName());
                    out.println(", Value = "+c.getValue()+"</h1>");
                }
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
