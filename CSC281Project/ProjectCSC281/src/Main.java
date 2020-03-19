import java.util.Scanner;

public class Main {

	private static Scanner in;

	public static void main(String[] args) {

		in = new Scanner(System.in);

		System.out.println("Enter Three numbers: ");

		int num1 = in.nextInt(), num2 = in.nextInt(), num3 = in.nextInt();

		EulerTheorem E = new EulerTheorem(num1, num2, num3);

		int LastTwoDigits = E.CalculateLastTwoDig();

		if (LastTwoDigits == 111)
			System.out
					.println("Can not use Euler totient Theorem because " + num1 + " and 100 are not relatively prime");
		else
			System.out.println(
					"The last two digits of the number " + num1 + "^" + num2 + "^" + num3 + " is: " + LastTwoDigits);
	}

}
