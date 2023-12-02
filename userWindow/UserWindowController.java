package offense.management.user.window;

import offense.management.component.*;
import offense.management.project.view.*;
import offense.management.login.*;
import offense.management.user.*;
import javax.swing.*;
import java.awt.event.*;

public class UserWindowController extends Component implements MouseListener{

  private static int mark = 0;
  JButton recordBtn,  pendingBtn, logoutBtn;
  public UserWindowController(){

    JLabel nameLbl = new JLabel(UserController.getName());
    ProjectView.addLabel(window, nameLbl, 10, 5, 422, 30, "EngraversGothic BT", 28, 0x7092BE);
    nameLbl.setHorizontalAlignment(JLabel.CENTER);
  
    JLabel IDLbl = new JLabel("ID No.: ");
    ProjectView.addLabel(window, IDLbl, 10, 35, 422, 30, "EngraversGothic BT", 25, 0x7092BE);
    IDLbl.setHorizontalAlignment(JLabel.CENTER);

    recordBtn = new JButton("Record");
    pendingBtn = new JButton("Pending");
    recordBtn.addMouseListener(this);
    pendingBtn.addMouseListener(this);
    if(mark == 0){
      UserWindowView.addButton(window, recordBtn, 10, 80, 211, 50, "EngraversGothic BT", 28, 0x7F7F7F, 0x420606,0x7F7F7F);
      UserWindowView.addButton(window, pendingBtn, 221, 80, 211, 50, "EngraversGothic BT", 28, 0x7F7F7F, 0x7F7F7F ,0x420606);
    }else{
      UserWindowView.addButton(window, recordBtn, 10, 80, 211, 50, "EngraversGothic BT", 28, 0x7F7F7F, 0x7F7F7F,0x420606);
      UserWindowView.addButton(window, pendingBtn, 221, 80, 211, 50, "EngraversGothic BT", 28, 0x7F7F7F, 0x420606 ,0x7F7F7F);
    }

    JPanel recordPnl = new JPanel();
    UserWindowView.addPanel(recordPnl, window, 10, 130, 422, 380, 0x7F7F7F);

    logoutBtn = new JButton("Logout");
    UserWindowView.addButton(window, logoutBtn, 120, 515, 211, 40, "EngraversGothic BT", 28, 0x7F7F7F, 0x7F7F7F ,0x420606);
    logoutBtn.addMouseListener(this);

    window.setVisible(true);
  }

  public void mouseClicked(MouseEvent event){
    if(event.getSource() == logoutBtn){
      ProjectView.clearFrame(window);
      mark = 0;
      new LoginController();
    }
    if(event.getSource() == recordBtn){
      ProjectView.clearFrame(window);
      mark = 0;
      new UserWindowController();
    }
    if(event.getSource() == pendingBtn){
      ProjectView.clearFrame(window);
      mark = 1;
      new UserWindowController();
    }

  }
  public void mouseEntered(MouseEvent event){
    if(event.getSource() == logoutBtn){
      ProjectView.changeStateButton(logoutBtn, "EngraversGothic BT", 30, 0xFFFFFF, 0x880015, 0xED1C24, 3);
    }
    if(mark == 0){
      if(event.getSource() == pendingBtn){
        ProjectView.changeStateButton(pendingBtn, "EngraversGothic BT", 30, 0xFFFFFF, 0x961217, 0x7F7F7F, 3);}
      }else{
      if(event.getSource() == recordBtn){
        ProjectView.changeStateButton(recordBtn, "EngraversGothic BT", 30, 0xFFFFFF, 0x961217, 0x7F7F7F, 3);}
    }
    
    
  }
  public void mouseExited(MouseEvent event){
    if(event.getSource() == logoutBtn){
      ProjectView.changeStateButton(logoutBtn, "EngraversGothic BT", 28, 0x7F7F7F, 0x420606, 0x7F7F7F, 1);
    }
     if(mark == 0){
      if(event.getSource() == pendingBtn){
        ProjectView.changeStateButton(pendingBtn, "EngraversGothic BT", 28, 0x7F7F7F, 0x420606, 0x7F7F7F, 1);
      }
    }else{
      if(event.getSource() == recordBtn){
        ProjectView.changeStateButton(recordBtn, "EngraversGothic BT", 28, 0x7F7F7F, 0x420606, 0x7F7F7F, 1);
      }
    }
    
  }
  public void mousePressed(MouseEvent event){
    
  }
  public void mouseReleased(MouseEvent event){
    
  }
  
}