package br.com.calcassinc.webservice.service;

import br.com.calcassinc.webservice.exception.ObjectNotFoundException;
import br.com.calcassinc.webservice.model.Post;
import br.com.calcassinc.webservice.model.User;
import br.com.calcassinc.webservice.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {


    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findbyId(String id){

        Optional<Post> u = postRepository.findById(id);
        return u.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado!"));
    }

    public List<Post> findByTitle(String text){

        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
