package com.eqshen.freechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/eqshen")
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)

    public ModelAndView index(){
        ModelAndView view = new ModelAndView("/index.btl");
        //total 是模板的全局变量，可以直接访问
        view.addObject("userId","123456");
        return view;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return "do test";
    }
}
