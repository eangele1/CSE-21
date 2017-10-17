import java.util.Scanner;

public class remainderFunc{

	public static void main (String[]args){

		int max, div, res;

		Scanner input = new Scanner (System.in);

		System.out.println("Please enter the max number: ");
		max = input.nextInt();
		
		System.out.println("Please enter the divisor: ");
		div = input.nextInt();

		for (int i = 1; i <= max; i++) {
			res = i % div;
			System.out.println("Num: " + i + " % " + div + " = " + res);
		}
		input.close();
	}
}