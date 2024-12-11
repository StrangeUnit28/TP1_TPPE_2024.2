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
public class TesteCalcularBaseCalculo {

    private IRPF irpf;
    private float rendimento;
    private float deducao;
    private float baseCalculoEsperada;

    public TesteCalcularBaseCalculo(float rendimento, float deducao, float baseCalculoEsperada) {
        this.rendimento = rendimento;
        this.deducao = deducao;
        this.baseCalculoEsperada = baseCalculoEsperada;
    }

    @Before
    public void setUp() {
        irpf = new IRPF();
        irpf.criarRendimento("Rendimento", IRPF.TRIBUTAVEL, rendimento);
        irpf.cadastrarDeducaoIntegral("Dedução", deducao);
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 30000, 5000, 25000 },
            { 40000, 10000, 30000 },
            { 50000, 15000, 35000 },
            { 60000, 20000, 40000 }
        });
    }

    @Test
    public void testCalcularBaseCalculo() {
        assertEquals(baseCalculoEsperada, irpf.calcularBaseCalculo(), 0.01);
    }
}