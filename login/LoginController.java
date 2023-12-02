package offense.management.login;

import offense.management.project.view.*;
import offense.management.component.*;
import offense.management.register.*;
import offense.management.main.window.*;
import offense.management.user.*;
import offense.management.user.window.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginController extends Component implements MouseListener{
    JButton loginBtn; 
    JButton registerBtn; 
    JTextField usernameTxt;
    JPasswordField passwordTxt;
    static int mark = 3;
    static String username = null;

  public LoginController(){

    JLabel loginLbl = new JLabel("LOGIN");
    ProjectView.addLabel(window, loginLbl, 125, 30, 200, 60, "Ink Free", 53, 0x7596C3);

    JLabel projectLbl = new JLabel("Offense Management");
    ProjectView.addLabel(window, projectLbl, 70, 500, 310, 40, "EngraversGothic BT", 32, 0x8A7A7A);

    JLabel usernameLbl = new JLabel("Username:");
    ProjectView.addLabel(window, usernameLbl, 65, 135, 150, 40, "EngraversGothic BT", 28, 0x907878);

    usernameTxt = new JTextField();
    ProjectView.addTextField(window, usernameTxt, 65, 185, 315, 40, 0xD98761, "MV Boli", 20, 0xD98761);
  
    JLabel passwordLbl = new JLabel("Password:");                  
    ProjectView.addLabel(window, passwordLbl, 65, 240, 150, 40, "EngraversGothic BT", 28, 0x907878);

    passwordTxt = new JPasswordField();
    ProjectView.addPasswordField(window, passwordTxt, 65, 290, 315, 40, 0xD98761, "MV Boli", 20, 0xD98761);

    loginBtn = new JButton("LOGIN");
    ProjectView.addButton(window, loginBtn, 120, 400, 200, 35, "Monospaced", 20, 0xB5796E, 0xB5796E);
    loginBtn.addMouseListener(this);

    registerBtn = new JButton("REGISTER");
    ProjectView.addButton(window, registerBtn, 120, 450, 200, 35, "Monospaced", 20, 0xB5796E, 0xB5796E);
    registerBtn.addMouseListener(this);

    JLabel warnLbl;
     if(mark == 0){
      warnLbl = new JLabel("ACCOUNT DOESN'T EXIST");
      ProjectView.addLabel(window, warnLbl, 85, 340, 390, 40, "Segoe Print", 20, 0xFF5858);
    }else if(mark == 1){
      warnLbl = new JLabel("WRONG PASSWORD");
      usernameTxt.setText(username);
      ProjectView.addLabel(window, warnLbl, 115, 340, 390, 40, "Segoe Print", 20, 0xFF5858);
    }else if(mark == 4){
      warnLbl = new JLabel("FILL IN THE BLANK");
      usernameTxt.setText(username);
      ProjectView.addLabel(window, warnLbl, 115, 340, 390, 40, "Segoe Print", 20, 0xFF5858);
    }

    addBorder();
    window.setVisible(true);
  }

  static void addBorder(){
    JLabel[] border = new JLabel[6];
    border[0] = new JLabel();
    border[1] = new JLabel();
    border[2] = new JLabel();
    border[3] = new JLabel();
    border[4] = new JLabel();
    border[5] = new JLabel();

    ProjectView.addLabelBoder(window, border[0], 25 ,50, 95, 6, 0x8A7A7A);
    ProjectView.addLabelBoder(window, border[1], 326,50, 95, 6, 0x8A7A7A);
    ProjectView.addLabelBoder(window, border[2], 25 ,50, 6, 475, 0x8A7A7A);
    ProjectView.addLabelBoder(window, border[3], 415 ,50, 6, 475, 0x8A7A7A);
    ProjectView.addLabelBoder(window, border[4], 25, 520, 35, 6, 0x8A7A7A);
    ProjectView.addLabelBoder(window, border[5], 386, 520, 35, 6, 0x8A7A7A);

  }

@SuppressWarnings("deprecation")
  public void mouseClicked(MouseEvent event){
      if(event.getSource() == registerBtn){
        ProjectView.clearFrame(window);
        mark = 3;
        new RegisterController();
      }
      if(event.getSource() == loginBtn){
        username = usernameTxt.getText();
        if(usernameTxt.getText().equals("ADMINISTRATOR") && passwordTxt.getText().equals("ADMIN123")){
          ProjectView.clearFrame(window);
          mark = 7;
          new MainWindowController();
        }else{
          if(usernameTxt.getText().isEmpty() || passwordTxt.getText().isEmpty()){
            ProjectView.clearFrame(window);
            mark = 4;
            new LoginController();
          }else{
            int check = UserController.accountCheck(usernameTxt.getText(), passwordTxt.getText());
            if(check == 0){
              ProjectView.clearFrame(window);
              mark = 0;
              new LoginController();
            }else if(check == 1){
              ProjectView.clearFrame(window);
              mark = 1;
              new LoginController();
            }else if(check == 2){
              ProjectView.clearFrame(window);
              mark = 3;
              new UserWindowController();
            }
          }
        }
      }
  }

  public void mouseEntered(MouseEvent event){
    if(event.getSource() == loginBtn){
      ProjectView.changeStateButton(loginBtn, true, 1, 0x210303, 0xB5796E);
    }
    if(event.getSource() == registerBtn){
      ProjectView.changeStateButton(registerBtn, true, 1, 0x210303, 0xB5796E);
    }
  }
  public void mouseExited(MouseEvent event){
    if(event.getSource() == loginBtn){
      ProjectView.changeStateButton(loginBtn, false, 2, 0xB5796E, 0xB5796E);
    }
    if(event.getSource() == registerBtn){
      ProjectView.changeStateButton(registerBtn, false, 2, 0xB5796E, 0xB5796E);
    }
  }

  public void mousePressed(MouseEvent event){

  }
  public void mouseReleased(MouseEvent event){

  }


}