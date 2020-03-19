
public class EulerTheorem {

	private int num1, num2, num3;

	public EulerTheorem(int num1, int num2, int num3) {

		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;

	}

	private int EulerTotient(int n) {

		int counter = 0;

		for (int i = 1; i < n; i++)
			if (gcd(n, i))
				counter++;

		return counter;

	}

	private boolean gcd(int x, int y) {

		int gcd = 1;

		for (int i = 1; i <= x && i <= y; i++)
			if (x % i == 0 && y % i == 0)
				gcd = i;

		if (gcd == 1)
			return true;
		else
			return false;

	}

	private int pm40(int d, int e) {

		if (e == 0)
			return 1;

		int x = 1;
		int y = d;

		do {
			if (e % 2 != 0)
				x = (x * y) % 40;

			y = (y * y) % 40;
			e /= 2;

		} while (e > 0);

		return x;
	}

	private int pm100(int d, int e) {

		if (e == 0)
			return 1;

		int x = 1;
		int y = d;

		do {
			if (e % 2 != 0)
				x = (x * y) % 100;

			y = (y * y) % 100;
			e /= 2;

		} while (e > 0);

		return x;
	}

	public int CalculateLastTwoDig() {

		int pm40Result = 0, LastTwoDig = 0;

		if (gcd(100, num1)) {

			num1 %= 100;

			int EulerTotientFor100 = EulerTotient(100);

			num2 %= EulerTotientFor100;

			if (gcd(EulerTotientFor100, num2)) {

				int EulerTotientFor40 = EulerTotient(40);

				num3 %= EulerTotientFor40;

				pm40Result = pm40(num2, num3);

			} else
				pm40Result = pm40(num2, num3);

			LastTwoDig = pm100(num1, pm40Result);

		} else
			return 111;

		return LastTwoDig;
	}

}
