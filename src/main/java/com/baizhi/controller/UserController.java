package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("selectUsersByStarId")
    public Map<String,Object> selectUsersByStarId(Integer page,Integer rows,String starId){
        return userService.selectUsersByStarId(page,rows,starId);
    }
    @RequestMapping("selectAll")
    public Map<String,Object> selectAll(Integer page,Integer rows){
        Map<String, Object> map = userService.selectAll(page, rows);
        return map;
    }

    @RequestMapping("export")
    public void export(HttpServletResponse resp){
//        准备数据
//        userService...
        List<User> list = userService.export();
        System.out.println(list);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"), com.baizhi.entity.User.class, list);

        String fileName = "用户报表("+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+").xls";
        //处理中文下载名乱码
        try {
            fileName = new String(fileName.getBytes("gbk"),"iso-8859-1");
            //设置 response
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("content-disposition","attachment;filename="+fileName);
            workbook.write(resp.getOutputStream());
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("echarts")
    public Map<String,Object> echarts(){
        List<User> trends = userService.select();
        List<User> trend = userService.queryNv();
        List<String> names=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        List<Integer> count1=new ArrayList<>();
        for (int i=1;i<=6;i++){//月
            names.add(i+"月");
        }
        for (int i=1;i<=6;i++){
            int j=i;
            for (User trend1:trends){//男
                if (trend1.getCreateDate().equals(i)){
                    count1.add(trend1.getCount());
                    j++;
                }
            }
            if (j==i){
                count1.add(0);
            }
        }
        for (int i=1;i<=6;i++){
            int j=i;
            for (User trend1:trend){//女
                if (trend1.getCreateDate().equals(i)){
                    count.add(trend1.getCount());
                    j++;
                }
            }
            if (j==i){
                count.add(0);
            }
        }
        System.out.println("男"+count1);
        System.out.println("女"+count);
        //names.forEach(name-> System.out.println(name));
        Map<String, Object> map = new HashMap<>();
        map.put("names",names);
        map.put("count1",count1);//男
        map.put("count",count);//女
        return map;
    }



}
