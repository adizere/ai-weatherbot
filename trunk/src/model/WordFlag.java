package model;

public class WordFlag {
	
	private long wordKey;
	private long flagKey;
	
	/**
	 * @param wordKey
	 * @param flagKey
	 */
	public WordFlag(long wordKey, long flagKey) {
		super();
		this.wordKey = wordKey;
		this.flagKey = flagKey;
	}

	public WordFlag(Word word, Flag flag)
	{
		this.wordKey = word.getKey();
		this.flagKey = flag.getKey();
	}

	public long getWordKey() {
		return wordKey;
	}

	public void setWordKey(long wordKey) {
		this.wordKey = wordKey;
	}

	public long getFlagKey() {
		return flagKey;
	}

	public void setFlagKey(long flagKey) {
		this.flagKey = flagKey;
	}

	public void setWord(Word word) {
		this.wordKey = word.getKey();
	}


	public void setFlag(Flag flag) {
		this.flagKey = flag.getKey();
	}
	
	
}
