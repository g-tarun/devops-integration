package com.learning.path.base;

import java.util.ArrayList;
import java.util.List;

public class demo {

	public static void main(String[] args) {
		List<String> demo = new ArrayList<String>();
		demo.add("g.tarunrao11@gmail.com");
		demo.add("g.tarunrao2002@gmail.com");
		String email="g.tarunrao11@gmail.com";
		System.out.println(demo.stream().anyMatch(i->i.equalsIgnoreCase(email)));
	}

}
