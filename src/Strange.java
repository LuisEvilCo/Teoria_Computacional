import java.io.*;

class Strange
{
	String res="";
	String contenido;
	int num;
	public class Planeta
	{
		int e1;
		int e2;
		int e3;

		public Planeta(int a, int b, int c){
			e1 = a;
			e2 = b;
			e3 = c;
		}

		void asesina(){
			res += planeta_string()+"\n";

			if(e1-2 >= 0 ){
				Planeta x = new Planeta(e1-2, e2+1, e3+1);				
				if( !res.contains(x.planeta_string()) )
					x.asesina();
			}
			if(e2 -2 >= 0 ){
				Planeta x = new Planeta(e1+1, e2-2, e3+1);
				if( !res.contains(x.planeta_string()) )
					x.asesina();
			}
			if(e3 -2 >= 0 ){
				Planeta x = new Planeta(e1+1, e2+1, e3-2);
				if( !res.contains(x.planeta_string()) )
					x.asesina();
			}

		}

		String planeta_string(){
			String cad="";
			cad += e1 + "" + e2 + "" + e3 + "->";
			return cad;
		}
	}
	

	public Strange(int flag)
	{
		while(true){
			String opc;		
			contenido = "";	
			res = "";							
			FileReader fr = null;

			System.out.println("PLANETA EXTRAÑO");

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
					File file = new File("entrada_strange.txt");
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

			Planeta hum = new Planeta(num,0,0);
			hum.asesina();
			contenido += res;

			try {	 
				File file = new File("salida_strange.txt");
	 
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