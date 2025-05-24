package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BookModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookModel,Integer>{
	
	
     @Modifying
     @Query("delete from BookModel b where b.bookid in ?1")
     void deleteMultipleId(List<Integer> ids);
}
