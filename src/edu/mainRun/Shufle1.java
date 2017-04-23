package edu.mainRun;

public class  Shufle1 {
	public static void main(String[] args) {
		int x = 3;

		while (0 < x) {
			if (x > 2) {
				System.out.print("a");
			}

			x -= 1;
			System.out.print("-");

			if (x == 2) {
				System.out.print("b c");
			}

			if (x == 1) {
				System.out.print("d");
				x -= 1;
			}
		}
	}
}