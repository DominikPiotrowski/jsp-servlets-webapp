package servlets;

import model.User;
import repo.GenericRepository;
import repo.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        userRepository = new UserRepository();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        final Optional<User> userByEmail = userRepository.findByEmail(email);

        Optional<User> userOptional = userByEmail
                .filter(user -> user.getEmail().equals(email))
                .filter(user -> user.getPassword().equals(password));

        if (userOptional.isPresent()) {
            HttpSession session = request.getSession(true);

            if (Boolean.parseBoolean(request.getParameter("remember-me"))) {
                session.setMaxInactiveInterval(10000);
            }
            session.setMaxInactiveInterval(600);
            session.setAttribute("email", email);
            response.sendRedirect("/account");

        } else {
            response.sendRedirect("/user-not-valid.jsp");
        }
    }
}