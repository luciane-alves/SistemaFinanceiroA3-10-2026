
    public class Colaborador {
        public static final double SALARIO_BASE = 2000.00;

        private int matricula;
        private String nome;
        private double salarioBase;

        public Colaborador(int matricula, String nome) {
            this.matricula = matricula;
            this.nome = nome;
            this.salarioBase = SALARIO_BASE;
        }

        public int getMatricula() { return matricula; }
        public String getNome() { return nome; }
        public double getSalarioBase() { return salarioBase; }


        public String getTipo() { return "Colaborador"; }


        public String getNomeBeneficio() { return null; }

        public double getValorBeneficio() { return 0.0; }

        public double calcularSalarioFinal() {
            return salarioBase;
        }

        public void exibirDados() {
            System.out.println("Matrícula: " + matricula);
            System.out.println("Nome: " + nome);
            System.out.println("Tipo: " + getTipo());
            System.out.printf("Salário Base: R$ %,.2f%n", salarioBase);
            if (getNomeBeneficio() != null) {
                System.out.printf("%s: R$ %,.2f%n", getNomeBeneficio(), getValorBeneficio());
            }
            System.out.printf("Salário Final: R$ %,.2f%n", calcularSalarioFinal());
        }
    }


