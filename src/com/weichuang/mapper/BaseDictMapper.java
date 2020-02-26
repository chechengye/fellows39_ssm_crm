package com.weichuang.mapper;


import com.weichuang.pojo.BaseDict;

import java.util.List;

public interface BaseDictMapper {

    List<BaseDict> getBaseDictListByType(String type);
}
