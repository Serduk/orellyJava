package edu.mainRun;

public class TestArrays {
	public static void main(String[] args) {
		String[] islands = new String[4];
		int[] index = new int[4];
		int y = 0;

		islands[0] = "zero";
		islands[1] = "one";
		islands[2] = "two";
		islands[3] = "three";

		index[0] = 1;
		index[1] = 3;
		index[2] = 0;
		index[3] = 2;

		int ref;

		while (y < 4) {
			ref = index[y];
			System.out.print("islands = ");
			System.out.println(islands[ref]);
			y += 1;			
		}
	}
}