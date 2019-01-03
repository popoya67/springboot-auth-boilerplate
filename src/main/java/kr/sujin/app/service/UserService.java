package kr.sujin.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.sujin.app.dto.User;
import kr.sujin.app.exception.InvalidAccountException;
import kr.sujin.app.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(User user) {
		User loginUser = userRepository.findByUserIdAndPassword(user.getUserId(), user.getPassword());
		if(loginUser == null) {
			throw new InvalidAccountException("잘못된 ID/PW를 입력하셨습니다.");
		}
		return loginUser;
	}
}
