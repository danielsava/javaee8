package repositorio;

import model.Teste;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;


@ApplicationScoped
public class TesteDao implements Serializable {


    @PersistenceContext
    private EntityManager em;


    public void salvar(Teste teste) {
        em.persist(teste);
    }

    /*
    public List<Teste> findAll() {
        return em.createNamedQuery("Teste.findAll", Teste.class).getResultList();
    }
    */


    /* Stream findAll
    public Stream<Person> findAll() {
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(Person.class));
        return entityManager.createQuery(criteriaQuery).getResultStream();
    }
    */


}
