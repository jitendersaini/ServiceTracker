/**
 * 
 */
package com.accenture.tracker.util;



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
	
	/** Month Array */
	public static String[] MONTHS_ARRAY = { "January", "February", "March",
			"April", "May", "June", "July", "August", "September", "October",
			"November", "December" };

	public static final String NO_ACCESS = "admin-page/403";
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
	public static final String WORKENV_DATA = "workenv-pages/workenv_data";
	
	/** KT */	
	public static final String KT_LIST = "kt-pages/kt_list";
	public static final String KT_CREATE = "kt-pages/kt_create";
	public static final String KT_EDIT = "kt-pages/kt_edit";
	public static final String KT_DATA = "kt-pages/kt_data";
	
	/** Projects */	
	public static final String PROJECTS_LIST = "projects-pages/projects_list";
	public static final String PROJECTS_CREATE = "projects-pages/projects_create";
	public static final String PROJECTS_EDIT = "projects-pages/projects_edit";
	public static final String PROJECTS_DATA = "projects-pages/projects_data";
	
	/** Status */	
	public static final String STATUS_LIST = "status-pages/status_list";
	public static final String STATUS_CREATE = "status-pages/status_create";
	public static final String STATUS_EDIT = "status-pages/status_edit";
	public static final String STATUS_DATA = "status-pages/status_data";
	
	/** Users */	
	public static final String USERS_LIST = "users-pages/users_list";
	public static final String USERS_CREATE = "users-pages/users_create";
	public static final String USERS_EDIT = "users-pages/users_edit";
	public static final String USERS_DATA = "users-pages/users_data";
}
