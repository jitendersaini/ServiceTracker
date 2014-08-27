/**
 * 
 */
package com.accenture.tracker.util;

import java.util.HashMap;
import java.util.Map;


/**
 * @author jitender
 * 
 */
public class AppConstants {
	
	
	public static Integer[] convertStringToIntArray(String[] arr) {
		final String[] userids = arr;
	    final Integer[] useridsInt = new Integer[userids.length];
	    for (int i=0; i < userids.length; i++) {
	    	useridsInt[i] = Integer.parseInt(userids[i]);
	    }
	    
	    return useridsInt;
	}
	
	public static Map<Short, String> getPaidViaMap() {
		Map<Short, String> mapPaidVia = new HashMap<Short, String>();
		Short i = 0;
		for (String payment_mode : AppConstants.PAYMENT_MODE_ARRAY) {
			mapPaidVia.put(i, payment_mode);
			i++;
		}
		return mapPaidVia;
	}
	
	
	/** Payment Mode Array */
	public static String[] PAYMENT_MODE_ARRAY = { "Cash", "Credit Card", "Debit Card",
		"Cheque", "Coupons"};
	
	/** Month Array */
	public static String[] MONTHS_ARRAY = { "January", "February", "March",
			"April", "May", "June", "July", "August", "September", "October",
			"November", "December" };

	/** Login */
	public static final String LOGIN_PAGE = "login-page/login";
	
	/** Sign Up */	
	public static final String SIGNUP = "signup-page/signup";
	public static final String SUCCESS = "common-page/success";
	
	/** Sign Up */	
	public static final String WORKENV_PAGE = "workenv-pages/workenv_create";
	public static final String WORKENV_DATA = "workenv-pages/workenv_data";
	
	
}
