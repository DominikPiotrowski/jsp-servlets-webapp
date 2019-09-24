package servlets;

import model.User;
import repo.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "MyAccountServlet", urlPatterns = "/account")
public class MyAccountServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        UserRepository repository = new UserRepository();

        if (session != null) {
            //session.setAttribute("email", User);
            Object email = session.getAttribute("email");
            Optional<User> presentUser = repository.findByEmail((String) email);
            presentUser.ifPresent(user -> request.setAttribute("user", user));
        }
        request.getRequestDispatcher("/account.jsp").forward(request, response);
    }
}