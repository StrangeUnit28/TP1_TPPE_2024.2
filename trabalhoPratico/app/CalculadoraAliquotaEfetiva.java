package app;

public class CalculadoraAliquotaEfetiva {
    private IRPF irpf;

    public CalculadoraAliquotaEfetiva(IRPF irpf) {
        this.irpf = irpf;
    }

    public float calcular() {
        float baseCalculo = new CalculadoraBaseCalculo(irpf).calcular();
        if (baseCalculo <= 0) {
            return 0; // Se a base for zero ou negativa, a alíquota é zero
        }

        float impostoDevido = new CalculadoraImposto(baseCalculo).calcular();
        return (impostoDevido / baseCalculo) * 100;
    }
}