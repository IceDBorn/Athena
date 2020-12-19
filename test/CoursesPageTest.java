/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author IceDBorn
 */
public class CoursesPageTest {
    
    public CoursesPageTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class CoursesPage.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        CoursesPage.main(null);
    }

    @Test
    public void testCoursesPage() {
        System.out.println("CoursesPage");
        CoursesPage test = new CoursesPage(null, null, null);
        fail("Failed");
    }


    
}
