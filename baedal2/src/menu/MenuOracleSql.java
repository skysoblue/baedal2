package menu;

public class MenuOracleSql {
	public static final String dropMenuSeq
		= "drop sequence menuSeq";
	public static final String createMenuSeq 
		= "create sequence menu_seq";
	public static final String createMenu 
		= "create table Menu("
				+ "menu_seq number, food_name varchar2(20), food_image varchar2(20),"
				+ "constarint menu_pk primary key(menu_seq))";
	public static final String selectAllMenu
		= "select * from menu";
	
}
