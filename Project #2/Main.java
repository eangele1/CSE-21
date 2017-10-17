import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {

		Scanner kbd = new Scanner(System.in);

		System.out.print("Enter the file name: ");

		String filename = kbd.next();

		int[] score = new int[1000];
		Student[] arr = new Student[100];

		int count = 0;

		try {
			Scanner input = new Scanner(new FileReader(filename));

			while (input.hasNextLine() && count < 100) {
				Scanner match = new Scanner(input.nextLine());
				match.useDelimiter("[-\t]");

				String name = match.next();
				char gender = match.next().charAt(0);

				int month = match.nextInt();
				int day = match.nextInt();
				int year = match.nextInt();
				int quietTime = match.nextInt();
				int music = match.nextInt();
				int read = match.nextInt();
				int chat = match.nextInt();

				Date birthday = new Date(month, day, year);
				Preference pref = new Preference(quietTime, music, read, chat);
				arr[count] = new Student(name, gender, birthday, pref);
				count++;
			}
			input.close();

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

		int i = 0, k = 0, bestScore = 0, index = 0;

		for (i = 0; i < count; i++) {
			bestScore = 0;
			if (!arr[i].getMatched()) {
				index = 0;
				bestScore = 0;
				for (k = i + 1; k < count; k++) {
					if(arr[i].getMatched()) continue;
					if(arr[k].getMatched()) continue;
					score[i] = arr[i].compare(arr[k]);

					if (score[i] > bestScore) {
						bestScore = score[i];
						index = k;
					}
				}
				if (bestScore > 0) {
					System.out.println(arr[i].getName() + " matches with "
							+ arr[index].getName() + " with the score of "
							+ bestScore + ".");
					arr[i].setMatched(true);
					arr[index].setMatched(true);
					continue;
				} else {
					System.out.println(arr[i].getName() + " has no matches. ");
					arr[i].setMatched(false);
				}
			}
		}
		kbd.close();
	}
}