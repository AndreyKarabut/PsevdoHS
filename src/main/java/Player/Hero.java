package Player;

public class Hero {
    int currentHp;
    int buffHp;
    int startHp;
    int receivedDamage;
    int maxHp;

    int currentArmor;

    int currentAttack;
    int buffAttack;
    int startAttack;

    public void setMaxHp(){
        this.maxHp = this.startHp + this.buffHp;
    }

    public void setBuffHp(int plusbuffHp) {
        this.buffHp = this.buffHp + plusbuffHp;
        setCurrentHp(0, plusbuffHp, 0);
        setMaxHp();
    }

    public void setReceivedDamage(int plusReceivedDamage) {
        this.receivedDamage = this.receivedDamage + plusReceivedDamage;
        setCurrentHp(plusReceivedDamage, 0, 0);
    }

    public int getCurrentHp() {
        return currentHp;
    }

    private void setCurrentHp(int damage, int buffHp, int healHp) {
        if (damage > 0) {
            if (currentArmor > 0) {
                setCurrentArmor(0, damage);
            }
            this.currentHp = this.currentHp - damage;
        }
        if (buffHp > 0) {
            this.currentHp = this.currentHp + buffHp;
        }
        if (healHp > 0){
            if (this.currentHp + healHp >= this.maxHp){
                this.currentHp = this.maxHp;
            } else {
                this.currentHp = this.currentHp + healHp;
            }
        }
    }

    public void setCurrentArmor(int buffArmor, int damage){
        int extraDamage = this.currentArmor - damage;
        this.currentArmor = this.currentArmor + buffArmor - damage;
        setCurrentHp(extraDamage, 0, 0);
    }

    public void healMySelf(int healHp){
        setCurrentHp(0, 0 , healHp);
    }

    public boolean iAmDead(){
        return this.currentHp < 1;
    }

}
