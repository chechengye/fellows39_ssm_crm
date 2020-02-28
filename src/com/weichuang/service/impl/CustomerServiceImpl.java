package com.weichuang.service.impl;

import com.weichuang.mapper.CustomerMapper;
import com.weichuang.pojo.Customer;
import com.weichuang.service.ICustomerService;
import com.weichuang.utils.Page;
import com.weichuang.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomerMapper customerMapper;

    /**
     * 根据查询条件，获取当前页数据
     * @param vo
     * @return
     */
    @Override
    public Page getPageByQueryVo(QueryVo vo) {
        Page page = new Page();
        if(null != vo){
            vo.setMaxCount(10);
            if(vo.getPage() != null && vo.getPage() != ""){
                page.setPage(Integer.valueOf(vo.getPage()));
                vo.setStartIndex((Integer.valueOf(vo.getPage()) - 1) * vo.getMaxCount());
            }
            page.setSize(5);
            page.setTotal(customerMapper.getTotalByQueryVo(vo));
            page.setRows(customerMapper.getRowsByQueryVo(vo));
        }
        return page;
    }

    /**
     * 根据id获取顾客信息
     * @param id
     * @return
     */
    @Override
    public Customer getCustomerById(int id) {
        return customerMapper.getCustomerById(id);
    }
    /**
     * 更新客户
     * @param customer
     * @return
     */
    @Override
    public int customerUpdate(Customer customer) {
        return customerMapper.customerUpdate(customer);
    }

    /**
     * 根据id删除客户
     * @param id
     * @return
     */
    @Override
    public int customerDelete(int id) {
        return customerMapper.customerDelete(id);
    }
}
