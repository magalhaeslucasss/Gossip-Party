public class Npc {
    private String name;
    private int drunk;
    private int hungry;
    public static boolean reciveQuestItem;
    public static String questItem;
    public static String history;
    public static boolean firstTime;

    public Npc(String name, int drunk, int hungry, String history, String questItem) {
        this.name = name;
        this.drunk = drunk;
        this.hungry = hungry;
        this.history = history;
        this.reciveQuestItem = false;
        this.firstTime = true;
        this.questItem = questItem;
    }
    
    public String getName()
    {
        return name;
    }
}
