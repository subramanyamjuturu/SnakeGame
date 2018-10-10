package com.Snake.Task.SnakeGame;

public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a ="We test coders. Give us a try?";
		Demo4 s = new Demo4();

		System.out.println("Count---"+s.solution3(a));

	}

	public int solution3(String S) {
		// write your code in Java SE 8

		String[] Sentences = S.split("[.?!]");
		int wordsCounts = 0;
		int tempWordsCount = 0;

		for(int i = 0; i<Sentences.length;i++)
		{
			System.out.println(Sentences[i]);
			int count =0;
			String[] Words = Sentences[i].split(" ");
			for(int j=0;j<Words.length;j++)
			{
				
				if(!Words[j].equalsIgnoreCase("") && !Words[j].equalsIgnoreCase(null))
				{
					
					tempWordsCount = ++count;
					if(tempWordsCount>wordsCounts)
					{
						wordsCounts = tempWordsCount;
						System.out.println(wordsCounts);
					}
				}
			}

		}



		return wordsCounts;
	}

}
