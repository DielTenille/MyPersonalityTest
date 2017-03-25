package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Question {
// A SCORE is defined by a TAG <D>,<I>,<S>,<C> with an associated key-word.   
    private static String[] tags = {"Dominant","Influencer","Sensitive","Compliant"};
    private static Map score = new HashMap();        
    private String[] words;    

    // for testing
    public Question() {       
    }
    
    // Get line of options from assessment questions
    public Question(String aLine) {        
        loadWords(aLine);
    }

    // for testing
    public void loadWords(String aLine)
    {  words = aLine.split("#");
    }
    
    
    public String[] getWordsRandom()
    {       
        ArrayList<String> rndWords = new ArrayList<String>(Arrays.asList(words));
        
        long seed = System.nanoTime();
        Collections.shuffle(rndWords, new Random(seed));        
                    
        String [] options = rndWords.toArray(new String[rndWords.size()]);        
        return options;
    }
          
    public int getScores(String key )
    {   return (int) score.get(key);
    }
    
    public void addScore(String[] pWordOrder)            
    {   //System.out.println("Adding Scores:");
        for (int i = 0; i < pWordOrder.length; i++) {
             String toFind = pWordOrder[i];
             int foundAt = 0;
             
                for (int j = 0; j < words.length; j++) {
                    String lookAt = words[j];
                    
                    if (lookAt.equals(toFind))
                        foundAt = j;                        
                }                
            score.put(tags[foundAt],(int)score.get(tags[foundAt])+(4-i));    
           // System.out.println("found: "+tags[foundAt]+" at: "+i);
        }        
    }
    
    public static void resetScores()
    {   score.clear();
        for (int i = 0; i < tags.length; i++) {            
            score.put(tags[i], 0);
        }
    }
    
    public static String getScores()
    { String result = "Your Personality Type Breakdown:<br>";
      
        for (int i = 0; i < tags.length; i++) {
            result += "<br>" + tags[i] + ": " +score.get(tags[i]) + "%";            
        }
        return result;
    }
    
    //identify type with highest score
    public static String getType() {
        int highestScore = 0;
        int highestTag = 0;
        for (int i = 0; i < tags.length; i++) {
            if ((int)score.get(tags[i]) > highestScore) {
                highestScore = (int)score.get(tags[i]);
                highestTag = i;
            }
            
        }
        
        return tags[highestTag];
    }
    
}
