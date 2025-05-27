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

    public boolean excluirAluno(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                alunos.remove(aluno);
                return true;
            }
        }
        return false;
    }

    public boolean editarAluno(int id, String nome, String email, String endereco, String curso, int idade) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                aluno.setNome(nome);
                aluno.setEmail(email);
                aluno.setEndereco(endereco);
                aluno.setCurso(curso);
                aluno.setIdade(idade);
                return true;
            }
        }
        return false;
    }

    public Aluno buscarAlunoPorId(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    public boolean lancarNota(int idAluno, int disciplina, double nota) {
        if (disciplina < 1 || disciplina > 3) return false;

        Aluno aluno = buscarAlunoPorId(idAluno);
        if (aluno != null) {
            aluno.setNota(disciplina - 1, nota);
            return true;
        }
        return false;
    }
}