package com.json2;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.json.Boy;
import com.json.Person;

public class ParseJson {
	public static void main(String[] args) {
		String jsonStr1 = "[\"Tom\",\"Rose\",\"Mary\"]";
		List<String> list1 = JSON.parseArray(jsonStr1, String.class);
		System.out.println(list1);
		System.out.println("-----------------------------");
		String jsonStr3 = "[{\"id\":101,\"name\":\"小郭\",\"age\":20,\"sex\":\"男\"},"
				+ "{\"id\":102,\"name\":\"小杜\",\"age\":22,\"tel\":\"123456\"}]";
		List<Person> list2 = JSON.parseArray(jsonStr3, Person.class);
		System.out.println(list2);
		System.out.println("--------------------");
		String jsonStr2 = "{\"id\":1, \"name\":\"Tom\", \"age\":18, \"sex\":\"男\"}";
		Person per = JSON.parseObject(jsonStr2, Person.class);
		System.out.println(per);
		System.out.println("------------------");
		String jsonstr4 = " {\"name\":\"小明\",\"age\":25, \"girlFreind\":[\"翠花\",\"小红\",\"小黄\"]}";
		Boy boy = JSON.parseObject(jsonstr4, Boy.class);
		System.out.println(boy);
		
	}
}
