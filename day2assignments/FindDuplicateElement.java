package week1.day2assignments;

public class FindDuplicateElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String arr[] = {"test","mark","mark","friend"};
duplicateelement(arr);
	}

	public static void duplicateelement(String arr[])
	{
		
	int size = arr.length;
	
	for(int i=0;i<size;i++)
	{
		for(int j=i+1;j<size;j++)
		{
			if(arr[i]==arr[j])
			{
				System.out.println("The duplicate element is "+ arr[i]);
				return;
			}
		}
	}
	
	System.out.println("No duplicate element");
		
	}
}
