package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.Image;

public interface ImageMetier {
	
	public Image save(Image o) ;
	public List<Image> getAll();
	public Image update(Image o);
	public Long  delete(Long id) ;
	public Image findOne(Long id) ;
	

}