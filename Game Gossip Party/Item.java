
/**
 * Escreva uma descrição da classe Items aqui.
 * 
 * @author (seu nome)
 * @version (um número da versão ou uma data)
 */
public class Item {
    private int alcohol;
    private int hungry;
    private boolean comida;
    private String name;
    
    public Item(String name, int alcohol, int hungry, boolean comida) {
        this.name = name;
        this.alcohol = alcohol;
        this.hungry = hungry;
        this.comida = comida;
    }
    
    public int getAlcohol()
    {
        return alcohol;
    }
    
    public int getHungry()
    {
        return hungry;
    }
    
    public boolean isComida() {
        return comida;
    }
    
    public String getName()
    {
        return name;
    }
}
