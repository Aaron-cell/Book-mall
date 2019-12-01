package com.book.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
/**
 * 上传图片业务service
 * @ClassName: pictureUploadService
 * @Title: pictureUploadService
 * @author:
 * @date: 2019年8月18日
 */
public interface PictureUploadService {
	Map pictureUpload(MultipartFile uploadFile) throws Exception;
}	
