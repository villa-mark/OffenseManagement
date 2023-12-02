package offense.management.main.window;

import javax.swing.*;
import offense.management.component.*;
import offense.management.project.view.*;
import offense.management.login.*;
import java.awt.event.*;

public class MainWindowController extends Component implements MouseListener{
   JButton fileOffenseBtn, acceptRequestBtn, pendingAppealBtn, logoutBtn;

  public MainWindowController(){

    JLabel adminLbl = new JLabel("ADMIN");
    ProjectView.addLabel(window, adminLbl, 125, 30, 200, 60, "Ink Free", 53, 0x7596C3);

    JLabel projectLbl = new JLabel("Offense Management");
    ProjectView.addLabel(window, projectLbl, 70, 500, 310, 40, "EngraversGothic BT", 32, 0x7596C3 );

    fileOffenseBtn = new JButton("File Offense");  
    MainWindowView.addButton(fileOffenseBtn, window, 31, 140, 384, 70, 0x420606, "EngraversGothic BT", 40, 0x8A7A7A);
    fileOffenseBtn.addMouseListener(this);

    acceptRequestBtn =new JButton("Accept Request");
    MainWindowView.addButton(acceptRequestBtn, window, 31, 220, 384, 70, 0x420606, "EngraversGothic BT", 40, 0x8A7A7A);
    acceptRequestBtn.addMouseListener(this);

    pendingAppealBtn = new JButton("Pending Appeal");
    MainWindowView.addButton(pendingAppealBtn, window, 31, 300, 384, 70, 0x420606, "EngraversGothic BT", 40, 0x8A7A7A);
    pendingAppealBtn.addMouseListener(this);
    
    logoutBtn = new JButton("Logout");
    MainWindowView.addButton(logoutBtn, window, 31, 380, 384, 70, 0x420606, "EngraversGothic BT", 40, 0x8A7A7A);
    logoutBtn.addMouseListener(this);

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

  public void mouseClicked(MouseEvent event){
      if(event.getSource() == logoutBtn){
        ProjectView.clearFrame(window);
        new LoginController();
      }
  }
  public void mouseEntered(MouseEvent event){
     if(event.getSource() == fileOffenseBtn){
        MainWindowView.formatButton(fileOffenseBtn, 0x2B0405, "EngraversGothic BT", 45, 0x839DCC);
     }
     if(event.getSource() == acceptRequestBtn){
        MainWindowView.formatButton(acceptRequestBtn, 0x2B0405, "EngraversGothic BT", 45, 0x839DCC);
     }
     if(event.getSource() == pendingAppealBtn){
        MainWindowView.formatButton(pendingAppealBtn, 0x2B0405, "EngraversGothic BT", 45, 0x839DCC);
     }
     if(event.getSource() == logoutBtn){
        MainWindowView.formatButton(logoutBtn, 0x2B0405, "EngraversGothic BT", 45, 0xED1C24);
     }

  }
  public void mouseExited(MouseEvent event){
    if(event.getSource() == fileOffenseBtn){
        MainWindowView.formatButton(fileOffenseBtn, 0x420606, "EngraversGothic BT", 40, 0x8A7A7A);
     }
     if(event.getSource() == acceptRequestBtn){
        MainWindowView.formatButton(acceptRequestBtn, 0x420606, "EngraversGothic BT", 40, 0x8A7A7A);
     }
     if(event.getSource() == pendingAppealBtn){
        MainWindowView.formatButton(pendingAppealBtn, 0x420606, "EngraversGothic BT", 40, 0x8A7A7A);
     }
     if(event.getSource() == logoutBtn){
        MainWindowView.formatButton(logoutBtn, 0x420606, "EngraversGothic BT", 40, 0x8A7A7A);
     }
    
  }
  public void mousePressed(MouseEvent event){
    
  }
  public void mouseReleased(MouseEvent event){
    
  }
}