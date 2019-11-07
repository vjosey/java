package com.skillstorm.patterns;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Factory design pattern : 
 * code is VERY flexible to changes
 * 
 * 1. Hide the object being used 
 * 2. Usually when the caller doesn't need to know
 * the concrete class
 * 
 * Calendar cal = Calendar.getInstance();
 * 
 * @author PWalsh
 *
 */
public class InstantiationLogic {
	static Calendar cal = Calendar.getInstance(); // new instance

	public static void main(String[] args) {
		Weapon ww = new Sword();
		Weapon w = WeaponFactory.getWeapon("sword");
		//w.attack();
		Weapon www = WeaponFactory.getModernWeapon();
	}
}

class WeaponFactory {
	public static Weapon getModernWeapon() {
		return new Hk416();
	}
	public static Weapon getWeapon(String type) {
		switch (type) {
		case "sword":
			return new Sword();
		case "hk":
			return new Hk416();
		default:
			return new Sword();
		}
	}
}

interface Weapon {
	public void attack();
}

class Sword implements Weapon {
	public void attack() {
		System.out.println("Swoosh");
	}
}

class Hk416 implements Weapon {
	public void attack() {
		System.out.println("pbpbpbpbpbpb");
	}
}
