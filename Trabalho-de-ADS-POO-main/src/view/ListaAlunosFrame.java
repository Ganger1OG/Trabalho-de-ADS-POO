package view;

import model.Aluno;  // Importação adicionada
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ListaAlunosFrame extends JFrame {
    private JTable tabelaAlunos;
    private JButton btnEditar, btnExcluir, btnVoltar;
    private DefaultTableModel tableModel;

    public ListaAlunosFrame() {
        setTitle("Lista de Alunos");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configuração da tabela
        String[] colunas = {"ID", "Nome", "Email", "Idade", "Curso", "Endereço", "Média", "Situação", "Nota 1", "Nota 2", "Nota 3"};
        tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0, 3 -> Integer.class;  // ID e Idade
                    case 6, 8, 9, 10 -> Double.class; // Notas e Média
                    default -> String.class;
                };
            }
        };

        tabelaAlunos = new JTable(tableModel);
        configurarTabela();

        // Painel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(tabelaAlunos), BorderLayout.CENTER);
        panel.add(criarPainelBotoes(), BorderLayout.SOUTH);

        add(panel);
    }

    private void configurarTabela() {
        // Configurações de seleção
        tabelaAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaAlunos.setSelectionBackground(new Color(220, 240, 255));
        tabelaAlunos.setSelectionForeground(Color.BLACK);

        // Ordenação
        tabelaAlunos.setAutoCreateRowSorter(true);

        // Formatação
        tabelaAlunos.setDefaultRenderer(Double.class, new CenterRenderer());
        tabelaAlunos.setDefaultRenderer(Integer.class, new CenterRenderer());

        // Tamanho das colunas
        tabelaAlunos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = tabelaAlunos.getColumnModel();
        int[] widths = {50, 150, 200, 50, 100, 150, 60, 80, 60, 60, 60};
        for (int i = 0; i < widths.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(widths[i]);
        }
    }

    private JPanel criarPainelBotoes() {
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnEditar = criarBotao("Editar", new Color(70, 130, 180));
        btnExcluir = criarBotao("Excluir", new Color(220, 20, 60));
        btnVoltar = criarBotao("Voltar", new Color(169, 169, 169));

        botoesPanel.add(btnEditar);
        botoesPanel.add(btnExcluir);
        botoesPanel.add(btnVoltar);
        return botoesPanel;
    }

    private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setBackground(cor);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(100, 30));
        return botao;
    }

    public void carregarAlunos(List<Aluno> alunos) {
        tableModel.setRowCount(0);
        for (Aluno aluno : alunos) {
            Object[] rowData = {
                    aluno.getId(),
                    aluno.getNome(),
                    aluno.getEmail(),
                    aluno.getIdade(),
                    aluno.getCurso(),
                    aluno.getEndereco(),
                    aluno.calcularMedia(),
                    aluno.isAprovado() ? "Aprovado" : "Reprovado",
                    aluno.getNotas()[0],
                    aluno.getNotas()[1],
                    aluno.getNotas()[2]
            };
            tableModel.addRow(rowData);
        }
    }

    // Classe interna para centralizar conteúdo das células
    private static class CenterRenderer extends DefaultTableCellRenderer {
        public CenterRenderer() {
            setHorizontalAlignment(SwingConstants.CENTER);
        }
    }

    public int getAlunoSelecionadoId() {
        int linha = tabelaAlunos.getSelectedRow();
        return linha >= 0 ? (int) tableModel.getValueAt(linha, 0) : -1;
    }

    public void setEditarListener(ActionListener listener) {
        btnEditar.addActionListener(listener);
    }

    public void setExcluirListener(ActionListener listener) {
        btnExcluir.addActionListener(listener);
    }

    public void setVoltarListener(ActionListener listener) {
        btnVoltar.addActionListener(listener);
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}