package listener;


import lombok.extern.slf4j.Slf4j;
import model.BankAccount;
import model.Currency;
import model.User;
import repository.BankAccountRepository;
import repository.UserRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Slf4j
public class ContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        log.error("sratatata");
        UserRepository userRepository = new UserRepository();
        BankAccountRepository bankAccountRepository = new BankAccountRepository();

        BankAccount account = BankAccount.builder()
                .accountNumber("12345678901234567890")
                .availableFunds(2500L)
                .balance(300L)
                .currency(Currency.PLN)
                .build();

        bankAccountRepository.create(account);

        User user = User.builder()
                .email("test@gmail.com")
                .password("password")
                .firstName("Pawel")
                .lastName("Wronski")
                .bankAccount(account)
                .build();

        userRepository.create(user);

        log.info("Creating user with details: {}", user);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
