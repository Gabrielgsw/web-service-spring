package br.com.calcassinc.webservice.service;

import br.com.calcassinc.webservice.model.User;
import br.com.calcassinc.webservice.repository.UserRepository;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();

    }

    public User findById(String id){

        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new ObjectCollectedException("Objeto não encontrado");
        }
        return userRepository.findById(id).orElseThrow();
    }
}
