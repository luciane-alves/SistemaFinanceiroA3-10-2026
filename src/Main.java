import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Colaborador> colaboradores = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInt("Opção: ");
            switch (opcao) {
                case 1: cadastrarPadrao(); break;
                case 2: cadastrarComissionado(); break;
                case 3: cadastrarProducao(); break;
                case 4: gerarFolhaPagamento(); break;
                case 5: exibirResumoFolha(); break;
                case 0: System.out.println("Encerrando o sistema..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n===== SISTEMA DE FOLHA DE PAGAMENTO =====");
        System.out.println("1 - Cadastrar Colaborador Padrão");
        System.out.println("2 - Cadastrar Colaborador Comissionado");
        System.out.println("3 - Cadastrar Colaborador Produção");
        System.out.println("4 - Gerar Folha de Pagamento");
        System.out.println("5 - Exibir Resumo da Folha");
        System.out.println("0 - Sair");
    }

    private static void cadastrarPadrao() {
        int matricula = lerInt("Matrícula: ");
        String nome = lerTexto("Nome: ");
        colaboradores.add(new Colaboradorpadrao(matricula, nome));
        System.out.println("Colaborador Padrão cadastrado!");
    }

    private static void cadastrarComissionado() {
        int matricula = lerInt("Matrícula: ");
        String nome = lerTexto("Nome: ");
        double vendas = lerDouble("Valor de vendas: ");
        double percentual = lerDouble("Percentual de comissão: ");
        colaboradores.add(new ColaboradorComissionado(matricula, nome, vendas, percentual));
        System.out.println("Colaborador Comissionado cadastrado!");
    }

    private static void cadastrarProducao() {
        int matricula = lerInt("Matrícula: ");
        String nome = lerTexto("Nome: ");
        int pecas = lerInt("Quantidade de peças: ");
        double valorPeca = lerDouble("Valor por peça: ");
        colaboradores.add(new ColaboradorProducao(matricula, nome, pecas, valorPeca));
        System.out.println("Colaborador de Produção cadastrado!");
    }

    private static void gerarFolhaPagamento() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }
        System.out.println("\n===== FOLHA DE PAGAMENTO =====");
        for (Colaborador c : colaboradores) {
            c.exibirDados();
            System.out.println("------------------------------");
        }
    }


    private static double calcularTotalFolha() {
        double total = 0;
        for (Colaborador c : colaboradores) {
            total += c.calcularSalarioFinal();
        }
        return total;
    }

    private static double calcularMediaSalarial() {
        if (colaboradores.isEmpty()) return 0;
        return calcularTotalFolha() / colaboradores.size();
    }

    private static void exibirResumoFolha() {
        System.out.println("\n===== RESUMO DA FOLHA =====");
        System.out.println("Quantidade de colaboradores: " + colaboradores.size());
        System.out.printf("Soma total da folha: R$ %,.2f%n", calcularTotalFolha());
        System.out.printf("Média salarial: R$ %,.2f%n", calcularMediaSalarial());
    }


    private static String lerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    private static int lerInt(String msg) {
        while (true) {
            try {
                return Integer.parseInt(lerTexto(msg));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    private static double lerDouble(String msg) {
        while (true) {
            try {
                return Double.parseDouble(lerTexto(msg).replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número (ex.: 1500.50).");
            }
        }
    }
}

