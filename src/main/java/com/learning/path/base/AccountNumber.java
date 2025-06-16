package com.learning.path.base;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccountNumber {

	@Value("${API.key.profile}")
	private String profile;

	public String VerifyAccount(String AccountID) {
		if (AccountID.equalsIgnoreCase("null")) {
			AccountID = "default";
		}
		if (profile.equalsIgnoreCase("DEV")) {
			return "The user with this Id is" + AccountID + " " + "from dev profile";
		}
		return "The user with this Id is" + AccountID;
	}

}
