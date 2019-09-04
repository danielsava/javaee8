package model.lob.recomendado;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BookCoverLob implements Serializable {


    @Id
    private Long id;

    @OneToOne
    @MapsId
    private Book book;

    @Lob
    private byte[] cover;


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

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

}
