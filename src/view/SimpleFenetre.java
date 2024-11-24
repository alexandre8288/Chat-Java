package view;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class SimpleFenetre extends JFrame {
    public SimpleFenetre() {
        super();
        build(); // On initialise notre fenêtre
    }

    private void build() {
        setTitle("Ma première fenêtre"); // On donne un titre à l'application
        setSize(320, 240); // On donne une taille à notre fenêtre
        setLocationRelativeTo(null); // On centre la fenêtre sur l'écran
        setResizable(false); // On interdit le redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // On dit à l'application de se fermer lors du clic sur la croix
        setContentPane(buildContentPane()); // On applique le contenu à la fenêtre
    }

    private JPanel buildContentPane() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Ajout d'un label
        JLabel label = new JLabel("Bienvenue dans l'application de chat !");
        panel.add(label);

        // Bouton pour ajouter un ami
        JButton addFriendButton = new JButton("Ajouter un ami");
        addFriendButton.addActionListener(e -> {
            // Code à exécuter lors du clic sur le bouton
            System.out.println("Bouton 'Ajouter un ami' cliqué !");
            // Ici, vous pouvez ouvrir une nouvelle fenêtre pour saisir le nom de l'ami
        });
        panel.add(addFriendButton);

        // Bouton pour afficher la liste des amis
        JButton showFriendsButton = new JButton("Afficher la liste d'amis");
        showFriendsButton.addActionListener(e -> {
            // Code à exécuter lors du clic sur le bouton
            System.out.println("Bouton 'Afficher la liste d'amis' cliqué !");
            // Ici, vous pouvez afficher la liste des amis (par exemple dans une nouvelle fenêtre ou une console)
        });
        panel.add(showFriendsButton);

        return panel;
    }
}
