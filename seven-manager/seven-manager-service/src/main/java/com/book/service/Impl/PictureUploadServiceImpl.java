package com.book.service.Impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.book.common.utils.FtpUtil;
import com.book.common.utils.IDUtils;
import com.book.service.PictureUploadService;

@Service
public class PictureUploadServiceImpl implements PictureUploadService {
	//ip地址
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	//端口号
	@Value("${FTP_PORT}")
	private int FTP_PORT;
	//用户名
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	//密码
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	//根路径
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	//图片回显根路径
	@Value("${IMAGE_BASE_PATH}")
	private String IMAGE_BASE_PATH;
	@Override
	public Map pictureUpload(MultipartFile uploadFile) throws Exception {
		Map<Object,Object> map = new HashMap<>();
		String filename = uploadFile.getOriginalFilename();
		InputStream inputStream = uploadFile.getInputStream();
		//生成图片id
		String name = IDUtils.genImageName();
		//组成新名
		name=name+filename.substring(filename.lastIndexOf("."));
		//图片相对路径
		String imagePath = new DateTime().toString("/yyyy/MM/dd");
		boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, imagePath, name, inputStream);
		if(!result) {
			map.put("error", 1);
			map.put("message", "上传失败");
		}else {
			map.put("error", 0);
			map.put("url", IMAGE_BASE_PATH+imagePath+"/"+name);
		}
		return map;
	}

}
