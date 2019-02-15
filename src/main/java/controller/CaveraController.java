package controller;

import Bean.CaveraBean;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class CaveraController implements Serializable {


    private String login;

    private String senha;



    private LocalDateTime dataHora;

    private List<CaveraBean> soldados;

    private List<String> identificacoes;


    @PostConstruct
    private void init() {
        dataHora = LocalDateTime.now();
        soldados = CaveraBean.of();
        identificacoes = soldados.stream().map(CaveraBean::getIdentificacao).collect(Collectors.toList());
    }

    public void login() {

        FacesMessage message = null;

        boolean loggedIn = false;

        if(login != null && login.equals("cavera") && senha != null && senha.equals("cavera")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", login);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Reprovado", "NUNCA SERÃO !!!");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);

        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);

    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public List<CaveraBean> getSoldados() {
        return soldados;
    }

    public void setSoldados(List<CaveraBean> soldados) {
        this.soldados = soldados;
    }

    public List<String> getIdentificacoes() {
        return identificacoes;
    }

    public void setIdentificacoes(List<String> identificacoes) {
        this.identificacoes = identificacoes;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
