package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	@Query(value="select * from Customer where id=:s or name like %:ha",nativeQuery = true)
	   public List<Customer> getStudentinfo(@Param("s") int id,@Param("ha") String name);
		
	@Modifying
	@Transactional
	@Query(value="update Product set productname=:newName where prodid=:oldId", nativeQuery = true)
	public void updateProduct(@Param("newName") String newProductName, @Param("oldId") int oldProductId);

	@Modifying
	 @Transactional
	 @Query(value="delete from Interaction where id=:s",nativeQuery = true)
	 public int deleteinfo(@Param("s") int id);
}
