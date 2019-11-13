package com.example.demo.phoenix.controller;

import com.example.demo.phoenix.entity.Order;
import com.example.demo.phoenix.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by hadoopuser on 11/2/19.
 */

@Controller
//@RequestMapping("/testBoot")
public class OrderController {

    @Autowired
    private OrderService orderService;

    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping("/")
    public String hello(Model model) {
        Map map = new LinkedHashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put("key" + i, "value" + i);
        }
        model.addAttribute("list", Arrays.asList("string1", "string2", "string3", "string4", "string5", "string6"));
        model.addAttribute("map", map);
        model.addAttribute("name", "   htTps://wWw.zHyD.mE   ");
        model.addAttribute("htmlText", "<span style=\"color: red;font-size: 16px;\">html内容</span>");
        model.addAttribute("num", 123.012);
        model.addAttribute("null", null);
        model.addAttribute("dateObj", new Date());
        model.addAttribute("bol", true);

        return "index";
    }

    @RequestMapping(value = "/getOrder")
    public String getOrder(Model model){

        List<Order> orderList = orderService.getOrders();
        orderList.forEach(t->System.out.println(t.toString()));

        model.addAttribute("orderList", orderList);
        return "order/list";
    }

    @RequestMapping("/orderList.html")
    public String getArticles(Model model, String title, @RequestParam(defaultValue = "10") Integer pageSize, Integer pageNum) {
        if (pageSize == null) {
            pageSize = 10;
        }
        if (pageNum == null) {
            pageNum = 1;
        }
        int offset = (pageNum - 1) * pageSize;
//        List<Order> list = articleService.getArticles(title, 1L, offset, pageSize);


        ArrayList<Order> list= new ArrayList<Order>();
        Order o1= new Order();
        o1.setId(new Long(100));
        o1.setOrderCode("code01");
        o1.setUserId(new Long(12));
        o1.setCreateTime(new Date());
        list.add(o1);

        model.addAttribute("list", list);
//        List<Order> orderList = orderService.getOrders();
        return "orderList";
    }

    @PostMapping("/order/search.action")
    public ModelAndView insertSong(@Valid Order order, BindingResult result){
        //@Valid注解启动后台校验,
        ModelAndView modelAndView = new ModelAndView();

        System.out.println("userId:"+ order.getUserId());

        if(result.hasErrors()){
            modelAndView.addObject("hintMessage", "出错啦！");
        }else{

            List<Order> orderList = orderService.getOrders();
//            orderList.forEach(t->System.out.println(t.toString()));

            modelAndView.addObject("orderList", orderList);
        }

        modelAndView.setViewName("order/list");

        return modelAndView;

    }

}
