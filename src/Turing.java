import java.io.*;

class Turing
{
	String cad;
	int resultado;	
	char direccion;
	int salir;
	int estado;
	public Turing(int flag)
	{
		System.out.println("\nT U R I N G ");
		while(true){			
			String opc,contenido="";		
			cad = "";
			direccion = 'R';
			salir = 0;
			estado = 0;
			String archivo = "entrada_turing.txt";
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
			
			int i;
			cad = cad + " ";
			for(i=0 ; i<cad.length() && i>=0 && salir==0 ; ){
				switch(estado){
					case 0:
						if(cad.charAt(i) ==  '0'){							
							direccion = 'R';
							contenido += cad.substring(0,i) + "q(" + estado + ")" + cad.substring(i) + " |- ";
							estado = 1;
							cad = cad.replaceFirst("0","X");							
						} else if(cad.charAt(i) ==  'Y'){
							contenido += cad.substring(0,i) + "q(" + estado + ")" + cad.substring(i) + " |- ";
							estado = 3;
							direccion = 'R';							
						}else
							salir = 1;
						break;

					case 1:
						if(cad.charAt(i) == '0' || cad.charAt(i) == 'Y')
							contenido += cad.substring(0,i) + "q(" + estado + ")" + cad.substring(i) + " |- ";
						else if(cad.charAt(i) == '1'){							
							direccion = 'L';
							contenido += cad.substring(0,i) + "q(" + estado + ")" + cad.substring(i) + " |- ";
							estado = 2;
							cad = cad.replaceFirst("1","Y");							
						} else if(cad.charAt(i) == ' ')
							contenido += cad.substring(0,i) + "q(" + estado + ")" + cad.substring(i) + "B";
						else
							salir = 1;
						break;

					case 2:
						if(cad.charAt(i) == '0' || cad.charAt(i) == 'Y'){
							direccion = 'L';
							contenido += cad.substring(0,i) + "q(" + estado + ")" + cad.substring(i) + " |- ";
						} else if(cad.charAt(i) == 'X'){
							contenido += cad.substring(0,i) + "q(" + estado + ")" + cad.substring(i) + " |- ";						
							estado = 0;
							direccion = 'R';							
						} else 
							salir = 1;
						break;

					case 3:
						if(cad.charAt(i) == 'Y')
							contenido += cad.substring(0,i) + "q(" + estado + ")" + cad.substring(i) + " |- ";
						else if(cad.charAt(i) == ' '){
							contenido += cad.substring(0,i) + "q(" + estado + ")B" + cad.substring(i) + " |- ";
							estado = 4;
							contenido += cad.substring(0,i) + "Bq(" + estado + ")B" + cad.substring(i);
						} else
							salir = 1;

				}
				if( direccion == 'R')
					i++;
				else
					i--;
			}
			if(estado == 4)
				contenido += "\n" + "La cadena es valida";

			try {	 
				File file = new File("salida_turing.txt");
	 
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
				opc = Leer.dato();;
			if(opc.equals("N") || opc.equals("n")){
				break;
			}
		}
	}
}