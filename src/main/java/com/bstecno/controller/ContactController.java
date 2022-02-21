package com.bstecno.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bstecno.common.SendMailTLS;
import com.bstecno.dao.ContactDAO;




@Controller
public class ContactController {
	

	@RequestMapping(value = "/savecompany_json.web", method = RequestMethod.POST)	
	public  @ResponseBody String saveCompany_JSON( @RequestBody ContactDAO data )   {		
		
		//Potwierdzenie mailowe dla nadawcy
		String textFrom = "Tresc wiadomosci od usera: " + data.getName() + " z maila: " + data.getEmail() + "\n\n" + data.getText();
		String toMailFrom = data.getEmail() ;
		SendMailTLS.sendMail("Mjm - Dziekujemy za kontakt!", textFrom, "mjm.info.pl@gmail.com", "wedsaq123", toMailFrom);	

		//Przekazanie wiadomosci do nas na serwer
		String textTo = "Tresc wiadomosci od usera: " + data.getName() + " z maila: " + data.getEmail() + "\n\n" + data.getText();
		String toMailTo = "mjm.info.pl@gmail.com";
		SendMailTLS.sendMail("Otrzymano nowa wiadomosc od usera " +data.getEmail(), textTo, "mjm.info.pl@gmail.com", "wedsaq123", toMailTo);	
	
		return "Wyslano wiadomosc";
	}
}

