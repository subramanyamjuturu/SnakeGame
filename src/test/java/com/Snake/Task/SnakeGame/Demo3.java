package com.Snake.Task.SnakeGame;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo3 {

	public int solution2(int[] A) {
		// write your code in Java SE 8
		int small =111;
		Arrays.sort(A);

		ArrayList <Integer>a = new ArrayList <Integer>();
		for(int i= 0;i<A.length;i++)
		{
			if(A[i]>-10 && A[i]<10)
			{
				a.add(A[i]);
			}
		}
		small = a.get(0);

		return small;
	}  




	public static void main(String[] args)
	{
		int [] a= {-6, -91, 1011, -100, 84, -22, 0, 1, 473};
		Demo3 s = new Demo3();

		System.out.println(s.solution2(a));


	}
}

