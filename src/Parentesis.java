import java.io.*;

class Parentesis
{
	public Parentesis(int flag)
	{
		System.out.println("\nPARENTESIS");
		while(true){
			String cad="", opc,automata;			
			String contenido="";
			String archivo = "entrada_parentesis.txt";
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
					cad = Aleatorio.parentesis();
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

			int i=0;
			automata = "B";
			cad = cad + " ";
			contenido += cad + " " + automata + "\n";
			while(i<cad.length() && i<automata.length()){
				if(cad.charAt(i) == '(' && automata.charAt(i) == 'B')
					automata = automata.replaceFirst("B","(RB");
				else if (cad.charAt(i) == '(' && automata.charAt(i) == 'R')
					automata = automata.replaceFirst("R","(RR");
				else if (cad.charAt(i) == ')' && automata.charAt(i) == 'R')
					automata = automata.replaceFirst("R",")");
				else if (cad.charAt(i) == ' ' && automata.charAt(i) == 'B')
					automata = automata.replaceFirst("B"," ");
				else 
					break;
				i++;
				contenido += cad.substring(i) + " " + automata + "\n";
			}
			if(cad.equals(automata))
				contenido += "Los parentesis están balanceados";
			else
				contenido += "Los parentesis NO están balanceados";

			try {	 
				File file = new File("salida_parentesis.txt");
	 
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