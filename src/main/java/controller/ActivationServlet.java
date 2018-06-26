package controller;

import model.User;
import repository.UserRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "ActivationServlet", urlPatterns = "/activate")
public class ActivationServlet extends HttpServlet {

    @Inject
    UserRepository repository;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String activationCode = request.getParameter("code");

        Optional<User> optionalUser = repository.findByActivationCode(activationCode);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setActivated(true);
            user.setActivationCode(null);
            repository.update(user);
            response.sendRedirect(request.getContextPath() + "/");
        }else{
            response.sendError(404);
        }
    }
}
