package com.swinghearthstone.model.game;

import com.swinghearthstone.model.game.hero.Hero;
import com.swinghearthstone.model.game.minion.Minion;

@FunctionalInterface
public interface MinionAttackedHeroCallback
{
    void apply(Minion attacker, Hero target);
}
