package com.genius.game;

import java.util.Scanner;

public class GGame {
	int[] card = new int[100];
	int score;
	int input;
	int cardcount;
	
	Scanner scanner = new Scanner(System.in);
	
	public GGame(){
		for(int i=0;i<100;i++)
		{
			card[i]=i;
		}
		score=0;
		input=0;
		cardcount=0;
	}
	
	void reset(int a){
		for(int i=a;i<100;i++){
			card[i]=101;
		}
	}
	
	int showcard(GGame player,int cardnum){
		return player.card[cardnum];
	}
	
	boolean checkcard(int cardnum){
		if(this.card[cardnum]==101)
			return true;
		return false;
	}
	
	void flag(GGame player){
		this.card[input]=101;
		player.card[player.input]=101;
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
	
}