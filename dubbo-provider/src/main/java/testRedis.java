import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import util.redisUtils;

import javax.ws.rs.core.Context;
import java.util.HashMap;
import java.util.Map;

public class testRedis {

    private static Jedis jedis= redisUtils.getJedis();

    public void addString(){
        jedis.set("string1","redisString1");
        System.out.println(jedis.get("string1"));

        jedis.set("string2","redisString2");
        System.out.println(jedis.get("string2"));

        jedis.set("string3","redisString3");
        System.out.println(jedis.get("string3"));


        jedis.set("string4","redisString4");
        System.out.println(jedis.get(jedis.get("string4")));

        jedis.mset("mset1","mvalue1","mset2","mvalue2","mset3","mvalue3","mset4","mvalue4","mset5","mvalue5");
        System.out.println(jedis.get("mset1")+"--"+jedis.get("mset2")+"--"+jedis.get("mset3"));


        jedis.del("mset1");
        System.out.println(jedis.get("mset1"));
    }

    public void addMap(){
//        Map<String,Object> map=new HashMap<>();
//        map.put("map1",1);
//        map.put("map2",true);
//        map.put("map3","mapString");
//        map.put("map5",'c');
        Map<String,String> map=new HashMap<>();
        map.put("map1","1");
        map.put("map2","2");
        map.put("map3","3");
        map.put("map5","5");

        jedis.hmset("mapredis",map);

//        byte b=0;//1字节
//        short s=0;//2字节
//        int i=0;//4字节
//        long l=0L;//8字节
//        double d=0.0d;//4字节
//        float f=0.0f;//8字节
//        char c='3';//2字节
//        boolean bl=true;//1/8字节
    }

    public static void main(String[] args) {
        testRedis t=new testRedis();
        t.addString();
        t.addMap();
    }
}
