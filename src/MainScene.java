import javax.swing.*;
import java.awt.*;

import static java.awt.Color.RED;


public class MainScene extends JPanel {
    public MainScene(int x, int y , int width, int hight){
        this.setBounds(x, y ,  width, hight);
        this.setFocusable(true);
        this.requestFocus();
        //this.setBackground(RED);
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int size = Integer.valueOf((int) (Window.WIDTH*0.075*3));
        System.out.println(size +" size");
        g.fillRect(0, 5,5, Window.HIGHT-5);
        g.fillRect((size + Window.BUFFER), 5,5, Window.HIGHT-5);
        g.fillRect((size*2 + Window.BUFFER*2), 5,5, Window.HIGHT-5);
        g.fillRect((size*3 + Window.BUFFER*3), 5,5, Window.HIGHT-5);

        g.fillRect(0, (size + Window.BUFFER),(size*3 + Window.BUFFER*3), 5);
        g.fillRect(0, (size*2 + Window.BUFFER*2),(size*3 + Window.BUFFER*3), 5);
        g.fillRect(0, (size*3 + Window.BUFFER*3),(size*3 + Window.BUFFER*3), 5);
       // g.drawLine(0,1000,1000,HEIGHT);


    }

}
