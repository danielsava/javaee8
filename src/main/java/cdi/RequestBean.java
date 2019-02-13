package cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

@RequestScoped
public class RequestBean implements Serializable {


    public static int contador = 0;

    public RequestBean() {
        contador++;
    }

    @PostConstruct
    private void init() {
        System.out.println(RequestBean.class.getSimpleName() + " : Construído");
    }


    @PreDestroy
    private void destroy() {
        System.out.println(RequestBean.class.getSimpleName() + " : Destruído");
    }

    public void hellow() {
        System.out.println("(REQUEST) Estou Vivo ...");
    }
    

}
