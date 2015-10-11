import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Diag_ajedrez extends JFrame
{
    Vector<Vector<Integer>> tablero = new Vector<Vector<Integer>>(10);
    String cad,camino="";

    public Diag_ajedrez(String cadena){
        super("AJEDREZ");
        setLayout(null);
        cad = cadena;

        Vector<Integer> aux = new Vector<Integer>();
        aux.add(2);
        aux.add(4);
        aux.add(5);
        tablero.add(0, aux);
        tablero.add(1, aux);    
        
        Vector<Integer> aux2 = new Vector<Integer>();
        aux2.add(1);
        aux2.add(4);
        aux2.add(5);
        aux2.add(6);
        aux2.add(3);
        tablero.add(2,aux2);

        Vector<Integer> aux3 = new Vector<Integer>();
        aux3.add(2);
        aux3.add(5);
        aux3.add(6);
        tablero.add(3,aux3);

        Vector<Integer> aux4 = new Vector<Integer>();
        aux4.add(1);
        aux4.add(2);
        aux4.add(5);
        aux4.add(8);
        aux4.add(7);
        tablero.add(4,aux4);

        Vector<Integer> aux5 = new Vector<Integer>();
        aux5.add(1);
        aux5.add(2);
        aux5.add(3);
        aux5.add(4);        
        aux5.add(6);
        aux5.add(7);
        aux5.add(8);
        aux5.add(9);
        tablero.add(5,aux5);

        Vector<Integer> aux6 = new Vector<Integer>();
        aux6.add(2);
        aux6.add(3);
        aux6.add(5);
        aux6.add(8);
        aux6.add(9);
        tablero.add(6,aux6);

        Vector<Integer> aux7 = new Vector<Integer>();
        aux7.add(4);
        aux7.add(5);
        aux7.add(8);
        tablero.add(7,aux7);

        Vector<Integer> aux8 = new Vector<Integer>();
        aux8.add(7);
        aux8.add(4);
        aux8.add(5);
        aux8.add(6);
        aux8.add(9);
        tablero.add(8,aux8);

        Vector<Integer> aux9 = new Vector<Integer>();
        aux9.add(8);
        aux9.add(5);
        aux9.add(6);
        tablero.add(9,aux9);

        evalua(1, 0, "");        
    }

    public void evalua(int casilla, int pos, String res){
        if( pos == cad.length()){
            if( casilla == 9 )
                camino = res;           
        } else {
            for(int i=0 ; i < tablero.get(casilla).size() && camino.length()==0 ; i++)                
                if( valido( tablero.get(casilla).get(i), cad.charAt(pos)) ) {
                    evalua( tablero.get(casilla).get(i), pos+1, res+tablero.get(casilla).get(i) );
                }
        }     
    }

    boolean valido( int casilla, char letra){
        if( letra == 'B' && casilla%2 == 1)
            return true;
        if( letra == 'R' && casilla%2 == 0)
            return true;
        return false;
    }

    public String res(){
        return camino;
    }

	public void paint(Graphics g){
        int posX=30,posY=50,tam=50;
        super.paint(g);
        int conta = 1;
        for(int j=0 ; j<3 ; j++){
            for(int h=0 ; h<3 ; h++){
                if( conta%2 == 1 ){
                    g.setColor(Color.black);
                    g.fillRect( posX, posY, tam, tam);
                }
                else{
                    g.setColor(Color.red);
                    g.fillRect( posX, posY, tam, tam);
                }
                g.setColor(Color.white);
                g.drawString( conta+"", posX+tam/2, posY+tam/2);
                posX = posX + tam;
                conta++;
            }
            posX = 30;
            posY = posY + tam;
        }

        posX=30;posY=50;tam=50;
        conta = 1;
        for(int j=0 ; j<3 ; j++){
            for(int h=0 ; h<3 ; h++){
                if( camino.contains(conta+"") ){
                    g.setColor(Color.green);
                    g.fillRect( posX, posY, tam, tam );
                    delay();
                }
                posX = posX + tam;
                conta++;
            }            
            posX = 30;
            posY = posY + tam;
        }
    }

    void delay(){
        Thread th = new Thread();
        try{
            th.sleep(2000);
        }catch(InterruptedException e){}
    }
}