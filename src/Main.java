class Main
{		
	public static void main(String args[])
	{
		int random;
		int opc;
		int menu[] = new int[16];
		String opc2;
		System.out.println("\nActivar el modo random? (S/N)");
		opc2 = Leer.dato();
		if(opc2.equals("S") || opc2.equals("s"))
			random = 1;
		else
			random = 0;
		while(true){
                        System.out.println("\n0.Alfabeto a la N");
                        System.out.println("\n1. Segundo");
			System.out.println("\n2.Cadenas que incluyen 01");
			System.out.println("\n3.AFN cadenas que terminan en 01");
			System.out.println("\n4.Paridad");
			System.out.println("\n5.Webay");			
			System.out.println("\n6.Planeta Extraño");
                        //expresion n
                        
                        System.out.println("\n7.Ajedrez magico");
                        System.out.println("\n8.Automata de pila");
                        System.out.println("\n9.Parentesis");
                        System.out.println("\n10.Primos");
                        System.out.println("\n11.Palindromo");
                        System.out.println("\n12.Turing");
			System.out.println("\n13.Salir");
			System.out.println("\nEscriba el numero de opcion: ");		
			if(random == 1){				
				//opc = Aleatorio.numero(14,1);
				opc = Aleatorio.numero(14,1);
				System.out.println(opc);
				menu[opc]++;
				if(menu[opc]>3){
					System.out.println("Opcion escogida mas de tres veces\nAdios :)");
					System.exit(0);
				}
			}
			else				
				opc = Leer.datoInt();
			
			switch(opc){
                            
                            case 0:
                                Primer programa = new Primer(random);
                                break;
                                
                            case 1:
                                Segundo prog2 = new Segundo(random);
                                break;
                                
                                
				case 2:
					x01y x1 = new x01y(random);
					break;

				case 3:
					x01 x2 = new x01(random);
					break;

				case 4:
					Paridad par = new Paridad(random);
					break;

				case 5:
					Webay wb = new Webay(random);
					break;


				case 6:
					Strange str = new Strange(random);
					break;
                                    
                                case 7:
                                    Ajedrez aj = new Ajedrez(random);
                                    break;
                                    
                                case 8:
                                    Pila pil = new Pila(random);
                                    break;

                                   
                                case 9:
                                    Parentesis paren = new Parentesis(random);
                                    break;
                                    
				  case 10: 
                                    Primos primos = new Primos(random);
                                    break;
                             
                                    
                                case 11: 
                                    Palindromos palindro = new Palindromos(random);
                                     break;
                                    
                              
                                   
                                case 12:
                                    Turing tur = new Turing(random);
                                    break;
                                    
                                    case 13:
					System.exit(0);
					break;

				default:
					System.out.println("\nOpcion invalida");
			}

			System.out.println("\nDesea realizar otra operacion del menu principal? (S/N)");
			if(random == 1){
				opc2 = Aleatorio.si_no();
				System.out.println(opc2);
			}
			else
				opc2 = Leer.dato();
			if(opc2.equals("N") || opc2.equals("n"))				
				System.exit(0);
		}
	}
}