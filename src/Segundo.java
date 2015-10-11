import java.io.*;

class Segundo
{
	String abc, contenido;
	char cad[];
	int tam,conta;
	int total;

	public Segundo(int flag)
	{
		while(true){
			String opc;
			abc = "";
			contenido = "";					
			FileReader fr = null;

			System.out.println("ALFABETO DESDE 1 A N");

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
					abc = Aleatorio.alfabeto();
					System.out.println("\n" + abc);
				}
				else
					abc = Leer.dato();	
				System.out.println("\nIntroduzca el tamaño");				
				if(flag == 1){
					tam = Aleatorio.numero(4,1);
					System.out.println(tam);
				}
				else
					tam = Leer.datoInt();
			} else {
				try {
					File file = new File("entrada_segundo.txt");
					FileReader fileReader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					StringBuffer stringBuffer = new StringBuffer();
					String line;
					line = bufferedReader.readLine();
					stringBuffer.append(line);
					abc = stringBuffer.toString();
					stringBuffer.delete(0, stringBuffer.length());

					line = bufferedReader.readLine();
					stringBuffer.append(line);
					tam = Integer.parseInt(stringBuffer.toString());
					System.out.println("El alfabeto es: " + abc);
					System.out.println("N vale: " + tam);
					
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
			
			for(int i=1 ; i<=tam ; i++){
				cad = new char[i];
				total = (int)Math.pow( abc.length(), i);
				conta = 0;
				contenido += "{";
				comb(i,abc.length());
				contenido += "}";
				contenido += "\n";
			}

			try {	 
				File file = new File("salida_segundo.txt");
	 
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

	void comb(int pos, int card_abc){
		int i;
		if(pos == 0){
			contenido += String.valueOf(cad);
			conta++;
			if(conta != total)
				contenido += ",";
		}
		else{
			for(i = 0; i < card_abc ; i++){				
				cad[pos-1] = abc.charAt(i);
				comb(pos-1, card_abc);
			}
		}
	}
}