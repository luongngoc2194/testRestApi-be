package demo.app.repository;

import java.util.List;

import demo.app.entities.UserEntity;

public interface UserRepositoryCustom {
	List<UserEntity> findByParams(String name, String email, String phone);
}
