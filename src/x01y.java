import java.io.*;
import java.awt.*;

class x01y
{
	int resultado;
	public x01y(int flag)
	{
		System.out.println("\nX 0 1 Y");
		while(true){
			String cad="", opc;			
			String archivo = "entrada_x01y.txt";
			FileReader fr = null;

			System.out.println("\nDesea teclar la entrada? (S/N)");
			if(flag == 1){
				opc = Aleatorio.si_no();
				System.out.println(opc);
			}
			else
				opc = Leer.dato();
			if(opc.equals("S") || opc.equals("s")){
				System.out.println("\nIntroduzca la cadena");
				if(flag == 1){
					cad = Aleatorio.binario();
					System.out.println("\n" + cad);
				}
				else
					cad = Leer.dato();									
			} else {
				try{
					fr = new FileReader(archivo);
					int caract = fr.read();
					while(caract != -1){
						cad += caract-'0';
						caract = fr.read();
					}
					System.out.println("La cadena es: " + cad);
				}
				catch (FileNotFoundException f){
				    System.out.println("Error: Fichero no encontrado");
				    System.out.println(f.getMessage());
				}
				catch (Exception f){
				    System.out.println("Error de lectura del fichero");
				    System.out.println(f.getMessage());
				}
				finally{
				    try {
				        if(fr != null)
				            fr.close();
				    }
				    catch (Exception f) {
				        System.out.println("Error al cerrar el fichero");
				        System.out.println(f.getMessage());
				    }
				}
			}
			Diag_x01y d = new Diag_x01y();
			d.setBounds(0,0,450,470);
	        d.setResizable(false);
	        d.setVisible(true);	        
	        System.out.println(cad);
			resultado = d.evalua(cad);
			d.dispose();
			if(resultado==1)
				System.out.println("\nLa cadena es valida");
			else
				System.out.println("\nLa cadena NO es valida");
			System.out.println("\nDesea verificar otra palabra? (S/N)");
			if(flag == 1){
				opc = Aleatorio.si_no();
				System.out.println(opc);
			}
			else
				opc = Leer.dato();
			if(opc.equals("N") || opc.equals("n")){
				break;
			}
		}
	}
}