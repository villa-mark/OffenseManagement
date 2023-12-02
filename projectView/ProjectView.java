package offense.management.project.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ProjectView{

    public static void addButton(JFrame frame, JButton button, int x, int y, int width, int height, String fontStyle, int fontSize, int borderColor, int color){
      button.setBounds(x, y, width, height);
      button.setFont(new Font(fontStyle, Font.BOLD, fontSize));
      button.setBackground(null);
      button.setForeground(new Color(color));
      button.setBorder(new LineBorder(new Color(borderColor), 2));
      button.setFocusable(false);
     

      frame.add(button);
    }

     public static void addLabel(JFrame frame, JLabel label, int x, int y, int width, int height, String fontStyle, int fontSize, int color){
      label.setBounds(x, y, width, height);
      label.setFont(new Font(fontStyle, Font.BOLD, fontSize));
      label.setForeground(new Color(color));

      frame.add(label);
    }
    public static void addTextField(JFrame frame, JTextField textField, int x, int y, int width, int height, int borderColor, String fontStyle, int fontSize, int color){
      textField.setBounds(x, y, width, height);
      textField.setBackground(null);
      textField.setForeground(new Color(color));
      textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(borderColor)));
      textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
    
      frame.add(textField);
    }

    public static void addPasswordField(JFrame frame, JPasswordField passwordField, int x, int y, int width, int height, int borderColor, String fontStyle, int fontSize, int color){
      passwordField.setBounds(x, y, width, height);
      passwordField.setBackground(null);
      passwordField.setForeground(new Color(color));
      passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(borderColor)));
      passwordField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
      passwordField.setEchoChar('*');
    
      frame.add(passwordField);
    }

    public static void clearFrame(JFrame frame){
      frame.getContentPane().removeAll();
      frame.repaint();
      frame.validate();
    }

    public static void addLabelBoder(JFrame frame, JLabel label, int x, int y, int width, int height, int color){
      label.setBounds(x, y, width, height);
      label.setOpaque(true);
      label.setBackground(new Color(color));

      frame.add(label);
    }

    public static void changeStateButton(JButton button, boolean visible, int borderThickness, int color, int borderColor){

      if(!visible){button.setBackground(null);}
      else{button.setBackground(new Color(color));}
      
      butt
      on.setBorder(new LineBorder(new Color(borderColor), borderThickness));
    }
   public static void changeStateButton(JButton button, String fontStyle, int fontSize, int foregroundColor, int backgroundColor, int borderColor, int borderThickness){
    button.setFont(new Font(fontStyle, Font.BOLD, fontSize));
    button.setForeground(new Color(foregroundColor));
    button.setBackground(new Color(backgroundColor));
    button.setBorder(new LineBorder(new Color(borderColor), borderThickness));
  }
} 