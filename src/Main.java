import controller.AlunoController;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        AlunoController controller = new AlunoController();

        // Cria as telas
        MenuPrincipalFrame menuFrame = new MenuPrincipalFrame();
        CadastroAlunoFrame cadastroFrame = new CadastroAlunoFrame();
        ListaAlunosFrame listaFrame = new ListaAlunosFrame();
        LancarNotasFrame notasFrame = new LancarNotasFrame();

        // Configura os listeners do menu principal
        menuFrame.setCadastrarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.esconder();
                cadastroFrame.limparCampos();
                cadastroFrame.setVisible(true);
            }
        });

        menuFrame.setListarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaFrame.carregarAlunos(controller.listarAlunos());
                listaFrame.setVisible(true);
            }
        });

        menuFrame.setLancarNotasListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notasFrame.limparCampos();
                notasFrame.setVisible(true);
            }
        });

        menuFrame.setSairListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Configura os listeners do cadastro
        cadastroFrame.setCadastrarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = cadastroFrame.getNome();
                String email = cadastroFrame.getEmail();
                String endereco = cadastroFrame.getEndereco();
                String curso = cadastroFrame.getCurso();
                int idade = cadastroFrame.getIdade();

                if (nome.isEmpty() || email.isEmpty() || endereco.isEmpty() || curso.isEmpty()) {
                    cadastroFrame.mostrarMensagem("Todos os campos são obrigatórios!");
                    return;
                }

                if (idade < 0) {
                    cadastroFrame.mostrarMensagem("Idade inválida!");
                    return;
                }

                controller.cadastrarAluno(nome, email, endereco, curso, idade);
                cadastroFrame.mostrarMensagem("Aluno cadastrado com sucesso! ID: " +
                        controller.listarAlunos().size());
                cadastroFrame.limparCampos();
            }
        });

        cadastroFrame.setVoltarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroFrame.setVisible(false);
                menuFrame.mostrar();
            }
        });

        // Configura os listeners do lançamento de notas
        notasFrame.setLancarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = notasFrame.getIdAluno();
                if (id == -1) {
                    notasFrame.mostrarMensagem("ID inválido!");
                    return;
                }

                int cadeira = notasFrame.getCadeira();
                double nota = notasFrame.getNota();

                if (nota < 0 || nota > 10) {
                    notasFrame.mostrarMensagem("Nota inválida! Deve ser entre 0 e 10.");
                    return;
                }

                if (controller.lancarNota(id, cadeira, nota)) {
                    notasFrame.mostrarMensagem("Nota lançada com sucesso!");
                    notasFrame.limparCampos();
                } else {
                    notasFrame.mostrarMensagem("Aluno não encontrado!");
                }
            }
        });

        notasFrame.setVoltarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notasFrame.setVisible(false);
            }
        });

        // Configura os listeners da lista de alunos
        listaFrame.setVoltarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaFrame.setVisible(false);
            }
        });

        // Mostra o menu principal
        menuFrame.mostrar();
    }
}