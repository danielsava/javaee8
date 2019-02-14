package controller;

import Bean.CaveraBean;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class CaveraController implements Serializable {


    private LocalDateTime dataHora;

    private List<CaveraBean> soldados;

    private List<String> identificacoes;


    @PostConstruct
    private void init() {
        dataHora = LocalDateTime.now();
        soldados = CaveraBean.of();
        identificacoes = soldados.stream().map(CaveraBean::getIdentificacao).collect(Collectors.toList());
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

}
