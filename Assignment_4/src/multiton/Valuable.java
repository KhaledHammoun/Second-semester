package multiton;

import java.util.HashMap;
import java.util.Map;

public class Valuable
{
    private static Map<ValuableType, MinedValuable> valuables;

    static
    {
        valuables = new HashMap<>();
        createValuables();
    }

    private static void createValuables()
    {
        valuables.put(ValuableType.DIAMOND, new Diamond());
        valuables.put(ValuableType.GOLD_NUGGET, new GoldNugget());
        valuables.put(ValuableType.JEWEL, new Jewel());
        valuables.put(ValuableType.RUBY, new Ruby());
        valuables.put(ValuableType.WOODEN_COIN, new WoodenCoin());
    }

    public synchronized static MinedValuable getValuable()
    {
        return valuables.get(ValuableType.randomType());
    }
}
