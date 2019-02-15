package bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CaveraBean {

    private String nome;

    private String identificacao;

    private LocalDateTime dataHora;

    public CaveraBean(String nome) {
        this.nome = nome;
        this.identificacao = UUID.randomUUID().toString();
        this.dataHora = LocalDateTime.now();
    }

    public static CaveraBean of(String nome) {
        return new CaveraBean(nome);
    }


    public static List<CaveraBean> of() {

        List<CaveraBean> resultado = new ArrayList<>();

        resultado.add(CaveraBean.of("Sava"));
        resultado.add(CaveraBean.of("Rodrigao"));
        resultado.add(CaveraBean.of("Fagury"));
        resultado.add(CaveraBean.of("Mestre"));
        resultado.add(CaveraBean.of("Soldado"));
        resultado.add(CaveraBean.of("Jeff"));
        resultado.add(CaveraBean.of("Vianna"));
        resultado.add(CaveraBean.of("Estagi's"));
        resultado.add(CaveraBean.of("Alex"));

        return resultado;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

}
