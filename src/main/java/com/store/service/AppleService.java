package com.store.service;


public class AppleService implements FruitService{
	   
		@Override
		public String getEndPoint() {
			return "www.apple.com";
		}
 }