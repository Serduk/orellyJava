package edu.seaBattleSimple;

import java.io.*;

public class SimpleGameHelper {
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
			inputLine = br.readLine();

			if (inputLine.length() == 0) {
				return null;
			}
		} catch (IOException e) {
			System.out.println("Can't read user input data");
		}
		return inputLine;
	}
}