package repositorio;

import model.Pessoa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;


@ApplicationScoped
public class PessoaDao implements Serializable {


    @PersistenceContext
    private EntityManager em;


    public void salvar(Pessoa pessoa) {
        if (pessoa.getId() == null)
            em.persist(pessoa);
        else
            em.merge(pessoa);
    }


    public void remover(Pessoa pessoa) {
        em.remove(em.merge(pessoa));
    }

    public Pessoa consultarPorId(Long id) {
        return em.find(Pessoa.class, id);
    }


    public List<Pessoa> consultar() {
        return  em.createQuery("select t from Pessoa t", Pessoa.class).getResultList();
    }


    public List<Pessoa> consultarPorIdadeMaiorQue(Long idade) {
        TypedQuery<Pessoa> typedQuery = em.createQuery("select p from Pessoa p where p.idade > :idade", Pessoa.class);
        typedQuery.setParameter("idade", idade);
        return typedQuery.getResultList();

    }

    public List<Pessoa> consultarPorNome(String nome) {
        TypedQuery<Pessoa> typedQuery = em.createQuery("select p from Pessoa p where p.nome = :nome", Pessoa.class);
        typedQuery.setParameter("nome", nome);
        return typedQuery.getResultList();

    }

    public List<Pessoa> consultarCriteria() {
        CriteriaBuilder cb = em.getCriteriaBuilder(); // Criteria Builder
        CriteriaQuery<Pessoa> query = cb.createQuery(Pessoa.class); // Query
        Root<Pessoa> fromTeste = query.from(Pessoa.class); // from
        query.select(fromTeste);
        TypedQuery<Pessoa> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }


    public List<Pessoa> consultarPorNomeCriteria(String nome) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Pessoa> query = cb.createQuery(Pessoa.class);
        Root<Pessoa> fromTeste = query.from(Pessoa.class); // from
        query.select(fromTeste).where(cb.equal(fromTeste.get("nome"), "Daniel"));
        TypedQuery<Pessoa> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }

    /* JPQL Exemplos
     *
     *   -- InnerJoin
     *
     *   SELECT a, b FROM Author a JOIN a.books b
     *
     *   SELECT b, p FROM BookLob b, Publisher p WHERE b.fk_publisher = p.id
     *
     *
     *  -- Left Outer Joins
     *
     *  SELECT a, b FROM Author a LEFT JOIN a.books b
     *
     *  SELECT a, p FROM Author a JOIN a.publications p ON p.publishingDate > ?1
     *
     *
     */



}
