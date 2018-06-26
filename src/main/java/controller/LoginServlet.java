package controller;

import model.User;
import repository.UserRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


    @Inject
    UserRepository repo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Boolean rememberMe = request.getParameter("rememberMe")!=null;

        Optional<User> byEmail = repo.findByEmail(email);


        if (!byEmail.get().getPassword().equals(password)) {
            response.sendError(403);
        }else{

            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(rememberMe ? 3600 : 600);

            session.setAttribute("userId", byEmail.get().getId());
        }

        response.sendRedirect(request.getContextPath() + "/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
