import java.io.*;

class Pila
{
	int resultado;	
	public Pila(int flag)
	{
		System.out.println("\nP I L A ");
		while(true){
			String cad="", opc,contenido="";			
			String automata = "Z";
			String archivo = "entrada_pila.txt";
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

			int i=0;
			contenido += "(q," + cad + "," + automata + ")\n";
			while(cad.charAt(i) == '0'){
				automata = "X" + automata;
				contenido += "(q," + cad.substring(i+1) + "," + automata + ")\n";
				i++;
			}
			if(i!=0){
				while(i<cad.length()){
					if(cad.charAt(i) == '1'){
						automata = automata.substring(1);
						contenido += "(p," + cad.substring(i+1) + "," + automata + ")\n";
						i++;
					} else 
						break;
				}
				if(i == cad.length() && automata.equals("Z"))
					contenido += "(f,E," + automata + ")";
			}

			try {	 
				File file = new File("salida_pila.txt");
	 
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