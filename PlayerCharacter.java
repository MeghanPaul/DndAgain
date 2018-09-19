import java.io.*;
import java.util.*;
//import com.fasterxml.jackson.core.JsonParser;
/**
 * class Character - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public class PlayerCharacter extends DnD implements java.io.Serializable
{
    private String name;
    private String clas;
    private int level;
    private String race;
    private int str = 10;
    private int dex = 10;
    private int con = 10;
    private int intel = 10;
    private int wis = 10;
    private int cha = 10;
    
    
    public PlayerCharacter(){
        
    }
    
    //@Override
    //@JsonValue
    public PlayerCharacter(String n, String c, int lvl, String r)
    {
        name = n;
        clas = c;
        level = lvl;
        race = r;
        switch(race){
            case "Aarakocra":           dex+=2;
                                        wis+=1;
                                        break;
                                        
            case "Fallen Aasimar":      str+=1;
                                        cha+=2;
                                        break;
                                        
            case "Protector Aasimar":   wis+=1;
                                        cha+=2;
                                        break;
                                        
            case "Scourge Aasimar":     con+=1;
                                        cha+=2;
                                        break;
                                        
            case "Hill Dwarf":          con+=2;
                                        wis+=1;
                                        break;
            
            case "Mountain Dwarf":      con+=2;
                                        str+=2;
                                        break;
                                    
            case "Dragonborn":          str+=2;
                                        cha+=1;
                                        break;
                                    
            case "Drow Elf":            dex+=2;
                                        cha+=1;
                                        break;
                                        
            case "High Elf":            dex+=2;
                                        intel+=1;
                                        break;
                                        
            case "Wood Elf":            dex+=2;
                                        wis+=1;
                                        break;
            
            case "Firbolg":             str+=1;
                                        wis+=2;
                                        break;
            
            case "Air Genasi":          dex+=1;
                                        con+=2;
                                        break;
            
            case "Earth Genasi":        str+=1;
                                        con+=2;
                                        break;
            
            case "Fire Genasi":         con+=2;
                                        intel+=1;
                                        break;
            
            case "Water Genasi":        con+=2;
                                        wis+=1;
                                        break;
            
            case "Deep Gnome":          dex+=1;
                                        intel+=2;
                                        break;
            
            case "Forest Gnome":        dex+=1;
                                        intel+=2;
                                        break;
            
            case "Rock Gnome":          con+=1;
                                        intel+=2;
                                        break;
            
            case "Goliath":             str+=2;
                                        con+=1;
                                        break;
            
            case "Lightfoot Halfing":   dex+=2;
                                        cha+=1;
                                        break;
            
            case "Stout Halfling":      dex+=2;
                                        con+=1;
                                        break;
            
            case "Half Elf":            cha+=2;
                                        break;
            
            case "Half Orc":            str+=2;
                                        con+=1;
                                        break;
            
            case "Human":               str+=1;
                                        dex+=1;
                                        con+=1;
                                        intel+=1;
                                        wis+=1;
                                        cha+=1;
                                        break;
            
            case "Kenku":               dex+=2;
                                        wis+=1;
                                        break;
            
            case "Tabaxi":              dex+=2;
                                        cha+=1;
                                        break;
            
            case "Tiefling":            intel+=1;
                                        cha+=2;
                                        break;
        }
            
    }
    public void characterSaver(HashMap d)
    {
       try
           {
                  FileOutputStream fos = new FileOutputStream("hashmap.ser");
                  ObjectOutputStream oos = new ObjectOutputStream(fos);
                  oos.writeObject(d);
                  oos.close();
                  fos.close();
                  System.out.println("Serialized HashMap data is saved in hashmap.ser");
           }catch(IOException ioe)
            {
                  ioe.printStackTrace();
                  System.out.println("IOException");
            }
    } 
    public HashMap characterLoader()
    {
      //HashMap<String,Character> map = new HashMap<>();
      try
      {
         FileInputStream fis = new FileInputStream("hashmap.ser");
         ObjectInputStream ois = new ObjectInputStream(fis);
         System.out.println("Deserialized HashMap1");
         HashMap<String,PlayerCharacter> map = (HashMap<String,PlayerCharacter>) ois.readObject();
         System.out.println("Deserialized HashMap2");
         ois.close();
         fis.close();
         System.out.println("Deserialized HashMap3");
         return map;
      }catch(IOException ioe)
      {
         ioe.printStackTrace();
         System.out.println("IOException");
         return null;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Class not found");
         c.printStackTrace();
        return null;
      }
      
      
  }
    public void callSaver(HashMap dictionary)
    {
        characterSaver(dictionary);

    }
    public HashMap callLoader()
    {
        return(characterLoader()); 
    }
    public String getName()
    {
        return this.name;
    }
    
    public String getClas()
    {
        return this.clas;
    }
    
    public int getLevel()
    {
        return this.level;
    }
    
    public String getRace()
    {
        return this.race;
    }
    
    public void stats()
    {
        System.out.println("Str: " + this.str);
        System.out.println("Dex: " + this.dex);
        System.out.println("Con: " + this.con);
        System.out.println("Int: " + this.intel);
        System.out.println("Wis: " + this.wis);
        System.out.println("Cha: " + this.cha);
    }
    
    public void changeStat(String stat, int num)
    {
        if(stat.toLowerCase().equals("strength"))
        {
            this.str+=num;
        }else if(stat.toLowerCase().equals("dexterity"))
        {
            this.dex+=num;
        }else if(stat.toLowerCase().equals("constitution"))
        {
            this.con+=num;
        }else if(stat.toLowerCase().equals("intelligence"))
        {
            this.intel+=num;
        }else if(stat.toLowerCase().equals("wisdom"))  
        {
            this.wis+=num;
        }else if(stat.toLowerCase().equals("charisma"))
        {
            this.cha+=num;
        }
        
    }
    
    public String toString()
    {
        return this.name + " is a level " + this.level + " " + this.race + " " + this.clas ;
    }
    
    
}
