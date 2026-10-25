public class Colaboradorpadrao extends Colaborador{

    public Colaboradorpadrao(int matricula, String nome) {
        super(matricula, nome);
    }

    @Override
    public String getTipo() { return "Padrão"; }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase();
    }
}

