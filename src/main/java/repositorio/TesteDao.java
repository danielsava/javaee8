package repositorio;

import model.Teste;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;


/*
@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
        @NamedQuery(name = "Movie.findById", query = "SELECT m FROM Movie m WHERE m.id = :id"),
        @NamedQuery(name = "Movie.findByName", query = "SELECT m FROM Movie m WHERE m.name = :name"),
        @NamedQuery(name = "Movie.findByActors", query = "SELECT m FROM Movie m WHERE m.actors = :actors") })
*/


public class TesteDao implements Serializable {


    //@Inject
    private EntityManager em;



    public void persist(Teste teste) {
        em.persist(teste);
    }

    public List<Teste> findAll() {
        return em.createNamedQuery("Teste.findAll", Teste.class).getResultList();
    }


    /* Stream findAll
    public Stream<Person> findAll() {
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(Person.class));
        return entityManager.createQuery(criteriaQuery).getResultStream();
    }
    */


}
