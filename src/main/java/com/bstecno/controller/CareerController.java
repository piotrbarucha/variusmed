package com.bstecno.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bstecno.common.SendMailTLS;
import com.bstecno.dao.CareerDAO;




@Controller
public class CareerController {
	

	@RequestMapping(value = "/avaJobs.web", method=RequestMethod.GET)
	public  @ResponseBody List<String> getAllJobs() {
		List<String>jobList = new ArrayList<String>();
		jobList.add("Kierowca");
		jobList.add("Sprzedawca");
		jobList.add("Rze¿nik");
		return jobList;
	}

	@RequestMapping(value = "/avaPlaces.web", method=RequestMethod.GET)
	public  @ResponseBody List<String> getAllPlaces() {
		List<String>placeList = new ArrayList<String>();
		placeList.add("Raciborz 1");
		placeList.add("Raciborz 2");
		placeList.add("Gliwice");
		return placeList;
	}
	
	@RequestMapping(value = "/sendCV.web", method = RequestMethod.POST)	
	public  @ResponseBody String sendCV( @RequestBody CareerDAO data )   {	
		
		String textFrom = "Dziekujemy za przeslanie CV. Nasz dzial sie z Panem/Pania skontaktuje w najblizszym czasie.\n\n" + 
				"Na stanowiska:"+ data.getJob() + "\n" +
				"W miastach:"+ data.getPlace() + "\n";		String toMailFrom = data.getEmail() ;
		SendMailTLS.sendMail("Mjm - Dziekujemy za przeslanie CV!", textFrom, "mjm.info.pl@gmail.com", "wedsaq123", toMailFrom);	

		//Przekazanie wiadomosci do nas na serwer
		String textTo = "CV od usera: " + data.getName() + " z maila: " + data.getEmail() + " telefon: " + data.getPhone() + "\n\n" + 
						"Na stanowiska:"+ data.getJob() + "\n" +
						"W miastach:"+ data.getPlace() + "\n";
		String toMailTo = "mjm.info.pl@gmail.com";
		SendMailTLS.sendMail("Otrzymano CV od usera " +data.getEmail(), textTo, "mjm.info.pl@gmail.com", "wedsaq123", toMailTo);	
		
		return "";
	}
	@RequestMapping(value = "/sendMail.web", method=RequestMethod.GET)
	public  @ResponseBody List<String> sendMail() {
		
		SendMailTLS.sendMail("title", "Tekst sklepu miesnego", "mjm.info.pl@gmail.com", "wedsaq123", "pbpbio@gmail.com");	

		List<String>placeList = new ArrayList<String>();
		return placeList;
	}
}

