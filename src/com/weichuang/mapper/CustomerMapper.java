package com.weichuang.mapper;

import com.weichuang.pojo.Customer;
import com.weichuang.utils.Page;
import com.weichuang.vo.QueryVo;

import java.util.List;

public interface CustomerMapper {
    int getTotalByQueryVo(QueryVo vo);

    List<Customer> getRowsByQueryVo(QueryVo vo);

    Customer getCustomerById(int id);

    int customerUpdate(Customer customer);

    int customerDelete(int id);
}
