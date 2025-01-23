package app;

public class CalculadoraImposto {
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
