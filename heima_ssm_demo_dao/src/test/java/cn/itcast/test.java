package cn.itcast;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    @Test
    public  void test(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductDao bean = app.getBean(ProductDao.class);
        List<Product> productList = bean.findAll();
        System.out.println(productList);
    }
}
