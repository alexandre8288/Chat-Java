package view;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SimpleFenetre extends JFrame{

    public SimpleFenetre(){
        super();

        build();//On initialise notre fenêtre
    }

    private void build(){
        setTitle("Ma première fenêtre"); //On donne un titre à l'application
        setSize(320,240); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(false); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setContentPane(buildContentPane());
    }

    private JPanel buildContentPane(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("appli de connard");

        panel.add(label);

        return panel;
    }
}