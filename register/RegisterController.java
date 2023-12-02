package offense.management.register;

import offense.management.component.*;
import offense.management.project.view.*;
import offense.management.login.*;
import offense.management.user.*;
import javax.swing.*;
import java.awt.event.*;


public class RegisterController extends Component implements MouseListener{

    JButton clearBtn; 
    JButton registerBtn; 
    JTextField nameTxt;
    JTextField usernameTxt;
    JPasswordField passwordTxt;
    static int mark = 0;
    static String name = null;
    static String username = null;

  public RegisterController(){
    JLabel registerLbl = new JLabel("REGISTER");
    ProjectView.addLabel(window, registerLbl, 83, 30, 390, 80, "Ink Free", 53, 0x7596C3);

    JLabel projectLbl = new JLabel("Offense Management");
    ProjectView.addLabel(window, projectLbl, 70, 500, 310, 40, "EngraversGothic BT", 32, 0x8A7A7A);


    JLabel nameLbl = new JLabel("Name:");
    ProjectView.addLabel(window, nameLbl, 65, 100, 120, 40, "EngraversGothic BT", 28, 0x907878);

    nameTxt = new JTextField();
    ProjectView.addTextField(window, nameTxt, 65, 140, 315, 40, 0xD98761, "MV Boli", 20, 0xD98761);

    JLabel usernameLbl = new JLabel("Username:");
    ProjectView.addLabel(window, usernameLbl, 65, 200, 140, 40, "EngraversGothic BT", 28, 0x907878);

    usernameTxt = new JTextField();
    ProjectView.addTextField(window, usernameTxt, 65, 240, 315, 40, 0xD98761, "MV Boli", 20, 0xD98761);
  
    JLabel passwordLbl = new JLabel("Password:");
    ProjectView.addLabel(window, passwordLbl, 65, 300, 140, 40, "EngraversGothic BT", 28, 0x907878);

    passwordTxt = new JPasswordField();
    ProjectView.addTextField(window, passwordTxt, 65, 340, 315, 40, 0xD98761, "MV Boli", 20, 0xD98761);

    clearBtn = new JButton("CLEAR");
    ProjectView.addButton(window, clearBtn, 55, 450, 160, 35, "Monospaced", 20, 0xB5796E, 0xB5796E);
    clearBtn.addMouseListener(this);

    registerBtn = new JButton("REGISTER");
    ProjectView.addButton(window, registerBtn, 230, 450, 160, 35, "Monospaced", 20, 0xB5796E, 0xB5796E);
    registerBtn.addMouseListener(this);

    if(mark == 1){
      JLabel warnLbl = new JLabel("TRY ANOTHER USERNAME");
      ProjectView.addLabel(window, warnLbl, 75, 390, 390, 40, "Segoe Print", 20, 0xFF5858);
      nameTxt.setText(name);
    }else if(mark == 2){
      JLabel warnLbl = new JLabel("FILL IN THE BLANK");
      ProjectView.addLabel(window, warnLbl, 110, 390, 390, 40, "Segoe Print", 20, 0xFF5858);
      nameTxt.setText(name);
      usernameTxt.setText(username);
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

    ProjectView.addLabelBoder(window, border[0], 25 ,50, 55, 6, 0x8A7A7A);
    ProjectView.addLabelBoder(window, border[1], 366,50, 55, 6, 0x8A7A7A);
    ProjectView.addLabelBoder(window, border[2], 25 ,50, 6, 475, 0x8A7A7A);
    ProjectView.addLabelBoder(window, border[3], 415 ,50, 6, 475, 0x8A7A7A);
    ProjectView.addLabelBoder(window, border[4], 25, 520, 35, 6, 0x8A7A7A);
    ProjectView.addLabelBoder(window, border[5], 386, 520, 35, 6, 0x8A7A7A);

  }
@SuppressWarnings("deprecation")
   public void mouseClicked(MouseEvent event){
       if(event.getSource() == clearBtn){
         ProjectView.clearFrame(window);
         mark = 0;
         name = null;
         new LoginController();
      }
      if(event.getSource() == registerBtn){
        name = nameTxt.getText();
        username = usernameTxt.getText();
        if(nameTxt.getText().isEmpty() || usernameTxt.getText().isEmpty() ||  passwordTxt.getText().isEmpty()){
          ProjectView.clearFrame(window);
          mark = 2;
          new RegisterController();
        }
        else{
           int check = UserController.accountCheck(usernameTxt.getText(), passwordTxt.getText());
            if(check == 0){
              ProjectView.clearFrame(window);
              UserController.addDataInFile(nameTxt.getText(), usernameTxt.getText(), passwordTxt.getText());
              mark = 0;
              new LoginController();
            }else if(check == 1 || check == 2){
              ProjectView.clearFrame(window);
              mark = 1;
              new RegisterController();
            }
        }
       
      }
  }

  public void mouseEntered(MouseEvent event){
    if(event.getSource() == clearBtn){
      ProjectView.changeStateButton(clearBtn, true, 1, 0x210303, 0xB5796E);
    }
    if(event.getSource() == registerBtn){
      ProjectView.changeStateButton(registerBtn, true, 1, 0x210303, 0xB5796E);
    }
  }
  public void mouseExited(MouseEvent event){
    if(event.getSource() == clearBtn){
      ProjectView.changeStateButton(clearBtn, false, 2, 0xB5796E, 0xB5796E);
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