package jwd.parcijalni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.parcijalni.model.User;
import jwd.parcijalni.web.dto.UserDTO;

@Component
public class UserToUserDTO implements Converter<User, UserDTO> {

	@Override
	public UserDTO convert(User user) {
		if(user==null){
			return null;
		}
		
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setFirstname(user.getFirstname());
		dto.setLastname(user.getLastname());
		dto.setEmail(user.getEmail());
		dto.setBirth(user.getBirth());
		
		return dto;
	}
	
	public List<UserDTO> convert(List<User> users){
		List<UserDTO> ret = new ArrayList<>();
		
		for(User user: users){
			ret.add(convert(user));
		}
		return ret;
	}
	
}
