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
public class TesteCalcularAliquotaEfetiva {

    private IRPF irpf;
    private float rendimento;
    private float deducao;
    private float aliquotaEsperada;

    public TesteCalcularAliquotaEfetiva(float rendimento, float deducao, float aliquotaEsperada) {
        this.rendimento = rendimento;
        this.deducao = deducao;
        this.aliquotaEsperada = aliquotaEsperada;
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
            { 30000, 5000, ((25000 - 22847.76f) * 0.075f) / 25000 * 100 },
            { 40000, 10000, (((30000 - 22847.76f) * 0.075f) + ((40000 - 33919.80f) * 0.15f)) / 30000 * 100 },
            { 20000, 25000, 0.0f }, // Caso: dedução maior que rendimento
            { 0, 0, 0.0f }          // Caso: sem rendimentos
        });
    }

    @Test
    public void testCalcularAliquotaEfetiva() {
        assertEquals(aliquotaEsperada, irpf.calcularAliquotaEfetiva(), 0.01);
    }
}