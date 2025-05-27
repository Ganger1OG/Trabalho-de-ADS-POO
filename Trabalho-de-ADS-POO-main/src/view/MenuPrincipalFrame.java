package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPrincipalFrame extends JFrame {
    private JButton btnCadastrar, btnListar, btnLancarNotas, btnSair;

    public MenuPrincipalFrame() {
        setTitle("Sistema de Gestão de Alunos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        btnCadastrar = new JButton("Cadastrar Aluno");
        btnListar = new JButton("Listar Alunos");
        btnLancarNotas = new JButton("Lançar Notas");
        btnSair = new JButton("Sair");

        panel.add(btnCadastrar);
        panel.add(btnListar);
        panel.add(btnLancarNotas);
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
        btnLancarNotas.addActionListener(listener);
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
}