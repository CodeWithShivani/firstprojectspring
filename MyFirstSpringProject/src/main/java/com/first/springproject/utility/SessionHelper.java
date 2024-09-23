package com.first.springproject.utility;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {
	
	public static void removeMessage() {
		try {
			System.out.println("@@@@Removing Message From Session");
			HttpSession httpSession = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest().getSession();
			httpSession.removeAttribute("message");
		} catch (Exception ex) {
			System.out.println("Error in Session Helper : " + ex.toString());
		}
	}

}
