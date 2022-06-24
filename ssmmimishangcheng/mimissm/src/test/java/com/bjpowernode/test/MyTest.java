package com.bjpowernode.test;

import com.bjpowernode.mapper.ProductInfoMapper;
import com.bjpowernode.pojo.ProductInfo;
import com.bjpowernode.pojo.vo.ProductInfoVo;
import com.bjpowernode.service.ProductInfoService;
import com.bjpowernode.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_dao.xml","classpath:applicationContext_service.xml"})
@WebAppConfiguration
public class MyTest {
    @Autowired
    ProductInfoMapper mapper;

    @Autowired
    ProductInfoService service;

    @Test
    public void testMD5(){
        String mi= MD5Util.getMD5("000000");
        System.out.println(mi);
    }

    @Test
    public void testSelectCondition(){
        ProductInfoVo vo=new ProductInfoVo();
        vo.setPname("4");
        vo.setTypeid(3);
        vo.setLprice(3299.0);
        vo.setHprice(3999.0);
        List<ProductInfo> list=service.selectCondition(vo);
        for(ProductInfo pr:list){
            System.out.println(pr);
        }
    }
}
