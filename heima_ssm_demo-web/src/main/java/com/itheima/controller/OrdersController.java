package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size){

//        ModelAndView mv=new ModelAndView();
//        List<Orders> orderList = ordersService.findAll();
//        mv.addObject("ordersList",orderList);
//        mv.setViewName("orders-list");
//        return mv;
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page, size);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
@RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String ordersid){
        ModelAndView mv = new ModelAndView();
        Orders orders= ordersService.findById(ordersid);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
