package offense.management.main.window;

import javax.swing.*;
import java.awt.*;

class MainWindowView{

  static void addButton(JButton button, JFrame  frame, int x, int y, int width, int height, int backgroundColor, String fontStyle, int fontSize, int foregroundColor){
    button.setBounds(x, y, width, height);
    button.setBackground(new Color(backgroundColor));
    button.setBorder(null);
    button.setFont(new Font(fontStyle, Font.BOLD, fontSize));
    button.setForeground(new Color(foregroundColor));
    button.setFocusable(false);

    frame.add(button);
  }

  static void formatButton(JButton button, int backgroundColor, String fontStyle, int fontSize, int foregroundColor){
    button.setFont(new Font(fontStyle, Font.BOLD, fontSize));
    button.setForeground(new Color(foregroundColor));
    button.setBackground(new Color(backgroundColor));
  }
}