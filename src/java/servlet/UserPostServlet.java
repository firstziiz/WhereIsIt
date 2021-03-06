/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Post;
import Repo.Repo;
import model.User;
/**
 *
 * @author Huag
 */
public class UserPostServlet extends HttpServlet {

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
        if(request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }
        
        String query = request.getQueryString();
        int index;
        String type = "";
        
        if(query != null){
          index = query.indexOf("=");
          type = query.substring(index+1);
        }
        System.out.println(type);
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("loggedInUser");
        String search = request.getParameter("searchParam");
        List<Post> listPost = null;
        if(session != null && user != null){
            int userId = user.getUserId();
            
            if(search == null){
                if(type.equalsIgnoreCase("Pending") && search == null){
                    listPost = Repo.findPostByStatusAndUserId(1, userId);
                }
                else if(type.equalsIgnoreCase("closed") && search == null){
                    listPost = Repo.findPostByStatusAndUserId(2, userId);
                }
                else{
                    listPost = Repo.findPostByUserId(userId);
                    type = "all";
                }
            }
            else{
               listPost = Repo.findPostByNameAndUserId(search,userId);
            }
            request.setAttribute("type", type);
            request.setAttribute("userPost", listPost);
                getServletContext().getRequestDispatcher("/pages/user_post.jsp").forward(request, response);

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
