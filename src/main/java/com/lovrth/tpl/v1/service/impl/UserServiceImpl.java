package com.lovrth.tpl.v1.service.impl;

import com.lovrth.tpl.v1.mapper.UserMapper;
import com.lovrth.tpl.v1.model.User;
import com.lovrth.tpl.v1.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
