package com.diksha.spellcheck.service;

import java.util.List;

import com.diksha.spellcheck.domain.SpellCheckSuggestions;

import dk.dren.hunspell.Hunspell;

public interface SpellCheckInterface {
//	public void loadDictionaries();
	public SpellCheckSuggestions getSpellcheckSuggestions(String[] wordsToCheck);
	public List<String> getDictionariesAsList();
	public List<Hunspell.Dictionary> getLoadedDictionaries();
	

}
