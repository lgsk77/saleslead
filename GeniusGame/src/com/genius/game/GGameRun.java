package com.genius.game;

import java.util.Scanner;

public class GGameRun {

	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);

		do {
			GGame p1 = new GGame();
			GGame p2 = new GGame();
			System.out.println("카드를 몇 장 사용하시겠습니까?");
			System.out.println("(최대 100장)");
			int cardnum = scanner.nextInt();
			p1.reset(cardnum);
			p2.reset(cardnum);
			for (int j = 0; j < cardnum; j++) {
				System.out.println("플레이어 p1의 카드");
				for (int i = 0; i < cardnum; i++) {
					if (!p1.checkcard(i)) {
						System.out.print(p1.card[i] + " ");
					}
				}//gghh
				while (true) {
					if (p1.drawcard())
						System.out.println("없는 숫자를 입력하셨습니다. 다시입력하세요.");
					else
						break;
				}
				System.out.println("플레이어 p2의 카드");
				for (int i = 0; i < cardnum; i++) {
					if (!p2.checkcard(i)) {
						System.out.print(p2.card[i] + " ");
					}
				}
				while (true) {
					if (p2.drawcard())
						System.out.println("입력된 숫자를 입력하셨습니다. 다시입력하세요.");
					break;
				}

				if (p1.checkvictory(p2)) {
					System.out.println("p1이 이겼습니다.");
					System.out.println("p1score :" + p1.score);
					System.out.println("p2score :" + p2.score);
				} else if (p2.checkvictory(p1)) {
					System.out.println("p2가 이겼습니다.");
					System.out.println("p1score :" + p1.score);
					System.out.println("p2score :" + p2.score);
				} else {
					p1.flag(p2);
					System.out.println("비겼습니다.");
					System.out.println("p1score :" + p1.score);
					System.out.println("p2score :" + p2.score);
				}
			}
			if (p1.victorygame(p2)) {
				System.out.println("p1이 " + p1.score + " 대 " + p2.score + "로 이겼습니다.");
			} else if (p2.victorygame(p1))
				System.out.println("p2가 " + p1.score + " 대 " + p2.score + "로 이겼습니다.");
			else
				System.out.println("비겼네요 ㅠㅠ");
			System.out.println("고만 하시겠습니까?(y/n)");
		} while (!scanner.next().equals("y"));
	}
}