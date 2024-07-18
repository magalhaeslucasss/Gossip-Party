import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game. It is
 * connected to other rooms via exits. The exits are labelled north,
 * east, south, west. For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room {
    public String description;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * 
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
        Item vodka = new Item("vodka", 100, 0, false);
        Item doce = new Item("doce", 0, 20, true);
    }

    /**
     * verifica se o Npc mencionado é valido
     * 
     * @Param nome do npc a ser verificado
     */
    public boolean isInTheParty(String name) {
        for (Npc npc : Game.getAllNpcs()) {
            if (name.equals(npc.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna o nome dos outros nps para conversar,
     * por exemplo, "outros npcs: lillia, max".
     * 
     * @return Uma descrição das saídas disponíveis.
     */
    public static void getOthers() {
        System.out.println("outros fofoqueiros da festa: ");

        for (Npc npc : Game.getAllNpcs()) {
            if (!Game.getCurrentNpc().getName().equals(npc.getName()))
                System.out.println(npc.getName());
        }
    }

    /**
     * @return The description of the Npc.
     */
    public static String getLongDescription() {
        System.out.println("Você esta falando com: " + Game.getCurrentNpc().getName() + "\n: ");
        getOthers();
        return null;
    }
}
