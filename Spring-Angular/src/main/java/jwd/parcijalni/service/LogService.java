package jwd.parcijalni.service;

import java.util.List;

import jwd.parcijalni.model.Activity;
import jwd.parcijalni.model.Log;

public interface LogService {
	
	Log findOne(Long id);
	List<Log> findAll();
	Log save(Log log);
	void remove(Long id) throws IllegalArgumentException;
	
	int countByActivity(Activity activity);
	List<Log> findByActivity(Activity activity);

}
