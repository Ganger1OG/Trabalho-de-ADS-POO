package controller;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoController {
    private List<Aluno> alunos;

    public AlunoController() {
        this.alunos = new ArrayList<>();
    }

    public void cadastrarAluno(String nome, String email, String endereco, String curso, int idade) {
        Aluno aluno = new Aluno(nome, email, endereco, curso, idade);
        alunos.add(aluno);
    }

    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos);
    }

    public boolean lancarNota(int idAluno, int cadeira, double nota) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == idAluno) {

                if (cadeira <1 || cadeira > 3) {
                    return false;
                }

                aluno.setNota(cadeira - 1, nota); // -1 porque o array começa em 0
                return true;
            }
        }
        return false;
    }

    public Aluno buscarAluno(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }
}