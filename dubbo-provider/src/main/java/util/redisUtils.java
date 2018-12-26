package util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class redisUtils {
    private static String address="127.0.0.1";

    private static int port=6379;

    private static String auth="123456";

    private static int MAX_ACTIVE=1024;

    private static int MAX_WAIT=10000;

    private static int MAX_IDLE=200;

    private static int TIMEOUT=10000;

    private static boolean TEST_ON_BORROW=true;

    private static JedisPool jedisPool=null;

    static {
        try{
            JedisPoolConfig config=new JedisPoolConfig();
            config.setMaxIdle(MAX_IDLE);
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool=new JedisPool(config,address,port,TIMEOUT,null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized static Jedis getJedis(){
        try{
            if(jedisPool!=null){
                Jedis resource=jedisPool.getResource();
                return  resource;
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
