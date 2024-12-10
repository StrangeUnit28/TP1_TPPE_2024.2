package tst;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import app.IRPF;

public class TesteBaseCalculoImposto {

    private IRPF irpf;

    @Before
    public void setup() {
        irpf = new IRPF();
    }

    @Test
    public void testBaseCalculoImposto() {
        irpf.criarRendimento("Salário", IRPF.TRIBUTAVEL, 5000.00f);
        irpf.criarRendimento("Aluguel", IRPF.TRIBUTAVEL, 2000.00f);
        irpf.criarRendimento("Poupança", IRPF.NAOTRIBUTAVEL, 1000.00f);

        // Dependente
        irpf.cadastrarDependente("João", "Filho");
        irpf.cadastrarDependente("Maria", "Filha");

        // Previdenciária
        irpf.cadastrarContribuicaoPrevidenciaria(800.00f);

        // Alimentícia
        irpf.cadastrarPensaoAlimenticia("João", 500.00f);

        // Deduções
        irpf.cadastrarDeducaoIntegral("Plano de Saúde", 1000.00f);

        // Base de cálculo
        float rendimentosTributaveis = irpf.getTotalRendimentosTributaveis();
        float deducoes = irpf.getDeducao();
        float outrasDeducoes = irpf.getTotalOutrasDeducoes();
        float totalDeducoes = deducoes + outrasDeducoes;

        float baseCalculo = rendimentosTributaveis - totalDeducoes;

        float baseCalculoEsperada = 4320.82f;
        assertEquals(baseCalculoEsperada, baseCalculo, 0.01f);
    }
}
