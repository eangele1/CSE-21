import java.util.*;

public class Shop{

	public static void intro(){
		System.out.println("\nThis function supports 4 functions. ");
		System.out.println("1. Setup Shop");
		System.out.println("2. Buy");
		System.out.println("3. List Items");
		System.out.println("4. Checkout");
		System.out.println("\nPlease choose the function you want: ");
	}

	public static int getFunction(Scanner scan, int function){
		function = scan.nextInt();
		if (function <1 || function >4) {
			System.out.println("Error. Do not know " + function);
		}

		return function;
	}

	public static int getNumber(Scanner scan, int number){
		System.out.println("Please enter the amount of items: ");
		number = scan.nextInt();

		return number;
	}

	public static int getMaxPrice(Scanner scan, int maxPrice){
		System.out.print("Please enter the amount to qualify for discount: ");
		maxPrice = scan.nextInt();

		return maxPrice;
	}

	public static double getDiscount(Scanner scan, double discount){
		System.out.print("Please enter the discount rate (0.1 for 10%): ");
		discount = scan.nextDouble();

		return discount;
	}

	public static void setupShop(Scanner scan, int number, double[]prices, String[]names){
		for (int i = 0; i < number; i++) {
			System.out.print("Enter the name of product " + (i + 1) + ": ");
			names[i] = scan.next();

			System.out.print("Enter price of product " + (i + 1) + ": ");
			prices[i] = scan.nextDouble();
		}
	}

	public static void Buy(Scanner scan, int number, int[]amounts, String[]names){
		for (int i = 0; i < number; i++) {
			System.out.print("Enter the amount of " + names[i] + ": ");
			amounts[i] = scan.nextInt();
		}
	}

	public static void listItems (int[]amounts, int number, double[]prices, String[]names){
		for (int i = 0; i < number; i++) {
			if (amounts[i] > 0) {
				System.out.println(amounts[i] + " count of " + names[i] + " @ "
						+ prices[i] + " = $" + (amounts[i] * prices[i]));
			}
		}
	}

	public static void Checkout(int number, double subTotal, int[]amounts, double[]prices, double discount, double maxPrice){
		double[] costs = new double[number];

		for (int i = 0; i < number; i++) {
			costs[i] = amounts[i] * prices[i];
			subTotal = subTotal + costs[i];
		}

		if(subTotal > maxPrice){
			double discount1 = discount * subTotal;
			System.out.println("Thanks for coming!");
			System.out.println("Sub Total: $" + subTotal);
			System.out.println("-Discount: $" + discount1);
			System.out.println("Total	 : $" + (subTotal - discount1));
		}
		else {
			System.out.println("Thanks for coming!");
			System.out.println("Sub Total: $" + subTotal);
			System.out.println("-Discount: $0.0");
			System.out.println("Total	 : $" + subTotal);
		}
	}

	public static void main(String[]args){
		final int MAXITEMS = 100;

		Scanner scan = new Scanner(System.in);
		boolean allOK = true;

		int number = 0;
		int function = 0;

		String[] names = new String[MAXITEMS];
		double[] prices = new double[MAXITEMS];
		int[] amounts = new int[MAXITEMS];

		int maxPrice = 0;
		double subTotal = 0;
		double discount = 0;

		boolean isSetup = false;
		boolean isBuy = false;
		boolean isList = false;

		while(allOK){

			intro();
			function = getFunction(scan, function);

			switch (function) {

			case 1:

				number = getNumber(scan, number);
				setupShop(scan, number, prices, names);
				maxPrice = getMaxPrice(scan, maxPrice);
				discount = getDiscount(scan, discount);

				isSetup = true;
				break;

			case 2:

				if (isSetup == false){
					System.out.println("Shop is not setup yet!");
					break;
				}

				Buy(scan, number, amounts, names);

				isBuy = true;
				break;

			case 3:

				if (isBuy == false){
					System.out.println("Try again: You have not bought anything");
					break;
				}

				listItems(amounts, number, prices, names);

				isList = true;
				break;

			case 4:

				if (isList == false){
					System.out.println("Shop is not setup yet!");
					break;
				}

				Checkout(number, subTotal, amounts, prices, discount, maxPrice);

				allOK = false;
				break;

			}
		}
	}
}