package jp.ac.uryukyu.ie.e175742;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing(String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    public boolean isDead() {
        return dead;
    }

    public String getName() {
        return name;
    }

    public void attack(LivingThing opponent) {
        int damage = (int) (Math.random() * attack);
        if (dead) {
            damage = 0;
        } else {
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    public int getHitPoint(){
        return hitPoint;
    }

    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    public int getAttack(){
        return attack;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public boolean getDead(){
        return dead;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }

    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
