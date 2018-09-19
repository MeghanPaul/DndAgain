import java.util.*;
import java.io.*;

//test test test

class DnD implements java.io.Serializable
{
    HashMap<String,PlayerCharacter> dictionary = new HashMap<>();

    public static void main(String[] args)
    {
        DnD initial = new DnD();
        initial.commands();
        

    }
    
    public void commands()
    {
        PlayerCharacter h = new PlayerCharacter();
        //dictionary = loader.characterLoader();
        dictionary.put("Locke", new PlayerCharacter("Locke", "Fighter", 10, "Protector Aasimar"));
        //dictionary.put("Gwen", new PlayerCharacter("Gwen", "Cleric", 5, "Hill Dwarf"));
        h.callLoader();
        //System.out.println(Locke);
        //System.out.println(Gwen);
        Scanner input = new Scanner(System.in);
        String text;
        do
        {
            //System.out.println("while");
            text = input.nextLine();
            handler(text,dictionary);
            //System.out.println("while 2");
        }while((!(text.toLowerCase()).equals("stop")));
        h.callSaver(dictionary);
        //System.out.flush();
    }
    private void handler(String t,HashMap dic)
    {
        Scanner input = new Scanner(System.in);
        PlayerCharacter holder;
        String name;
        if(t.contains("stats"))
        {
            do
            {
                System.out.print("For who? ");
                name = input.nextLine();
                if(dic.containsKey(name))
                {
                    holder = (PlayerCharacter)dic.get(name);
                    holder.stats();
                }else {
                    System.out.println("Invalid Name. Try Again.");
                }
            }while(!(dic.containsKey(name)));
        }else if(t.toLowerCase().equals("stop"))
        {
            System.out.print('\u000C');
        }else if(t.toLowerCase().contains("create character"))
        {
            create(dic);
        }else if(t.equals("print"))
        {
            do
            {
                System.out.print("For who? ");
                name = input.nextLine();
                if(dic.containsKey(name))
                {
                    holder = (PlayerCharacter)dic.get(name);
                    System.out.println(holder);
                }else {
                    System.out.println("Invalid Name. Try Again.");
                }
            }while(!(dic.containsKey(name)));
        }else if(t.equals("print all"))
        {
            System.out.println(dic.keySet());
        }else{
            System.out.println("Invalid Command");
        }
        
    }
    private void create(HashMap d){
        Scanner input = new Scanner(System.in);
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Race: ");
        String race = input.nextLine();
        System.out.print("Class: ");
        String clas = input.nextLine();
        System.out.print("Level: ");
        int level = input.nextInt();
        
        PlayerCharacter temp = new PlayerCharacter(name, clas, level, race);
        
        //needs fixin
        if(race.equals("Half Elf"))
        {   
            System.out.print("Stat Bonus Number One: ");
            String statOne = input.nextLine();
            System.out.print("Stat Bonus Number One: ");
            String statTwo = input.nextLine();
            temp.changeStat(statOne,1);
            temp.changeStat(statTwo,1);
        }
       
        d.put(name,temp);
   
    }
}
