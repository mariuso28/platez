package org.plate.services.validator;

import org.plate.user.BaseUser;

public class BaseUserValidator {

	public void validate(BaseUser bu) throws ValidatorException
	{
		EmailValidator ev = new EmailValidator();
		if (!ev.validate(bu.getEmail()))
			throw new ValidatorException("Please supply a valid email.");
		PasswordValidator pv = new PasswordValidator();
		if (!pv.validate(bu.getPassword()))
			throw new ValidatorException("Invalid password - (at least 8 chars and contains 1 number and 1 uppercase character).");
		PhoneValidator pvv = new PhoneValidator();
		if (!pvv.validate(bu.getPhone()))
			throw new ValidatorException("Please supply a valid phone number.");
		if (bu.getContact()==null || bu.getContact().isEmpty())
			throw new ValidatorException("Please supply a contact.");
	}
}
