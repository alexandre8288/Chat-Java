import javax.swing.*;

import view.StartingScreen;
public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                //On crée une nouvelle instance de notre JDialog
                StartingScreen fenetre = new StartingScreen();
                fenetre.setVisible(true);//On la rend visible
            }
        });
    }
}

