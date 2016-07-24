package jwd.parcijalni.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import jwd.parcijalni.model.Activity;
import jwd.parcijalni.repository.ActivityRepository;
import jwd.parcijalni.service.ActivityService;

@Service
@Transactional
public class JpaActivityService implements ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public Page<Activity> findAll(int page ,  int elemenata) {
		// TODO Auto-generated method stub
		return activityRepository.findAll(new PageRequest(page, elemenata, Direction.DESC, "created"));
	}

	@Override
	public Activity findOne(Long id) {
		// TODO Auto-generated method stub
		return activityRepository.findOne(id);
	}

	@Override
	public List<Activity> save(List<Activity> activities) {
		// TODO Auto-generated method stub
		return activityRepository.save(activities);
	}

	@Override
	public Activity save(Activity activity) {
		// TODO Auto-generated method stub
		return activityRepository.save(activity);
	}

	@Override
	public Activity delete(Long id) {
		Activity activity = activityRepository.findOne(id);
		if(activity==null){
			return null;
		}
		activityRepository.delete(activity);
		return activity;
	}

	@Override
	public List<Activity> delete(List<Long> id) {
		List<Activity> ret = new ArrayList<>();
		for(Long i: id){
			ret.add(delete(i));
		}
		return ret;
	}

	@Override
	public Page<Activity> findByName(int page,  int elemenata ,String name) {
		Page<Activity> ret = activityRepository.findByNameLikeOrDescroptionLike(new PageRequest(page, elemenata, Direction.ASC, "id"),"%"+name+"%", "%"+name+"%");
		return ret;
	}

}
