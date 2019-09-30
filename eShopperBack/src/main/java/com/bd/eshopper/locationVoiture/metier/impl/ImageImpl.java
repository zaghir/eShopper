package com.bd.eshopper.locationVoiture.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.locationVoiture.dao.ImageRepository;
import com.bd.eshopper.locationVoiture.entity.Image;
import com.bd.eshopper.locationVoiture.metier.ImageMetier;

@Service
public class ImageImpl implements ImageMetier{

	@Autowired
	private ImageRepository imageRepository ;

	@Override
	public Image save(Image o) {
		Image a = new Image() ;
		if(imageRepository.findOne(o.getId()) == null){
			return imageRepository.save(o);
		}else{
			 a.setUrlImg("exite deja");			 
			 return a;
		}		
	}

	@Override
	public List<Image> getAll() { 
		return imageRepository.findAll();
	}

	@Override
	public Image update(Image o) {
		return imageRepository.save(o);
	}

	@Override
	public Long delete(Long id) {
		if(imageRepository.findOne(id) != null){
			imageRepository.delete(id);
			return id ;
		}else{
			return 0L ;
		}
	}

	@Override
	public Image findOne(Long id) {
		return imageRepository.findOne(id);
	}
	
	
	
}
