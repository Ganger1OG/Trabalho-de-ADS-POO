import controller.AlunoController;
import model.Aluno;  // Importação adicionada
import view.*;

import javax.swing.JOptionPane;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final AlunoController controller = new AlunoController();
        final MenuPrincipalFrame menuFrame = new MenuPrincipalFrame();
        final CadastroAlunoFrame cadastroFrame = new CadastroAlunoFrame();
        final ListaAlunosFrame listaFrame = new ListaAlunosFrame();
        final LancarNotasFrame notasFrame = new LancarNotasFrame();

        // Configuração do menu principal
        menuFrame.setCadastrarListener(e -> {
            menuFrame.esconder();
            cadastroFrame.limparCampos();
            cadastroFrame.setVisible(true);
        });

        menuFrame.setListarListener(e -> {
            listaFrame.carregarAlunos(controller.listarAlunos());
            listaFrame.setVisible(true);
        });

        menuFrame.setLancarNotasListener(e -> {
            notasFrame.limparCampos();
            notasFrame.setVisible(true);
        });

        menuFrame.setSairListener(e -> System.exit(0));

        // Configuração do cadastro
        cadastroFrame.setCadastrarListener(e -> {
            if (cadastroFrame.getNome().isEmpty() || cadastroFrame.getIdade() < 0) {
                cadastroFrame.mostrarMensagem("Dados inválidos!");
                return;
            }

            controller.cadastrarAluno(
                    cadastroFrame.getNome(),
                    cadastroFrame.getEmail(),
                    cadastroFrame.getEndereco(),
                    cadastroFrame.getCurso(),
                    cadastroFrame.getIdade()
            );

            cadastroFrame.mostrarMensagem("Aluno cadastrado! ID: " + controller.listarAlunos().size());
            cadastroFrame.limparCampos();
        });

        cadastroFrame.setVoltarListener(e -> {
            cadastroFrame.dispose();
            menuFrame.mostrar();
        });

        // Configuração da listagem (nomes de métodos corrigidos)
        listaFrame.setEditarListener(e -> {
            int id = listaFrame.getAlunoSelecionadoId();
            if (id == -1) {
                listaFrame.mostrarMensagem("Selecione um aluno!");
                return;
            }

            Aluno aluno = controller.buscarAlunoPorId(id);
            if (aluno != null) {
                EdicaoAlunoFrame edicaoFrame = new EdicaoAlunoFrame(
                        aluno.getId(),
                        aluno.getNome(),
                        aluno.getEmail(),
                        aluno.getEndereco(),
                        aluno.getCurso(),
                        aluno.getIdade()
                );

                edicaoFrame.setSalvarListener(ev -> {
                    if (edicaoFrame.getIdade() < 0) {
                        edicaoFrame.mostrarMensagem("Idade inválida!");
                        return;
                    }

                    boolean sucesso = controller.editarAluno(
                            edicaoFrame.getAlunoId(),
                            edicaoFrame.getNome(),
                            edicaoFrame.getEmail(),
                            edicaoFrame.getEndereco(),
                            edicaoFrame.getCurso(),
                            edicaoFrame.getIdade()
                    );

                    if (sucesso) {
                        edicaoFrame.mostrarMensagem("Aluno atualizado!");
                        listaFrame.carregarAlunos(controller.listarAlunos());
                        edicaoFrame.dispose();
                    } else {
                        edicaoFrame.mostrarMensagem("Erro ao atualizar!");
                    }
                });

                edicaoFrame.setCancelarListener(ev -> edicaoFrame.dispose());
                edicaoFrame.setVisible(true);
            }
        });

        listaFrame.setExcluirListener(e -> {  // Nome corrigido
            int id = listaFrame.getAlunoSelecionadoId();
            if (id == -1) {
                listaFrame.mostrarMensagem("Selecione um aluno!");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                    listaFrame,
                    "Excluir este aluno?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                if (controller.excluirAluno(id)) {
                    listaFrame.mostrarMensagem("Aluno excluído!");
                    listaFrame.carregarAlunos(controller.listarAlunos());
                } else {
                    listaFrame.mostrarMensagem("Erro ao excluir!");
                }
            }
        });

        listaFrame.setVoltarListener(e -> listaFrame.dispose());  // Nome corrigido

        // Configuração do lançamento de notas
        notasFrame.setLancarListener(e -> {
            if (notasFrame.getNota() < 0 || notasFrame.getNota() > 10) {
                notasFrame.mostrarMensagem("Nota inválida (0-10)!");
                return;
            }

            boolean sucesso = controller.lancarNota(
                    notasFrame.getIdAluno(),
                    notasFrame.getDisciplina(),
                    notasFrame.getNota()
            );

            if (sucesso) {
                notasFrame.mostrarMensagem("Nota lançada!");
                notasFrame.limparCampos();
            } else {
                notasFrame.mostrarMensagem("ID inválido ou disciplina incorreta!");
            }
        });

        notasFrame.setVoltarListener(e -> notasFrame.dispose());

        // Inicia o sistema
        menuFrame.mostrar();
    }
}