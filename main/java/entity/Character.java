package entity;

import value.id;
import value.name;
import value.rarity;

public class Character {
	private id id;
	public rarity rarity;
	private name name;
	
	public Character( id id, rarity rarity, name name) {
		this.id = id;
		this.rarity = rarity;
		this.name = name;
	}
	
	public id getId() {
		return id;
	}
	
	public rarity getRarity() {
		return rarity;
	}
	public name getname() {
		return name;
	}

	
}
