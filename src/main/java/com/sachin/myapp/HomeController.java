package com.sachin.myapp;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sachin.dao.StockDao;
import com.sachin.dao.StockDaoImpl;
import com.sachin.model.Stock;

/**
 * Handles requests for the application home page.
 */

@Controller

public class HomeController {
	@Autowired
	private StockDaoImpl stockDao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "home";
	}
	
	@RequestMapping(value = "/stocklist/{id}", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Stock> stockList(@PathVariable("id") String id, Locale locale, Model model) {	
		ArrayList<Stock> al = new ArrayList<Stock>();
		al=stockDao.listValues(id);
		model.addAttribute("al", al );		
		return al;
	}
	
	@RequestMapping(value = "/stocknames", method = RequestMethod.GET)
	public @ResponseBody ArrayList<String> stockNames(Locale locale, Model model) {	
		ArrayList<String> al = new ArrayList<String>();		
		al=stockDao.listNames();		
		model.addAttribute("al", al );		
		return al;
	}
	
	@RequestMapping(value = "/stockcurrent/{id}", method = RequestMethod.GET)
	public @ResponseBody Stock stockCurrent(@PathVariable("id") String id, Locale locale, Model model) {	
		Stock s=stockDao.listCurrent(id);
		System.out.println("reached here");
		model.addAttribute("s", s );		
		return s;
	}
	
	@RequestMapping(value = "/stockgoogle/", method = RequestMethod.GET)
	public @ResponseBody Stock stockGoogle(Locale locale, Model model) {		
		Stock s=stockDao.listGoogle();
		System.out.println("reached here");
		model.addAttribute("s", s );		
		return s;
	}
}
