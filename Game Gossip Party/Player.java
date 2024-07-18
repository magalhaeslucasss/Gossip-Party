public class Player {

    public static String name;
    private static int drunk;
    private static int hungry;
    public static Item leftHand;
    public static Item rightHand;
    

    public Player() {
        name = "";
        drunk = 0;
        hungry = 25;
        leftHand = null;
        rightHand = null;
    }
    
    public static boolean deuPT() {
        if(drunk > 150) {
            System.out.print("GAME OVER");
            System.out.print("Você bebeu demais, deu pt e foi espulso da festa pelos seguranças");
            return true;
        }
        
        return false;
    }
    
    //altera os valores de alcolismo do player
    public static void drunkUpLeftHand() {
        drunk += leftHand.getAlcohol();
    }

    public static void drunkUpRightHand() {
        drunk += rightHand.getAlcohol();
    }
    
    //altera is valores de fome do player
    public static void hungerDownRightHand() {
        hungry -= rightHand.getHungry();
    }

    public static void hungerDownLeftHand() {
        hungry -= leftHand.getHungry();
    }
    
    //atribui um item para mão
    public static void pickUpRight(Item item) {
        rightHand = item;
    }

    public static void pickUpLeft(Item item) {
        leftHand = item;
    }
    
    public static void takeItem(Item item) {
        if(Game.hand.equals("direita")) {
            rightHand = item;
        } else {
            leftHand = item;
        }
    }

    //retorna o valor de alcolismo
    public static int getDrunkValue() {
        return drunk;
    }
    
    public static void hungerUp() {
        hungry += 5;
    }
    
    public static void drunkDown() {
        drunk -= 5;
    }
    
    //retorna o valor de fome
    public static int getHungerValue() {
        return hungry;
    }

    //transforma em string o nome do item na mão
    public String getNameLeft()
    {
        return leftHand.getName();
    }
    
    public String getNameRight()
    {
        return rightHand.getName();
    }
    
    //printa as informações do personagem
    public void getInfo() {
        System.out.println(name);
        System.out.println(drunk);
        System.out.println(hungry);
        System.out.println(getNameLeft());
        System.out.println(getNameRight());
    }

}