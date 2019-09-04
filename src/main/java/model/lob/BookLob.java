package model.lob;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Exemplo de utilização de LOB da forma mais 'natural', com byte[] e String
 *
 *  - byte[] : Images
 *  - String : Conteúdo texto muito 'muito' extensos
 *
 *
 *  *** ESTE É UM MAPEAMENTO ESPECIFICADO PELA JPA ***
 *
 * Essa é a forma mais simples, mais natural ao Java mas menos performática.
 *
 * fonte: https://www.youtube.com/watch?v=uZXfZZ59cjU (Thoughts On Java)
 *
 *
 */

@Entity
public class BookLob implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    /**
     *
     *  Esta é a forma mais 'natural', com @Lob mapeando os atributos 'byte[]' e 'String' grandes.
     *
     *  Para usar as anotações
     *
     *
     */

    @Lob
    private byte[] cover; // BLOB : Imagem (Capa do Livro)

    @Lob //@Nationalized
    private String content; // CLOB : String 'muito' grande (Conteúdo do Livro).


    public BookLob() { }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
