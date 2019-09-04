package model.lob.recomendado;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BookContentLob implements Serializable {


    @Id
    private Long id;

    @OneToOne
    @MapsId             // O @MapsId diz ao Hibernate para usar o valor da chave primária do livro associado
    private Book book;

    @Lob
    private String content;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
