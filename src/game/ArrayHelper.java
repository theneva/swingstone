package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayHelper
{
    @SafeVarargs
    public static <T> List<T> asList(final T... items)
    {
        return new ArrayList<>(Arrays.asList(items));
    }
}
