import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Diag_x01 extends JFrame
{	
    JLabel q1,q2,q3,l1,l2,l4,l5,l6;
    int i,cero,flag;

    public Diag_x01(){
        setLayout(null);
        q1=new JLabel("q0");
        q1.setBounds(36,67,100,15);
        q2=new JLabel("q1");
        q2.setBounds(129,67,100,15);
        q3=new JLabel("q2");
        q3.setBounds(218,67,100,15);
       
        l1=new JLabel("Inicio");
        l1.setBounds(15,100,100,15);
        l2=new JLabel("0,1");
        l2.setBounds(55,95,100,15);
        l4=new JLabel("0");
        l4.setBounds(80,55,100,15);
        l5=new JLabel("1");
        l5.setBounds(170,55,100,15);
        add(q1);
        add(q2);
        add(q3);
        add(l1);
        add(l2);
        add(l4);
        add(l5);
    }

	public void paint(Graphics g){
        Hacerflecha hf = new Hacerflecha();
        super.paint(g);
        g.drawOval(30,80,30,30);
        g.drawOval(120,80,30,30);
        g.drawOval(210,80,30,30);
        g.drawOval(205,75,40,40);

        hf.flecha(g,120,95,60,95);
        hf.flecha(g,210,95,150,95);

        g.drawLine(57,105,50,125);
        hf.flecha(g,40,108,50,125);

        hf.flecha(g,30,95,30,120);

        g.setColor(Color.green);
        if(i>0)
            g.fillOval(30,80,30,30);
        if(cero==1)
            g.fillOval(120,80,30,30);
        if(flag==1)
            g.fillOval(205,75,40,40);
    }

    int evalua(String cad){
        int tam = cad.length();
        
        flag = 0;
        i=0;
        while(cad.charAt(i)=='1' || cad.charAt(i)=='0' && i<tam-2){
            i++;
            delay();
            repaint();            
        }
        if(cad.charAt(i)=='0'){
            cero=1;
            delay();
            repaint();
            if(cad.charAt(++i)=='1'){
                flag = 1;
                delay();
                repaint();                
            }
        }
        i++;
        if(i<tam)
            flag = 0;
        return flag;
    }

    void delay(){
        Thread th = new Thread();
        try{
            th.sleep(2000);
        }catch(InterruptedException e){}
    }
}