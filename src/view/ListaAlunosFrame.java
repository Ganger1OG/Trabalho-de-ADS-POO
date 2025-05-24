package view;

import model.Aluno;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ListaAlunosFrame extends JFrame {
    private JTable tabelaAlunos;
    private JButton btnVoltar;
    private DefaultTableModel tableModel;

    public ListaAlunosFrame() {
        setTitle("Lista de Alunos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] colunas = {"ID", "Nome", "Média", "Situação", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Nota 5", "Nota 6"};
        tableModel = new DefaultTableModel(colunas, 0);
        tabelaAlunos = new JTable(tableModel);
        tabelaAlunos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPane = new JScrollPane(tabelaAlunos);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        btnVoltar = new JButton("Voltar");
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botoesPanel.add(btnVoltar);
        panel.add(botoesPanel, BorderLayout.SOUTH);

        add(panel);
    }

    public void carregarAlunos(List<Aluno> alunos) {
        String[] colunas = {"ID", "Nome", "Email", "Idade", "Curso", "Endereço", "Média", "Situação", "Nota 1", "Nota 2", "Nota 3"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        tabelaAlunos.setModel(tableModel);

        for (Aluno aluno : alunos) {
            Object[] rowData = new Object[14];
            rowData[0] = aluno.getId();
            rowData[1] = aluno.getNome();
            rowData[2] = aluno.getEmail();
            rowData[3] = aluno.getIdade();
            rowData[4] = aluno.getCurso();
            rowData[5] = aluno.getEndereco();
            rowData[6] = String.format("%.2f", aluno.calcularMedia());
            rowData[7] = aluno.isAprovado() ? "Aprovado" : "Reprovado";

            double[] notas = aluno.getNotas();
            for (int i = 0; i < notas.length; i++) {
                rowData[8 + i] = String.format("%.2f", notas[i]);
            }

            tableModel.addRow(rowData);
        }
    }

    public void setVoltarListener(ActionListener listener) {
        btnVoltar.addActionListener(listener);
    }
}