package by.it.subach.jd03_03;

import by.it.subach.jd03_03.beans.*;
import by.it.subach.jd03_03.dao.DAO;

import java.sql.SQLException;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) throws SQLException {
        C_Reset.resetDB();
        C_Init.initDB();
        DAO dao = DAO.getInstance();
        User user = new User();
        user.setRole_id(1);
        if(dao.user.create(user)){
            System.out.println("Create OK " + user);
        }
        user.setLogin("TestLogin");
        if(dao.user.update(user)){
            System.out.println("Update OK " + user);
        }
        user = dao.user.read(user.getId());
        if(user != null){
            System.out.println("Read OK " + user);
        }
        if(dao.user.delete(user)){
            System.out.println("Delete OK " + user);
        }

        System.out.println("===============================role===================================");
        Role role = new Role();
        if(dao.role.create(role)) {
            System.out.println("Create OK: " + role);
        }
        role.setRole("testRole");
        if(dao.role.update(role))
            System.out.println("Update OK: " + role);
        role = dao.role.read(role.getId());
        if(role != null)
            System.out.println("Read OK: " + role);
        if(dao.role.delete(role))
            System.out.println("Delete OK: " + role);

        System.out.println("===============================category===================================");
        Category category = new Category();
        if(dao.category.create(category)) {
            System.out.println("Create OK: " + category);
        }
        category.setName("testName");
        category.setDescription("testDescription");
        if(dao.category.update(category))
            System.out.println("Update OK: " + category);
        category = dao.category.read(category.getId());
        if(category != null)
            System.out.println("Read OK: " + category);
        if(dao.category.delete(category))
            System.out.println("Delete OK: " + category);

        System.out.println("===============================product===================================");
        Product product = new Product();
        product.setCategories_id(1);
        System.out.println(product);
        product.setDescription("testDescription");
        System.out.println(product);

        if(dao.product.create(product)) {
            System.out.println("Create OK: " + product);
        }
        product.setName("testName");
        System.out.println(product);
        product.setPrice(20.00);
        System.out.println(product);

        if(dao.product.update(product))
            System.out.println("Update OK: " + product);
        product = dao.product.read(product.getId());
        if(product != null)
            System.out.println("Read OK: " + product);
        if(dao.product.delete(product))
            System.out.println("Delete OK: " + product);


        System.out.println("===============================blacklist===================================");
        BlackList blackList = new BlackList();
        System.out.println(blackList);
        blackList.setUser_id(1);
        if(dao.blackList.create(blackList)) {
            System.out.println("Create OK: " + blackList);
        }
        if(dao.blackList.update(blackList))
            System.out.println("Update OK: " + blackList);
        blackList = dao.blackList.read(blackList.getId());
        if(blackList != null)
            System.out.println("Read OK: " + blackList);
        if(dao.blackList.delete(blackList))
            System.out.println("Delete OK: " + blackList);

        System.out.println("===============================checkout===================================");
        Checkout checkout = new Checkout();
        System.out.println(checkout);
        checkout.setOrder_id(1);
        if(dao.checkout.create(checkout)) {
            System.out.println("Create OK: " + checkout);
        }
        if(dao.checkout.update(checkout))
            System.out.println("Update OK: " + checkout);
        checkout = dao.checkout.read(checkout.getId());
        if(checkout != null)
            System.out.println("Read OK: " + checkout);
        if(dao.checkout.delete(checkout))
            System.out.println("Delete OK: " + checkout);

        System.out.println("===============================order===================================");
        Order order = new Order();
        System.out.println();
        order.setProduct_id(1);
        order.setUser_id(2);
        if(dao.order.create(order)) {
            System.out.println("Create OK: " + order);
        }
        if(dao.order.update(order))
            System.out.println("Update OK: " + order);
        order = dao.order.read(order.getId());
        if(order != null)
            System.out.println("Read OK: " + order);
        if(dao.order.delete(order))
            System.out.println("Delete OK: " + order);

    }



}
