package com.primaseller.leanstartupbar;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.primaseller.leanstartupbar.utils.Menu;
import com.primaseller.leanstartupbar.utils.MenuParser;
import com.primaseller.leanstartupbar.utils.Queue;

public class Waiter {
	private static String filePath;
	private static int order_no;
	private static boolean isStop=true;


	public static void main(String[] args) {

		System.out.println("------------------------Application Started-------------------------");
		init();

		while(isStop){
			Menu menu=null;
			if(MenuParser.getMap().size()>0){
				System.out.println("enter 0 to exit Application:");
				System.out.println("Enter item id:");
				String choice;
				Scanner scanIn = new Scanner(System.in);
				choice = scanIn.nextLine();
				int id = Integer.parseInt(choice);
				if(id==0){
					isStop=false;
				}


				menu=MenuParser.getMap().get(id);
				
				if(menu!=null){
					order_no=order_no+1;
					SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm:ss a");
					System.out.println("OrderNumber:ORD"+order_no+" for "+menu.getMenu_Item()+" has been placed at "+formatDate.format(new Date()));
					Sheff sheff=new Sheff();
					menu.setOrder_no(order_no);
					sheff.setMenu(menu);
					Queue.getInstnce().addTask(sheff);

				}else{
					System.out.println("No such Item");
					

				}

			}
			else{
				System.out.println("No menu found");
				isStop=false;
			}
			


			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("------------------------Application Stoped-------------------------");
	}

	private static void init() {
		try {
			String appHome    = new File(".").getCanonicalPath();
			filePath=appHome+"/config/menu.txt";

		} catch (IOException e) {

		}
		MenuParser.getInstnce().readFromFile(filePath);
	}

}
