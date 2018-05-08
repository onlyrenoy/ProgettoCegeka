package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/go")
public class MyController {
	
	
	@GetMapping(path="/home")
	public  @ResponseBody  String go()
	{
		return "hello";
	}

}
