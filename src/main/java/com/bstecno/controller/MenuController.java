package com.bstecno.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


@Controller
public class MenuController {
	
	@RequestMapping(value="/springMenuControllerJS.web", method=RequestMethod.GET, produces={"application/xml", "application/json"})
    public @ResponseBody ModelAndView  getMenuStructure(String itemTop) {		

//		   JSONArray employeeJsonArray = // contains all the information of the employee
		   return new ModelAndView("employee", "employee","employeeJsonArray");
			
		
	}
	@RequestMapping(value = "/getAllProfiles.web", method=RequestMethod.GET)
	public  @ResponseBody String getAllProfiles(/* ModelMap model*/ ) {
		String jsonData = "[{\"firstname\":\"ajitesh\",\"lastname\":\"kumar\",\"address\":\"211/20-B,mgstreet\",\"city\":\"hyderabad\",\"phone\":\"999-888-6666\"},{\"firstname\":\"nidhi\",\"lastname\":\"rai\",\"address\":\"201,mgstreet\",\"city\":\"hyderabad\",\"phone\":\"999-876-5432\"}]";
		return jsonData;
	}

	@RequestMapping(value = "/getClicked.web", method=RequestMethod.POST)
	public  @ResponseBody String getSelectedMenuItem(String clicked) {

		return clicked;
	}
}

