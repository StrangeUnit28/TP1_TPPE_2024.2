UnB - Universidade de Brasilia  
FCTE - Faculdade de Ciências e Tecnologias em Engenharias  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

---

# Trabalhos práticos - semestre 2024/2

## Descrição do cenário

O Imposto de Renda de Pessoas Físicas (IRPF) é um imposto federal calculado com base na renda e despesas dedutíveis dos cidadãos brasileiros. De modo bastante resumido, o imposto considera, mensalmente, todas as rendas tributáveis recebidas pelo cidadão e todas suas deduções legais. A base de cálculo do IRPF é a diferença da renda pelas deduções de modo que o imposto devido é calculado sobre esse valor. Por fim, a alíquota efetiva é dada pelo quociente entre o imposto pago e o total de rendimentos tributáveis. Cada um desses passos está apresentado abaixo, através de um exemplo ilustrativo.

### Rendimentos

Os rendimentos são aqueles valores recebidos pelo cidadão ao longo de um mês. Os rendimentos são classificados como _tributáveis_ quando há a incidência de imposto sobre eles, ou _não-tributáveis_, caso contrário. São exemplos de rendimentos tributáveis os salários, rendimentos de alguns tipos de investimentos, pro-labore, dentre outros. São exemplos de rendimentos não-tributáveis os ressarcimentos de despesas de trabalho, bolsas de estudos, dentre outros. Apenas os rendimentos tributáveis são considerados para efeito de cálculo do imposto de renda.

Suponha que um cidadão possua os seguintes rendimentos:

| Descrição do Rendimento  | Tributável? |            Valor |
| :----------------------- | :---------: | ---------------: |
| Salário                  |     Sim     |      R$ 8.000,00 |
| Aluguel                  |     Sim     |      R$ 2.000,00 |
| Bolsa de estudos         |     Não     |      R$ 1.500,00 |
| **Total rendimentos:**   |             | **R$ 11.500,00** |
| **Total rend. tribut.:** |             | **R$ 10.000,00** |

### Deduções

As deduções são os valores que, legalmente, podem ser descontados para o cálculo do imposto. Para cada dependente do contribuinte (filho/filha) desconta-se o valor de R$189,59. Valores pagos à previdência oficial (Previdência Social do Governo Federal) são deduzidos em sua integralidade. Valores pagos à previdência complementar (planos de previdência privada do tipo PGBL), ao Carnê-leão e à pensões alimentícias também são deduzidos integralmente.

Em nosso exemplo, supondo que o cidadão possua um dependente, pague R$500,00 de previdência oficial, R$1.000,00, de previdência complementar e R$1.500,00 de pensão alimentícia, tem-se a seguinte tabela de deduções.

| Descrição da dedução  |           Valor |
| :-------------------- | --------------: |
| 1 filho               |       R$ 189,59 |
| Cont. Prev. oficial   |       R$ 500,00 |
| Cont. Prev. privada   |     R$ 1.000,00 |
| Pensão alimentícia    |     R$ 1.500,00 |
| **Total de deduções** | **R$ 3.189,59** |

### Base de cálculo

A base de cálculo é o valor que será utilizado para cálculo do imposto de renda. Ele é dado pela diferença dos total de rendimentos tributáveis pelo total das deduções legais. No exemplo, a base de cálculo é calculada como demonstrado a seguir.

| Descrição                        |           Valor |
| :------------------------------- | --------------: |
| Total de rendimentos tributáveis |    R$ 10.000,00 |
| Total de deduções                |     R$ 3.189.59 |
| **Total**                        | **R$ 6.810,41** |

### Cálculo do imposto

A tributação do imposto de renda é realizada através de cinco faixas. Cada faixa possui uma alíquota de imposto aplicada ao valor da base de cálculo que se enquadrou naquela faixa. Os limites e as alíquotas são crescentes conforme tabela seguinte. O valor total do imposto é dado pela soma dos impostos de cada faixa.

| Faixa | Faixa de valores         | Alíquota |
| :---- | :----------------------- | :------: |
| 1a.   | Até 2.259,20             |  0.0 %   |
| 2a.   | De 2.259,21 até 2.826,65 |  7.5 %   |
| 3a.   | De 2.826,66 até 3.751,05 |  15.0 %  |
| 4a.   | De 3.751,06 até 4.664,68 |  22.5 %  |
| 5a.   | Acima de 4.664,68        |  27.5 %  |

No caso do exemplo desse trabalho, a base de cálculo do IRPF é de R$ 6.810,41. Portanto, ela contempla todas as faixas do IRPF, conforme demonstrado pela tabela a seguir:

_Base de cálculo:_ R$ 6.810,41

| Faixa | Alíquota  | Imposto devido |
| :---- | :-------: | -------------: |
| 1a.   |   0.0 %   |        R$ 0,00 |
| 2a.   |   7.5 %   |       R$ 53,59 |
| 3a.   |  15.0 %   |      R$ 138,66 |
| 4a.   |  22.5 %   |      R$ 205,56 |
| 5a.   |  27.5 %   |      R$ 590,07 |
|       | **Total** |  **R$ 987,88** |

A alíquota efetiva é dada pelo quociente entre o imposto pago e o total de rendimentos tributáveis. Embora o cidadão do exemplo se encontrar na quinta faixa (27,5%), a alíquota efetiva do imposto pago é de 9,87% ($\frac{R\$ 987,88}{R\$ 10.000,00}$).

---

# Enunciados dos trabalhos

Três trabalhos serão realizados sobre o cenário descrito acima. Os temas para esses trabalhos são, na sequencia, TDD, Refatoração e Depuração de código. Os grupos dos trabalhos terão, no máximo, 5 componentes. Os componentes dos grupos deverão ser informados através do formulário presente [nesse link.](https://docs.google.com/forms/d/e/1FAIpQLSevIusyB-JxQe5uP1oPuWkIPXfQzdy9H6eIeuIWkVPgc1NJ2Q/viewform)

Os trabalhos deverão ser realizados em Java e disponibilizados em repositórios do GitHub. As entregas serão feitas através dos repositórios, de modo que a data e o horário dos commits serão considerados como horário da entrega dos trabalhos. Os componentes do grupo deverão adicionar o professor como membro do repositório.

## Entrega 1 - TDD

**Valor:** 20 pontos  
**Data de entrega:** 13/12/2024, 23:59hs.

Junto desse enunciado encontra-se o código da calculadora de IRPF, iniciado em sala de aula. Esse código já contempla os testes para as seguintes funcionalidades (e suas respectivas unidades).

| Classe                                  | Funcionalidade                    |
| :-------------------------------------- | :-------------------------------- |
| TesteCadastrarDependente                | Cadastrar dependentes             |
| TesteRendimentos                        | Cadastrar rendimentos             |
| TesteCalculosDeducoesDependentes        | Calcular deduções por dependentes |
| TesteCadastroContribuicaoPrevidenciaria | Calcular deducoes por previdencia |
| TesteCadastroPensaoAlimenticia          | Calcular deducoes por pensoes     |
| TesteCadastroOutrasDeducoes             | Calcular outros tipos de deducoes |

Ainda não estão implementados os testes e as unidades para o calcula:

- a base de cálculo do imposto,
- os impostos por faixas e o total do imposto,
- e a alíquota efetiva do imposto pago.

Para essa entrega os grupos deverão criar testes triangulados (parametrizados, preferencialmente) para cada uma das unidades mencionadas acima, e os testes têm que estar integrados à suíte de testes presente no arquivo `AllTests.java`.

## Entrega 2 - Refatoração

## Refatoração do Método `cadastrarDependente` - Extrair Método

**Descrição:**  
Refatoramos o método `cadastrarDependente` para extrair a lógica de adição de dependentes em um método separado. Criamos um método auxiliar `adicionarElemento` que adiciona um novo elemento a um array.

### Código Original:

```java
public void cadastrarDependente(String nome, String parentesco) {
    // adicionar dependente
    String[] temp = new String[nomesDependentes.length + 1];
    for (int i=0; i<nomesDependentes.length; i++) {
        temp[i] = nomesDependentes[i];
    }
    temp[nomesDependentes.length] = nome;
    nomesDependentes = temp;

    String[] temp2 = new String[parentescosDependentes.length + 1];
    for (int i=0; i<parentescosDependentes.length; i++) {
        temp2[i] = parentescosDependentes[i];
    }
    temp2[parentescosDependentes.length] = parentesco;
    parentescosDependentes = temp2;

    numDependentes++;
}
```

### Código Refatorado:

```java
public void cadastrarDependente(String nome, String parentesco) {
    nomesDependentes = adicionarElemento(nomesDependentes, nome);
    parentescosDependentes = adicionarElemento(parentescosDependentes, parentesco);
    numDependentes++;
}

private String[] adicionarElemento(String[] array, String elemento) {
    String[] temp = new String[array.length + 1];
    for (int i = 0; i < array.length; i++) {
        temp[i] = array[i];
    }
    temp[array.length] = elemento;
    return temp;
}
```

**Justificativa:**  
A refatoração melhora a legibilidade e a manutenção do código ao encapsular a lógica de adição de elementos em um método separado. Isso evita duplicação de código e facilita futuras modificações.

---

## Refatoração do Método `calcularImposto` - Substituir método por objeto-método

**Descrição:**  
Refatoramos o método `calcularImposto` utilizando o padrão "Substituir Método por Objeto-Método". Criamos uma classe separada `CalculadoraImposto` que encapsula a lógica de cálculo do imposto.

### Código Original:

```java
public float calcularImposto() {
    float baseCalculo = calcularBaseCalculo();

    if (baseCalculo <= FAIXAS[0]) {
        return 0;
    }

    float imposto = 0;
    for (int i = FAIXAS.length - 1; i >= 0; i--) {
        if (baseCalculo > FAIXAS[i]) {
            imposto += (baseCalculo - FAIXAS[i]) * ALIQUOTAS[i];
            baseCalculo = FAIXAS[i];
        }
    }

    return imposto;
}
```

### Código Refatorado:

```java
public float calcularImposto() {
    return new CalculadoraImposto(calcularBaseCalculo()).calcular();
}

private class CalculadoraImposto {
    private float baseCalculo;

    public CalculadoraImposto(float baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    public float calcular() {
        if (baseCalculo <= IRPF.FAIXAS[0]) {
            return 0;
        }

        float imposto = 0;
        for (int i = IRPF.FAIXAS.length - 1; i >= 0; i--) {
            if (baseCalculo > IRPF.FAIXAS[i]) {
                imposto += (baseCalculo - IRPF.FAIXAS[i]) * IRPF.ALIQUOTAS[i];
                baseCalculo = IRPF.FAIXAS[i];
            }
        }

        return imposto;
    }
}
```

**Justificativa:**  
A refatoração melhora a modularidade do código ao encapsular a lógica de cálculo do imposto em uma classe separada. Isso facilita a manutenção e a extensão do código, além de seguir o princípio de responsabilidade única.

---

## Refatoração dos Métodos `CalculadoraBaseCalculo`, `CalculadoraImposto`, `CalculadoraAliquotaEfetiva` - Extrair Classe

Com essa refatoração, cada método foi extraído para sua própria classe, tornando o código mais modular e fácil de manter. A classe `IRPF` agora delega essas responsabilidades para as novas classes:

- `CalculadoraBaseCalculo`
- `CalculadoraImposto`
- `CalculadoraAliquotaEfetiva`

**Benefícios da Refatoração:**

- A modularização do código melhora sua legibilidade e manutenção.
- Segue os princípios do design orientado a objetos, como o **Princípio de Responsabilidade Única** (SRP).
- Facilita a extensão e evolução da aplicação.

## Entrega 3 - Depuração de código

**Valor:** 20 pontos  
**Data de entrega:** a ser definida
