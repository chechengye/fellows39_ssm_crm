package com.weichuang.service;

import com.weichuang.pojo.BaseDict;

import java.util.List;

public interface IBaseDict {
    List<BaseDict> getBaseDictListByType(String s);
}
