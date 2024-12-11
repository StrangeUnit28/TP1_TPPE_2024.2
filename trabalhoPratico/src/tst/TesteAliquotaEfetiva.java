// package tst;

// import static org.junit.Assert.assertEquals;

// import org.junit.Before;
// import org.junit.Test;

// import app.IRPF;

// public class TesteAliquotaEfetiva {

//     IRPF irpf;

//     @Before
//     public void setup() {
//         irpf = new IRPF();
//     }

//     @Test
//     public void testeAliquotaEfetiva() {
//         IRPF irpf = new IRPF();
//         irpf.criarRendimento("Salário", IRPF.TRIBUTAVEL, 8000);
//         irpf.criarRendimento("Aluguel", IRPF.TRIBUTAVEL, 2000);
//         irpf.cadastrarDependente("Bruno Henrique", "Filho");
//         irpf.cadastrarContribuicaoPrevidenciaria(500);
//         irpf.cadastrarDeducaoIntegral("Pensão Alimentícia", 1500);

//         // TODO: IMPLEMENTAR METODO (TDD)
//         assertEquals(9.87f, irpf.calcularAliquotaEfetiva(), 0.01f);
//     }
// }
