package com.shots.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shots.entity.Picture;

public interface PictureRepository extends JpaRepository <Picture, Integer>{

	@Query("Select P from Picture P where P.orderId= ?1")
	public List<Picture> findPicturesByOrderNum(String orderId);
}
