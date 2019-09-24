package listener;

import lombok.extern.slf4j.Slf4j;
import model.BankAccount;
import model.ECurrency;
import model.User;
import repo.BankAccountRepository;
import repo.GenericRepository;
import repo.UserRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebListener
@Slf4j //logs
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final UserRepository repository = new UserRepository();
        final BankAccountRepository bankAccountRepository = new BankAccountRepository();

        BankAccount account1 = BankAccount.builder()
                .accountNumber("444555666")
                .freeFounds(500.00)
                .currency(ECurrency.PLN)
                .build();
        bankAccountRepository.create(account1);

        BankAccount account2 = BankAccount.builder()
                .accountNumber("555666777")
                .freeFounds(1500.00)
                .currency(ECurrency.PLN)
                .build();
        bankAccountRepository.create(account2);

        BankAccount account3 = BankAccount.builder()
                .accountNumber("777888999")
                .freeFounds(1800.00)
                .currency(ECurrency.PLN)
                .build();
        bankAccountRepository.create(account3);

        BankAccount account4 = BankAccount.builder()
                .accountNumber("888999111")
                .freeFounds(5000.00)
                .currency(ECurrency.PLN)
                .build();
        bankAccountRepository.create(account4);

        List<BankAccount> bankAccountList1 = Arrays.asList(account1, account2);
        List<BankAccount> bankAccountList2 =Arrays.asList(account3, account4);

        User user1 = User.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .password("123")
                .email("jk@yahoo.com")
                .bankAccounts(bankAccountList1)
                .build();
        repository.create(user1);

        User user2 = User.builder()
                .firstName("Dominik")
                .lastName("Piotrowski")
                .password("456")
                .email("dp@yahoo.com")
                .bankAccounts(bankAccountList2)
                .build();
        repository.create(user2);

        log.info("Creating user with details {}", user1);
        log.info("Creating user with details {}", user2);
        log.info("Creating bank account {}", bankAccountList1);
        log.info("Creating bank account {}", bankAccountList2);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}