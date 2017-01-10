package cn.libra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import cn.libra.dto.*;

/**
 * Created by libra on 2017/1/10.
 */

@Controller
public class HomeController {

    @RequestMapping(value="/" )
    public String index(){
        String s = "";
        return "index";
    }


    @RequestMapping(value="/get/{id:[0-9]*}")
    @ResponseBody
    public Object Get(@PathVariable("id") Integer id1){
        User u = new User();
        u.setAge("20");
        u.setName("展示");
        u.setStatus(id1);
        return u;
    }
}
