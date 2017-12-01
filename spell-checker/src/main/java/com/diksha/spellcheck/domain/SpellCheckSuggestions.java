package com.diksha.spellcheck.domain;

import java.util.ArrayList;
import java.util.List;


public class SpellCheckSuggestions {
	private List<SpellCheckSuggestion> suggestions;
	 public SpellCheckSuggestions() {
	        this.suggestions = new ArrayList<SpellCheckSuggestion>();
	    }

	    public SpellCheckSuggestions(List<SpellCheckSuggestion> suggestions) {
	        this.suggestions = suggestions;
	    }

	    public List<SpellCheckSuggestion> getSuggestions() {
	        return suggestions;
	    }

	    public void setSuggestions(List<SpellCheckSuggestion> suggestions) {
	        this.suggestions = suggestions;
	    }

	    public void add(SpellCheckSuggestion suggestion) {
	        this.suggestions.add(suggestion);
	    }
	}
