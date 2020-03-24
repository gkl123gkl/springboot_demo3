package com.aistar.service;

import com.aistar.pojo.Product;
import com.aistar.util.ServerResponse;

/**
 * Created by admin on 2020/3/4.
 */
public interface ProductService {
    public ServerResponse add(Product product);
    public ServerResponse update(Product product);
    public ServerResponse delete(String proId);
    public ServerResponse getById(String proId);
    public ServerResponse getAll();
    public ServerResponse getAllByPage(Integer pageNum);


}
