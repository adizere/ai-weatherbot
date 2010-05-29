package services;

import java.util.ArrayList;
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
	public List<Word> evaluateStatement(String st) {

		List<Word> list = new ArrayList<Word>();

		String s[] = st.split(" ");
		Word w;
		for (int i = 0; i < s.length; i++) {
			String flag = wr.contains(s[i]);
			if (flag.length() <= 0)
				flag = "General";
			w = new Word(0, s[i], flag);
			list.add(w);
		}

		return list;
	}
}
