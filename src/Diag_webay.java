import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Diag_webay extends JFrame
{	
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;    
    int i=0, w=0, e=0, we=0, cont_web=0, cont_ebay=0, cont_webay=0;
    public Diag_webay()
    {
        super("WEBAY");                
        setLayout(null);

       
        l1=new JLabel("Inicio");
        l1.setBounds(15,170,100,15);
        l2=new JLabel("w");
        l2.setBounds(80,100,100,15);
        l3=new JLabel("e");
        l3.setBounds(80,170,100,15);
        l6=new JLabel("b");
        l6.setBounds(175,195,100,15);        
        l8=new JLabel("e");
        l8.setBounds(175,90,100,15);        
        l10=new JLabel("b");
        l10.setBounds(255,80,100,15);
        l11=new JLabel("a");
        l11.setBounds(255,180,100,15);
        l12=new JLabel("y");
        l12.setBounds(350,180,100,15);

        add(l1);
        add(l2);
        add(l3);
        add(l6);
        add(l8);
        add(l10);
        add(l11);        
        add(l12);
    }

	public void paint(Graphics g)
    {
        Hacerflecha hf = new Hacerflecha();
        super.paint(g);
        g.setColor(Color.black);
        g.drawOval(30,150,30,30);//inicio
        g.drawOval(120,100,30,30);//w
        g.drawOval(210,100,30,30);//e
        g.drawOval(300,100,30,30);//b
        g.drawOval(295,95,40,40);//centro-b

        g.drawOval(120,200,30,30);//e
        g.drawOval(210,200,30,30);//b
        g.drawOval(300,200,30,30);//a
        g.drawOval(390,200,30,30);//y
        g.drawOval(385,195,40,40);//centro-y

        hf.flecha(g,120,115,55,155);
        hf.flecha(g,210,115,150,115);
        hf.flecha(g,295,115,240,115);

        hf.flecha(g,120,210,55,175);
        hf.flecha(g,210,215,150,215);
        hf.flecha(g,300,215,240,215);
        hf.flecha(g,385,215,330,215);

        g.setColor(Color.blue);
        switch( w ){
            case 1:
                g.fillOval(120,100,30,30);//w
            break;

            case 2:
                g.fillOval(210,100,30,30);//e
            break;

            case 3:
                g.fillOval(295,95,40,40);//centro-b
            break;
        }
        g.setColor(Color.green);
        switch( e ){
            case 1:
                g.fillOval(120,200,30,30);//e
            break;

            case 2:
                g.fillOval(210,200,30,30);//b
            break;

            case 3:
                g.fillOval(300,200,30,30);//a
            break;
            
            case 4:
                g.fillOval(385,195,40,40);//centro-y
            break;
        }
        g.setColor(Color.orange);
        switch( we ){
            case 1:
                g.drawOval(120,100,30,30);//w
            break;

            case 2:
                g.drawOval(210,100,30,30);//e
                g.drawOval(120,200,30,30);//e
            break;

            case 3:
                g.drawOval(295,95,40,40);//centro-b
                g.drawOval(210,200,30,30);//b
            break;
            
            case 4:
                g.drawOval(300,200,30,30);//a
            break;   
            
            case 5:
                g.drawOval(385,195,40,40);//centro-y
            break;   
        }
    }

    String evalua(String cadena){
        Thread th = new Thread();
        String web="web", ebay="ebay", webay="webay", res;
        i=0; w=0; e=0; we=0; cont_web=0; cont_ebay=0; cont_webay=0;
           
        while( i < cadena.length() ){
            if(cadena.charAt(i) != web.charAt(w++%3))
                w=0;                            
            if(cadena.charAt(i) != ebay.charAt(e++%4))
                e=0;            
            if(cadena.charAt(i) != webay.charAt(we++%5))
                we=0;            

            if(w == 3)
                cont_web++;                             
            if(e == 4)
                cont_ebay++;                                
            if(we == 5)
                cont_webay++;                                   
            
            try{
                th.sleep(2000);
            }catch(InterruptedException e){}
            repaint();
            i++;
        }
        res = "\nWeb: " + cont_web + "\nEbay: " + cont_ebay + "\nWebay: " + cont_webay;
        return res;        
    }       
}