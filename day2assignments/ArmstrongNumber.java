package week1.day2assignments;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=253;
		int original=253;
		int arm=0;
		int rem;
		do {
		rem = n%10;
		arm=arm+(rem*rem*rem);
		n=n/10;
		}
		while(n>0);
		
		if(original==arm)
		{
			System.out.println(original +" - The given number is Armstrong");
			
		}
		else
		{
			System.out.println(original +" - The given number is not Armstrong");
			
		}	
		
		
	}

}
