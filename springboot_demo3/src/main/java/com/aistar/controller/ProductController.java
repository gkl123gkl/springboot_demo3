package com.aistar.controller;

import com.aistar.service.ProductService;
import com.aistar.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2020/3/11.
 */
@Controller
public class ProductController {
    @Autowired
    @Qualifier("productServiceImpl")
   private ProductService productService;
    @GetMapping(value = "/product/{id}")
    @ResponseBody
    public ServerResponse getById(@PathVariable("id") String proId){
        ServerResponse serverResponse=productService.getById(proId);
        return serverResponse;
    }
}
