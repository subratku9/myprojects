package com.capgemini.hibernate.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public Boolean numValidation(String num) {
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(num);
		if (mat.matches() && (Integer.parseInt(num) >= 0)) {
			return true;
		}
		return false;
	}

	public Boolean dateValidation(String valid) {
		Pattern pat = Pattern.compile("([12]\\d{3}(\\/)(0[1-9]|1[0-2])(\\/)(0[1-9]|[12]\\d|3[01]))");
		Matcher mat = pat.matcher(valid);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}
	
}
