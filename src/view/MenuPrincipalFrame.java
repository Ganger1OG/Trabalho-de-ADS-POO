package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalFrame extends JFrame {
    private JButton btnCadastrar, btnListar, btnlancarNotas, btnSair;

    public MenuPrincipalFrame() {
        setTitle("Sistema de Gestão de Alunos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        btnCadastrar = new JButton("Cadastrar Aluno");
        btnListar = new JButton("Listar Alunos");
        btnlancarNotas = new JButton("Lancar Notas");
        btnSair = new JButton("Sair");

        panel.add(btnCadastrar);
        panel.add(btnListar);
        panel.add(btnlancarNotas);
        panel.add(btnSair);

        add(panel);
    }
    public void setCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }
    public void setListarListener(ActionListener listener) {
        btnListar.addActionListener(listener);
    }
    public void setLancarNotasListener(ActionListener listener) {
        btnlancarNotas.addActionListener(listener);
    }
    public void setSairListener(ActionListener listener) {
        btnSair.addActionListener(listener);
    }
    public void mostrar() {
        setVisible(true);
    }
    public void esconder() {
        setVisible(false);
    }
    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}


