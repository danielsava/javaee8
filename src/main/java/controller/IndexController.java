package controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class IndexController implements Serializable {


    private String mensagem;


    private Integer contador;

    @PostConstruct
    private void init() {
        contador = 0;
    }


    public void mostrarMensagem() {
        mensagem = "Cavera !!!";
        contador++;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

}
