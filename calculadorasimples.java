import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Calculator{
	private boolean notOperation = false;
	public Calculator(){
		display();
	}

	private boolean isNumber(String number){ 
		try{
			Float.parseFloat(number);
		}catch(Exception e){
			return false;
		return true;
	}

	private void Operation(String operator, String x, String y){
			case "+":
				System.out.print("Result: " + addition(x, y));
				break;

			case "-":
				System.out.print("Result: " + substraction(x, y));
				break;

			case "*":
				System.out.print("Result: " + multiplication(x, y));
				break;

			case "/":
				System.out.print("Result: " + division(x, y));
				break;

				default:
				notOperation = true;

		}
	}

	private Float addition(String x, String y){
		return Float.valueOf(x) + Float.valueOf(y);
	}

	private Float substraction(String x, String y){
		return Float.valueOf(x) - Float.valueOf(y);
	}

	private Float multiplication(String x, String y){
		return Float.valueOf(x) * Float.valueOf(y);
	}

	private Float division(String x, String y){
		return Float.valueOf(x) / Float.valueOf(y);
	}

	private void display(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String x, y, option, operator;
		boolean again = false;

		try{
			do{
				again = false;

				do{
					System.out.print("Digite o primeiro numero: ");
					x = in.readLine();
				}while(!isNumber(x)); 
				do{
					System.out.print("Digite o segundo numero: ");
					y = in.readLine();
				}while(!isNumber(y)); // check if the input is number.			

				do{
					notOperation = false;
					System.out.print("Selecione uma operação (+, -, *, /) :");
					operator = in.readLine();
					Operation(operator, x, y);
				}while(notOperation == true);

				System.out.print("\nFazer outro calculo? s/n: "); 
				option = in.readLine();

				if(option.equalsIgnoreCase("s")){
					again = true;
				}else{
					System.exit(0);
				}
			}while(again == true); 
			

		}catch(IOException e){
			System.err.print(e.getMessage());
		}
	}

	public static void main(String []args){
		new Calculator();
	}
}