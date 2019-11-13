package com.example.demo.phoenix.controller;

import com.example.demo.phoenix.entity.Order;
import com.example.demo.phoenix.entity.UserPay;
import com.example.demo.phoenix.service.OrderService;
import com.example.demo.phoenix.service.UserPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by hadoopuser on 11/2/19.
 */

@Controller
//@RequestMapping("/testBoot")
public class UserPayController {

    @Autowired
    private UserPayService userPayService;

    private final static Logger logger = LoggerFactory.getLogger(UserPayController.class);


    @RequestMapping(value = "/index")
    public ModelAndView getPaylist(@Valid UserPay userPay, BindingResult result){

        ModelAndView modelAndView = new ModelAndView();

//        System.out.println("userId:"+ userPay.getUserId());
//
//        if(result.hasErrors()){
//            modelAndView.addObject("hintMessage", "出错啦！");
//        }else{
//
//            Map<String, Object> map = new HashMap<>();
//            if(userPay.getUserId() !=null){
//                map.put("userId",userPay.getUserId());
//            }
//
//            List<UserPay> payList = userPayService.getPayList(map);
//
//            modelAndView.addObject("payList", payList);
//        }

        modelAndView.setViewName("pay/list");

        return modelAndView;
    }

    @PostMapping(value = "/search.action")
    public ModelAndView search(@Valid UserPay userPay, BindingResult result){

        ModelAndView modelAndView = new ModelAndView();

        System.out.println("userId:"+ userPay.getUserId());

        if(result.hasErrors()){
            modelAndView.addObject("hintMessage", "出错啦！");
        }else{

            Map<String, Object> map = new HashMap<>();
            if(userPay.getUserId() !=null && userPay.getUserId().length()!=0){
                map.put("userId",userPay.getUserId());
            }

            System.out.println("map params:"+map.toString());
            List<UserPay> payList = userPayService.getPayList(map);

            modelAndView.addObject("payList", payList);
        }

        modelAndView.setViewName("pay/list");

        return modelAndView;
    }
}
