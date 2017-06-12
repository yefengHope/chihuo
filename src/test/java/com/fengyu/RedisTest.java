// package com.fengyu;
//
// import org.apache.log4j.Logger;
// import org.junit.Assert;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.SpringApplicationConfiguration;
// import org.springframework.dao.DataAccessException;
// import org.springframework.data.redis.core.*;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
// import java.util.ArrayList;
// import java.util.List;
// import java.util.concurrent.*;
//
// /**
//  * <p>@Title 类标题描述 </p>
//  * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
//  * <p>@Version 1.0.0 版本号</p>
//  * <p>@author hanfeng</p>
//  * <p>@date 2017/3/7 16:56 创建日期</p>
//  * <p>hanfeng@dgg.com 作者的公司邮箱</p>
//  * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
//  */
// @RunWith(SpringJUnit4ClassRunner.class)
// @SpringApplicationConfiguration(ChihuoApplication.class)
// public class RedisTest {
//
//     private static Logger logger = Logger.getLogger(RedisTest.class);
//
//     @Autowired
//     private StringRedisTemplate stringRedisTemplate;
//
//     @Autowired
//     private RedisTemplate redisTemplate;
//
//     @Test
//     public void test() throws Exception {
//         stringRedisTemplate.opsForValue().set("aaa", "111");
//         logger.info(stringRedisTemplate.opsForValue().get("aaa"));
//         Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
//     }
//
//     /**
//      * 阻塞式
//      * @throws InterruptedException
//      * @throws ExecutionException
//      */
//     @Test
//     public void cas() throws InterruptedException, ExecutionException {
//         String key = "test-cas-1";
//         ValueOperations<String, String> strOps = redisTemplate.opsForValue();
//         strOps.set(key, "hello");
//         ExecutorService pool  = Executors.newCachedThreadPool();
//         List<Callable<Object>> tasks = new ArrayList<>();
//         logger.info("***********************");
//         for(int i=0;i<5;i++){
//             final int idx = i;
//             tasks.add(new Callable() {
//                 @Override
//                 public Object call() throws Exception {
//                     return redisTemplate.execute(new SessionCallback() {
//                         @Override
//                         public Object execute(RedisOperations operations) throws DataAccessException {
//                             operations.watch(key);
//                             String origin = (String) operations.opsForValue().get(key);
//                             operations.multi();
//                             operations.opsForValue().set(key, origin + idx);
//                             Object rs = operations.exec();
//                             logger.info("set  key:" + key + " value:" + origin+idx+" rs:"+rs);
//                             return rs;
//                         }
//                     });
//                 }
//             });
//         }
//         logger.info("***********************");
//         List<Future<Object>> futures = pool.invokeAll(tasks);
//         for(Future<Object> f:futures){
//             logger.info(f.get());
//         }
//         pool.shutdown();
//         pool.awaitTermination(1000, TimeUnit.MILLISECONDS);
//
//         logger.info(key + ":" + redisTemplate.opsForValue().get(key));
//     }
//
//     @Test
//     public void testObj() throws Exception {
//         // User user = new User("aa@126.com", "aa", "aa123456", "aa", "123");
//         // ValueOperations<String, User> operations = redisTemplate.opsForValue();
//         // operations.set("com.neox", user);
//         // operations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
//         // Thread.sleep(1000);
//         // //redisTemplate.delete("com.neo.f");
//         // boolean exists = redisTemplate.hasKey("com.neo.f");
//         // if (exists) {
//         //     System.out.println("exists is true");
//         // } else {
//         //     System.out.println("exists is false");
//         // }
//         // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
//     }
// }
//
