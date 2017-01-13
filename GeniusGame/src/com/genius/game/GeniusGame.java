package com.genius.game;
import java.util.Scanner;

public class GeniusGame {
	public static void main(String[] args) throws InterruptedException{
		int[] p1card= new int[10];
		int[] p2card= new int[10];
		
		int p1in;
		int p2in;
		
		int p1_score=0;
		int p2_score=0;
		
		Scanner in = new Scanner(System.in);
		
		for(int i=0;i<10;i++)
		{
			p1card[i]=i;
			p2card[i]=i;
		}
		for(int j=0;j<10;j++)
		{
			System.out.println("player1의 카드");
			for(int i=0;i<10;i++)
			{
				if(p1card[i]<10)
					System.out.print(p1card[i] + " ");
			}
			System.out.println("");
			System.out.println("p1 낼 카드를 입력하세요 : ");
			p1in=in.nextInt();

			for(int x=0;x<10;x++)
			{
				System.out.println("");
			}
			
			for(int i=0;i<10;i++)
			{
				if(p2card[i]<10)
					System.out.print(p2card[i] + " ");
			}
			System.out.println("");
			System.out.println("p2 낼 카드를 입력하세요 : ");
			p2in=in.nextInt();

			
			if(p1in > p2in){
				System.out.println("p1이 점수를 가져 갑니다.");
				p1_score++;
				p1card[p1in]=10;
				p2card[p2in]=10;
				System.out.println(p1_score + "대" +p2_score);
				Thread.sleep(2000);
			}
			else if(p1in <p2in){
				System.out.println("p2가 점수를 가져갑니다.");
				p2_score++;
				p1card[p1in]=10;
				p2card[p2in]=10;
				System.out.println(p1_score + "대" +p2_score);
				Thread.sleep(2000);
			}
			else{
				System.out.println("비겼습니다.");
				p1card[p1in]=10;
				p2card[p2in]=10;
				Thread.sleep(2000);
			}
		}
		if(p1_score>p2_score)
			System.out.println("p1이 이겼습니다.");
		else if(p1_score<p2_score)
			System.out.println("p2가 이겼습니다.");
		else
			System.out.println("비겼습니다.");
	}
}
