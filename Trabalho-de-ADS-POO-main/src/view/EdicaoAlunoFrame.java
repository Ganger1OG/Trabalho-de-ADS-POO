package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EdicaoAlunoFrame extends JFrame {
    private JTextField txtNome, txtEmail, txtEndereco, txtCurso, txtIdade;
    private JButton btnSalvar, btnCancelar;
    private int alunoId;

    public EdicaoAlunoFrame(int alunoId, String nome, String email, String endereco, String curso, int idade) {
        this.alunoId = alunoId;
        setTitle("Editar Aluno");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Nome
        txtNome = new JTextField(nome, 25);
        panel.add(criarCampo("Nome:", txtNome));

        // Email
        txtEmail = new JTextField(email, 25);
        panel.add(criarCampo("Email:", txtEmail));

        // Endereço
        txtEndereco = new JTextField(endereco, 25);
        panel.add(criarCampo("Endereço:", txtEndereco));

        // Curso
        txtCurso = new JTextField(curso, 25);
        panel.add(criarCampo("Curso:", txtCurso));

        // Idade
        txtIdade = new JTextField(String.valueOf(idade), 5);
        panel.add(criarCampo("Idade:", txtIdade));

        // Botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");
        botoesPanel.add(btnSalvar);
        botoesPanel.add(btnCancelar);
        panel.add(botoesPanel);

        add(panel);
    }

    private JPanel criarCampo(String label, JTextField campo) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(label));
        panel.add(campo);
        return panel;
    }

    public int getAlunoId() { return alunoId; }
    public String getNome() { return txtNome.getText(); }
    public String getEmail() { return txtEmail.getText(); }
    public String getEndereco() { return txtEndereco.getText(); }
    public String getCurso() { return txtCurso.getText(); }
    public int getIdade() {
        try {
            return Integer.parseInt(txtIdade.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void setSalvarListener(ActionListener listener) {
        btnSalvar.addActionListener(listener);
    }

    public void setCancelarListener(ActionListener listener) {
        btnCancelar.addActionListener(listener);
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}