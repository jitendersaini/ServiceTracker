/**
 * 
 */
package com.accenture.tracker.dao;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Projects;


/**
 * @author j.saini
 *
 */
public interface ProjectsDAO {

	List<Projects> search();

	void save(Projects projects);

	Projects fetchById(Long id);

	void remove(String id);
}
