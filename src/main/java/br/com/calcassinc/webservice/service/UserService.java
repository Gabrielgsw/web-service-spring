package br.com.calcassinc.webservice.service;

import br.com.calcassinc.webservice.model.User;
import br.com.calcassinc.webservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();

    }
}
