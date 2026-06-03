package br.com.calcassinc.webservice.service;

import br.com.calcassinc.webservice.dto.UserDTO;
import br.com.calcassinc.webservice.model.Post;
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

    public User fromDTO (UserDTO userDTO){
        User user = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());

        return userRepository.save(user);
    }


    public User addUser(User user){

        return userRepository.save(user);

    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }



}
