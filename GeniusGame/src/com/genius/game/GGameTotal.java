package com.genius.game;

import java.util.Scanner;

public class GGameTotal {
	public static void main(String argc[]) {

		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("1.Up 2.Down 3.end");
			int selectMenu  = scanner.nextInt();
			GGame[] player={new GGameUp(),new GGameUp(),new GGameDown(5),new GGameDown(5)}; 
			if(selectMenu==1){
				System.out.println("카드를 몇 장 사용하시겠습니까?");
				System.out.println("(최대 100장)");
				int cardnum = scanner.nextInt();
				((GGameUp) player[0]).initailReverse(cardnum);
				((GGameUp) player[1]).initailReverse(cardnum);
				for (int j = 0; j < cardnum; j++) {
					for(int k=0;k<2;k++)
					{
						System.out.println("플레이어 p"+(k+1)+"의 카드");
						for (int i = 0; i < cardnum; i++) {
							if (!((GGameUp) player[k]).checkCard(i)) {
								System.out.print(player[k].getCardNum(i) + " ");
							}
						}
						while (true) {
							int select = scanner.nextInt();
							if (((GGameUp) player[k]).drawCard(select))
								System.out.println("입력된 숫자를 입력하셨습니다. 다시입력하세요.");
							else
								break;
						}
						clear();
					}
					if (((GGameUp) player[0]).checkVictory((GGameUp)player[1])) {
						System.out.println("p1이 이겼습니다.");
						System.out.println("p1score :" + player[0].getScore());
						System.out.println("p2score :" + player[1].getScore());
					} else if (((GGameUp) player[1]).checkVictory((GGameUp)player[0])) {
						System.out.println("p2가 이겼습니다.");
						System.out.println("p1score :" + player[0].getScore());
						System.out.println("p2score :" + player[1].getScore());
					} else {
						((GGameUp) player[0]).reverse((GGameUp)player[1]);
						System.out.println("비겼습니다.");
						System.out.println("p1score :" + player[0].getScore());
						System.out.println("p2score :" + player[1].getScore());
					}
				}
				if (((GGameUp) player[0]).victoryGame(player[1])) {
					System.out.println("p1이 " + player[0].getScore() + " 대 " + player[1].getScore() + "로 이겼습니다.");
				} else if (((GGameUp) player[1]).victoryGame(player[0]))
					System.out.println("p2가 " + player[0].getScore() + " 대 " + player[1].getScore() + "로 이겼습니다.");
				else
					System.out.println("비겼네요 ㅠㅠ");
			}
			else if(selectMenu==2){
				System.out.println("몇 점으로 하시겠습니까?");
				int maxscore = scanner.nextInt();
				System.out.println(maxscore);
				player[2].setScore(maxscore);
				player[3].setScore(maxscore);
				System.out.println("카드를 몇 장 사용하시겠습니까?");
				System.out.println("(최대 100장)");
				int cardnum = scanner.nextInt();
				((GGameDown) player[2]).initailReverse(cardnum);
				((GGameDown) player[3]).initailReverse(cardnum);
				for (int j = 0; j < cardnum; j++) {
					for(int k=2;k<4;k++)
					{
						System.out.println("플레이어 p"+(k+1)+"의 카드");
						for (int i = 0; i < cardnum; i++) {
							if (!((GGameDown) player[k]).checkCard(i)) {
								System.out.print(player[k].getCardNum(i) + " ");
							}
						}
						while (true) {
							int select = scanner.nextInt();
							if (((GGameDown) player[k]).drawCard(select))
								System.out.println("입력된 숫자를 입력하셨습니다. 다시입력하세요.");
							else
								break;
						}
						clear();
					}
					if (((GGameDown) player[2]).checkVictory(((GGameDown) player[3]))) {
						System.out.println("p1이 점수를 땃습니다.");
						System.out.println("p1score :" + player[2].getScore());
						System.out.println("p2score :" + player[3].getScore());
						if (((GGameDown) player[2]).victoryGame()) {
							System.out.println("p1이 게임에서 이겼습니다.");
							System.out.println("p1score :" + player[2].getScore());
							System.out.println("p2score :" + player[3].getScore());
							break;
						} else if (((GGameDown) player[3]).victoryGame()) {
							System.out.println("p2가 게임에서 이겼습니다.");
							System.out.println("p1score :" + player[2].getScore());
							System.out.println("p2score :" + player[3].getScore());
							break;
						}
					} else if (((GGameDown) player[3]).checkVictory(((GGameDown) player[2]))) {
						System.out.println("p2가 점수를 땄습니다");
						System.out.println("p1score :" + player[2].getScore());
						System.out.println("p2score :" + player[3].getScore());
						if (((GGameDown) player[2]).victoryGame()) {
							System.out.println("p1이 게임에서 이겼습니다");
							System.out.println("p1score :" + player[2].getScore());
							System.out.println("p2score :" + player[3].getScore());
							break;
						} else if (((GGameDown) player[3]).victoryGame()) {
							System.out.println("p2가 게임에서 이겼습니다.");
							System.out.println("p1score :" + player[2].getScore());
							System.out.println("p2score :" + player[3].getScore());
							break;
						}
					} 
				}
			}
			else if(selectMenu==3)
				System.out.println("");
			System.out.println("그만 하시겠습니까?(y/n)");
		} while (!scanner.next().equals("y"));
		System.out.println("***************");
		System.out.println("***다음에 또 만나요***");
		System.out.println("***************");
	}

	static void clear() {
		for (int i = 0; i < 15; i++)
			System.out.println("");
	}
}
