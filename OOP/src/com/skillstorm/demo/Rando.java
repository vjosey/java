package com.skillstorm.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Rando {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		String[] trainees = new String[] { "Victor", "Karim", 
				"Mike", "Yuliya", "Andrew", "Yasuhiro", "Suraj", "Loi",
				"Shaun", "Cedric", "Leevanni", "Nick", "Marc", "Roel" };
		for(String t : trainees) {
			list.add(t);
		}
		Random random = new Random();

		while (list.size() > 0) {
			int index = random.nextInt(list.size());
			System.out.println(list.get(index));
			list.remove(index);
		}
	}
}
