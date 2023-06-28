package hshri;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MainTest {




    @PersistenceContext
    EntityManager entityManager;


    @Test
    public void test1() throws IOException {


        StringTokenizer t = new StringTokenizer("name");

        System.out.println(t.nextToken());

    }

    @Test
    public void test2() throws IOException {

        entityManager.toString();

    }



}
