package com.weichuang.controller;

import com.weichuang.pojo.BaseDict;
import com.weichuang.pojo.Customer;
import com.weichuang.service.IBaseDict;
import com.weichuang.service.ICustomerService;
import com.weichuang.utils.Page;
import com.weichuang.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    IBaseDict iBaseDict;
    @Autowired
    ICustomerService iCustomerService;
    @RequestMapping("/customerList.do")
    public String getCustomerList(QueryVo vo , Model model){
        //取出头部下拉数据
        List<BaseDict> industryType =  iBaseDict.getBaseDictListByType("001");
        List<BaseDict> fromType =  iBaseDict.getBaseDictListByType("002");
        List<BaseDict> levelType =  iBaseDict.getBaseDictListByType("006");
        model.addAttribute("industryType",industryType);
        model.addAttribute("fromType",fromType);
        model.addAttribute("levelType",levelType);
        Page page = iCustomerService.getPageByQueryVo(vo);
        model.addAttribute("page" , page);
        model.addAttribute("vo" , vo);
        return "customer";
    }
    @RequestMapping("/customerEdit.do")
    @ResponseBody //异步请求时，响应回数据的必要注解。且它也能默认转换为json格式
    public Customer customerEdit(int id){
        return iCustomerService.getCustomerById(id);
    }
    //produces = "text/html;charset=utf-8" : 处理@ResponseBody返回字符串乱码问题。注意多个参数以,号分开。但是要写回缺省的value属性
    @RequestMapping(value = "/customerUpdate.do" , produces = "text/html;charset=utf-8")
    @ResponseBody
    public String customerUpdate(Customer customer){
        int rows = iCustomerService.customerUpdate(customer);
        if(rows > 0){
            return "更新成功!";
        }else{
            return "更新失败!";
        }
    }

    @RequestMapping(value = "/customerDelete.do", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String customerDelete(int id){
        int rows = iCustomerService.customerDelete(id);
        if(rows > 0){
            return "删除成功!";
        }else{
            return "删除失败!";
        }
    }
}
