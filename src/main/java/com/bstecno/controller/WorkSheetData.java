package com.bstecno.controller;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WorkSheetData {
	
	private String name;
	private String width;
	private String height;
	private String structure;
	private ArrayList<String> columnNameList = new ArrayList<String>();
	private ArrayList<String> rowsDataList = new ArrayList<String>();

	private ArrayList<String> rowList = new ArrayList<String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public ArrayList<String> getRowList() {
		return rowList;
	}

	public void setRowList(ArrayList<String> rowList) {
		this.rowList = rowList;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public ArrayList<String> getColumnNameList() {
		return columnNameList;
	}

	public String getColumnNameListInString() {
		String columnNameListInString = "";
		for(int i=0;i<columnNameList.size();i++){
			columnNameListInString += columnNameList.get(i);
			if(i!=columnNameList.size()-1){
				columnNameListInString += ",";
			}

		}
		return columnNameListInString;
	}

	public void setColumnNameList(ArrayList<String> columnNameList) {
		this.columnNameList = columnNameList;
	}

	public ArrayList<String> getRowsDataList() {
		return rowsDataList;
	}

	public void setRowsDataList(ArrayList<String> rowsDataList) {
		this.rowsDataList = rowsDataList;
	}
	
}
