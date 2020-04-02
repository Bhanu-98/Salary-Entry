import java.util.Scanner;

public class Salary {

	public static void main(String args[]) {

		System.out.println("Enter the choice u want : ");
		System.out.println("1. Create New Salary Document /n 2. Edit Existing Salary Document");

		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		scanner.close();
		if (choice == 1) {
			createNewSalaryDocument();
		} else if (choice == 2) {
			editExistingSalaryDocument();
		}

	}

	private static void createNewSalaryDocument() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Year to create Salary Document");

		String year = scanner.next();

		if (year != null) {

			System.out.println("Enter Month to create Salary Document");

			String month = scanner.next();

			if (month != null) {

				System.out.println("You are creating Salary Document for " + month + " " + year);
				scanner.close();
			}
		}
	}

	private static void editExistingSalaryDocument() {

	}

}
