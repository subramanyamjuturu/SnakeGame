package com.Snake.Task.SnakeGame;

import java.util.Arrays;

public class Demo2 {

	public int solution1(int[] A) {
		// write your code in Java SE 8
		int x =0;
		int y=0;
		Arrays.sort(A);


		int temp [] = new int [A.length];
		for(int i=0;i<A.length-1;i++)
		{
			if(A[i]!=A[i+1])
			{
				temp[y++] = A[i];
			}
		}

		temp[y++] = A[A.length-1];

		for (int i=0; i<y; i++){  
			A[i] = temp[i];  
		}          

		Arrays.sort(temp);
		int small = 0;

		for(int i= 0;i<temp.length;i++)
		{
			if(temp[i]>-10 && temp[i]<10)
			{
				//System.out.print(a[i]);
				if(temp[i] < temp[i+1])
				{
					small=temp[i];
				}
				
			}
		}

	return small;
	}  




	public static void main(String[] args)
	{
		int [] a= {-1,-3,-50,20,-10,9,5,6,-9,-8,-5,1,5,6,9};
		Demo2 s = new Demo2();

		System.out.println(s.solution1(a));


	}
}

