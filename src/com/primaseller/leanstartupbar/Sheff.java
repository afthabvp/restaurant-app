package com.primaseller.leanstartupbar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.primaseller.leanstartupbar.utils.Menu;


public class Sheff  implements Runnable{
	private static String outfileName;


	private Menu menu;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public void run() {
		try {
			outfileName = new File(".").getCanonicalPath() + File.separator
					+ "OrderProcessed.txt";
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(outfileName, true), true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm:ss a");
		long sleep=menu.getPreparation_time()*60*1000;
		out.write("Chef:Picked up ORD"+menu.getOrder_no()+" at "+formatDate.format(new Date())+ "\n");
		out.close();
		out.write("Chef:Cooking "+menu.getMenu_Item()+"..."+ "\n");
		out.close();
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		out.write("Chef:Finished making "+menu.getMenu_Item()+" for ORD"+menu.getOrder_no()+" at "+formatDate.format(new Date())+ "\n");
		out.close();




	}
}
