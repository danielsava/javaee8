package controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;

@Named
@ApplicationScoped
public class AplicacaoController implements Serializable {


    public void preRenderView() {
        System.out.println("Evento PreRender : " + LocalDateTime.now());
    }

    public void posRenderView() {
        System.out.println("Evento PosRender : " + LocalDateTime.now());
    }

}
