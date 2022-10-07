package week1.day2assignments;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a1[]= {2,3,4};
int a2[] = {5,6,2,7};
findIntersection(a1, a2);

	}

	public static void findIntersection(int a1[], int a2[])
	{
		int size1 = a1.length;
		int size2 = a2.length;
		
		for(int i=0;i<size1;i++)
		{
			for(int j=0;j<size2;j++)
				
			{
				if(a1[i] == a2[j])
				{
					System.out.println("The intersection number is " + a1[i]);
					return;
				}
			}
		}
		
		System.out.println("No Intersection numbers");
	}
}
