package com.java8.practice.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LambdaFileRead {
	
	public static void main(String[] args) throws IOException {
		String txt = processFile((BufferedReader br) -> br.readLine() + br.readLine() + br.readLine());
		System.out.println(txt);
	}

	public static String processFile(BufferedReaderProcessor processor) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("E:\\java and ds urls.txt"))){
			return processor.process(br);
		}
	}
}

@FunctionalInterface
interface BufferedReaderProcessor{
	String process(BufferedReader bf) throws IOException;
}