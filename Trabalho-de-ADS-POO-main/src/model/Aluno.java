package model;

public class Aluno {
    private int id;
    private String nome;
    private String email;
    private String endereco;
    private String curso;
    private int idade;
    private double[] notas;
    private static int proximoId = 1;

    public Aluno(String nome, String email, String endereco, String curso, int idade) {
        this.id = proximoId++;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.curso = curso;
        this.idade = idade;
        this.notas = new double[3];
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getEndereco() { return endereco; }
    public String getCurso() { return curso; }
    public int getIdade() { return idade; }
    public double[] getNotas() { return notas; }

    // Setters
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setCurso(String curso) { this.curso = curso; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setNota(int disciplina, double nota) {
        if (disciplina >= 0 && disciplina < notas.length) {
            notas[disciplina] = nota;
        }
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return notas.length > 0 ? soma / notas.length : 0;
    }

    public boolean isAprovado() {
        return calcularMedia() >= 7.0;
    }
}