package br.com.calcassinc.webservice.config;

import br.com.calcassinc.webservice.model.User;
import br.com.calcassinc.webservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instaciation implements CommandLineRunner {

    private final UserRepository userRepository;

    public Instaciation(UserRepository UserRepository){
        this.userRepository = UserRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

    }
}
