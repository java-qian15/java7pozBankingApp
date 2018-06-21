package controller;

import model.User;
import repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Boolean rememberMe = request.getParameter("rememberMe")!=null;

        UserRepository repo = new UserRepository();
        Optional<User> byEmail = repo.findByEmail(email);
        byEmail.ifPresent(user -> System.out.println(user));
        request.setAttribute("user", byEmail.get());

        System.out.println("");

        request.getRequestDispatcher("/myAccount").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
