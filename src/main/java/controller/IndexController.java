package controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.RequestCookieMap;
import javax.faces.annotation.SessionMap;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.io.Serializable;
import java.util.Map;

@Named
@SessionScoped
public class IndexController implements Serializable {


    @Inject
    @RequestCookieMap //@RequestCookieMap
    private Map<String, Object> cookies;


    @Inject
    @SessionMap  //@SessionMap
    private Map<String, Object> sessionMap;


    @Inject
    private ServletContext servletContext;

    private String mensagem;


    private Integer contador;


    private String servidor;


    @PostConstruct
    private void init() {
        servidor = servletContext.getServerInfo();
        contador = 0;
    }


    public void mostrarMensagem() {
        System.out.println(servidor);
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

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

}
