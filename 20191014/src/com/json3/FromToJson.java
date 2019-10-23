package com.json3;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.json2.User;

public class FromToJson {

	public static void main(String[] args) {

		Gson gson = new Gson();
		
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
		
		List<User> list = gson.fromJson(json, new TypeToken<List<User>>() {}.getType());
		for(User u : list) {
			System.out.println(u);
		}
		System.out.println("--------------------------------------------");
		String str = gson.toJson(list);
		System.out.println(str);
		

	}

}
