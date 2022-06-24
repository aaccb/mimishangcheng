package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.AdminMapper;
import com.bjpowernode.pojo.Admin;
import com.bjpowernode.pojo.AdminExample;
import com.bjpowernode.service.AdminService;
import com.bjpowernode.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    //在业务逻辑层中，一定会有数据库访问层的对象
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin longin(String name, String pwd) {
        //根据传入的用户或者到DB中查询相应用户对象
        //如果有条件，则一定要创建AdminExample的对象，用来封装条件
        AdminExample example=new AdminExample();
        example.createCriteria().andANameEqualTo(name);
        List<Admin> list=adminMapper.selectByExample(example);
        if(list.size()>0){
            Admin admin = list.get(0);
            //如果查询到用户对象，在进行密码对比，注意密码是密文
            String miPwd = MD5Util.getMD5(pwd);
            if (miPwd.equals(admin.getaPass())) {
                return admin;
            }
        }
        return null;
    }
}
