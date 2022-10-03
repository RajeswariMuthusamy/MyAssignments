package week1.day1;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int a =5;
		
		int fact = 1;
		
		for(int i=1;i<=a;i++)
		{
			fact = fact*i;
			
		}
		
		System.out.println("Factorial of a is " + fact);
	}

}
