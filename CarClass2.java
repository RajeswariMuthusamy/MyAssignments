package week1.day1;

import week1.day2.Carmethod;

public class CarClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carmethod car = new Carmethod();
		//below is accessible outside the class within the package
				int add = car.addThreeNumber(3, 4, 5);
				System.out.println(add);
				
				//below is not accessible outside the class and outside the package
//				int diff = car.subTwoNumber(5,8);
//				System.out.println(diff);
				
				
				//below is not accessible outside the package
//				float multiply = car.multiplyThreeNumbers(6, 7, 8);
//				System.out.println(multiply);
				
				//below is not accessible outside the package
//				int div = car.divTwoNumber(26, 2);
//				System.out.println(div);
				
	}

}
