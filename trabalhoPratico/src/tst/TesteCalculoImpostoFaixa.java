package tst;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import app.IRPF;
import org.junit.Test;

public class TesteCalculoImpostoFaixa {

    private IRPF irpf;

    @Before
    public void setUp() {
        irpf = new IRPF();
    }

    @Test
    public void testCalcularImpostoSemRendimentos() {
        assertEquals(0, irpf.calcularImposto(), 0.01);
    }

    @Test
    public void testCalcularImpostoComRendimentosAbaixoDaPrimeiraFaixa() {
        irpf.criarRendimento("Salário", IRPF.TRIBUTAVEL, 20000);
        assertEquals(0, irpf.calcularImposto(), 0.01);
    }

    @Test
    public void testCalcularImpostoComRendimentosNaSegundaFaixa() {
        irpf.criarRendimento("Salário", IRPF.TRIBUTAVEL, 30000);
        // Calculando o imposto esperado
        float baseCalculo = 30000 - 22847.76f;
        float impostoEsperado = baseCalculo * 0.075f;
        assertEquals(impostoEsperado, irpf.calcularImposto(), 0.01);
    }

    @Test
    public void testCalcularImpostoComRendimentosNaTerceiraFaixa() {
        irpf.criarRendimento("Salário", IRPF.TRIBUTAVEL, 40000);
        // Calculando o imposto esperado
        float baseCalculo = 40000 - 33919.80f;
        float impostoEsperado = (baseCalculo * 0.15f) + (11072.04f * 0.075f);
        assertEquals(impostoEsperado, irpf.calcularImposto(), 0.01);
    }

    @Test
    public void testCalcularImpostoComRendimentosNaQuartaFaixa() {
        irpf.criarRendimento("Salário", IRPF.TRIBUTAVEL, 50000);
        // Calculando o imposto esperado
        float baseCalculo = 50000 - 45012.60f;
        float impostoEsperado = (baseCalculo * 0.225f) + (11092.80f * 0.15f) + (11072.04f * 0.075f);
        assertEquals(impostoEsperado, irpf.calcularImposto(), 0.01);
    }

    @Test
    public void testCalcularImpostoComRendimentosAcimaDaQuartaFaixa() {
        irpf.criarRendimento("Salário", IRPF.TRIBUTAVEL, 60000);
        // Calculando o imposto esperado
        float baseCalculo = 60000 - 55976.16f;
        float impostoEsperado = (baseCalculo * 0.275f) + (10963.56f * 0.225f) + (11092.80f * 0.15f) + (11072.04f * 0.075f);
        assertEquals(impostoEsperado, irpf.calcularImposto(), 0.01);
    }
}