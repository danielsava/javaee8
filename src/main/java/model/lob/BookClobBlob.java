package model.lob;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;

/**
 * Exemplo de utilização de LOB utilizando os BLOB (byte[]) e CLOB (String).
 *
 * *** ESTE É UM MAPEAMENTO ESPECIFICADO E IMPLEMENTADO SOMENTE PELO HIBERNATE ***
 *
 * Esses atributos permitem o JDBC driver utilizar otimizaçoes específicas para LOB que melhoram a performance
 * da aplicação, como por exemplo o uso de STREAM por parte do driver JDBC.
 *
 * Quais otimizações serão utilizadas, vai depender do drive JDBC e da Base de Dados.
 *
 *
 * fonte: https://www.youtube.com/watch?v=uZXfZZ59cjU (Thoughts On Java)
 *
 *
 */

@Entity
public class BookClobBlob implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    /**
     *
     *  Esta é a forma mais 'natural', com @Lob mapeando os atributos 'byte[]' e 'String' grandes.
     *
     *  Para usar as anotações 'CLOB' e 'BLOB' é necessário alterar o tipo dos atributos (ver entidade BookClobBlob)
     *
     *
     */

    @Lob
    private Blob cover; // BLOB : Imagem (Capa do Livro)

    @Lob //@Nationalized
    private Clob content; // CLOB : String 'muito' grande (Conteúdo do Livro).


    public BookClobBlob() { }


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

    public Blob getCover() {
        return cover;
    }

    public void setCover(Blob cover) {
        this.cover = cover;
    }

    public Clob getContent() {
        return content;
    }

    public void setContent(Clob content) {
        this.content = content;
    }

}
