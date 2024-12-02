package view;

import javax.swing.*;
import java.awt.*;

public class StartingScreen extends JFrame {
    public StartingScreen() {
        super();
        build(); // On initialise notre fenêtre
        animateWindow(); // Ajoute une animation au démarrage
    }

    private void build() {
        setTitle("Application de Chat"); // Titre plus pertinent
        setSize(400, 300); // Taille légèrement plus grande pour plus de lisibilité
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        setResizable(false); // Désactiver le redimensionnement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Quitter l'application en fermant la fenêtre
        setContentPane(buildContentPane()); // Construire et appliquer le contenu
    }

    private JPanel buildContentPane() {
        // Création du panneau principal avec un layout plus structuré
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(60, 63, 65)); // Couleur de fond moderne (gris foncé)

        // Ajout d'un label d'accueil
        JLabel label = new JLabel("Bienvenue dans l'application de chat !");
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centrer le texte
        label.setFont(new Font("Arial", Font.BOLD, 18)); // Police plus grande et en gras
        label.setForeground(Color.WHITE); // Texte en blanc
        panel.add(label, BorderLayout.NORTH);

        // Panneau pour les boutons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        buttonPanel.setOpaque(false); // Rendre le fond transparent pour garder la couleur principale

        // Bouton pour ajouter un ami (à faire)
        JButton addFriendButton = createStyledButton("Ajouter un ami");
        addFriendButton.addActionListener(e -> {
            System.out.println("Bouton 'Ajouter un ami' cliqué !");
            JOptionPane.showMessageDialog(this, "Fonctionnalité à implémenter : Ajouter un ami.");
        });
        buttonPanel.add(addFriendButton);

        // Bouton pour afficher la liste des amis (à faire)
        JButton showFriendsButton = createStyledButton("Afficher la liste d'amis");
        showFriendsButton.addActionListener(e -> {
            System.out.println("Bouton 'Afficher la liste d'amis' cliqué !");
            JOptionPane.showMessageDialog(this, "Fonctionnalité à implémenter : Afficher la liste d'amis.");
        });
        buttonPanel.add(showFriendsButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        return panel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14)); // Police des boutons
        button.setBackground(new Color(75, 110, 175)); // Couleur de fond (bleu)
        button.setForeground(Color.WHITE); // Texte blanc
        button.setFocusPainted(false); // Désactiver le contour de focus
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Espacement interne
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Curseur de la main
        return button;
    }

    private void animateWindow() {
        // Taille de l'écran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Position de départ (hors de l'écran, en haut à gauche)
        int targetX = (screenSize.width - getWidth()) / 2;
        int targetY = (screenSize.height - getHeight()) / 2;

        // Utilisation d'un tableau pour les positions de départ (modifiable dans la lambda)
        int[] position = { -getWidth(), -getHeight() }; // position[0] = startX, position[1] = startY

        Timer timer = new Timer(10, null);
        timer.addActionListener(e -> {
            // Mise à jour des positions
            if (position[0] < targetX) position[0] += 10;
            if (position[1] < targetY) position[1] += 10;

            // Mettre à jour la position de la fenêtre
            setLocation(position[0], position[1]);

            // Arrêter l'animation lorsqu'on atteint la position cible
            if (position[0] >= targetX && position[1] >= targetY) {
                setLocation(targetX, targetY);
                timer.stop();
            }
        });
        timer.start();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartingScreen fenetre = new StartingScreen();
            fenetre.setVisible(true); // Afficher la fenêtre
        });
    }
}
