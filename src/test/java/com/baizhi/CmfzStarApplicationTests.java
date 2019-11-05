package com.baizhi;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import io.goeasy.GoEasy;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class CmfzStarApplicationTests {

    @Autowired
    private AdminDao adminDao;

    public void asdf() {


//第一个参数：REST Host
// 第二个参数：发布消息的App Key
   GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io", "BC-b161122b054940e995ba7c0e68fc6915");
// 第一个参数：channel的名称
// 第二个参数：发布的内容
  goEasy.publish("123123", "Hello, 李云涛");

    }


    @Test
    void contextLoads() {
//        List<Admin> list = adminDao.selectAll();
//        for (Admin admin : list) {
//            System.out.println(admin);
//        }

//        Admin admin = new Admin();
//        admin.setUsername("zhangsan");
//        admin.setPassword("111111");
//        List<Admin> list = adminDao.select(admin);
//        for (Admin admin1 : list) {
//            System.out.println(admin1);
//        }

//        Admin admin = adminDao.selectByPrimaryKey("1");
//        System.out.println(admin);


//        Admin admin = new Admin();
//        admin.setUsername("zhangsan");
//        RowBounds rowBounds = new RowBounds(1,1);
//        List<Admin> list = adminDao.selectByRowBounds(admin, rowBounds);
//        for (Admin admin1 : list) {
//            System.out.println(admin1);
//        }

//        Example example = new Example(Admin.class);
//        example.createCriteria().andBetween("age",18,20).andEqualTo("sex","女");
//        List<Admin> list = adminDao.selectByExample(example);
//        for (Admin admin : list) {
//            System.out.println(admin);
//        }\


        Admin admin = new Admin();
        admin.setId("88bb3d5e-987b-4760-a975-0efd92ba7ab8");
        admin.setUsername("zhangsan");
        admin.setPassword("111111");
//        adminDao.updateByPrimaryKey(admin);
        adminDao.updateByPrimaryKeySelective(admin);


    }

}
