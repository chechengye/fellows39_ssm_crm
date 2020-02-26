package com.weichuang.controller;

import com.weichuang.pojo.BaseDict;
import com.weichuang.service.IBaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    IBaseDict iBaseDict;
    @RequestMapping("/customerList.do")
    public String getCustomerList(Model model){
        //取出头部下拉数据
        List<BaseDict> industryType =  iBaseDict.getBaseDictListByType("001");
        List<BaseDict> fromType =  iBaseDict.getBaseDictListByType("002");
        List<BaseDict> levelType =  iBaseDict.getBaseDictListByType("006");
        model.addAttribute("industryType",industryType);
        model.addAttribute("fromType",fromType);
        model.addAttribute("levelType",levelType);
        return "customer";
    }
}
