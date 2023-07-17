package com.ohgiraffers.transactional.section01.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RegistOrderService {
    private MenuMapper mapper;
    private OrderMapper orderMapper;

    @Autowired
    public RegistOrderService(MenuMapper mapper,OrderMapper orderMapper){
        this.mapper = mapper;
        this.orderMapper = orderMapper;

    }
    @Transactional(rollbackFor = RuntimeException.class,
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT
    ) //propagation 속성 및 isolation 속성 공부
    // rollbackFor 런타임 오류가 발생하면 롤백시켜라
    //readonly -select 전용 객체만들때 속도가 빨라진다
    public void registNewOrder(OrderDTO orderInfo){
        List<Integer> menuCodes = orderInfo.getOrderMenus()
                .stream()
                .map(OrderMenuDTO::getMenuCode)
                .collect(Collectors.toList());

        System.out.println("menuCodes = "+menuCodes);

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("menuCodes",menuCodes);

        List<Menu> menus =mapper.findMenusByMenuCode(map);
        menus.forEach(System.out::println);

        int totalOrderPrice = calTotalOrderPrice(orderInfo.getOrderMenus(), menus);
        System.out.println("totalOrderPrice = " + totalOrderPrice);

        List<OrderMenu> orderMenus = orderInfo.getOrderMenus()
                                              .stream()
                                              .map(dto -> {
                                                return new OrderMenu(dto.getMenuCode(), dto.getOrderAmount());
                                              })
                                              .collect(Collectors.toList());

        Order order=new Order(orderInfo.getOrderDate(),orderInfo.getOrderTime(),totalOrderPrice,orderMenus);
        System.out.println("order = " + order);

        orderMapper.registOrder(order);

        System.out.println("order = " + order);

        int orderMenuSize = orderMenus.size();
        for (int i=0;i<orderMenuSize;i++){
            OrderMenu orderMenu=orderMenus.get(i);
            orderMenu.setOrderCode(order.getOrderCode());

            orderMapper.registOrderMenu(orderMenu);
        }
    }

    private int calTotalOrderPrice(List<OrderMenuDTO> orderMenus, List<Menu> menus) {
        int totalOrderPrice = 0;
        int orderMenuSize = orderMenus.size();
        for (int i=0;i<orderMenuSize;i++){
            OrderMenuDTO orderMenu=orderMenus.get(i);
            Menu menu = menus.get(i);

            totalOrderPrice +=menu.getMenuPrice() * orderMenu.getOrderAmount();
        }

        return totalOrderPrice;
    }

}
