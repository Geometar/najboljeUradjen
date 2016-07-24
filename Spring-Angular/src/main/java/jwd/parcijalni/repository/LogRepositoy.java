package jwd.parcijalni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.parcijalni.model.Activity;
import jwd.parcijalni.model.Log;

@Repository
public interface LogRepositoy extends JpaRepository<Log, Long> {
	
	int countByActivity(Activity activity);
	List<Log> findByActivity(Activity activity);

}
