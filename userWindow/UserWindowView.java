package offense.management.user.window;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

class UserWindowView{
    public static void addButton(JFrame frame, JButton button, int x, int y, int width, int height, String fontStyle, int fontSize, int borderColor, int color, int backgroundColor){
      button.setBounds(x, y, width, height);
      button.setFont(new Font(fontStyle, Font.BOLD, fontSize));
      button.setBackground(new Color(backgroundColor));
      button.setForeground(new Color(color));
      button.setBorder(new LineBorder(new Color(borderColor), 2));
      button.setFocusable(false);
     

      frame.add(button);
    }
    public static void addPanel(JPanel panel, JFrame frame, int x, int y, int width, int height, int color){
      panel.setBounds(x, y, width, height);
      panel.setBackground(new Color(color));
      panel.setOpaque(true);

      frame.add(panel);
    }
} 