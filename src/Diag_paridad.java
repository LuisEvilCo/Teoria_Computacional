import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Diag_paridad extends JFrame
{	
    JLabel q1,q2,q3,q4,l1,l2,l3,l4,l5,l6,l7,l8,l9;
    int i,uno,cero;
    public Diag_paridad(){
        setLayout(null);
        q1=new JLabel("q0");
        q1.setBounds(36,27,100,15);
        q2=new JLabel("q1");
        q2.setBounds(129,27,100,15);
        q3=new JLabel("q3");
        q3.setBounds(36,117,100,15);
        q4=new JLabel("q4");
        q4.setBounds(129,117,100,15);
       
        l1=new JLabel("Inicio");
        l1.setBounds(0,60,100,15);
        l2=new JLabel("0");
        l2.setBounds(20,80,100,15);
        l3=new JLabel("0");
        l3.setBounds(60,80,100,15);
        l4=new JLabel("0");
        l4.setBounds(115,80,100,15);
        l5=new JLabel("0");
        l5.setBounds(150,80,100,15);
        l6=new JLabel("1");
        l6.setBounds(92,135,100,15);
        l7=new JLabel("1");
        l7.setBounds(92,95,100,15);
        l8=new JLabel("1");
        l8.setBounds(92,45,100,15);
        l9=new JLabel("1");
        l9.setBounds(92,10,100,15);
        add(q1);
        add(q2);
        add(q3);
        add(q4);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(l9);
    }

	public void paint(Graphics g){
        Hacerflecha hf = new Hacerflecha();
        super.paint(g);
        g.drawOval(30,40,30,30);//inicio
        g.drawOval(25,35,40,40);
        g.drawOval(120,40,30,30);//q1
        g.drawOval(30,130,30,30);//q3
        g.drawOval(120,130,30,30);//q4

        hf.flecha(g,30,55,15,80);

        hf.flecha(g,35,135,35,70);
        hf.flecha(g,54,70,54,135);

        hf.flecha(g,125,135,125,70);
        hf.flecha(g,144,70,144,135);

        hf.flecha(g,65,46,123,46);
        hf.flecha(g,123,65,65,65);

        hf.flecha(g,60,136,123,136);
        hf.flecha(g,123,155,60,155);

        g.setColor(Color.green);
        if(cero==0 && uno==1)
            g.fillOval(120,40,30,30);//q1
        if(cero==1 && uno==0)
            g.fillOval(30,130,30,30);//q3
        if(cero==1 && uno==1)
            g.fillOval(120,130,30,30);//q4
        if(cero==0 && uno==0)
            g.fillOval(25,35,40,40);
    }

    public int evalua(String cad){
        int tam = cad.length();
        uno=0;
        cero=0;

        while(i<tam){
            if(cad.charAt(i)=='0')
                cero = (cero+1)%2;
            else if(cad.charAt(i)=='1')
                uno = (uno+1)%2;
            else
                break;            
            delay();
            repaint();
            i++;
        }
        if(cero==0 && uno==0)
            return 1;
        else
            return 0;
    }

    void delay(){
        Thread th = new Thread();
        try{
            th.sleep(2000);
        }catch(InterruptedException e){}
    }
}