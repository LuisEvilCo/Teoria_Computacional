import java.io.*;

class Palindromos
{
	String contenido;
	int num;
	boolean m[] = new boolean[1007];

	public Palindromos(int flag)
	{
		while(true){
			String opc;			
			contenido = "";					
			FileReader fr = null;

			System.out.println("P A L I N D R O M O S");

			System.out.println("\nDesea teclar la entrada? (S/N)");
			if(flag == 1){
				opc = Aleatorio.si_no();
				System.out.println(opc);
			}
			else
				opc = Leer.dato();
			if(opc.equals("S") || opc.equals("s")){
				System.out.println("\nIntroduzca el numero");								
				if(flag == 1){
					num = Aleatorio.numero(7,1);
					System.out.println("\n" + num);
				}
				else
					num = Leer.datoInt();
			} else {
				try {
					File file = new File("entrada_palindromos.txt");
					FileReader fileReader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					StringBuffer stringBuffer = new StringBuffer();
					String line;

					line = bufferedReader.readLine();
					stringBuffer.append(line);
					num = Integer.parseInt(stringBuffer.toString());
					System.out.println("El numero es: " + num);					
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			String aux = "";
			contenido += "P\n";
			if(num%2==0)
				contenido += "E\n";
			else{
				switch(Aleatorio.numero(2,1)){
					case 1:
						aux += "1";
						break;
					case 2:
						aux += "0";
						break;
				}
			}
			while(num>0){
				switch(Aleatorio.numero(2,1)){
					case 1:
						aux = "0" + aux + "0";
						break;
					case 2:
						aux = "1" + aux + "1";
						break;
				}
				contenido += aux+"\n";
				num = num-2;
			}
		

			try {	 
				File file = new File("salida_palindromos.txt");
	 
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
			
			System.out.println("\nDesea verificar otro numero? (S/N)");
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