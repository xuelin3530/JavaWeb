package com.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ToJsonString1 {

	public static void main(String[] args) throws JSONException {
		List<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("赵六");
		
		JSONArray arr = new JSONArray();
		for(String s : list) {
			arr.put(s);
		}
		
		String str1 = arr.toString();
		System.out.println(str1);
		System.out.println("--------------------");
		
		Person p = new Person(111, "田七", "女", 23);
		JSONObject obj1 = new JSONObject();
		obj1.put("pid", p.getId());
		obj1.put("pname", p.getName());
		obj1.put("psex", p.getSex());
		obj1.put("page", p.getAge());
		
		String str2 = obj1.toString();
		System.out.println(str2);
		System.out.println("---------------------");
		Person p2 = new Person(222, "程九", "男", 25);
		List<Person> list2 = new ArrayList<Person>();
		list2.add(p);
		list2.add(p2);
		
		JSONArray arr2 = new JSONArray();
		for(Person per : list2) {
			JSONObject obj2 = new JSONObject();
			obj2.put("pid", per.getId());
			obj2.put("pname", per.getName());
			obj2.put("psex", per.getSex());
			obj2.put("page", per.getAge());
			
			arr2.put(obj2);
		}
		String str3 = arr2.toString();
		System.out.println(str3);
		System.out.println("---------------------");
		Boy boy = new Boy();
		boy.setAge(30);
		boy.setName("小黑");
		boy.setGirlFreind(list);
		
		JSONObject obj3 = new JSONObject();
		obj3.put("name", boy.getName());
		obj3.put("age", boy.getAge());
		
		JSONArray arr3 = new JSONArray();
		for(String name : boy.getGirlFreind()) {
			arr3.put(name);
		}
		obj3.put("girls", arr3);
		String str4 = obj3.toString();
		System.out.println(str4);
		
		
		
		
		
		
		
		
		
		

	}

}
