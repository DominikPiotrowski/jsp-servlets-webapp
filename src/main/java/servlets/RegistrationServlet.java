package servlets;

import model.BankAccount;
import model.ECurrency;
import model.User;
import org.apache.commons.lang3.RandomStringUtils;
import repo.BankAccountRepository;
import repo.UserRepository;
import services.EmailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registrationServlet")
public class RegistrationServlet extends HttpServlet {
    EmailService emailService;
    UserRepository userRepository;
    BankAccountRepository bankAccountRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        userRepository = new UserRepository();
        emailService = new EmailService();
        bankAccountRepository = new BankAccountRepository();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User newUser = getUserFromRequest(request);
        BankAccount newBankAccount = createNewAccount(newUser);
        bankAccountRepository.create(newBankAccount);
        userRepository.create(newUser);
        emailService.sendActivationEmail(newUser);

        response.sendRedirect("/account-created.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public User getUserFromRequest(HttpServletRequest request) {

        final String firstName = request.getParameter("firstName");
        final String lastName = request.getParameter("lastName");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final String actiovationCode = RandomStringUtils.randomAlphanumeric(50);

        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .activationcode(actiovationCode)
                .activated(false)
                .build();
    }

    public BankAccount createNewAccount(User user) {
        String newAccountNumber = (RandomStringUtils.randomNumeric(18));

        BankAccount bankAccount = BankAccount.builder()
                .freeFounds(0L)
                .accountNumber(newAccountNumber)
                .currency(ECurrency.PLN)
                .build();

        user.setBankAccounts(Arrays.asList(bankAccount));
        return bankAccount;
    }
}