package demo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import demo.app.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
//	@Query("SELECT p FROM UserEntity p WHERE "
//			+"CONCAT(p.email,p.phone,p.zone,p.status) LIKE %?1%")
//	List<UserEntity> findAll (String keyword);

	UserEntity findById(Long id);
	
//	 @Query(value = "SELECT u.* FROM user u WHERE u.name = :name and u.phone = :phone and  u.email =:email", nativeQuery = true)
//	 List<UserEntity> findUserByParamsNative( @Param("name") String name,@Param("phone") String phone,@Param("email") String email);
}
