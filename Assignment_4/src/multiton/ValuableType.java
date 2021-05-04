package multiton;

import java.util.List;
import java.util.Random;

public enum ValuableType
{
    DIAMOND,
    GOLD_NUGGET,
    JEWEL,
    WOODEN_COIN,
    RUBY;

    private static final List<ValuableType> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static ValuableType randomType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
