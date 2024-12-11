package tst;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import app.IRPF;

@RunWith(Parameterized.class)
public class TesteBaseCalculoImposto {

    private String[] nomesRendimentos;
    private boolean[] rendimentosTributaveis;
    private float[] valoresRendimentos;
    private float[] deducoes;
    private float resultadoEsperado;

    // Construtor com parâmetros adicionais para deduções
    public TesteBaseCalculoImposto(String[] nomesRendimentos, boolean[] rendimentosTributaveis, 
                                    float[] valoresRendimentos, float[] deducoes, float resultadoEsperado) {
        this.nomesRendimentos = nomesRendimentos;
        this.rendimentosTributaveis = rendimentosTributaveis;
        this.valoresRendimentos = valoresRendimentos;
        this.deducoes = deducoes;
        this.resultadoEsperado = resultadoEsperado;
    }

    private IRPF irpf;

    @Before
    public void setup() {
        irpf = new IRPF();
    }

    // Definição dos casos de teste
    @Parameterized.Parameters
    public static Collection<Object[]> parametros() {
        return Arrays.asList(new Object[][] {
            { 
                new String[] {"Salário", "Aluguel"}, 
                new boolean[] {IRPF.TRIBUTAVEL, IRPF.NAOTRIBUTAVEL}, 
                new float[] {5000f, 2000f},
                new float[] {189.59f}, // Dedução: Plano de Saúde
                5000f - (189.59f + 189.59f) // Rendimento tributável menos a dedução
            },
            { 
                new String[] {"Freelance", "Investimento"}, 
                new boolean[] {IRPF.TRIBUTAVEL, IRPF.TRIBUTAVEL}, 
                new float[] {3000f, 1000f}, 
                new float[] {189.59f}, // Dedução: Contribuição Previdenciária
                4000f - (189.59f + 189.59f) // Rendimento tributável menos a dedução
            },
            { 
                new String[] {"Salário", "Freelance", "Aluguel"},
                new boolean[] {IRPF.TRIBUTAVEL, IRPF.TRIBUTAVEL, IRPF.NAOTRIBUTAVEL}, 
                new float[] {6000f, 2000f, 1500f}, 
                new float[] {189.59f}, // Deduções: Plano de Saúde, Contribuição Previdenciária
                (6000f + 2000f) - (189.59f + 189.59f) // Total de rendimentos tributáveis menos as deduções
            },
            { 
                new String[] {"Pensão", "Venda Imóvel"}, 
                new boolean[] {IRPF.NAOTRIBUTAVEL, IRPF.NAOTRIBUTAVEL}, 
                new float[] {1500f, 8000f}, 
                new float[] {}, // Sem deduções, já que são não tributáveis
                0f // Ambos os rendimentos são não tributáveis
            },
            { 
                new String[] {}, 
                new boolean[] {}, 
                new float[] {}, 
                new float[] {}, // Sem rendimentos e sem deduções
                0f // Não há rendimentos tributáveis
            }
        });
    }

    @Test
    public void testBaseCalculoImposto() {
        // Cadastrando os rendimentos no IRPF
        for (int i = 0; i < nomesRendimentos.length; i++) {
            irpf.criarRendimento(nomesRendimentos[i], rendimentosTributaveis[i], valoresRendimentos[i]);
        }

        // Cadastrando as deduções diretamente (sem usar cadastrarDeducaoIntegral)
        for (float deducao : deducoes) {
            // Aqui, vamos considerar que o método getDeducao já lida com as deduções internas
            irpf.cadastrarDependente("Dependente", "Filho"); // Exemplo de dependente
            irpf.cadastrarContribuicaoPrevidenciaria(deducao); // Contribuições como exemplo
        }

        // Verificando o valor total de rendimentos tributáveis após as deduções
        assertEquals(resultadoEsperado, irpf.getTotalRendimentosTributaveis() - irpf.getDeducao(), 0.001);
    }
}
