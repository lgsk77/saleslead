package com.genius.game;

public class GGameFirst extends GGame implements CheckCard,CheckVictory,DrawCard,InitialReverse,Reverse,VictoryGame {
	
	public GGameFirst(){
		super();
	}
	
	@Override
	public void reverse(GGame player){
		this.setCardReverse(getInput(),false);
		player.setCardReverse(player.getInput(),false);
	}
	@Override
	public void initailReverse(int a){
		for(int i=a;i<TOTAL_CARD;i++){
			this.setCardReverse(i,false);
		}
	}
	@Override
	public boolean checkCard(int cardnum){
		if(this.isCardReverse(cardnum))
			return false;
		return true;
	}
	@Override
	public boolean checkVictory(GGame player){
		
		if(this.getInput()>player.getInput() ){
			this.setScore(this.getScore()+1);
			reverse(player);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean drawCard(int input){
		this.setInput(input);
		if(this.checkCard(input))
			return true;
		return false;
	}
	
	@Override
	public boolean victoryGame(GGame player){
		if(this.getScore()>player.getScore())
			return true;
		return false;
	}
}

