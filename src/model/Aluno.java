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
        this.notas = new double[3]; // 3 notas
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCurso() {
        return curso;
    }

    public int getIdade() {
        return idade;
    }

    public double[] getNotas() {
        return notas;
    }


    public void setNota(int cadeira, double nota) {
        if (cadeira >= 0 && cadeira < notas.length) {
            notas[cadeira] = nota;
        }
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public boolean isAprovado() {
        return calcularMedia() >= 7.0;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Média: " + String.format("%.2f", calcularMedia()) +
                ", Situação: " + (isAprovado() ? "Aprovado" : "Reprovado");
    }
}