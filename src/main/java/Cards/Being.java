package Cards;

import Cards.Propertys.Damaged;
import Cards.Propertys.TypeBeing;

import java.util.ArrayList;

public class Being extends Card implements Damaged {

    int currentHp;
    int buffHp;
    int startHp;
    int receivedDamage;
    int maxHp;

    int currentAttack;
    int buffAttack;
    int startAttack;

    ArrayList<TypeBeing> typeBeings;

    //standart skills
    boolean taunt;
    boolean poison;
    boolean divineShield;
    boolean rush;
    boolean charge;
    boolean liveSteal;
    boolean magnetic;
    boolean windFury;
    boolean targetedBySpell;
    boolean targetedByHeroPowers;
    boolean targetedByBeing;
    int spellDamage;

    public void battleCry(){}

    public void deathRattle(){}

    public void setMaxHp(){
        this.maxHp = this.startHp + this.buffHp;
    }

    public void setBuffHp(int plusbuffHp) {
        this.buffHp = this.buffHp + plusbuffHp;
        setCurrentHp(0 , plusbuffHp,0);
        setMaxHp();
    }

    public void setReceivedDamage(int plusReceivedDamage) {
        this.receivedDamage = this.receivedDamage + plusReceivedDamage;
        setCurrentHp(plusReceivedDamage, 0, 0);
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int damage, int buff, int heal) {
        if (damage > 0){
            this.currentHp = this.currentHp - damage;
        }
        if (buff > 0){
            this.currentHp = this.currentHp + buff;
        }
        if (heal > 0){
            if (this.currentHp + heal >= this.maxHp){
                this.currentHp = this.maxHp;
            } else {
                this.currentHp = this.currentHp + heal;
            }
        }
    }

    public int getCurrentAttack() {
        return currentAttack;
    }

    public void setCurrentAttack(int currentAttack) {
        this.currentAttack = currentAttack;
    }

    public static boolean iAmDead(Being being){
        return being.currentHp < 1;
    }

}
