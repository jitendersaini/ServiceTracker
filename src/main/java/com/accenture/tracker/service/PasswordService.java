/**
 * 
 */
package com.accenture.tracker.service;

import com.accenture.tracker.model.ChangePassword;



/**
 * @author j.saini
 *
 */
public interface PasswordService {

	String save(ChangePassword password, Long userid);

}
