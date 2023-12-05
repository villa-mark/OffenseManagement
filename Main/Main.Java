package offense.management;

import offense.management.component.*;
import javax.swing.JFrame;
import java.awt.Color;
import offense.management.login.LoginController;


class Main extends Component{

  public static void main(String args[]){
    window.setSize(460, 600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLayout(null);
    window.setResizable(false);
    window.setLocationRelativeTo(null);
    window.getContentPane().setBackground(new Color(0x420606));


    new LoginController();
  }
}