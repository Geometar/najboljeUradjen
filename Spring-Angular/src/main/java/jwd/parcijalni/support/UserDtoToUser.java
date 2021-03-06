package jwd.parcijalni.support;

import java.awt.IllegalComponentStateException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.parcijalni.model.User;
import jwd.parcijalni.service.UserService;
import jwd.parcijalni.web.dto.UserDTO;

@Component
public class UserDtoToUser implements Converter<UserDTO, User> {

	@Autowired
	private UserService userService;
	
	@Override
	public User convert(UserDTO dto) {
		User user = null;
		if(dto.getId()==null){
			user = new User();
		}else{
			user = userService.findOne(dto.getId());
			if(user == null){
				throw new IllegalComponentStateException("Edditing non-existing User");
			}
		}
		
		user.setEmail(dto.getEmail());
		user.setFirstname(dto.getFirstname());
		user.setLastname(dto.getLastname());
		user.setBirth(dto.getBirth());
		
		return user;
	}
	
	public List<User> convert(List<UserDTO> dtos){
		List<User> ret = new ArrayList<>();
		
		for(UserDTO dto: dtos){
			ret.add(convert(dto));
		}
		
		return ret;
	}

}
