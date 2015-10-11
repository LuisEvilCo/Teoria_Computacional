import java.io.*;

class Primos
{
	String contenido;
	int num;
	boolean m[] = new boolean[1007];

	public Primos(int flag)
	{
		while(true){
			String opc;			
			contenido = "";					
			FileReader fr = null;

			System.out.println("P R I M O S");

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
					num = Aleatorio.numero(50,1);
					System.out.println("\n" + num);
				}
				else
					num = Leer.datoInt();
			} else {
				try {
					File file = new File("entrada_primos.txt");
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

			criba();			
			for(int i = 2 ; i<= num ; i++){				
				if(m[i]){
					contenido += i + " " + Integer.toBinaryString(i);
					contenido += "\n";
				}
			}			

			try {	 
				File file = new File("salida_primos.txt");
	 
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
	void criba(){
		m[0] = false;
		m[1] = false;

		for(int i=2 ; i<=1000 ; ++i)
			m[i] = true;

		for(int j=2 ; j<=1000 ; ++j){
			if(m[j]){
				for(int k=2 ; j*k<=1000 ; ++k)
					m[j*k] = false;
			}
		}
	}
}