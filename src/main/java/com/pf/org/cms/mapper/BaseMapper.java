package com.pf.org.cms.mapper;

import java.util.HashMap;

public interface BaseMapper {
    int insert(Map params);

    int update(Map params);

    int delete(Map params);

    HashMap queryForObject(Map params);
}
