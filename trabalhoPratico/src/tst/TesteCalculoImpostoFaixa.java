package tst;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import app.IRPF;

@RunWith(Parameterized.class)
public class TesteCalculoImpostoFaixa {

    private IRPF irpf;
    private float rendimento;
    private float impostoEsperado;

    public TesteCalculoImpostoFaixa(float rendimento, float impostoEsperado) {
        this.rendimento = rendimento;
        this.impostoEsperado = impostoEsperado;
    }

    @Before
    public void setUp() {
        irpf = new IRPF();
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 0, 0 },
            { 20000, 0 },
            { 30000, (30000 - 22847.76f) * 0.075f },
            { 40000, ((40000 - 33919.80f) * 0.15f) + (11072.04f * 0.075f) },
            { 50000, ((50000 - 45012.60f) * 0.225f) + (11092.80f * 0.15f) + (11072.04f * 0.075f) },
            { 60000, ((60000 - 55976.16f) * 0.275f) + (10963.56f * 0.225f) + (11092.80f * 0.15f) + (11072.04f * 0.075f) }
        });
    }

    @Test
    public void testCalcularImposto() {
        irpf.criarRendimento("Salário", IRPF.TRIBUTAVEL, rendimento);
        assertEquals(impostoEsperado, irpf.calcularImposto(), 0.01);
    }
}