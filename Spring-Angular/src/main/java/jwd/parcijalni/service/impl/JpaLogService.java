package jwd.parcijalni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.parcijalni.model.Activity;
import jwd.parcijalni.model.Log;
import jwd.parcijalni.repository.LogRepositoy;
import jwd.parcijalni.service.LogService;

@Service
public class JpaLogService implements LogService{
	
	@Autowired
	private LogRepositoy logRepository;
	

	@Override
	public Log findOne(Long id) {
		// TODO Auto-generated method stub
		return logRepository.findOne(id);
	}

	@Override
	public List<Log> findAll() {
		// TODO Auto-generated method stub
		return logRepository.findAll();
	}

	@Override
	public Log save(Log log) {
		// TODO Auto-generated method stub
		return logRepository.save(log);
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		logRepository.delete(id);
		
	}

	@Override
	public int countByActivity(Activity activity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Log> findByActivity(Activity activity) {
		// TODO Auto-generated method stub
		return null;
	}

}
