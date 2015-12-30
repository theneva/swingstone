package com.swinghearthstone;

import com.swinghearthstone.model.game.minion.Minion;
import com.swinghearthstone.util.ArrayHelper;

import java.util.List;

public class MinionRepository
{
    private final List<Minion> minions = ArrayHelper.asList(
            new Minion("Wisp", 1, 1, 0),
            new Minion("Spider Tank", 3, 4, 3),
            new Minion("Chillwind Yeti", 4, 5, 4)
    );

    public List<Minion> findAll()
    {
        return minions;
    }
}
