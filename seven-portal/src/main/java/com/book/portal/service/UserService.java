package com.book.portal.service;

import com.book.common.pojo.BookResult;
import com.book.pojo.TbUser;

public interface UserService {
	TbUser login(String username);

	void regist(TbUser user);

	void updateUserStatus(TbUser user);
	
	BookResult checkUsername(String username);

	BookResult checkNickname(String nickname);

	void update(TbUser user);
}
