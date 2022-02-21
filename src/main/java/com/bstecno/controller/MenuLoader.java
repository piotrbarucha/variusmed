package com.bstecno.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import menuDao.BookItem;
import menuDao.MenuItem;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


@Controller
public class MenuLoader {
	
	@RequestMapping(value="/springMenuJS.web", 
			method=RequestMethod.GET,
			produces={"application/xml", "application/json"})
    public @ResponseBody MenuItem  getMenuStructure() {		
		MenuItem mi = getArch();
		for (BookItem book : mi.getBook()) {
			mi.getNames().add(book.getPropertyName());
		}
		for (MenuItem item : mi.getItem()) {
			mi.getNames().add(item.getPropertyName());
		}
		return mi;
	}

	@RequestMapping(value="/springSimpleMenuJS.web", 
			method=RequestMethod.GET,
			produces={"application/xml", "application/json"})
	public @ResponseBody ArrayList<BookItem>  getSimpleMenuStructure() {		
		MenuItem mi = getArch();

		return mi.getBook();
	}

	
	private MenuItem getArch() {

		try {			
			 ClassLoader classLoader = getClass().getClassLoader();	 
		     String menuFile = "menu.xml";	     
		     File file = new File(classLoader.getResource(menuFile).getFile());

			 JAXBContext jaxbContext;
		     jaxbContext = JAXBContext.newInstance(MenuItem.class);
			 Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			 return (MenuItem) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		 
		return new MenuItem();
	}
	
	private String generateMenuItem(org.w3c.dom.Node xmlNode, String menuKey) {
		return menuKey;
	}
	

}