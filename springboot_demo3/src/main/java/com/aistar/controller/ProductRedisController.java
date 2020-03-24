package com.aistar.controller;

import com.aistar.pojo.Product;
import com.aistar.service.ProductService;
import com.aistar.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2020/3/18.
 */
@Controller
public class ProductRedisController {
    @Autowired
    @Qualifier("productServiceRedisImpl")
    private ProductService productService;

   @GetMapping(value = "/productRedis/{id}")
    @ResponseBody
    public ServerResponse getById(@PathVariable("id") String proId){
        ServerResponse serverResponse=productService.getById(proId);
        return serverResponse;
    }

    @PostMapping(value = "/productRedis/{id}")
    @ResponseBody
    public ServerResponse delete(@PathVariable("id") String proId){
        ServerResponse serverResponse=productService.delete(proId);
        return serverResponse;
    }
    @PutMapping(value = "/productRedis")
    @ResponseBody
    public ServerResponse update(Product product){
        ServerResponse serverResponse=productService.update(product);
        return serverResponse;
    }
}
