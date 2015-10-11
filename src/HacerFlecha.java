import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Hacerflecha
	{
		public void flecha(Graphics papel, int x1, int y1, int x2, int y2)
            {
                double ang=0.0, angSep=0.0;
                double tx=0,ty=0;
                int dist=0;
                Point punto1=null,punto2=null;

                 punto2=new Point(x1,y1);
                 punto1=new Point(x2,y2);

                 dist=15;

                 ty=-(punto1.y-punto2.y)*1.0;
                 tx=(punto1.x-punto2.x)*1.0;
                 ang=Math.atan (ty/tx);

                 if(tx<0)
                    ang+=Math.PI;
                 Point p1=new Point(),p2=new Point(),punto=punto2;
                 angSep=25.0;
                
                 p1.x=(int)(punto.x+dist*Math.cos (ang-Math.toRadians (angSep)));
                 p1.y=(int)(punto.y-dist*Math.sin (ang-Math.toRadians (angSep)));
                 p2.x=(int)(punto.x+dist*Math.cos (ang+Math.toRadians (angSep)));
                 p2.y=(int)(punto.y-dist*Math.sin (ang+Math.toRadians (angSep)));

                 Graphics2D g2D=(Graphics2D)papel;
                 papel.setColor (Color.black);
                 g2D.setStroke (new BasicStroke(1.2f));
                 papel.drawLine (punto1.x,punto1.y,punto.x,punto.y);

                 int x[] = {p1.x,punto.x,p2.x}; 
                 int y[] = {p1.y,punto.y,p2.y};
                 Polygon myTri = new Polygon(x, y, 3);
                    papel.setColor(Color.BLACK);
                    papel.drawPolygon(myTri);
                    papel.fillPolygon(myTri);
            }

	}