import java.util.Scanner;

public class cheeseshop {

	public static void main(String[] args){

		Scanner input = new Scanner (System.in);

		System.out.println("Hello!");
		System.out.println();
		System.out.println("Welcome to the Cheese Shop!");
		System.out.println();
		System.out.println("We sell 3 kinds of Cheese.");
		System.out.println();
		System.out.println("-Dalaran Sharp: $1.25 per pound.");
		System.out.println("-Stormwind Brie: $10.00 per pound.");
		System.out.println("-Alterac Swiss: $40.00 per pound.");
		System.out.println();
		
		System.out.println("Please enter the amount of Sharp: ");
		int sharp = input.nextInt();

		System.out.println("Please enter the amount of Brie: ");
		int brie = input.nextInt();

		System.out.println("Please enter the amount of Swiss: ");
		int swiss = input.nextInt();

		System.out.println("Would you like me to display the itemized list? (1 for yes, 0 for no) ");
		int itemized = input.nextInt();
		
		while (itemized > 1 || itemized < 0){
			System.out.println("Please input 1 or 0.");
			itemized = input.nextInt();
		}

		double total = (sharp*1.25) + (brie*10.0) + (swiss*40.00);

		double discount = 0;

		if (total >= 100)
			discount = 25;
		else if (total >= 50)
			discount = 10;

		if (itemized == 1){
			if (sharp > 0)
				System.out.println(sharp + " lbs of Sharp @ $1.25 = $" + (sharp*1.25));
			if (brie > 0)
				System.out.println(brie + " lbs of Brie @ $10.00 = $" + (brie*10.0));
			if (swiss > 0)
				System.out.println(swiss + " lbs of Swiss @ $40.00 = $" + (swiss*40.00));
		}

		System.out.println();
		System.out.println("Sub Total: $" + total);
		System.out.println("-Discount: $" + discount);
		System.out.println("Total    : $" + (total - discount));

		input.close();
	}
}