package cdi.producer.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class EntityManagerProducer {


    /**
     *   Com o uso do Qualifier (anotação), pode produzir diversos EntityManager,
     *   uma para cada Unidade de Persistencia, caso o sistema utilize.
     *
     */

    //@Produces
    //@PersistenceContext(unitName = "applicationPetstorePU")
    private EntityManager entityManager;


}
