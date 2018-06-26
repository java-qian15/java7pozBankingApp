package controller;

import model.User;
import repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "AccountServlet", urlPatterns = "/account")
public class AccountServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession(false);
        UserRepository repo = new UserRepository();

        if (session!=null && session.getAttribute("userId")!=null) {

            Long userId = (Long) session.getAttribute("userId");

            Optional<User> userOptional = repo.get(userId);
            request.setAttribute("user", userOptional.get());

            request.getRequestDispatcher("/account.jsp").forward(request,response);
        }else{
            response.sendError(403);
        }

    }
}
