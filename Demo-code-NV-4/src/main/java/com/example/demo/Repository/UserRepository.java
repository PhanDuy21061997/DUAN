package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Personnel;
import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value ="select * from users e where e.id_account=1",nativeQuery = true)
	List<User>find_id_account();
	@Query(value ="select p.name from users e join personnel p on e.id_personnel=p.id_p",nativeQuery = true)
	List<User>find_id_user();
}
