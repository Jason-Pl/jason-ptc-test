import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ArrayServiceControllerTest {

    public static List<Integer> list;

    @Before
    public void init(){
        list = Arrays.asList(1,2,3,4,5);
    }

    
    @Test
    public void checkReturnEmptyListOnEmptyListParam(){
        list = new ArrayList<>();
        
        List<List<Integer>> result = ArrayService.partition(list,2);
        assertEquals(1,result.size());
    }

    @Test
    public void checkReturnListOnEmptySizeParam(){
        List<List<Integer>> result = ArrayService.partition(list,0);
        assertEquals(1,result.size());
    }

    @Test
    public void checkReturnEmptyListOnEmptySizeAndListParam(){
        list = new ArrayList<>();

        List<List<Integer>> result = ArrayService.partition(list,0);
        assertEquals(1,result.size());
    }

    @Test
    public void checkifSublistEqualsSize(){
        List<List<Integer>> result = ArrayService.partition(list,2);
        assertEquals(2,result.get(0).size());
    }

    @Test
    public void checkifSizeGreaterThanListSize(){
        List<List<Integer>> expected = Arrays.asList(list);
        List<List<Integer>> result = ArrayService.partition(list,6);
        assertEquals(expected,result);
    }

    @Test
    public void test1(){
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4),Arrays.asList(5));
        List<List<Integer>> result = ArrayService.partition(list,2);
        assertEquals(expected, result);
    }

    @Test
    public void test2(){
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5));
        List<List<Integer>> result = ArrayService.partition(list,3);
        assertEquals(expected, result);
    }

    @Test
    public void test3(){
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1,2,3,4),Arrays.asList(5));
        List<List<Integer>> result = ArrayService.partition(list,4);
        assertEquals(expected, result);
    }
}
