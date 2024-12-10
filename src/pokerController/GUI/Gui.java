package pokerController.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;


public class Gui extends JFrame {
    public Gui() { // Constructeur de la classe Gui
        super("titre de l'application"); // Appel au constructeur parent doit être en premier

        WindowListener l = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        
        };
        BackgroundPanel bgPanel = new BackgroundPanel("src/pokerController/GUI/table.jpg");
        setContentPane(bgPanel);
        JLabel label = new JLabel("Jeu de Poker entre amis");
        label.setFont(new Font("Algerian", Font.BOLD, 50)); // Police Serif, gras, taille 18
        label.setBounds(500, 50, 200, 30);
        label.setForeground(Color.WHITE);


        // Création d'un bouton
        JButton button = new JButton("Jouer");
        button.setBounds(0, 0, 150, 40); // Position et taille du bouton

        // Ajouter un écouteur d'événements au bouton
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action effectuée lorsque le bouton est cliqué
                JOptionPane.showMessageDialog(null, "Au revoir");
            }
        });


        // Ajouter la zone de texte au panneau
        bgPanel.add(button);
        bgPanel.add(label);
        addWindowListener(l);
        setSize(1000, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Gui(); // Instancier la classe Gui pour afficher la fenêtre
    }
}


