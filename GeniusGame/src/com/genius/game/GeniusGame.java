package com.genius.game;
import java.io.*;
import java.util.Scanner;

public class GeniusGame {
	public static void main(String[] args) throws InterruptedException{
		int[] p1card= new int[10];
		int[] p2card= new int[10];
	
		Scanner scanner = new Scanner(System.in);
		
		do{
			int p1in=0,p2in = 0;
			int p1_score=0;
			int p2_score=0;
			for(int i=0;i<10;i++)
			{
				p1card[i]=i;
				p2card[i]=i;
			}
			for(int j=0;j<p1card.length;j++)
			{
				System.out.println("player1의 카드");
				for(int i=0;i<10;i++)
				{
					if(p1card[i]<10)
						System.out.print(p1card[i] + " ");
				}
				System.out.println("");
				while(true){
					System.out.println("p1 낼 카드를 입력하세요 : ");
					p1in=scanner.nextInt();
					if(p1in>=10)
						System.out.println("없는 카드입니다. 다시입력하세요.");
					else{
						if(p1card[p1in]!=10)
							break;
						else
							System.out.println("낸 카드를 입력 하셨습니다. 다시 입력하세요.");
					}
				}
				
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
				while(true){
					System.out.println("p2 낼 카드를 입력하세요 : ");
					p2in=scanner.nextInt();
					if(p2in>=10)
						System.out.println("없는 카드입니다. 다시입력하세요.");
					else{
						if(p2card[p2in]!=10)
							break;
						else
							System.out.println("낸 카드를 입력 하셨습니다. 다시 입력하세요.");
					}
				}
				
				if(p1in > p2in){
					System.out.println("p1이 점수를 가져 갑니다.");
					p1_score++;
					p1card[p1in]=10;
					p2card[p2in]=10;
					System.out.println(p1_score + " 대 " +p2_score);
					pause();
					for(int x=0;x<10;x++)
					{
						System.out.println("");
					}
				}
				else if(p1in <p2in){
					System.out.println("p2가 점수를 가져갑니다.");
					p2_score++;
					p1card[p1in]=10;
					p2card[p2in]=10;
					System.out.println(p1_score + " 대 " +p2_score);
					pause();
					for(int x=0;x<10;x++)
					{
						System.out.println("");
					}
				}
				else{
					System.out.println("비겼습니다.");
					p1card[p1in]=10;
					p2card[p2in]=10;
					pause();
					for(int x=0;x<10;x++)
					{
						System.out.println("");
					}
				}
			}
			if(p1_score>p2_score){
				System.out.println("p1이 이겼습니다.");
			}
			else if(p1_score<p2_score){
				System.out.println("p2가 이겼습니다.");
			}
			else{
				System.out.println("비겼습니다.");
			}
			System.out.println("게임을 종료 하려면 y를 누르세요.");
		}while(!scanner.next().equals("y"));
		System.out.println("***************");
		System.out.println("***게임 끝 수고염***");
		System.out.println("***************");
	}
	
	public static void pause() {
	    try {
	      System.in.read();
	    } catch (IOException e) { }
	  }
}
