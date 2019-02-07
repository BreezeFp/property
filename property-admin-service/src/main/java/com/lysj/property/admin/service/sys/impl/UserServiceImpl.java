package com.lysj.property.admin.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lysj.property.admin.service.sys.IUserService;
import com.lysj.property.dao.sys.UserMapper;
import com.lysj.property.entity.sys.User;
import org.springframework.stereotype.Service;

/**
 * @author fupeng
 * @date 2019/1/19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
