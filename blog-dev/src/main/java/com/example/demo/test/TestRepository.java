package com.example.demo.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer>{

	@Modifying
	@Query(value="INSERT INTO myDB.blog_test (id, comment) VALUES (10, 'Hello Spring')", nativeQuery = true)
	void checkRollback();
}
