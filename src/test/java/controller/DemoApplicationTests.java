package controller;

import Application.DemoApplication;
import domain.AccountRepository;
import domain.DepartmentRepository;
import domain.UserRepository;
import entity.Account;
import entity.Department;
import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    AccountRepository accountRepository;
    @Test
    public void contextLoads() {

    }

    @Test
    @Transactional
    public void testUserToDepartment(){
        Department department = new Department();
        department.setDepartmentName("testDepartment");
        department.setDepartmentSn("testSn");
        User user1 = new User("u1", "fengchu", 18, department);
        User user2 = new User("u2", "fengchuchu", 8, department);
        Set<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);
//        userRepository.saveAll(users);
        department.setUserSet(users);
        departmentRepository.save(department);
        department.setUserSet(null);
        departmentRepository.save(department);
    }

    @Test
    public void testOneToOne(){
        User user1 = new User("u1", "fengchu", 18, null);
        Account account1 = new Account();
        account1.setAccountNum(21L);
        user1.setAccount(account1);
//        userRepository.save(user1);
        account1.setUser(user1);
        accountRepository.save(account1);
//        System.out.println(accountRepository.findAll().get(0).getUser());
        account1.setAccountNum(154545515L);
        accountRepository.save(account1);
//        userRepository.delete(user1);

    }

    @Test
    public void testSaveManyObject(){
        Department department = new Department();
        department.setDepartmentSn("testdepartasdasda");
        department.setDepartmentName("cesasda");
        User user1 = new User("u1", "fengchu", 18, department);
        User user2 = new User("u2", "fengchu", 18, department);
        User user3 = new User("u3", "fengchu", 18, department);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }

}
