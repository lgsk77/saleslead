package com.genius.game;

import java.util.Scanner;

public class GGame {
	Card[] card = new Card[100];
	int score;
	int input;
	int cardcount;
	
	Scanner scanner = new Scanner(System.in);
	
	public GGame(){
		
		for(int i=0;i<100;i++){
			card[i]=new Card();
			card[i].num=i;
			card[i].card=true;
		}
		score=0;
		input=0;
		cardcount=0;
	}
	
	void reset(int a){
		for(int i=a;i<100;i++){
			card[i].card=false;
		}
	}
	
	int showcard(GGame player,int cardnum){
		return player.card[cardnum].num;
	}
	
	boolean checkcard(int cardnum){
		if(this.card[cardnum].card==false)
			return true;
		return false;
	}
	
	void flag(GGame player){ //낸 카드를 안보이게 하는 것
		this.card[input].card=false;
		player.card[player.input].card=false;
	}
	
	boolean checkvictory(GGame player){
		if(this.input>player.input){
			this.score++;
			flag(player);
			return true;
		}
		return false;
	}
	
	boolean drawcard(){
		input=scanner.nextInt();
		if(input>=101)
			return true;
		else if(checkcard(input))
			return true;
		return false;
	}
	
	boolean victorygame(GGame player){
		if(this.score>player.score)
			return true;
		return false;
	}
	
	void clear(){
		for(int i=0;i<15;i++)
			System.out.println("");
	}
	
}