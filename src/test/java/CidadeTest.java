import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CidadeTest {

    @Test
    void deveNotificarUmaCidade() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica();
        Cidade cidade = new Cidade("São Paulo");
        cidade.registrarNaEstacao(estacao);
        estacao.atualizarPrevisao("Chuva forte");

        assertEquals("Alerta para São Paulo: nova previsão - Chuva forte", cidade.getUltimaNotificacao());
    }
    @Test
    void deveNotificarVariasCidades() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica();
        Cidade cidade1 = new Cidade("Rio de Janeiro");
        Cidade cidade2 = new Cidade("Belo Horizonte");
        cidade1.registrarNaEstacao(estacao);
        cidade2.registrarNaEstacao(estacao);

        estacao.atualizarPrevisao("Tempo nublado");

        assertEquals("Alerta para Rio de Janeiro: nova previsão - Tempo nublado", cidade1.getUltimaNotificacao());
        assertEquals("Alerta para Belo Horizonte: nova previsão - Tempo nublado", cidade2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCidadeNaoRegistrada() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica();
        Cidade cidade = new Cidade("Curitiba");

        estacao.atualizarPrevisao("Tempestade de granizo");

        assertNull(cidade.getUltimaNotificacao());
    }

    @Test
    void deveNotificarApenasCidadeRegistrada() {
        EstacaoMeteorologica estacao1 = new EstacaoMeteorologica();
        EstacaoMeteorologica estacao2 = new EstacaoMeteorologica();

        Cidade cidade1 = new Cidade("Fortaleza");
        Cidade cidade2 = new Cidade("Salvador");

        cidade1.registrarNaEstacao(estacao1);
        cidade2.registrarNaEstacao(estacao2);

        estacao1.atualizarPrevisao("Vento moderado");

        assertEquals("Alerta para Fortaleza: nova previsão - Vento moderado", cidade1.getUltimaNotificacao());
        assertNull(cidade2.getUltimaNotificacao());
    }

}
