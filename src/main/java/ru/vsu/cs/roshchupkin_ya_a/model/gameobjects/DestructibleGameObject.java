package ru.vsu.cs.roshchupkin_ya_a.model.gameobjects;

public abstract class DestructibleGameObject extends GameObject {
    protected int hp;

    public DestructibleGameObject(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
