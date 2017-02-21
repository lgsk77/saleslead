package com.genius.game;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

//import com.test.collection_Exam.Person;


class PlayerInfo  implements Serializable{
	private String name;
	private int win;
	private int lose;
	void PlayerInfo(){
		name="";
		win = 0;
		lose=0;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getWin(){
		return this.win;
	}
	
	public int getLose(){
		return this.lose;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setWin(int Win){
		this.win=Win;
	}
	
	public void setLose(int lose){
		this.lose=lose;
	}
}

public class GGameTotal {
	public static void main(String argc[]) {

		Scanner scanner = new Scanner(System.in);
		String P1 = new String();
		String P2 = new String();
		boolean endFlag = true;
		ArrayList<PlayerInfo> playerRecord= new ArrayList<PlayerInfo>();
		playerRecord = readRanking();
		
		for(int i=0;i<playerRecord.size();i++){
			int a;
			PlayerInfo info = playerRecord.get(i);
			System.out.println(info.getName()+" 승 : "+info.getWin()+" 패 : "+info.getLose());
		}
		
		do {
			while(true){
				System.out.println("P1의 이름을 입력해 주세요.");
				P1 = scanner.next();
				System.out.println(P1);
				System.out.println("P2의 이름을 입력해 주세요.");
				P2 = scanner.next();
				System.out.println(P2);
				
				if(P1.equals(P2)){
					System.out.println("같은 이름은 안됩니다. 다시 입력해주십시요.");
				}
				else
					break;
			}
			
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
					winGame(playerRecord,P1,P2);
				} else if (((GGameUp) player[1]).victoryGame(player[0])){
					System.out.println("p2가 " + player[0].getScore() + " 대 " + player[1].getScore() + "로 이겼습니다.");
					winGame(playerRecord,P2,P1);
				}
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
							winGame(playerRecord,P1,P2);
							break;
						} else if (((GGameDown) player[3]).victoryGame()) {
							System.out.println("p2가 게임에서 이겼습니다.");
							System.out.println("p1score :" + player[2].getScore());
							System.out.println("p2score :" + player[3].getScore());
							winGame(playerRecord,P2,P1);
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
							winGame(playerRecord,P1,P2);
							break;
						} else if (((GGameDown) player[3]).victoryGame()) {
							System.out.println("p2가 게임에서 이겼습니다.");
							System.out.println("p1score :" + player[2].getScore());
							System.out.println("p2score :" + player[3].getScore());
							winGame(playerRecord,P2,P1);
							break;
						}
					} 
				}
			}
			else if(selectMenu==3)
				System.out.println("");
			for(int i=0;i<playerRecord.size();i++){
				int a;
				PlayerInfo info = playerRecord.get(i);
				System.out.println(info.getName()+" 승 : "+info.getWin()+" 패 : "+info.getLose());
			}
			System.out.println("그만 하시겠습니까?(y/n)");
			String end= new String();
			end=scanner.next();
			if(end.equals("y")){
				endFlag=false;
			}
		} while (endFlag);
		//playerRecord.clear();
		
		writeRanking(playerRecord);
		
		for(int i=0;i<playerRecord.size();i++){
			int a;
			PlayerInfo info = playerRecord.get(i);
			System.out.println(info.getName()+" 승 : "+info.getWin()+" 패 : "+info.getLose());
		}
		System.out.println("***************");
		System.out.println("***다음에 또 만나요***");
		System.out.println("***************");
	}

	static void clear() {
		for (int i = 0; i < 15; i++)
			System.out.println("");
	}
	
	static ArrayList<PlayerInfo> readRanking(){
		ArrayList<PlayerInfo> player= new ArrayList<PlayerInfo>();
		try{
			FileInputStream fis = new FileInputStream("ranking.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			player= (ArrayList<PlayerInfo>)ois.readObject();		
			ois.close();
			fis.close();
		}catch(Exception e){
			FileOutputStream fos;
			try {
				fos = new FileOutputStream("ranking.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(player);
				oos.flush();
				oos.close();
				fos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return player;
	}
	
	static void writeRanking(ArrayList<PlayerInfo> player){
		//ArrayList<Person> player= new ArrayList<Person>();
		try{
			FileOutputStream fos = new FileOutputStream("ranking.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(player);
			oos.flush();
			oos.close();
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		//return player;
	}
	
	static void winGame(ArrayList<PlayerInfo> player,String P1,String P2){
		boolean p1flag = true;
		boolean p2flag = true;
		for(int i=0;i<player.size();i++){
			PlayerInfo info = player.get(i);
			if(info.getName().equals(P1)){
				info.setName(info.getName());
				info.setWin(info.getWin()+1);
				info.setLose(info.getLose());
				player.set(i, info);
				p1flag=false;
			}
			else if(info.getName().equals(P2)){
				info.setName(info.getName());
				info.setWin(info.getWin());
				info.setLose(info.getLose()+1);
				player.set(i, info);
				p2flag=false;
			}
		}
		if(p1flag==true){
			PlayerInfo info= new PlayerInfo();
			info.setName(P1);
			info.setWin(1);
			player.add(info);
		}
		if(p2flag==true){
			PlayerInfo info= new PlayerInfo();
			info.setName(P2);
			info.setLose(1);
			player.add(info);
		}
	}
}
