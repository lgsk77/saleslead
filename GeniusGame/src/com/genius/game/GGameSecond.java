package com.genius.game;

public class GGameSecond extends GGame{
	
	/*private int maxscore;
	
	public void setMaxScore(int max){
		this.maxscore=max;
	}
	
	public int getScore(){
		return maxscore;
	}
	*/
	public GGameSecond(int score){
		super();
		this.setScore(score);
	}
	
	@Override
	void reverse(GGame player){
		this.setCardReverse(getInput(),false);
		player.setCardReverse(player.getInput(),false);
	}
	@Override
	void reset(int a){
		for(int i=a;i<TOTAL_CARD;i++){
			this.setCardReverse(i,false);
		}
	}
	@Override
	boolean checkCard(int cardnum){
		if(this.isCardReverse(cardnum))
			return false;
		return true;
	}
	@Override
	boolean checkVictory(GGame player){
		if(this.getInput()>player.getInput()){
			this.setScore(this.getScore()-1);
			reverse(player);
			return true;
		}
		return false;
	}
	

	@Override
	boolean drawCard(int input){
		this.setInput(input);
		if(this.checkCard(input))
			return true;
		return false;
	}
	
	@Override
	boolean victoryGame(GGame player){
		if(this.getScore()>player.getScore())
			return true;
		return false;
	}
	
	boolean victoryGame(){
		if(this.getScore()<1)
			return true;
		return false;
	}
}
