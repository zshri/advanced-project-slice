package com.example.blogservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//@SpringBootTest
class BlogServiceApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void test1(){

       int  a = 1;

       int b = 1;

       if (a == b) {
           System.out.println(a + b);
       }

        Assertions.assertEquals(a, b);



    }
}
