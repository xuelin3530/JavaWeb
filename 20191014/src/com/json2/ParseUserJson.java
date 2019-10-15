package com.json2;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.json.Boy;
import com.json.Person;

public class ParseUserJson {
	
	public static void main(String[] args) {
		
		String jsonStr1 = "[\"Tom\",\"Rose\",\"Mary\"]";
		List<String> list1 = JSON.parseArray(jsonStr1,String.class);
		System.out.println(list1+"\n");
		
		String jsonStr3 = "[{\"id\":101,\"name\":\"小郭\",\"age\":20,\"sex\":\"男\"},"
				+ "{\"id\":102,\"name\":\"小杜\",\"age\":22,\"sex\":\"男\"}]";
		List<String> list2 = JSON.parseArray(jsonStr3,String.class);
		System.out.println(list2+"\n");
		
		String jsonStr2 = "{\"id\":1, \"name\":\"Tom\", \"age\":18, \"sex\":\"男\"}";
		Person per = JSON.parseObject(jsonStr2,Person.class);
		System.out.println(per+"\n");
		
		String jsonstr4 = " {\"name\":\"小明\",\"age\":25, \"girlF\":[\"翠花\",\"小红\",\"小黄\"]}";
		Boy boy = JSON.parseObject(jsonstr4,Boy.class);
		System.out.println(boy+"\n");
		
		
		String json="[{\"name\":\"卡卡西\",\"age\":27,"
				+ "\"list\":[{\"price\":35.6,\"bookName\":\"亲热天堂\"},"
							+ "{\"price\":88.6,\"bookName\":\"呼啸山庄\"},"
							+ "{\"price\":90.6,\"bookName\":\"茶花女\"}]},"
		+ "{\"name\":\"犬夜叉\",\"age\":20,"
			+ "\"list\":[{\"price\":33.5,\"bookName\":\"泡面大全\"},"
			+ "{\"price\":73.5,\"bookName\":\"追菇凉\"},"
			+ "{\"price\":93.5,\"bookName\":\"乱世佳人\"},"
			+ "{\"price\":43.5,\"bookName\":\"雾都孤儿\"}]},"
		+ "{\"name\":\"小新\",\"age\":17,"
			+ "\"list\":[{\"price\":33.6,\"bookName\":\"红楼梦\"},"
			+ "{\"price\":103.6,\"bookName\":\"孙子兵法\"},"
			+ "{\"price\":63.6,\"bookName\":\"哆啦A梦\"}]}]";
		
		
		
	}

}
