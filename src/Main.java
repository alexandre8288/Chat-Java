import javax.swing.*;
import java.awt.event.*;
import view.SimpleFenetre;
public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                //On crée une nouvelle instance de notre JDialog
                SimpleFenetre fenetre = new SimpleFenetre();
                fenetre.setVisible(true);//On la rend visible
            }
        });
    }
}

