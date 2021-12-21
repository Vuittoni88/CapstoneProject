package com.shots.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shots.entity.Picture;
import com.shots.repository.PictureRepository;

@CrossOrigin
@RestController
public class PictureController {

@Autowired
PictureRepository pr;
	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity uploadFile(@RequestParam MultipartFile file, @RequestParam String pictureDescription, @RequestParam String orderId) {
		Picture picture= new Picture();
		picture.setPictureDescription(pictureDescription);
		picture.setOrderId(orderId);
		try {
			picture.setPicture(file.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		pr.save(picture);
		return ResponseEntity.ok().build();
	}
	@GetMapping (value="/vieworder")
	@ResponseBody
	public ResponseEntity<List<Picture>> viewOrder(String orderId) {
		List<Picture> order = pr.findPicturesByOrderNum(orderId);
			return new ResponseEntity<>(order, HttpStatus.OK);
		}
	
	


}
