package demo.app.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import demo.app.entities.UserEntity;
import org.springframework.stereotype.Repository;

import demo.app.repository.UserRepositoryCustom;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public List<UserEntity> findByParams(String name, String email, String phone) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder(" select ue.name name, ");
		sql.append("ue.id id, ");
		sql.append("ue.phone phone, ");
		sql.append("ue.phone zone, ");
		sql.append("ue.phone status, ");
		sql.append("ue.email email ");
		sql.append("from user ue ");
		sql.append("where 1 = 1 ");
		
		if (name != null && name != "") {
			sql.append("and ue.name like :name ");
		}
		
		if (email != null && email != "") {
			sql.append(" and ue.email like :email ");
		}
		
		if (phone != null && phone != "") {
			sql.append(" and ue.phone like :phone ");
		}
//		sql.append("Order by ue.id desc ");
		
		Query query = em.createNativeQuery(sql.toString(), "doSearchUser");
		
		if (name != null && name != "") {
			query.setParameter("name", "%" + name + "%");
		}
		
		if (email != null && email != "") {
			query.setParameter("email", "%" + email + "%");
		}
		
		if (phone != null && phone != "") {
			query.setParameter("phone", "%" + phone + "%");
		}
		
		return query.getResultList();
		
	}
	
	
	
}
