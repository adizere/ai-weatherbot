package control;

import java.util.ArrayList;
import java.util.List;

import javax.management.Notification;
import javax.management.NotificationListener;

import model.Word;

import services.StatementEvaluator;
import ui.BotGUI;

public class UiController {
	private BotGUI botGui;
	private StatementEvaluator statementEvaluator;
	
	public UiController() {
		// TODO Auto-generated constructor stub
	}
	
	public BotGUI getBotGui() {
		return botGui;
	}
	
	public void setBotGui(BotGUI botGui) {
		this.botGui = botGui;
	}
	
	public StatementEvaluator getStatementEvaluator() {
		return statementEvaluator;
	}
	
	public void setStatementEvaluator(StatementEvaluator statementEvaluator) {
		this.statementEvaluator = statementEvaluator;
	}
	
	public void createMainWindow(){
		this.botGui.setVisible(true);
	}
	
	public void giveResponse(){
		String question = botGui.getInputTextField();
		List<Word> wordList = statementEvaluator.evaluateStatement(question);
		String response = statementEvaluator.interpretStatement(wordList);
		botGui.insertBotResponse(response);
	}
	
	public void getNotifications(){
		NotificationListener listener = new NotificationListener() {
			
			@Override
			public void handleNotification(Notification notification, Object handback) {
				// TODO Auto-generated method stub
				giveResponse();
			}
		};
		
	}
	
	
}
