package controller;

import model.User;
import org.apache.commons.lang3.RandomStringUtils;
import repository.UserRepository;
import services.EmailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        UserRepository repo = new UserRepository();

        User user = User.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .password(password)
                .activationCode(RandomStringUtils.randomAlphanumeric(20))
                .build();


        repo.create(user);
        EmailService.sendActivationEmail(user);

        response.sendRedirect(request.getContextPath() + "/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request,response);
    }
}
