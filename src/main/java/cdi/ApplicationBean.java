package cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

@ApplicationScoped
public class ApplicationBean implements Serializable {


    public static int contador = 0;

    public ApplicationBean() {
        contador++;
    }

    @PostConstruct
    private void init() {
        System.out.println(ApplicationBean.class.getSimpleName() + " : Construído");
    }


    @PreDestroy
    private void destroy() {
        System.out.println(ApplicationBean.class.getSimpleName() + " : Destruído");
    }


    public void hellow() {
        System.out.println("(APPLICATION) Estou Vivo ...");
    }


}
