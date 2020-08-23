package controller;

import controller.action.Action;
import controller.action.DeleteAction;
import controller.action.InsertAction;
import controller.action.SearchAction;
import controller.action.SearchAllAction;
import controller.action.SearchBoardAction;
import controller.action.UpdateAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory(){}
	public static ActionFactory getInstance(){
		return instance;
	}
	public Action getAction(String command){
		Action action = null;
		
		if(command.equals("search")){
			action = new SearchBoardAction();
		}else if(command.equals("insert")) {
			action = new InsertAction();
		}else if(command.equals("search_entity")) {
			action = new SearchAction();
		}else if(command.equals("getall")) {
			action = new SearchAllAction();
		}else if(command.equals("update")) {
			action = new UpdateAction();
		}else if(command.endsWith("delete")) {
			action = new DeleteAction();
		}
		return action;
	}
}
