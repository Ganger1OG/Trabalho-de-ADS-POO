package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LancarNotasFrame extends JFrame {
    private JTextField txtIdAluno, txtNota;
    private JComboBox<String> cbDisciplina;
    private JButton btnLancar, btnVoltar;

    public LancarNotasFrame() {
        setTitle("Lançamento de Notas");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ID Aluno
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("ID do Aluno:"));
        txtIdAluno = new JTextField(10);
        idPanel.add(txtIdAluno);

        // Disciplina
        JPanel disciplinaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        disciplinaPanel.add(new JLabel("Disciplina (1-3):"));
        cbDisciplina = new JComboBox<>(new String[]{"1", "2", "3"});
        disciplinaPanel.add(cbDisciplina);

        // Nota
        JPanel notaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        notaPanel.add(new JLabel("Nota (0-10):"));
        txtNota = new JTextField(10);
        notaPanel.add(txtNota);

        // Botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnLancar = new JButton("Lançar Nota");
        btnVoltar = new JButton("Voltar");
        botoesPanel.add(btnLancar);
        botoesPanel.add(btnVoltar);

        panel.add(idPanel);
        panel.add(disciplinaPanel);
        panel.add(notaPanel);
        panel.add(new JLabel());
        panel.add(botoesPanel);

        add(panel);
    }

    public int getIdAluno() {
        try {
            return Integer.parseInt(txtIdAluno.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public int getDisciplina() {
        return cbDisciplina.getSelectedIndex() + 1;
    }

    public double getNota() {
        try {
            return Double.parseDouble(txtNota.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void setLancarListener(ActionListener listener) {
        btnLancar.addActionListener(listener);
    }

    public void setVoltarListener(ActionListener listener) {
        btnVoltar.addActionListener(listener);
    }

    public void limparCampos() {
        txtIdAluno.setText("");
        txtNota.setText("");
        cbDisciplina.setSelectedIndex(0);
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}