package com.test.mybatis.plus.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.test.mybatis.plus.common.Constants;
import com.test.mybatis.plus.easeypoi.StudentEntity;
import com.test.mybatis.plus.entity.Msg;
import com.test.mybatis.plus.entity.User;
import com.test.mybatis.plus.service.UserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.test.mybatis.plus.service.impl.StudentPoiImpl;
import com.test.mybatis.plus.utils.Page;


import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @ProjectName: test
 * @Package: com.test.mybatis.plus.controller
 * @ClassName: UserController
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/22 13:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/22 13:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
/*@RestController*/
@Controller

public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private StudentPoiImpl studentPoi;


    EntityWrapper<User> queryWrapper = new EntityWrapper<User>();
    EntityWrapper<StudentEntity> studentEntityEntityWrapper = new EntityWrapper<StudentEntity>();



    @RequestMapping("list")
    public List<User> getUserList(){

        return userService.selectList(queryWrapper);
    }
 /*   @RequestMapping("page")
    public Page<User> getUserList(Page page){
        Page<User> pg = new Page<User>(1,3);

        return userService.selectPage(pg,queryWrapper);
    }*/

    @RequestMapping("pageList")
    public Page<User> getpageList(Page page){
        return userService.getList(page);
    }


    @RequestMapping("ll")
    public User get(User user){
        return userService.selectOne(user);
    }

    /**
     * 新增数据
     */
    @RequestMapping("save")
    public String save(User user){
        boolean b = userService.insertOrUpdate(user);
        if (b){
            return Constants.RESULT_SUCCESS;
        }
        else {
            return Constants.RESULT_FAIL;
        }
    }

    /**
     * 数据的更新
     */
    @RequestMapping("update")
    public String update(User user){
        boolean b = userService.updateById(user);
        if (b){
            return Constants.RESULT_SUCCESS;
        }
        else {
            return Constants.RESULT_FAIL;
        }
    }

    /**
     *数据的删除
     */
    @RequestMapping(value = "delete")
    public String delete(User user){
        Long id = user.getId();

        String str = "我是测试";
        System.out.println(str);
        EntityWrapper<User> q = new EntityWrapper<User>();

        q.eq("id",id);
        String strs = "我是测试sssssss";
        System.out.println(q);

        boolean b = userService.delete(q);
        if (b){
            return Constants.RESULT_SUCCESS;
        }
        else {
            return Constants.RESULT_FAIL;
        }
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello admin";
    }

    /**
     * 登录页面
     * @param
     * @return
     */
    @RequestMapping(value = "/loginaction")
    public String login(Model model, User user
            , @RequestParam(value = "error",required = false) boolean error
            , @RequestParam(value = "logout",required = false) boolean logout, HttpServletRequest request){
        model.addAttribute(user);
        //如果已经登陆跳转到个人首页
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null&&
                !authentication.getPrincipal().equals("admin")&&
                authentication.isAuthenticated()) {
            return "home";
        }
        if(error==true) {
            model.addAttribute("error",error);
        }
        if(logout==true) {
            model.addAttribute("logout",logout);
        }
        return "login";
    }

/*    @RequestMapping("home")
    public String successUrl(){
        return "home";
    }*/

    @RequestMapping("success")
    public String se(){
        return "success";
    }
    @RequestMapping("/home")
    public String index(Model model){
        Msg msg =  new Msg("1111111111111111","33333333333333","6666666666666666666666666666666");
        model.addAttribute("msg", msg);
        return "home";
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String getList(){
        return "hello getList";
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String save(){
        return "hello save";
    }


    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public String update(){
        return "hello update";
    }

    @RequestMapping("adminHome")
    public String adminHome(){

        return "adminHome";
    }

    @RequestMapping("logoutYemian")
    public String logoutYemian(){
        return "logoutYemian";

    }
    @RequestMapping("poi")
    private void poi() throws IOException {
        List<StudentEntity> list = studentPoi.getList();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                StudentEntity.class, list);
        File savefile = new File("D:/excel/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:/excel/Exce.xls");
        workbook.write(fos);
        fos.close();
    }
}
