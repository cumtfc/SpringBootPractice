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

        for (User user : userRepository.findAll()) {
            System.out.println(user.getDepartment().getDepartmentName());
        }

        for (Department department1 : departmentRepository.findAll()) {
            for (User user : department1.getUserSet()) {
                System.out.println(user.getUserSn());
            }
        }
    }

    @Test
    public void testUserToSeat(){
        User user1 = new User("u1", "fengchu", 18, null);
        Account account1 = new Account();
        account1.setAccountNum(21L);
        user1.setAccount(account1);
//        userRepository.save(user1);
        accountRepository.save(account1);
//        System.out.println(accountRepository.findAll().get(0).getUser());
//        account1.setAccountNum(154545515);
//        userRepository.delete(user1);

    }

}
