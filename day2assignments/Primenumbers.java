package week1.day2assignments;

public class Primenumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a=19;
boolean prime = true;
for(int i=2;i<a;i++)
	
{
	
	if(a%i==0)
	{
	
		prime=false;
	break;
	}
}				
	
		System.out.println(prime);
	}

}
