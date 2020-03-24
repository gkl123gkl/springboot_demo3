package com.aistar.service.redisimpl;

import com.aistar.mapper.ProductMapper;
import com.aistar.pojo.Product;
import com.aistar.service.ProductService;
import com.aistar.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2020/3/18.
 */
@Service
public class ProductServiceRedisImpl implements ProductService {
    @Autowired
    private RedisTemplate redisTemplate;
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

            String key = "pro_id_" + product.getProId();
            boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                Product product1=productMapper.selectByPrimaryKey(product.getProId());
                redisTemplate.opsForValue().set(key, product1);
                System.out.println("修改缓存中的数据");
            }
        if(rows>0){
            return ServerResponse.updateSuccess();
        }else{
            return ServerResponse.updateFailed();
        }
    }

    @Override
    public ServerResponse delete(String proId) {
        int rows=productMapper.deleteByPrimaryKey(proId);

            String key = "pro_id_" + proId;
            boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                redisTemplate.delete(key);
                System.out.println("删除缓存中的数据");
            }
        if(rows>0){
            return ServerResponse.deleteSuccess();
        }else{
            return ServerResponse.deleteFailed();
        }
    }

    @Override
    public ServerResponse getById(String proId) {
        String key = "pro_id_" + proId;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {//缓存中有该数据
            Product product = (Product) redisTemplate.opsForValue().get(key);
            if (product != null) {
                System.out.println("从缓存中查到该商品：" + product);
                return ServerResponse.getDataSuccess(product);
            } else {
                System.out.println("缓存中没有该商品：" + proId);
                return ServerResponse.getDataFailed("没有该商品");
            }
        } else {//缓存中没有该数据
            Product product = productMapper.selectByPrimaryKey(proId);
            System.out.println("从数据库中获得数据");
            if (product != null) {
                System.out.println("从数据库中查到该商品，并将其写入缓存中" + product);
                redisTemplate.opsForValue().set(key, product);
                return ServerResponse.getDataSuccess(product);
            } else {
                return ServerResponse.getDataFailed("没有该商品");
            }
        }
    }


    @Override
    public ServerResponse getAll() {
        return null;
    }

    @Override
    public ServerResponse getAllByPage(Integer pageNum) {
        return null;
    }
}