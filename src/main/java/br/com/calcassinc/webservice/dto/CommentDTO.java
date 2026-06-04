package br.com.calcassinc.webservice.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {

    private static final long seriaVersionUID = 1L;

    private String text;
    private Date data;
    private UserDTO autor;

    public CommentDTO(){

    }

    public CommentDTO(String text, Date data, UserDTO autor) {
        this.text = text;
        this.data = data;
        this.autor = autor;
    }


}
