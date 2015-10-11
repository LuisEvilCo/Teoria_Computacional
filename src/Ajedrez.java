import java.io.*;
import java.awt.*;

class Ajedrez
{
	String resultado;
	String contenido;
	public Ajedrez(int flag)
	{
		System.out.println("\nA J E D R E Z");
		while(true){
			String cad="", opc;			
			String archivo = "entrada_ajedrez.txt";
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
					cad = Aleatorio.ajedrez();
					System.out.println("\n" + cad);
				}
				else
					cad = Leer.dato();									
			} else {
				try{
					fr = new FileReader(archivo);
					int caract = fr.read();
					while(caract != -1){
						cad += (char)caract;
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
			Diag_ajedrez d = new Diag_ajedrez(cad);
			d.setBounds(0,0,450,470);
	        d.setResizable(false);
	        d.setVisible(true);
			resultado = d.res();
			d.dispose();

			if(resultado != "")
				contenido = "La ruta es: " + resultado;				
			else
				contenido = "La cadena NO es valida";

			try {	 
				File file = new File("salida_ajedrez.txt");
	 
				if (!file.exists()) {
					file.createNewFile();
				}
	 
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(contenido);
				bw.close();
	 
				System.out.println("Guardado");
	 
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
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