package app;

public class CalculadoraBaseCalculo {
    private IRPF irpf;

    public CalculadoraBaseCalculo(IRPF irpf) {
        this.irpf = irpf;
    }

    public float calcular() {
        float totalTributavel = irpf.getTotalRendimentosTributaveis();
        float deducaoTotal = irpf.getDeducao();
        return totalTributavel - deducaoTotal;
    }
}