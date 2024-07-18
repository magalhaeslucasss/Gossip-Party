
/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game. Users
 * can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 * 
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initialises all the others: it creates all
 * rooms, creates the parser and starts the game. It also evaluates and
 * executes the commands that the parser returns.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Parser parser;
    public static Npc currentNpc;
    public static final ArrayList<Npc> allNpcs = new ArrayList<Npc>();
    public static final ArrayList<Item> allItems = new ArrayList<Item>();
    private CommandWords commandWords;
    public static Npc segurança;
    public static Npc Lilia;
    public static Npc Max;
    public static Npc Steven;
    public static Npc Trixie;
    public static Npc Michael;
    public static Npc Elio;
    public static Npc Barman;
    public static String hand;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createRooms();
        createNpc();
        createItems();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */

    private void createRooms() {
        Room salaDaFesta;
        salaDaFesta = new Room("Sala da festa");
    }

    private void createNpc() {
        segurança = new Npc("Jão", 0, 0, "história q o npc vai contar", "questItem");
        Lilia = new Npc("Lilia", 0, 0, "Humm sei que foi depois do lanche coletivo do Conectividade e o Michael e a Trixie estavam lá. Ai mona então tá, eu só vou falar isso pq eu não sou fofoqueira.", "questItem");
        Max = new Npc("Max", 0, 0, "história q o npc vai contar", "questItem");
        Steven = new Npc("Steven", 0, 0, "Então... eu só sei que foi aqui no IFMG.Tenta perguntar pra mais alguém.", "Xeque-Mate");
        Trixie = new Npc("Trixie", 0, 0, "Eu vi duas senhoras descendo do 4° andar enquanto o lanche estava acontecendo. Mas não sei quem são.", "questItem");
        Michael = new Npc("Michael", 0, 0, " Eu vi o Max descendo do 4° andar depois que o lanche acabou.", "questItem");
        Elio = new Npc("Elio", 0, 0, " O que eu sei é que alguém ganhou uma Skin caríssima no LOL.", "questItem");
        Barman = new Npc("Barman", 0, 0, "Boa noite! O que vai querer pedir?", "questItem");
        
        allNpcs.add(Elio);
        allNpcs.add(Michael);
        allNpcs.add(Trixie);
        allNpcs.add(Steven);
        allNpcs.add(Max);
        allNpcs.add(Lilia);
        allNpcs.add(segurança);
        allNpcs.add(Barman);
        currentNpc = segurança;
    }

    private void createItems() {
        Item Vodka = new Item ("Vodka",25,0,false);
        Item Caipirinha = new Item ("Caipirinha",18,0,false);
        Item XequeMate = new Item ("Xeque-Mate",13,0,false);
        Item Doritos = new Item ("Doritos",0,20,true);
        Item Bolo = new Item ("Bolo",0,25,true);
        
        allItems.add(Vodka);
        allItems.add(Caipirinha);
        allItems.add(XequeMate);
        allItems.add(Doritos);
        allItems.add(Bolo);
    }
    
    public static ArrayList<Npc> getAllNpcs() {
        return allNpcs;
    }

    public static Npc getCurrentNpc() {
        return currentNpc;
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() throws InterruptedException {
        Interact.interact();
        
        //Enter the main command loop. Here we repeatedly read commands and
        //execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    public String printNpcsInfo() {
        return Room.getLongDescription();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * 
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) throws InterruptedException {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();

        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            goNpc(command);
            Player.drunkDown();
            Player.hungerUp();
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        } else if (commandWord.equals("look")) {
            look();
        } else if (commandWord.equals("take")) {
            Scanner Scan = new Scanner(System.in);
            

            System.out.println("\tVocê quer pegar o item com qual mão?");
            System.out.println("\t>");
            hand = Scan.nextLine();
            
            boolean pegouItem = false;
            for(Item item : allItems) {
                if(Command.getSecondWord().equals(item.getName())) {
                    Player.takeItem(item);
                    pegouItem = true;
                }
            }
            if(!pegouItem) {
                System.out.println("O item não existe ou o nome digitado está incorreto. Tente novamente.");
            }
        } else if (commandWord.equals("drink")) {
            Scanner Scan = new Scanner(System.in);
            String hand;

            System.out.println("\tVocê quer consumir o item de qual mão?");
            System.out.println("\t>");
            hand = Scan.nextLine();

            drink(hand);
        } else if (commandWord.equals("eat")) {
            Scanner Scan = new Scanner(System.in);
            String hand;

            System.out.println("\tVocê quer consumir o item de qual mão?");
            System.out.println("\t>");
            hand = Scan.nextLine();

            eat(hand);
        } else if (commandWord.equals("back")) {
            back();
        }
        if (Player.deuPT()) {
            wantToQuit = Player.deuPT();
        }
        return wantToQuit;
    }
    

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        CommandWords.getComands();
    }

    /**
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goNpc(Command command) throws InterruptedException {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String Npc = command.getSecondWord();
        Npc nextNpc = null;

        for (Npc npc : allNpcs) {
            String nome = npc.getName();
            if (nome.equals(Npc)) {
                nextNpc = npc;
            }
        }
        currentNpc = nextNpc;
        printNpcsInfo();
        System.out.println();
        Interact.interact();
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * 
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
          if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true; // signal that we want to quit
        }
    }

    /**
     * printa as informaões de todos os Npcs ao redor
     */
    public void look() {
        printNpcsInfo();
    }

    /**
     * bebe um item de alguma das mãos
     * caso ambas sejam drinks, apresenta a opção de escolha para o jogador
     * 
     */
    public void drink(String mão) {
        if (mão.equals("direita")) {
            drinkRightHand();
        } else if (mão.equals("esquerda")) {
            drinkLeftHand();
        } else {
            System.out.println("insira 'direita' ou 'esquerda' para escolher o drink");
        }
    }

    public void drinkLeftHand() {
        if (Player.leftHand.isComida()) {
            System.out.println("esta mão não carrega uma bebida!");
        } else {
            Player.drunkUpLeftHand();
            System.out.println("você bebeu: " + Player.rightHand.getName() + "seu nivel de alcolizado agora é: "
                    + Player.getDrunkValue());
        }
    }

    public void drinkRightHand() {
        if (Player.rightHand.isComida()) {
            System.out.println("esta mão não carrega uma bebida!");
        } else {
            Player.drunkUpRightHand();
            System.out.println("você bebeu: " + Player.leftHand.getName() + "seu nivel de alcolizado agora é: "
                    + Player.getDrunkValue());
        }
    }

    public void eat(String mão) {
        if (mão.equals("direita")) {
            eatRightHand();
        } else if (mão.equals("esquerda")) {
            eatLeftHand();
        } else {
            System.out.println("insira 'direita' ou 'esquerda' para escolher a comida");
        }
    }

    public void eatRightHand() {
        if (Player.rightHand.isComida()) {
            Player.hungerDownRightHand();
            System.out.println("você comeu: " + Player.leftHand.getName() + "seu nivel de fome agora é: "
                    + Player.getHungerValue());
        } else {
            System.out.println("esta mão não carrega uma comida!");
        }
    }

    public void eatLeftHand() {
        if (Player.leftHand.isComida()) {
            Player.hungerDownLeftHand();
            System.out.println("você comeu: " + Player.leftHand.getName() + "seu nivel de fome agora é: "
                    + Player.getHungerValue());
        } else {
            System.out.println("esta mão não carrega uma comida!");
        }
    }

    public void back() {
        if (allNpcs.size() > 0) {
            currentNpc = allNpcs.get(allNpcs.size() - 1);
            allNpcs.remove(allNpcs.size() - 1);
        } else {
            System.out.println("You are in the game's starting room.");
        }
        //printNpcsInfo();
    }
}
