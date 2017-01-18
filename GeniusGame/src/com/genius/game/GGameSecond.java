package com.genius.game;

public class GGameSecond extends GGame{
	
	public GGameSecond(int score){
		super();
		this.setScore(score);
	}
	@Override
	void reverse(GGame player){
		this.setCardReverse(getInput(),false);
		player.setCardReverse(getInput(),false);
	}
	@Override
	void reset(int a){
		for(int i=a;i<TOTAL_CARD;i++){
			setCardReverse(i,false);
		}
	}
	@Override
	boolean checkcard(int cardnum){
		if(isCardReverse(cardnum))
			return false;
		return true;
	}
	@Override
	boolean checkVictory(GGame player){
		if(this.getInput()>player.getInput()){
			this.setScore(this.getScore()+1);
			reverse(player);
			return true;
		}
		return false;
	}
	
	@Override
	boolean drawCard(int input){
		this.setInput(input);
		if(checkcard(input))
			return true;
		return false;
	}
	
	@Override
	boolean victoryGame(GGame player){
		if(this.getScore()>player.getScore())
			return true;
		return false;
	}
}
