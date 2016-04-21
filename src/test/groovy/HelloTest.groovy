import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals

/**
 * Created by dmytro.lamashevskyi on 21.04.2016.
 */

class HelloTest {
    Hello hello

    @Before void setUp(){
        hello = new Hello()
    }

    @Test void 'zero returns zero'(){
        assertEquals "Should be zero", 0, hello.zero()
    }
}
