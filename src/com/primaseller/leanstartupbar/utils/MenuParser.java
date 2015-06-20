package com.primaseller.leanstartupbar.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MenuParser {
	private static MenuParser _instnce = null;
	static HashMap<Integer, Menu> map=null;
	
	private MenuParser() {
		 map = new HashMap<Integer, Menu>();
		
	}
	
	public static MenuParser getInstnce() {
		if( _instnce == null) 
			_instnce = new MenuParser();
		return _instnce;
	}
	
	
	
	
	public static HashMap<Integer, Menu> getMap() {
		return map;
	}

	public static void setMap(HashMap<Integer, Menu> map) {
		MenuParser.map = map;
	}

	public void readFromFile(String filePath) {
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(filePath));
			sCurrentLine = br.readLine();
			while ((sCurrentLine = br.readLine()) != null) {
				
				String [] data=sCurrentLine.split("\\t");
				Menu menuObject=new Menu(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]));
				map.put(menuObject.getItem_id(),menuObject);
				System.out.println(menuObject.getItem_id() + " : " +sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
