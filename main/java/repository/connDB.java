package repository;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Character;
import value.id;
import value.name;
import value.rarity;


public class connDB {
	public static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
	public static String URL = "jdbc:mysql://localhost:3306/gacha";
	public static String USER = "root";
	public static String PW = "Nakamura419"; 

	public static List<Character> connection() {
		List<entity.Character> charalist = new ArrayList<entity.Character>();
		try {
			
			//接続情報の準備
			Class.forName(RDB_DRIVE).newInstance();
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			
			//SQL文の発行
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM charainfo";
			
			//SQLの実行
			ResultSet rs = stmt.executeQuery(sql);
			
			//取得したリザルトセットを最後のレコードまで読み出してエンティティに格納
			while(rs.next()) {
				id rsId = new id(rs.getInt("id"));  
				rarity rsRarity = new rarity(rs.getString("rarity"));
				name rsName = new name(rs.getString("name"));
			
			//キャラクターのエンティティをインスタンス
			entity.Character recChar = new entity.Character(rsId, rsRarity, rsName);
			
			//エンティティをリストに追加
				charalist.add(recChar);
			} 
			
			//リストを作成し終わったらリザルトセットとステートメントをクローズ
			rs.close();
			stmt.close();
			
		}
		catch (Exception e) {
				e.printStackTrace();// 例外処理
			}
		return charalist;
		
		
		}
}


