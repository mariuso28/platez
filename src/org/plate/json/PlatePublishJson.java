package org.plate.json;

import org.springframework.web.multipart.MultipartFile;

public class PlatePublishJson extends PlateParamsJson{

	private String price;
	private MultipartFile upload;
 
	public PlatePublishJson()
	{
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	
}
