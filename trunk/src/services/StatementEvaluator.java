package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


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
		
		String noPunctuation = st.replaceAll("[?!.,':;]", "");
		/*
		st.replaceAll("\\?", "");		
		st.replaceAll("!", "");
		st.replaceAll("\\.", "");
		st.replaceAll(",", "");
		*/

		List<Word> list = new ArrayList<Word>();

		String s[] = noPunctuation.split("[\\s,]");		
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
		TimeService.setDay(anyTime);
		
		timp = anyTime;

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
				variabila.setValue("oricum");
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

		/* verificare ce avem */
		
		/* filtram datele in ordinea urmatoare:
		 * 		- locatie
		 * 		- timp
		 * 		- variabile
		 */
		
		List<WeatherData> weatherDatas;
		weatherDatas = wdr.getAll();
		List<WeatherData> result = new ArrayList<WeatherData>();
		
		if (!locatie.getValue().equals("oriunde")){
			for (WeatherData wd : weatherDatas) {
				if (wd.getLocation().equals(locatie.getValue()))
					result.add(wd);
			}
			if (result.size() == 0 && locatie.getValue().length() > 0)
				return "Nu am nicio data despre " + locatie.getValue();
		}else{
			for (WeatherData wd : weatherDatas) 
				result.add(wd);
		}
		
		if (timp.getBegin().get(Calendar.YEAR) != 1){
			Iterator<WeatherData> it = result.iterator();
			while (it.hasNext()){
				WeatherData wData = it.next();
				if (!wData.getTimeline().covers(timp) && !timp.covers(wData.getTimeline()))
					it.remove();
			}
		}
		
		if (variabila.getValue().length() > 0 && !variabila.getValue().equals("oricum")){
			Iterator<WeatherData> it = result.iterator();
			while (it.hasNext()){
				WeatherData wData = it.next();
				if (!wData.getLabel().getVariable().getName().equals(variabila.getValue()))
					it.remove();
			}
		}
		
		String retStr = "";
		Variable varPred;
		Domain domPred;
		if (pred != null && !pred.getName().equals("default")){
			Iterator<WeatherData> it = result.iterator();
			while (it.hasNext()){
				WeatherData wData = it.next();
				Set<Variable> sv = pred.keySet();
				Iterator<Variable> itv = sv.iterator();
				while (itv.hasNext()){
					varPred = itv.next();
					domPred = pred.get(varPred);
					
					if (!wData.getLabel().getVariable().getName().equals(varPred.getName()) || !domPred.covers(wData.getLabel().getValue()))
							it.remove();
				}
			}
			if (result.size() == 0)
				if (locatie.getValue().length() <= 0)
					return "Nu ai specificat locatia";
				else
					retStr = "Nu";
		}
		
		

		for (WeatherData weatherData : result) {
			retStr += "Am gasit orasul ";
			retStr += weatherData.getLocation();
			retStr += " pe perioada ";
			retStr += weatherData.getTimeline().toString() + " ";
			retStr += weatherData.getLabel().getVariable().getName();
			retStr += " intre ";
			retStr += weatherData.getLabel().getValue().getLowerBound() + " si " +weatherData.getLabel().getValue().getUpperBound(); 
			retStr += "\n";
		}
		if (retStr.length() == 0)
			retStr += "Fi putin mai explicit, te rog.";
		
		return retStr;
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