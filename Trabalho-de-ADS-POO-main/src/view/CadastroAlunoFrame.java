package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CadastroAlunoFrame extends JFrame {
    private JTextField txtNome, txtEmail, txtEndereco, txtCurso, txtIdade;
    private JButton btnCadastrar, btnVoltar;

    public CadastroAlunoFrame() {
        setTitle("Cadastro de Aluno");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Nome
        JPanel nomePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nomePanel.add(new JLabel("Nome:"));
        txtNome = new JTextField(25);
        nomePanel.add(txtNome);

        // Email
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPanel.add(new JLabel("Email:"));
        txtEmail = new JTextField(25);
        emailPanel.add(txtEmail);

        // Endereço
        JPanel enderecoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        enderecoPanel.add(new JLabel("Endereço:"));
        txtEndereco = new JTextField(25);
        enderecoPanel.add(txtEndereco);

        // Curso
        JPanel cursoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cursoPanel.add(new JLabel("Curso:"));
        txtCurso = new JTextField(25);
        cursoPanel.add(txtCurso);

        // Idade
        JPanel idadePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idadePanel.add(new JLabel("Idade:"));
        txtIdade = new JTextField(5);
        idadePanel.add(txtIdade);

        // Botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnCadastrar = new JButton("Cadastrar");
        btnVoltar = new JButton("Voltar");
        botoesPanel.add(btnCadastrar);
        botoesPanel.add(btnVoltar);

        panel.add(nomePanel);
        panel.add(emailPanel);
        panel.add(enderecoPanel);
        panel.add(cursoPanel);
        panel.add(idadePanel);
        panel.add(new JLabel());
        panel.add(botoesPanel);

        add(panel);
    }

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

    public void setCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }

    public void setVoltarListener(ActionListener listener) {
        btnVoltar.addActionListener(listener);
    }

    public void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
        txtCurso.setText("");
        txtIdade.setText("");
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}