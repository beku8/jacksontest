package com.fm.resttest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestOperations;

@Controller
public class Consumer {
	
	@Autowired private RestOperations restOperations;
	
	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model){
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		Identifiable identifiable = restOperations.getForObject("http://localhost:8080/resttest/identifiable", Identifiable.class);
		
		model.addAttribute(identifiable);
		
		return "home";
	}
	
	@RequestMapping(value = "/client/foo", method = RequestMethod.GET)
	public String foo(Model model){
		Foo foo = restOperations.getForObject("http://localhost:8080/resttest/foo", Foo.class);
		model.addAttribute(foo);
		return "foo";
	}
	

}
