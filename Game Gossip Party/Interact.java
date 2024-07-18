import java.util.Scanner;

public class Interact
{
    public Interact () {
        
    }
    
    public static void interact() throws InterruptedException {
       String nome = "";
       
       if(Game.segurança.equals(Game.currentNpc)) {
           Scanner Scan = new Scanner(System.in);
           Janela janela = new Janela();
           System.out.println("Bem vindo a Gossip Party");
           System.out.println("Digite seu nome: ");
           nome = Scan.nextLine();
           System.out.printf("\nOK Sr(a) %s, aproveite a festa!!\n", nome);
           Player.name = nome;
           Game.allNpcs.remove(Game.segurança);
       } else if(Game.Max.equals(Game.currentNpc)) {
           System.out.println("funciona Max");
           
       } else if(Game.Steven.equals(Game.currentNpc)) {
           if(Game.Steven.firstTime) {
               System.out.printf("\nSteven: Oi %s, c tá bom?\n",Player.name);
               Thread.sleep(1500);
               System.out.printf("\n%s: Tô bom meu templário. E você? \n", Player.name);
               Thread.sleep(1500);
               System.out.printf("\n%s: Fiquei sabendo que tem uma fofoca aqui no IF. Sabe de alguma coisa? \n", Player.name);
               Thread.sleep(1500);
               System.out.print("\nSteven: Tô bem. Soube sim, mas primeiro pega um Xeque Mate pra mim e te conto o que eu sei.\n");
               Game.Steven.firstTime = false;
               
           } else {
               if(Player.rightHand.getName().equals("Xeque-Mate")) {
                   Player.rightHand = null;
                   System.out.printf("\n%s: Tá aqui o seu Xeque Mate. Me conta aí o que sabe.\n", Player.name);
                   System.out.println("\nSteven: Eu vi o Max descendo do 4° andar depois que o lanche acabou.");
                   Thread.sleep(1500);
                   System.out.println("Steven: Mas é só isso que eu sei...\n");
                   
               } else if(Player.leftHand.getName().equals("Xeque-Mate")) {
                   Player.leftHand = null;
                   System.out.println("Steven: Tá aqui o seu Xeque Mate. Me conta aí o que sabe.\n");
                   System.out.println("\nSteven: Eu vi o Max descendo do 4° andar depois que o lanche acabou.");
                   Thread.sleep(1500);
                   System.out.println("Steven: Mas é só isso que eu sei...\n");
                   
               } else {
                   System.out.println("Steven: Nada de informações antes do meu Xeque Mate HAHAHAHA...\n");
                   
               }
           }
           
       } else if(Game.Trixie.equals(Game.currentNpc)) {
           System.out.println("funciona Trixie");
           
       } else if(Game.Michael.equals(Game.currentNpc)) {
           System.out.println("funciona Michael");
           
       } else if(Game.Elio.equals(Game.currentNpc)) {
           System.out.println("funciona Elio");
           
       } else if (Game.Lilia.equals(Game.currentNpc)) {
           System.out.println("funciona Lilia");
           
       } else if (Game.Barman.equals(Game.currentNpc)) {
           System.out.println("Boa noite! O que vai querer pedir?");
           Thread.sleep(1000);
           System.out.println("Escolha algum item do cardápio: ");
           for(Item item : Game.allItems) {
               System.out.println(item.getName());
               Thread.sleep(500);
           }
       }
    }
}
