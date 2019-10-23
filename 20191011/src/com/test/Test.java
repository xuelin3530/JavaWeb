package com.test;

import org.apache.commons.io.FilenameUtils;

public class Test {

	public static void main(String[] args) {
		String str = "c:/a/bc/c/my.java";
		System.out.println(FilenameUtils.getName(str));

	}

}
