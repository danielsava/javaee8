package model.lob.recomendado;


import javax.persistence.Id;

/**
 *   Segundo o autor do video (fonte), a melhor prática para mapear atributos LOB é colocados
 *   em uma entidade separada
 *
 */

public class Book {


    @Id
   //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


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

}
