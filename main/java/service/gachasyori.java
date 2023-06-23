package service;

import java.util.Collections;
import java.util.List;
import entity.Character;
import java.util.Random;

import repository.connDB;
import java.util.ArrayList;

public class gachasyori {
	public static List<entity.Character> gachastructure(String action){
		int Number = Integer.parseInt(action);
		connDB a = new connDB();
		List<entity.Character> b = a.connection();
	    List<Character> Resultlist = new ArrayList<Character>();
	  //gachastructure(String action)

		while (0 < Number){

			Random rand = new Random();
			int num = rand.nextInt(101);

			if(0 <= num && num<= 10){
				List<Character> SRlist = b.subList(18,20);
				//Listをシャッフル
				Collections.shuffle(SRlist);
				//SRリストをガラガラ抽選会した結果をコンソールへ出力
				SRlist.get(0).getId().toInt();
				SRlist.get(0).getRarity().toString();
				SRlist.get(0).getname().toString();
				Resultlist.add(SRlist.get(0));
				
				//return Resultlist;

			} else if (11 <= num && num <= 40){
				List<Character> Rlist = b.subList(11,18);
				Collections.shuffle(Rlist);
				Rlist.get(0).getId().toInt();
				Rlist.get(0).getRarity().toString();
				Rlist.get(0).getname().toString();
				Resultlist.add(Rlist.get(0));
				
				//return Resultlist;

			} else{
				List<Character> Nlist = b.subList(0,11);
				Collections.shuffle(Nlist);
				Nlist.get(0).getId().toInt();
				Nlist.get(0).getRarity().toString();
				Nlist.get(0).getname().toString();
				Resultlist.add(Nlist.get(0));
				
				//return Resultlist;
			}
			
			Number -= 1;
		}
		return Resultlist;
	}
}

