package Cards;


import Cards.Propertys.Damaged;
import Cards.Propertys.Attacking;

public class Card {
    int manaCost;

    public static void dealDamage(Being dealer, Damaged ricipient){
        dealDamage(dealer.getCurrentAttack(), ricipient);
    }

    public static void dealDamage(int damage, Damaged ricipient){
        ricipient.setReceivedDamage(damage);
    }
}
