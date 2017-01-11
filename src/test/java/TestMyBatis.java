import cn.libra.dao.IUserMapper;
import cn.libra.domain.User;
import org.apache.log4j.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by clam on 2017/1/11.
 */

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMyBatis {
    @Test
    public void test2(){

    }

    private static Logger logger = Logger.getLogger(TestMyBatis.class);
    //  private ApplicationContext ac = null;

    @Autowired
    private IUserMapper userMapper = null;

//  @Before
//  public void before() {u
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//      userService = (IUserService) ac.getBean("userService");
//  }

    @Test
    public void test1() {
        User u = new User();
        u.setName("test");
        u.setAge(20);
        Integer id = userMapper.insert(u);
        logger.info(id);
        User user = userMapper.selectByPrimaryKey(1);
       logger.info("test");
        // System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());
        //logger.info(JSON.toJSONString(user));
    }
}
