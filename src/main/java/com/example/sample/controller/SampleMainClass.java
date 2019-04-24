package com.example.sample.controller;

public class SampleMainClass {

	public static void main(String[] args) {
		System.out.println(returnNum());

	}

	@SuppressWarnings("finally")
	public static int returnNum() {
		try {
			return 3;
		} catch (Exception e) {
			return 4;
		} finally {
			
		}
	}

}
