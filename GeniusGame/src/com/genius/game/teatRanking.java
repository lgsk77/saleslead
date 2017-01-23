package com.genius.game;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class teatRanking {
	public static void main(String args[]){
		ArrayList<Person> playerRecord= new ArrayList<Person>();
		playerRecord.clear();
		writeRanking(playerRecord);
	}
	static void writeRanking(ArrayList<Person> player){
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
	
}
