package service;

import domain.CourseRepository;
import domain.DepartmentRepository;
import domain.UserRepository;
import entity.Course;
import entity.Department;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@EnableCaching
public class SampleService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    CourseRepository courseRepository;
    @Transactional
    public List<User> testJPA(){
        return userRepository.findAll();
    }

    public String testRedis(){
        System.out.println(123);
//        redisTemplate.opsForValue().set("testKey","redis hello world");
        Map<String,String> map = new HashMap<>();
        map.put("testKey", "redis hello world");
        redisTemplate.opsForValue().set("testKey",map);
        map = (Map<String, String>) redisTemplate.opsForValue().get("testKey");
        return map.get("testKey");
    }
    @Cacheable(cacheNames = "testAutoCache")
    public String testAutoCache(String test){
        System.out.println(111);
        return "this is test of autoCache";
    }
}
