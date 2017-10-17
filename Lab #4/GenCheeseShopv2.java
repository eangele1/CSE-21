import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	public static void intro(String[] names, double[]prices, int[] amounts) {
		
		if (amounts.length == 0){
			System.out.println("Sorry...");
			System.out.println();
			System.out.println("We don't have any Cheese.");
		}

		if(amounts.length > 0 ){
			System.out.println("Hello!");
			System.out.println();
			System.out.println("Welcome to the Cheese Shop!");
			System.out.println();
			System.out.println("We sell " + amounts.length + " kinds of Cheese.");
			names[0] = "Dalaran Sharp";
			prices[0] = 1.25;
			System.out.println(names[0] + ": $" + prices[0] + " per pound.");
		}

		if(amounts.length > 1){
			names[1] = "Stormwind Brie";
			prices[1] = 10.00;
			System.out.println(names[1] + ": $" + prices[1] + " per pound.");
		}

		if (amounts.length > 2){
			names[2] = "Alterac Swiss";
			prices[2] = 40.00;
			System.out.println(names[2] + ": $" + prices[2] + " per pound.");
		}

		if(amounts.length > 3){
			Random ranGen = new Random(100);	

			for (int i = 3; i < amounts.length; i++){
				names[i] = "Cheese Type " + (char)('A'+i);
				prices[i] = ranGen.nextInt(1000)/100.0;
				System.out.println(names[i] + ": $" + prices[i] + " per pound.");
			}
		}
	}

	public static void getAmount(Scanner input, String[] names, int[] amounts) {

		for (int i = 0; i < names.length; i++) {
			System.out.println();
			System.out.println("Please enter the amount of " + names[i] + ":");
			amounts[i] = input.nextInt();
		}

	}

	public static void itemizedList(String[] names, double[]prices, int[] amounts) {

		System.out.println();
		
		for (int i = 0; i < names.length; i++){
			if (amounts[i] > 0)
				System.out.println(amounts[i] + " lbs of " + names[i] + " @ " + prices[i] + " = $" + amounts[i]*prices[i]);
		}

	}

	public static double calcSubTotal(double[] prices, int[] amounts) {

		double subTotal = 0;

		for(int i = 0; i < amounts.length; i++){
			subTotal = subTotal + (amounts[i]*prices[i]);
		}

		return subTotal;
	}

	public static int discount(double subTotal){
		int discount = ((subTotal > 100)? 25 : (subTotal > 50)? 10: 0);

		return discount;
	}

	public static void printTotal(double subTotal, double discount) {
		System.out.println("Sub Total: $" + subTotal);
		System.out.println("-Discount: $" + discount);
		System.out.println("Total    :" + " $" + (subTotal - discount));
	}

	public static void main(String[] args) {

		final int MAXCHEESE = 10;

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		int[] amounts = new int[MAXCHEESE];

		Scanner input = new Scanner(System.in);

		intro(names, prices, amounts);

		getAmount(input, names, amounts);

		double total = calcSubTotal(prices, amounts);

		if (MAXCHEESE > 0) {
			System.out.println();
			System.out.println("Would you like me to display the itemized list? (1 for yes)");
			int itemized = input.nextInt();

			while (itemized > 1 || itemized < 0 ){
				System.out.println("Please input 1 or 0.");
				itemized = input.nextInt();
			}

			if (itemized == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		System.out.println();

		printTotal(total,discount(total));
	}
}