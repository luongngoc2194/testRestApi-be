package demo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.app.entities.UserEntity;
import demo.app.repository.UserRepository;
import demo.app.repository.UserRepositoryCustom;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRepositoryCustom userRepositoryCustom;

	public List<UserEntity> getAll() {

		return userRepository.findAll();
	}

	
	public List<UserEntity> searchA2(String name,String phone,String email) {
		return userRepositoryCustom.findByParams(name, email, phone);
	}

//	public List<UserEntity> searchAll(UserEntity dto) {
//		List<UserEntity> result = new ArrayList<>();
//		List<UserEntity> all = userRepository.findAll();
//		for (UserEntity user : all) {
//			if (user.getName().contains(dto.getName())&&user.getEmail().contains(dto.getEmail())&&user.getPhone().contains(dto.getPhone())) {
//				result.add(user);
//			}
//			
//		}
//		return result;
//	}

	public void mySave(UserEntity entity) {
		userRepository.save(entity);
	}

	public UserEntity getOne(Long id) {
		return userRepository.findOne(id);
	}

	public void delete(Long id) {
		userRepository.delete(id);
	}
}
