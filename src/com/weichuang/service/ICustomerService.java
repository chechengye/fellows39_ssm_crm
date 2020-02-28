package com.weichuang.service;

import com.weichuang.pojo.Customer;
import com.weichuang.utils.Page;
import com.weichuang.vo.QueryVo;

public interface ICustomerService {
    Page getPageByQueryVo(QueryVo vo);

    Customer getCustomerById(int id);

    int customerUpdate(Customer customer);

    int customerDelete(int id);
}
