public class ColaboradorComissionado extends Colaborador {
    private double valorVendas;
    private double percentualComissao;

    public ColaboradorComissionado(int matricula, String nome,
                                   double valorVendas, double percentualComissao) {
        super(matricula, nome);
        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
    }

    public double calcularComissao() {
        return valorVendas * percentualComissao / 100;
    }

    @Override
    public String getTipo() { return "Comissionado"; }

    @Override
    public String getNomeBeneficio() { return "Comissão"; }

    @Override
    public double getValorBeneficio() { return calcularComissao(); }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase() + calcularComissao();
    }
}
