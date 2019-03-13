package by.it.subach.project.java.dao;

import by.it.subach.project.java.dao.dbInit.Reset;

import java.sql.SQLException;

public class DAO {

    private volatile static DAO instance;

    public RoleDao role;
    public UserDao user;
    public CategoryDao category;
    public ProductDao product;
    public BlackListDao blackList;
    public CheckoutDao checkout;
    public OrderDao order;

    public void reset() throws SQLException {
        Reset.main(new String[0]);
    }



    private DAO() {
        role = new RoleDao();
        user = new UserDao();
        category = new CategoryDao();
        product = new ProductDao();
        blackList = new BlackListDao();
        checkout = new CheckoutDao();
        order = new OrderDao();

    }

    public static DAO getInstance(){
        if(instance == null){
            synchronized (DAO.class){
                if(instance == null){
                    instance = new DAO();
                }
            }
        }
        return instance;
    }
}
