public class ColaboradorProducao extends Colaborador {
    private int quantidadePecas;
    private double valorPorPeca;

    public ColaboradorProducao(int matricula, String nome,
                               int quantidadePecas, double valorPorPeca) {
        super(matricula, nome);
        this.quantidadePecas = quantidadePecas;
        this.valorPorPeca = valorPorPeca;
    }

    public double calcularProdutividade() {
        return quantidadePecas * valorPorPeca;
    }

    @Override
    public String getTipo() { return "Produção"; }

    @Override
    public String getNomeBeneficio() { return "Produtividade"; }

    @Override
    public double getValorBeneficio() { return calcularProdutividade(); }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase() + calcularProdutividade();
    }
}

