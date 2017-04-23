package edu.mainRun;

import edu.workClasses.animals.Dog;

public class DogTestDrive {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Dog dog2 = dog;

		dog.size = 30;
		dog.bark();

		System.out.println("Dog2 size is " + dog2.size);

		int length = 7;

		Dog[] pets = new Dog[length];
		for (int i = 0; i < pets.length; i++) {
			pets[i] = new Dog();

			pets[i].bark();			
		}

	}
}