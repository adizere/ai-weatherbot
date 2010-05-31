package control;

import java.util.List;

import model.Word;
import services.StatementEvaluator;
import ui.BotGUI;

public class UiController {
	private BotGUI botGui;
	private StatementEvaluator statementEvaluator;
	
	public UiController() {
		botGui = new BotGUI(this);
	}
	
	public BotGUI getBotGui() {
		return botGui;
	}
	
	public void setBotGui(BotGUI botGui) {
		this.botGui = botGui;
		this.botGui.setUiController(this);
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
	
	public void giveResponse(String question){
		//List<Word> wordList = statementEvaluator.evaluateStatement(question);
		//String response = statementEvaluator.interpretStatement(wordList);
		//botGui.insertBotResponse(response);
		botGui.insertBotResponse(question);
	}
		
}
