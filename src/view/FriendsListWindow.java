package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FriendsListWindow extends JFrame {

    private List<String> friends; // Liste des amis

    public FriendsListWindow(List<String> friends) {
        this.friends = friends; // Initialisation de la liste d'amis
        build(); // Construction de la fenêtre
    }

    private void build() {
        setTitle("Liste d'amis");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centre la fenêtre à l'écran
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fermer uniquement cette fenêtre
        setContentPane(buildContentPane()); // Ajoute le contenu
    }

    private JPanel buildContentPane() {
        // Crée un panneau principal
        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Si la liste d'amis est vide, dessine une image de fond
                if (friends.isEmpty()) {
                    Image backgroundImage = new ImageIcon("src/resources/no_friends_background.jpg").getImage(); // Chemin vers l'image
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        if (!friends.isEmpty()) {
            // Si des amis existent, affichez-les dans une liste
            JList<String> friendsList = new JList<>(friends.toArray(new String[0]));
            friendsList.setFont(new Font("Arial", Font.PLAIN, 14));
            friendsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane scrollPane = new JScrollPane(friendsList);
            panel.add(scrollPane, BorderLayout.CENTER);
        } else {
            // Si aucun ami, affiche un message au centre
            JLabel noFriendsLabel = new JLabel("Vous n'avez pas encore d'amis !");
            noFriendsLabel.setHorizontalAlignment(SwingConstants.CENTER);
            noFriendsLabel.setFont(new Font("Arial", Font.ITALIC, 16));
            noFriendsLabel.setForeground(Color.WHITE);
            panel.add(noFriendsLabel, BorderLayout.CENTER);
        }

        return panel;
    }

    public static void main(String[] args) {
        // Exemple de test
        SwingUtilities.invokeLater(() -> {
            // Test avec une liste vide
            new FriendsListWindow(List.of()).setVisible(true);

            // Test avec une liste d'amis
            // new FriendsListWindow(List.of("Alice", "Bob", "Charlie")).setVisible(true);
        });
    }
}
