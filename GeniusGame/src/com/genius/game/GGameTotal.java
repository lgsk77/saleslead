package com.genius.game;

import java.util.Scanner;

public class GGameTotal {
	public static void main(String argc[]) {

		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("1.Up 2.Down 3.end");
			int selectMenu  = scanner.nextInt();
			GGame[] player={new GGameFirst(),new GGameFirst(),new GGameSecond(0),new GGameSecond(0)}; 
			if(selectMenu==1){
				//GGame p1 = new GGame();
				//GGame p2 = new GGame();
				System.out.println("카드를 몇 장 사용하시겠습니까?");
				System.out.println("(최대 100장)");
				//player[1] = new GGameFirst();
				int cardnum = scanner.nextInt();
				((GGameFirst) player[0]).initailReverse(cardnum);
				((GGameFirst) player[1]).initailReverse(cardnum);
				for (int j = 0; j < cardnum; j++) {
					for(int k=0;k<2;k++)
					{
						System.out.println("플레이어 p"+(k+1)+"의 카드");
						for (int i = 0; i < cardnum; i++) {
							if (!((GGameFirst) player[k]).checkCard(i)) {
								System.out.print(player[k].getCardNum(i) + " ");
							}
						}
						while (true) {
							int select = scanner.nextInt();
							if (((GGameFirst) player[k]).drawCard(select))
								System.out.println("입력된 숫자를 입력하셨습니다. 다시입력하세요.");
							else
								break;
						}
						clear();
					}
					/*System.out.println("플레이어 p1의 카드");
					for (int i = 0; i < cardnum; i++) {
						if (!player[0].checkCard(i)) {
							System.out.print(player[0].getCardNum(i) + " ");
						}
					}
					while (true) {
						int select = scanner.nextInt();
						if (player[0].drawCard(select))
							System.out.println("입력된 숫자를 입력하셨습니다. 다시입력하세요.");
						else
							break;
					}
					clear();
					System.out.println("플레이어 p2의 카드");
					for (int i = 0; i < cardnum; i++) {
						if (!player[1].checkCard(i)) {
							System.out.print(player[1].getCardNum(i) + " ");
						}
					}
					while (true) {
						int select = scanner.nextInt();
						if (player[1].drawCard(select))
							System.out.println("입력된 숫자를 입력하셨습니다. 다시입력하세요.");
						else
							break;
					}*/
					if (((GGameFirst) player[0]).checkVictory((GGameFirst)player[1])) {
						System.out.println("p1이 이겼습니다.");
						System.out.println("p1score :" + player[0].getScore());
						System.out.println("p2score :" + player[1].getScore());
					} else if (((GGameFirst) player[1]).checkVictory((GGameFirst)player[0])) {
						System.out.println("p2가 이겼습니다.");
						System.out.println("p1score :" + player[0].getScore());
						System.out.println("p2score :" + player[1].getScore());
					} else {
						((GGameFirst) player[0]).reverse((GGameFirst)player[1]);
						System.out.println("비겼습니다.");
						System.out.println("p1score :" + player[0].getScore());
						System.out.println("p2score :" + player[1].getScore());
					}
				}
				if (((GGameFirst) player[0]).victoryGame(player[1])) {
					System.out.println("p1이 " + player[0].getScore() + " 대 " + player[1].getScore() + "로 이겼습니다.");
				} else if (((GGameFirst) player[1]).victoryGame(player[0]))
					System.out.println("p2가 " + player[0].getScore() + " 대 " + player[1].getScore() + "로 이겼습니다.");
				else
					System.out.println("비겼네요 ㅠㅠ");
			}
			else if(selectMenu==2){
				System.out.println("몇 점으로 하시겠습니까?");
				int maxscore = scanner.nextInt();
				System.out.println(maxscore);
				GGameSecond p1 = new GGameSecond(maxscore);
				GGameSecond p2 = new GGameSecond(maxscore);
				System.out.println("카드를 몇 장 사용하시겠습니까?");
				System.out.println("(최대 100장)");
				int cardnum = scanner.nextInt();
				p1.initailReverse(cardnum);
				p2.initailReverse(cardnum);
				for (int j = 0; j < cardnum; j++) {
					System.out.println("플레이어 p1의 카드");
					for (int i = 0; i < cardnum; i++) {
						if (!p1.checkCard(i)) {
							System.out.print(p1.getCardNum(i) + " ");
						}
					}
					while (true) {
						int select = scanner.nextInt();
						if (p1.drawCard(select))
							System.out.println("입력된 숫자를 입력하셨습니다. 다시입력하세요.");
						else
							break;
					}
					clear();
					System.out.println("플레이어 p2의 카드");
					for (int i = 0; i < cardnum; i++) {
						if (!p2.checkCard(i)) {
							System.out.print(p2.getCardNum(i) + " ");
						}
					}
					while (true) {
						int select = scanner.nextInt();
						if (p2.drawCard(select))
							System.out.println("입력된 숫자를 입력하셨습니다. 다시입력하세요.");
						else
							break;
					}
					if (p1.checkVictory(p2)) {
						System.out.println("p1이 점수를 땃습니다.");
						System.out.println("p1score :" + p1.getScore());
						System.out.println("p2score :" + p2.getScore());
						if (p1.victoryGame()) {
							System.out.println("p1이 게임에서 이겼습니다.");
							System.out.println("p1score :" + p1.getScore());
							System.out.println("p2score :" + p2.getScore());
							break;
						} else if (p2.victoryGame()) {
							System.out.println("p2가 게임에서 이겼습니다.");
							System.out.println("p1score :" + p1.getScore());
							System.out.println("p2score :" + p2.getScore());
							break;
						}
					} else if (p2.checkVictory(p1)) {
						System.out.println("p2가 점수를 땄습니다");
						System.out.println("p1score :" + p1.getScore());
						System.out.println("p2score :" + p2.getScore());
						if (p1.victoryGame()) {
							System.out.println("p1이 게임에서 이겼습니다");
							System.out.println("p1score :" + p1.getScore());
							System.out.println("p2score :" + p2.getScore());
							break;
						} else if (p2.victoryGame()) {
							System.out.println("p2가 게임에서 이겼습니다.");
							System.out.println("p1score :" + p1.getScore());
							System.out.println("p2score :" + p2.getScore());
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
