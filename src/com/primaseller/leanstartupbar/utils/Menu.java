package com.primaseller.leanstartupbar.utils;

public class Menu {
	
	private int Item_id;
	private String menu_Item;
	private int preparation_time;
	private int order_no;
	public Menu(int Item_id,String menu_Item,int preparation_time ){
		
		this.Item_id=Item_id;
		this.menu_Item=menu_Item;
		this.preparation_time=preparation_time;
		
	}
	
	

	public int getOrder_no() {
		return order_no;
	}


	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}









	public int getItem_id() {
		return Item_id;
	}
	public void setItem_id(int item_id) {
		Item_id = item_id;
	}
	public String getMenu_Item() {
		return menu_Item;
	}
	public void setMenu_Item(String menu_Item) {
		this.menu_Item = menu_Item;
	}
	public int getPreparation_time() {
		return preparation_time;
	}
	public void setPreparation_time(int preparation_time) {
		this.preparation_time = preparation_time;
	}
	

}
