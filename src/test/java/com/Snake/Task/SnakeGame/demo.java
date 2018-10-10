package com.Snake.Task.SnakeGame;

import java.util.Arrays;

public class demo {

	public int solution(int[] A) {
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

		for(int i=0;i<temp.length;i++)
		{
			if(temp[i]>0)
			{
				if(temp[i]==1)
				{
					x=temp[i];
				}
				else if(temp[i]==x+1)
				{
					x++;
					if(i== temp.length-1)
					{
						x++;
					}
				}
				else
				{
					x++;
					break;
				}
			}else if(i>=temp.length-1 && temp[i]<0)
			{
				return ++x;
			}
		}
		return x;
	}  


	public static void main(String[] args) {
		{
			int [] a= {-1,-3,-50,20,-10,9,5,6,-9,-8,-5,1,5,6,9};
			demo s = new demo();
			Arrays.sort(a);
			int small = 0;
			int big;
			for(int i=0;i<a.length;i++)
			{
				if(a[i]>-10 && a[i]<10)
				{
					//System.out.print(a[i]);
					if(a[i] < a[i+1])
					{
						small=a[i];
					}
					
				}

			}
			System.out.println("small--"+small);
			System.out.println(s.solution(a));


		}

	}

}
