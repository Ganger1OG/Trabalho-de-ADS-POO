package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LancarNotasFrame extends JFrame {

    private JTextField txtIdAluno;
    private JComboBox<String> cbCadeira;
    private JTextField txtNota;
    private JButton btnLancar, btnVoltar;

    public LancarNotasFrame() {
        setTitle("Lançamento de Notas");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Painel para ID do Aluno
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("ID do Aluno:"));
        txtIdAluno = new JTextField(10);
        idPanel.add(txtIdAluno);

        // Painel para seleção de cadeira
        JPanel cadeiraPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cadeiraPanel.add(new JLabel("Cadeira:"));
        cbCadeira = new JComboBox<>(new String[]{"1", "2", "3"});
        cadeiraPanel.add(cbCadeira);

        // Painel para nota
        JPanel notaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        notaPanel.add(new JLabel("Nota (0-10):"));
        txtNota = new JTextField(10);
        notaPanel.add(txtNota);

        // Painel de botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnLancar = new JButton("Lançar Nota");
        btnVoltar = new JButton("Voltar");
        botoesPanel.add(btnLancar);
        botoesPanel.add(btnVoltar);

        panel.add(idPanel);
        panel.add(cadeiraPanel);
        panel.add(notaPanel);
        panel.add(new JLabel()); // Espaçamento
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

    public int getCadeira() {
        return cbCadeira.getSelectedIndex() + 1; // +1 porque o combo começa em 0
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
        cbCadeira.setSelectedIndex(0);
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}
