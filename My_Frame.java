import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class My_Frame extends JFrame {

    private int width ;
    private int height ;
    public int level ;

    My_Frame(){

        this.setTitle("Fraktal Koch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
       //this.setSize(1500,1000);
        this.setSize(1500,800);
        this.setVisible(true);
        this.width = this.getWidth() / 2;
        this.height = this.getHeight() / 2;
        this.level = 7;


    }
    public void paint(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.cyan);

        //koch_snowflake(g2D , 3 , 300 , 100);
        //g2D.setColor(Color.green);
        koch_snowflake(g2D , 5 , 600 , 300);
        g2D.setColor(Color.red);
        koch_snowflake(g2D , 6 , 900 , 100);
        g2D.setColor(Color.orange);
        koch_snowflake(g2D , 7 , 300 , 300);
       // g2D.setColor(Color.magenta);
       // koch_snowflake(g2D , 7 , 600 , 100);
        g2D.setColor(Color.GREEN);
        koch_snowflake(g2D , 8 , 000 , 300);
        g2D.setColor(Color.GREEN);


    }

    private void koch_snowflake(Graphics g , int level_x , int x_x ,int y_y){
        drawCurve(g,100 + x_x  ,150,0,300,level_x);
        drawCurve(g,400+ x_x ,150,1.55,300,level_x);
        drawCurve(g,400 + x_x  ,450,3.15,300,level_x);
        drawCurve(g,100 + x_x ,450,4.70,300,level_x);
    }
    private void drawCurve(Graphics g, double x1, double y1,
                             double angle1, double sideLength, int level) {


        double x2, y2, angle2, x3, y3, angle3, x4, y4;

        if (level>1) {

            sideLength /= 3;
            level -= 1;
            drawCurve(g, x1,y1, angle1, sideLength, level);
            x2 = x1+sideLength*Math.cos(angle1);
            y2 = y1+sideLength*Math.sin(angle1);
            angle2 = angle1-Math.PI/3;
            drawCurve(g, x2,y2, angle2, sideLength, level);
            x3 = x2+sideLength*Math.cos(angle2);
            y3 = y2+sideLength*Math.sin(angle2);
            angle3 = angle1+Math.PI/3;
            drawCurve(g, x3,y3, angle3, sideLength, level );
            x4 = x3+sideLength*Math.cos(angle3);
            y4 = y3+sideLength*Math.sin(angle3);
            drawCurve(g, x4,y4, angle1, sideLength, level);
        }
        else {

            g.drawLine((int)x1,(int)y1,
                    (int)(x1+sideLength*Math.cos(angle1)),(int)(y1+sideLength*Math.sin(angle1)));
        }
    }
        }





