package org.plate.services.validator;

public class PasswordValidator {

	public boolean validate(final String hex) {

		if (hex==null || hex.length()<8)
			return false;
		boolean hasDigit = false;
		boolean hasUpper = false;
		for (int i=0; i<hex.length(); i++)
		{
			char ch = hex.charAt(i);
			if (Character.isDigit(ch))
				hasDigit=true;
			else
			if (Character.isUpperCase(ch))
				hasUpper=true;
		}
			
		return hasUpper && hasDigit;
	}
}
