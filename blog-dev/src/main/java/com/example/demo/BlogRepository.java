package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntry, Integer> {

	List<BlogEntry> findAllByOrderByCreateTimeDesc();

//	@Modifying
//	@Transactional
//	@Query(value = "INSERT INTO myDB.blog_entry (id) VALUES (10)"
//			, nativeQuery = true)
//	void insertTestIdA();
//
//	@Modifying
//	@Transactional
//	@Query(value = "INSERT INTO myDB.blog_entry (id) values (20)"
//			, nativeQuery = true)
//	void insertTestIdB();
//
//	@Modifying
//	@Transactional
//	@Query(value = "INSERT INTO myDB.blog_entry (id) VALUES (10)"
//			, nativeQuery = true)
//	void insertTestIdC();
}
