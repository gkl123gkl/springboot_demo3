package com.aistar.service.impl;

import com.aistar.mapper.ProductMapper;
import com.aistar.pojo.Product;
import com.aistar.service.ProductService;
import com.aistar.util.MessageUtil;
import com.aistar.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/3/4.
 */
@Service
public class ProductServiceImpl implements ProductService {

   @Autowired
    private ProductMapper productMapper;

    @Override
    public ServerResponse add(Product product) {
        int rows=productMapper.insert(product);
        if(rows>0){
            return ServerResponse.addSuccess();
        }else{
            return ServerResponse.addFailed();
        }
    }

    @Override
    public ServerResponse update(Product product) {
        int rows=productMapper.updateByPrimaryKey(product);
        if(rows>0){
            return ServerResponse.updateSuccess();
        }else{
            return ServerResponse.updateFailed();
        }
    }

    @Override
    public ServerResponse delete(String proId) {
       int rows=productMapper.deleteByPrimaryKey(proId);
        if(rows>0){
            return ServerResponse.deleteSuccess();
        }else{
            return ServerResponse.deleteFailed();
        }
    }

    @Override
    public ServerResponse getById(String proId) {
        Product product= productMapper.selectByPrimaryKey(proId);
        if(product==null){
            return ServerResponse.getDataFailed(MessageUtil.NO_DATA);
        }else{
            return ServerResponse.getDataSuccess(product);
        }
    }

    @Override
    public ServerResponse getAll() {
        List<Product> productList= productMapper.selectByExample(null);
        if(productList!=null && productList.size()>0){
            return ServerResponse.getDataSuccess(productList);
        }else{
            return ServerResponse.getDataFailed(MessageUtil.NO_DATA);
        }
    }

    @Override
    public ServerResponse getAllByPage(Integer pageNum) {
       /* Page<Product> page=PageHelper.startPage(pageNum,3);
        List<Product> productList=productMapper.selectByExample(null);
        PageInfo<Product> pageInfo=page.toPageInfo();
        if(productList!=null && productList.size()>0){
            return ServerResponse.getDataSuccess(pageInfo);
        }else{
            return ServerResponse.getDataFailed(MessageUtil.NO_DATA);
        }*/
       return null;
    }


}
