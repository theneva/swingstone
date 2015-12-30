package com.swinghearthstone.model.game.minion;

public class Minion
{
    public final String name;
    public final int attack;
    public final int health;
    public final int cost;

    public Minion(final String name, final int attack, final int health, final int cost)
    {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.cost = cost;
    }
}
