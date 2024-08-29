// 1.matricular aluno
// 2.listar alunos por disciplina
// 3.mostrar info das disciplinas
// 4.listar disciplinas
// 5.mostrar info alunos por disciplina
// 6.alterar info aluno
// 0.sair

// classes:
// Aluno : nome, matricula
// Professor : nome, disciplina
// Disciplina: nome, professor, alunos

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Aluno {
    String nome;
    String matricula;

    Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
}

class Professor {
    String nome;
    String disciplina;

    Professor(String nome, String disciplina) {
        this.nome = nome;
        this.disciplina = disciplina;
    }
}

class Disciplina {
    String nome;
    Professor professor;
    List<Aluno> alunos;

    Disciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    void matricularAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    void listarAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno.nome + " - " + aluno.matricula);
        }
    }

    void mostrarInfo() {
        System.out.println("Disciplina: " + nome);
        System.out.println("Professor: " + "Prof."+professor.nome);
        System.out.println("Alunos: ");listarAlunos();
    }
}

public class Main {
    static List<Disciplina> disciplinas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Exemplo de dados iniciais
        Aluno aluno1 = new Aluno("Pedro", "123");
        Professor prof1 = new Professor("Silva", "Matemática");
        Disciplina disc1 = new Disciplina("Matemática", prof1);
        disciplinas.add(disc1);
        disc1.matricularAluno(aluno1);

        int opcao;
        do {
            System.out.println("1.matricular aluno");
            System.out.println("2.listar alunos por disciplina");
            System.out.println("3.mostrar info das disciplinas");
            System.out.println("4.listar disciplinas");
            System.out.println("5.mostrar info alunos por disciplina");
            System.out.println("6.alterar info aluno");
            System.out.println("7.adicionar disciplina");
            System.out.println("0.sair");
            System.out.println("Escolha uma opção:");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    matricularAluno();
                    break;
                case 2:
                    listarAlunosPorDisciplina();
                    break;
                case 3:
                    mostrarInfoDisciplinas();
                    break;
                case 4:
                    listarDisciplinas();
                    break;
                case 5:
                    mostrarInfoAlunosPorDisciplina();
                    break;
                case 6:
                    alterarInfoAluno();
                    break;
                case 7:
                    adicionarDisciplina();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    static void matricularAluno() {
        System.out.println("Nome do aluno:");
        String nome = scanner.nextLine();
        System.out.println("Matrícula do aluno:");
        String matricula = scanner.nextLine();
        Aluno aluno = new Aluno(nome, matricula);

        System.out.println("Nome da disciplina:");
        String nomeDisciplina = scanner.nextLine();
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.nome.equals(nomeDisciplina)) {
                disciplina.matricularAluno(aluno);
                System.out.println("Aluno matriculado com sucesso!");
                return;
            }
        }
        System.out.println("Disciplina não encontrada.");
    }

    static void listarAlunosPorDisciplina() {
        System.out.println("Nome da disciplina:");
        String nomeDisciplina = scanner.nextLine();
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.nome.equals(nomeDisciplina)) {
                disciplina.listarAlunos();
                return;
            }
        }
        System.out.println("Disciplina não encontrada.");
    }

    static void mostrarInfoDisciplinas() {
        for (Disciplina disciplina : disciplinas) {
            disciplina.mostrarInfo();
        }
    }

    static void listarDisciplinas() {
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina.nome);
        }
    }

    static void mostrarInfoAlunosPorDisciplina() {
        listarAlunosPorDisciplina();
    }

    static void alterarInfoAluno() {
        System.out.println("Matrícula do aluno:");
        String matricula = scanner.nextLine();
        for (Disciplina disciplina : disciplinas) {
            for (Aluno aluno : disciplina.alunos) {
                if (aluno.matricula.equals(matricula)) {
                    System.out.println("Novo nome do aluno:");
                    aluno.nome = scanner.nextLine();
                    System.out.println("Informações do aluno alteradas com sucesso!");
                    return;
                }
            }
        }
        System.out.println("Aluno não encontrado.");
    }
    static void adicionarDisciplina() {
        System.out.println("Nome da disciplina:");
        String nomeDisciplina = scanner.nextLine();
        System.out.println("Nome do professor:");
        String nomeProfessor = scanner.nextLine();
        System.out.println("Disciplina do professor:");
        String disciplinaProfessor = scanner.nextLine();

        Professor professor = new Professor(nomeProfessor, disciplinaProfessor);
        Disciplina disciplina = new Disciplina(nomeDisciplina, professor);
        disciplinas.add(disciplina);

        System.out.println("Disciplina adicionada com sucesso!");
    }
}