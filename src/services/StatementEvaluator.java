package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Word;
import repository.WordRepository;

public class StatementEvaluator {

	private WordRepository wr;

	public StatementEvaluator(WordRepository w) {
		this.wr = w;
	}

	/**
	 * @param st
	 *            : the question that was given to the bot
	 * @return list of each word in that sentence with an flag associated
	 * @author Adizere
	 */
	public List<Word> evaluateStatement(String st) {		/* tokenize by " " and "," */

		List<Word> list = new ArrayList<Word>();

		String s[] = st.split("[\\s,]");		
		Word w;
		for (int i = 0; i < s.length; i++) {
			if (s[i].length() > 0) {
				String flag = wr.contains(s[i]);
				if (flag.length() <= 0)
					flag = "General";
				w = new Word(0, s[i], flag);
				list.add(w);
			}
		}

		return list;
	}
	
	
	/* vezi documentation/interpretQuestion */
	public void interpretStatement(List<Word> words) {
		Word locatie = new Word(0, "");
		Word variabila = new Word(0, "");
		Calendar timp[] = new Calendar[2];
		
			/* check for complements */
		
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getValue() == "unde")
				locatie.setValue("oriunde");
			else if (words.get(i).getValue() == "cat"
					|| words.get(i).getValue() == "ce")
				variabila.setValue("oricum");
			else if (words.get(i).getValue() == "cand") {
				timp[0].setTimeInMillis(0);
				timp[1].setTimeInMillis(0);
			}
		}

			/* check for flagged words */
		for(int i=0; i<words.size(); i++){
			if (words.get(i).getFlag() == "locatie")
				locatie.setValue(words.get(i).getValue());
			else if (words.get(i).getFlag() == "variabila")
				variabila.setValue(words.get(i).getValue());
			else if (words.get(i).getFlag() == "predicat"){
				
				/* transformare din predicat in variabila (eg: "noros" -> sky coverage cu Domain(50,70) */
			}
		}
	}
}
