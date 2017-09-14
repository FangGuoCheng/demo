package com.wisely.highlight_spring4.ch1.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {
	@Autowired
	FuncationService funcationService; 
	
	public String SayHello(String word) {
		return funcationService.sayHello(word);
	}
}
