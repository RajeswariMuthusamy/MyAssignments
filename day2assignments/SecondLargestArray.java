package week1.day2assignments;

import java.util.Arrays;

public class SecondLargestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[] = {5,9,8,5,6,13,65,65,13};

SecondLargest(arr);

	}

	public static void SecondLargest(int arr[]) {
		
		int size = arr.length;
		
		if(size<2)
		{
			System.out.println("The given input is invalid");
			return;
		}
		
		
		Arrays.sort(arr);
		
		for(int i=size-1;i>0;i--)
		{
			if (arr[i] != arr[size-1])
			{
				System.out.println("Second Largest Number is " + arr[i]);
				return;
			}
		}
		
		System.out.println("There is no second largest number");
		
		

}
}
