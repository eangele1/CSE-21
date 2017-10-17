package io;

import java.util.ArrayList;

public class IORunner {

	public static void main(String[] args) {

		People peps1 = new People ();
		ArrayList<Person> coolpeps = peps1.readFile();
		peps1.printPeople(coolpeps);

		System.out.print("Total people  " + coolpeps.size());

	}

	public static void testPeople() {
		// fill in as necessary		
		System.out.print(PhoneNums.readPhoneNumbers());
	}
}
