import java.util.Observable;
import java.util.Observer;
public class Cidade implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Cidade(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void registrarNaEstacao(EstacaoMeteorologica estacao) {
        estacao.addObserver(this);
    }

    @Override
    public void update(Observable estacao, Object previsao) {
        this.ultimaNotificacao = "Alerta para " + this.nome + ": nova previsão - " + previsao;
    }
}
