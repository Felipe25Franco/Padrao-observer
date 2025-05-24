import java.util.Observable;
public class EstacaoMeteorologica extends Observable{
    private String previsao;

    public void atualizarPrevisao(String novaPrevisao) {
        this.previsao = novaPrevisao;
        setChanged();
        notifyObservers(novaPrevisao);
    }

    @Override
    public String toString() {
        return "Estação Meteorológica";
    }
}
