package quiz.application;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    
    Login() {      
        // Get the dimensions of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Setting size of the Frame
        setSize(screenSize.width - screenSize.width/4, screenSize.height - screenSize.height/3);
        // Setting color of the Frame
        getContentPane().setBackground(Color.WHITE);
        
        // Calculate the center coordinates
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;      
        setLocation(x, y);  // Set the location at the center of the screen
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(il);
        setLayout(null);
        image.setBounds(0,0,getWidth()/2,getHeight());
        add(image);
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Login();
    }
}

