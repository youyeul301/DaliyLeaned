package com.ohgiraffers.section01.xmlconfig;


import java.util.List;
import java.util.Map;

public class MenuController {

    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController(){
        printResult=new PrintResult();
        menuService=new MenuService();
    }

    public void findAllMenus() {
        List<MenuDTO> menus = menuService.findAllMenus();

        if (menus !=null){
            printResult.printMenus(menus);
        }else {
            printResult.printErrorMessage("findAllMenus");
        }
    }

    public void findMenuByMenuCode(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menuDTO=menuService.findMenuByMenuCode(menuCode);

        if (menuDTO != null) {
            printResult.printMenu(menuDTO);
        }else {
            printResult.printErrorMessage("findMenusByMenuCode");
        }

    }

    public void registMenu(Map<String, String> parameter) {
        String menuName=parameter.get("menuName");
        int menuPrice=Integer.parseInt(parameter.get("menuPrice"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setMenuName(menuName);
        menuDTO.setMenuPrice(menuPrice);
        menuDTO.setCategoryCode(categoryCode);

        if(menuService.registMenu(menuDTO)){
            printResult.printSuccessMessage("regist");
        }else {
            printResult.printErrorMessage("regist");
        }
    }

    public void modifyMenu(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode"));
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.parseInt(parameter.get("menuPrice"));

        MenuDTO menuDTO=new MenuDTO();
        menuDTO.setMenuCode(menuCode);
        menuDTO.setMenuName(menuName);
        menuDTO.setMenuPrice(menuPrice);

        if(menuService.modifyMenu(menuDTO)){
            printResult.printSuccessMessage("modify");
        }else {
            printResult.printErrorMessage("modify");
        }
    }

    public void removeMenu(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode"));


        if(menuService.removeMenu(menuCode)){
            printResult.printSuccessMessage("remove");
        }else {
            printResult.printErrorMessage("remove");
        }
    }
}
