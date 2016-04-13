package com.sachin.myapp;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sachin.dao.StockDaoImpl;
import com.sachin.model.Stock;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	@RequestMapping(value = "/stocklist/{id}", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Stock> stocklist(@PathVariable("id") String id, Locale locale, Model model) {	
		ArrayList<Stock> al = new ArrayList<Stock>();
		StockDaoImpl s = new StockDaoImpl();
		al=s.listValues(id);
		System.out.println("reached here");
		model.addAttribute("al", al );		
		return al;
	}
	
	@RequestMapping(value = "/stocknames", method = RequestMethod.GET)
	public @ResponseBody ArrayList<String> stocknames(Locale locale, Model model) {	
		ArrayList<String> al = new ArrayList<String>();
		StockDaoImpl s = new StockDaoImpl();
		al=s.listNames();		
		model.addAttribute("al", al );		
		return al;
	}
}
