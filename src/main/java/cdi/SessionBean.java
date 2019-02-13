package cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class SessionBean implements Serializable {


    public static int contador = 0;

    public SessionBean() {
        contador++;
    }

    @PostConstruct
    private void init() {
        System.out.println(SessionBean.class.getSimpleName() + " : Construído");
    }

    @PreDestroy
    private void destroy() {
        System.out.println(SessionBean.class.getSimpleName() + " : Destruído");
    }

    public void hellow() {
        System.out.println("(SESSION) Estou Vivo ...");
    }
    

}
