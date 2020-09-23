package com.cwh.protobuf.tutorial;

import com.cwh.protobuf.tutorial.PersonProtos.Person;

public class ProtoBufTutorialApp {
	public static void main(String[] args) {
		Person person = Person.newBuilder()
						.setId(1)
						.setName("조우현")
						.setEmail("aq3aq4@gmail.com")
						.build();
		System.out.println("-------");
		System.out.println(person.getId());
		System.out.println(person.getName());
		System.out.println(person.getEmail());
		System.out.println("-------");
		
	}
}
