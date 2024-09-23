package com.first.springproject.utility;

import org.springframework.security.core.Authentication;

public class Helper {
	public static String getEmailOfLoggedInUser(Authentication authentication) {
		
		return authentication.getName();
	}
}
