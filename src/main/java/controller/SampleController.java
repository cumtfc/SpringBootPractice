package controller;

import domain.DepartmentRepository;
import domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SampleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SampleController {

    @Autowired
    SampleService sampleService;

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    String home(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("msg", "hello th");
        request.setAttribute("allProducts", sampleService.testJPA());
        return "/index";
    }

    @RequestMapping("/testPathVariable/{string}")
    @ResponseBody
    String testPathVariable(@PathVariable String string) {
        return string;
    }

    @RequestMapping("/testRequestParam")
    @ResponseBody
    String testRequestParam(@RequestParam String info) {
        return info;
    }

    @RequestMapping("/testAutoRequestParam")
    @ResponseBody
    String testAutoRequestParam(String info) {
        return info;
    }
}