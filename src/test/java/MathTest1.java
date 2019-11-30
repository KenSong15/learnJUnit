import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class MathTest1 {

    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void bfAll1(){
        System.out.println("before all here");
    }

    @BeforeEach
    void bfEach1(TestInfo testInfo, TestReporter testReporter){
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Running: " + testInfo.getDisplayName() + " with tag: "+ testInfo.getTags());
        System.out.println("before each here");
    }

    @AfterEach
    void afRach1(){
        System.out.println("after each here");
    }

    @AfterAll
    static  void afAll1(){
        System.out.println("after all here");
    }

    @Test
    @DisplayName("assertion tast1")
    void testcase1(){
        System.out.println("the testcase1 ran");
        assertEquals(1,1);
    }

    @Test
    @Disabled
    void testcase2(){
        System.out.println("the testcase2 ran");
        assertThrows(ArithmeticException.class,() ->{int i = 1/0;},"divided by 0 should throw");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testcase3(){
        System.out.println("the testcase3 ran");
        assertEquals(1,1);
    }

    @Test
    void testcase4(){
        Boolean serverUp = true;
        assumeTrue(serverUp);
        System.out.println("the testcase4 ran");
    }

    @Test
    void testcase5(){
        assertAll(()->{assertEquals(1,1);},
                ()->{assertEquals(2,2);});
        System.out.println("the testcase5 ran");
    }

    @Nested
    class nestedTest{
        @Test
        void testcase6(){
            System.out.println("the testcase6 ran");
        }

        @Test
        void testcase7(){
            System.out.println("the testcase7 ran");
            //fail("7");
        }
    }

    @RepeatedTest(3)
    @Tag("math")
    void testcase8(RepetitionInfo ri){
        System.out.println("the testcase8 ran: "+ri.toString());
    }

    @Test
    @Tag("math")
    void testcase9(){
        System.out.println("the testcase9 ran");
        testReporter.publishEntry("Running: " + testInfo.getDisplayName() + " with tag: "+ testInfo.getTags());
    }

    @Test
    void testcase10(){
        System.out.println("the testcase10 ran");
    }

}
