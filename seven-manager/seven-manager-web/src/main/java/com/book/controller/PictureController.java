package com.book.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.book.common.utils.JsonUtils;
import com.book.service.PictureUploadService;

/**
 * 图片上传控制器
 * @ClassName: PictureController
 * @Title: PictureController
 * @author: 
 * @date: 2019年8月18日
 */
@Controller
public class PictureController {
	@Autowired
	private PictureUploadService  pictureUploadService;
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String PictureUpload(MultipartFile uploadFile) throws Exception {
		Map map = pictureUploadService.pictureUpload(uploadFile);
		//kingEditor图片上传如果返回json格式的map 火狐不支持 所以返回json格式的字符串
		String json = JsonUtils.objectToJson(map);
		return json;	
	}
}
