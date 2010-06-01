package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import model.*;
import repository.DomainRepository;
import repository.LabelRepository;
import repository.PredicateAdaptorRepository;
import repository.PredicateRepository;
import repository.TimelineRepository;
import repository.VariableRepository;
import repository.WeatherDataRepository;
import repository.WordRepository;

public class StatementEvaluator {

	private WordRepository wr;
	private DomainRepository dr;
	private LabelRepository lr;
	private PredicateRepository pr;
	private TimelineRepository tr;
	private VariableRepository vr;
	private WeatherDataRepository wdr;
	private TimeService timeService;
	

	

	public StatementEvaluator(WordRepository wr, DomainRepository dr,
			LabelRepository lr, PredicateRepository pr,
			TimelineRepository tr, VariableRepository vr,
			WeatherDataRepository wdr) {
		super();
		this.wr = wr;
		this.dr = dr;
		this.lr = lr;
		this.pr = pr;
		this.tr = tr;
		this.vr = vr;
		this.wdr = wdr;

	}


	public StatementEvaluator(WordRepository wr2) {
		this.wr = wr2;
	}


	/**
	 * @param st
	 *            : the question that was given to the bot
	 * @return list of each word in that sentence with an flag associated
	 * @author Adizere
	 */
	public List<Word> evaluateStatement(String st) {		/* tokenize by " " and "," */
		
		st.replaceAll("\\?", "");
		st.replaceAll("!", "");
		st.replaceAll("\\.", "");
		st.replaceAll(",", "");
		

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
	public String interpretStatement(List<Word> words) {
		Word locatie = new Word(0, "");
		Word variabila = new Word(0, "");
		Timeline timp = new Timeline();
		Predicate pred = new Predicate();

		Timeline anyTime = new Timeline();
		TimeService.setSeconds(anyTime);

		Timeline tRef = null;
		Word pRef = null;
		Word pLoc = null;
		Word pVar = null;

		/* check for complements */

		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getValue().equals("unde"))
				locatie.setValue("oriunde"); /*
											 * cautam locatiile care evalueaza
											 * predicatele la adevarat pentru
											 * datele de la locatiile respective
											 */
			else if (words.get(i).getValue().equals("cum")) {

			} else if (words.get(i).getValue().equals("cand")) {
				tRef = anyTime;
			}
		}

		/* check for flagged words */

		List<Word> timpi = new ArrayList<Word>();

		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getFlag().equals("locatie"))
				locatie.setValue(words.get(i).getValue());
			else if (words.get(i).getFlag().equals("variabila"))
				variabila.setValue(words.get(i).getValue());
			else if (words.get(i).getFlag().equals("predicat")) {
				pred = pr.findByName(words.get(i).getValue());
				
			} else if (words.get(i).getFlag().equals("timp")) {
				timpi.add(words.get(i));
			}
		}

		TimeService timeService = null;

		switch (timpi.size()) {
		case 1:
			timeService = new TimeService(timpi.get(0).getValue(), "");
			break;
		case 2:
			timeService = new TimeService(timpi.get(0).getValue(), timpi.get(1)
					.getValue());
			break;
		default:
			break;
		}

		if (timeService != null)
			timp = timeService.getTimeline();

		System.out.println(Timeline.displayCalendar(timp.getBegin()));
//		System.out.println(timp.getEnd());
			
		/* verificare ce avem */
		
		
		
	return "";
}
}



//for (Word w : words) {
//	if (w.getFlag().equals("variabila"))
//		pVar = w;
//	else if (w.getFlag().equals("predicat"))
//		pRef = w;
//}
//if (pVar == null && pRef == null)
//	return "nu mi-ai dat date suficiente";