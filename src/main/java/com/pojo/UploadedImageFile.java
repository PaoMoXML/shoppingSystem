/**
 * @author XuMenglin
 * @date 2019年9月9日
 *
 */
package com.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>Title: UploadedImageFile</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月9日
 */
public class UploadedImageFile {
	   MultipartFile image;

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
}
