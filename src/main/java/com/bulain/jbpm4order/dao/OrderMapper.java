package com.bulain.jbpm4order.dao;

import com.bulain.common.dao.PagedMapper;
import com.bulain.jbpm4order.model.Order;
import com.bulain.jbpm4order.pojo.OrderSearch;

public interface OrderMapper extends PagedMapper<OrderSearch, Order> {
    Order selectByWfId(String wfId);
}