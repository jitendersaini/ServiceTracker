/**
 * 
 */
package com.accenture.tracker.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * @author jitender
 * 
 */
public class AppConstants {
	
	
	public static Double formatNumber(Double number) {
		if(number == null) {
			return 0.0;
		}
		DecimalFormat f = new DecimalFormat("##.0");
		return Double.valueOf(f.format(number));
	}
	public static Integer[] convertStringToIntArray(String[] arr) {
		final String[] userids = arr;
	    final Integer[] useridsInt = new Integer[userids.length];
	    for (int i=0; i < userids.length; i++) {
	    	useridsInt[i] = Integer.parseInt(userids[i]);
	    }
	    
	    return useridsInt;
	}
	
	public static String convertDate(Date date) {		
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("MMM dd, yyyy z");
		return ft.format(date);
	}
	
	public static String convertDateWithTime(Date date) {		
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("MMM dd, yyyy HH:mm:ss z");
		return ft.format(date);
	}
	
	public static String FLAG_GREEN = "<div class='green'>&nbsp;</div>";
	public static String FLAG_AMBER = "<div class='amber'>&nbsp;</div>";
	public static String FLAG_RED = "<div class='red'>&nbsp;</div>";
	
	/** Month Array */
	public static String[] MONTHS_ARRAY = { "January", "February", "March",
			"April", "May", "June", "July", "August", "September", "October",
			"November", "December" };

	public static final String NO_ACCESS = "admin-page/403";
	public static final String SESSION_INVALID = "login-page/sessioninvalid";
	/** Login */
	public static final String LOGIN_PAGE = "login-page/login";
	public static final String DASHBOARD_PAGE = "/_dashboard";
	public static final String ADMIN_PAGE = "/_admin";
	public static final String USERS_VIEWERS = "dashboard-page/dashboard";
	public static final String ADMIN = "admin-page/dashboard";
	
	/** Sign Up */	
	public static final String SIGNUP = "signup-page/signup";
	public static final String SUCCESS = "common-page/success";
	
	/** Sign Up */	
	public static final String WORKENV_LIST = "workenv-pages/workenv_list";
	public static final String WORKENV_CREATE = "workenv-pages/workenv_create";
	public static final String WORKENV_EDIT = "workenv-pages/workenv_edit";
	
	/** KT */	
	public static final String KT_LIST = "kt-pages/kt_list";
	public static final String KT_CREATE = "kt-pages/kt_create";
	public static final String KT_EDIT = "kt-pages/kt_edit";	
	
	/** Projects */	
	public static final String PROJECTS_LIST = "projects-pages/projects_list";
	public static final String PROJECTS_CREATE = "projects-pages/projects_create";
	public static final String PROJECTS_EDIT = "projects-pages/projects_edit";	
	
	/** Status */	
	public static final String STATUS_LIST = "status-pages/status_list";
	public static final String STATUS_CREATE = "status-pages/status_create";
	public static final String STATUS_EDIT = "status-pages/status_edit";	
	
	/** Status */	
	public static final String OPERATIONS_LIST = "operations-pages/operations_list";
	public static final String OPERATIONS_CREATE = "operations-pages/operations_create";
	public static final String OPERATIONS_EDIT = "operations-pages/operations_edit";	
	
	/** Users */	
	public static final String USERS_LIST = "users-pages/users_list";
	public static final String USERS_CREATE = "users-pages/users_create";
	public static final String USERS_EDIT = "users-pages/users_edit";	
	
	/** Walkthrough */	
	public static final String WALKTHROUGH_LIST = "walkthrough-pages/walkthrough_list";
	public static final String WALKTHROUGH_CREATE = "walkthrough-pages/walkthrough_create";
	public static final String WALKTHROUGH_EDIT = "walkthrough-pages/walkthrough_edit";	
	
	/** Release */	
	public static final String RELEASE_LIST = "release-pages/release_list";
	public static final String RELEASE_CREATE = "release-pages/release_create";
	public static final String RELEASE_EDIT = "release-pages/release_edit";	
	
	
	/** Code Freeze */	
	public static final String CODE_FREEZE_LIST = "codefreeze-pages/codefreeze_list";
	public static final String CODE_FREEZE_CREATE = "codefreeze-pages/codefreeze_create";
	public static final String CODE_FREEZE_EDIT = "codefreeze-pages/codefreeze_edit";	
	
	/** Testing */	
	public static final String TESTING_LIST = "testing-pages/testing_list";
	public static final String TESTING_CREATE = "testing-pages/testing_create";
	public static final String TESTING_EDIT = "testing-pages/testing_edit";	
	
	
	/** Support Scope */	
	public static final String SUPPORT_SCOPE_LIST = "support-pages/support_scope_list";
	public static final String SUPPORT_SCOPE_CREATE = "support-pages/support_scope_create";
	public static final String SUPPORT_SCOPE_EDIT = "support-pages/support_scope_edit";	
	
	/** PGLS */	
	public static final String PGLS_LIST = "pgls-pages/pgls_list";
	public static final String PGLS_CREATE = "pgls-pages/pgls_create";
	public static final String PGLS_EDIT = "pgls-pages/pgls_edit";	
	
	/** Third Parties */	
	public static final String THIRD_PARTIES_LIST = "thirdparties-pages/thirdparties_list";
	public static final String THIRD_PARTIES_CREATE = "thirdparties-pages/thirdparties_create";
	public static final String THIRD_PARTIES_EDIT = "thirdparties-pages/thirdparties_edit";	
	
	/** Rehearsal */	
	public static final String REHEARSAL_LIST = "rehearsal-pages/rehearsal_list";
	public static final String REHEARSAL_CREATE = "rehearsal-pages/rehearsal_create";
	public static final String REHEARSAL_EDIT = "rehearsal-pages/rehearsal_edit";	
	
	/** Access for AO */	
	public static final String ACCESS_AO_LIST = "ao-pages/ao_list";
	public static final String ACCESS_AO_CREATE = "ao-pages/ao_create";
	public static final String ACCESS_AO_EDIT = "ao-pages/ao_edit";	
	
	/** Process And Tools */	
	public static final String PROCESS_TOOLS_LIST = "pt-pages/pt_list";
	public static final String PROCESS_TOOLS_CREATE = "pt-pages/pt_create";
	public static final String PROCESS_TOOLS_EDIT = "pt-pages/pt_edit";	
	
	/** Complete Status */	
	public static final String COMPLETE_STATUS_LIST = "compstatus-pages/compstatus_list";
	
	/** Change Password */
	public static final String PASSWORD_CHANGE = "password-pages/pasword_change";
	
	/** Save */
	public static final String RETURN_BLANK = "";
}
