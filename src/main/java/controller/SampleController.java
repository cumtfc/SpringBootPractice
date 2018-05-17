package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SampleService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SampleController {
    @Autowired
    SampleService sampleService;


    @RequestMapping("/")
    String home(HttpServletRequest request) {
        request.setAttribute("msg","hello th");
        return "/index";
    }

    @RequestMapping("/testJPA")
    @ResponseBody
    String testJPA(String info) {
        return sampleService.testJPA();
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