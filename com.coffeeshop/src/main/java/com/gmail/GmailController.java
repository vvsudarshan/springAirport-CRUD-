package com.gmail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GmailController {

	public GmailController() {
		System.out.println("GmailController invocked.. ()");
	}
	
	@RequestMapping(value="/sendmail")
	public void acceptRequest(@RequestParam String to,@RequestParam String message,@RequestParam String body) {
		
		System.out.println("to :"+to);
		System.out.println("message :"+message);
		System.out.println("body :"+body);
	}
	
	

}
