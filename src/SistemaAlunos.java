import java.util.Scanner;

public class SistemaAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantidadeAlunos;
        while (true) {
            System.out.print("Quantos alunos deseja cadastrar? ");
            if (scanner.hasNextInt()) {
                quantidadeAlunos = scanner.nextInt();
                scanner.nextLine(); // Limpa quebra de linha
                if (quantidadeAlunos > 0) {
                    break;
                }
            } else {
                scanner.nextLine(); // Descarta entrada inválida
            }
            System.out.println("Erro: digite um numero inteiro maior que 0.");
        }

        // Vetor de Aluno com o tamanho informado
        Aluno[] alunos = new Aluno[quantidadeAlunos];

        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("\n--- Cadastro do " + (i + 1) + "º Aluno ---");
            System.out.print("Nome do aluno: ");
            String nome = scanner.nextLine();

            int quantidadeNotas;
            while (true) {
                System.out.print("Quantas notas " + nome + " tera no ano? ");
                if (scanner.hasNextInt()) {
                    quantidadeNotas = scanner.nextInt();
                    scanner.nextLine();
                    if (quantidadeNotas > 0) {
                        break;
                    }
                } else {
                    scanner.nextLine();
                }
                System.out.println("Erro: digite uma quantidade valida (maior que 0).");
            }

            double[] notas = new double[quantidadeNotas];

            for (int j = 0; j < quantidadeNotas; j++) {
                while (true) {
                    System.out.print("Digite a nota " + (j + 1) + " (0 a 10): ");
                    if (scanner.hasNextDouble()) {
                        double nota = scanner.nextDouble();
                        scanner.nextLine();
                        if (nota >= 0.0 && nota <= 10.0) {
                            notas[j] = nota;
                            break;
                        } else {
                            System.out.println("Nota invalida! A nota deve estar entre 0 e 10. Digite novamente.");
                        }
                    } else {
                        scanner.nextLine();
                        System.out.println("Entrada invalida! Digite um numero entre 0 e 10.");
                    }
                }
            }

            // Cria o objeto Aluno via construtor e armazena no vetor
            alunos[i] = new Aluno(nome, notas);
        }

        // Exibição final dos dados e da média de cada aluno
        System.out.println("\n==========================================");
        System.out.println("       RESUMO FINAL DOS ALUNOS            ");
        System.out.println("==========================================");

        for (int i = 0; i < alunos.length; i++) {
            Aluno aluno = alunos[i];
            System.out.println("Aluno: " + aluno.getNome());
            System.out.print("Notas: ");
            double[] notasAluno = aluno.getNotas();
            for (int j = 0; j < notasAluno.length; j++) {
                System.out.print(notasAluno[j]);
                if (j < notasAluno.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.printf("%nMedia: %.2f%n", aluno.calcularMedia());
            System.out.println("------------------------------------------");
        }

        scanner.close();
    }
}