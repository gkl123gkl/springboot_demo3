package com.aistar.service;

import com.aistar.util.ServerResponse;

/**
 * Created by admin on 2020/2/12.
 */
public interface BaseService<T> {
    public ServerResponse add(T t);
    public ServerResponse modify(T t);
    public ServerResponse modifyStatus(T t);
    public ServerResponse getById(Integer id);
    public ServerResponse getAll();
}
