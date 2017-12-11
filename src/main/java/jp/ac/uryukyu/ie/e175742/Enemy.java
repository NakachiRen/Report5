package jp.ac.uryukyu.ie.e175742;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing {

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     *
     * @param name      モンスター名
     * @param maximumHP モンスターのHP
     * @param attack    モンスターの攻撃力
     */
    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    int HP = getHitPoint();

    @Override
    public void attack(LivingThing opponent) {
        int damage = (int) (Math.random() * getAttack());
        double persent = (Math.random());
        if (!isDead()) {
            if (damage == 0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n",getName(), opponent.getName());
            } else if (persent < 0.3) {
                int tukon_no_ichigeki = damage * 2;
                System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n",getName(), opponent.getName(),tukon_no_ichigeki);
                opponent.wounded(tukon_no_ichigeki);
            } else {
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n",getName(), opponent.getName(), damage);
                opponent.wounded(damage);
            }
        }
    }

    public void wounded(int damage) {
        HP -= damage;
        if (HP < 0) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }
}
