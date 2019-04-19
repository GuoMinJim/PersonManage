import cn.pzhu.pserson.PsersonApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = PsersonApplication.class)
@RunWith(SpringRunner.class)
public class TestRedisConnection {


  @Autowired
  RedisTemplate redisTemplate;


  @Test
  public void testReid(){
    redisTemplate.opsForValue().set("1","1");
    System.out.println(redisTemplate.opsForValue().get("1"));
  }

}
