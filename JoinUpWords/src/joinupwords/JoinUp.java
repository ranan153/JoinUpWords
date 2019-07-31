import java.util.*;

public class JoinUp {

    public static void main(String[] args) {
        
        
        Scanner dict = new Scanner(System.in);
        
        String[] dictHC = {"array", "fixage", "ire", "entire",  "words",
                 "only", "to", "fixture",  "pad", "out", "agent", "the"};
        
        String[] dict2 = {"suffix", "read", "fixre"};

        portmantout("suffix", "read", dictHC);
        
    }

    public static void portmantout(String start, String end, String[] dict) {

        ArrayList<String> explored = new ArrayList<>();
        ArrayList<String> completed = new ArrayList<>();
        String[] fits; 
        String candidate = start;
        String suffix;
        String endPre = end.substring(0, end.length() / 2);
        int candLen, candHalf;
        

        completed.add(candidate);
        
        while (!completed.contains(end)) {
            
            
            candLen = candidate.length();
            candHalf = (candLen / 2) + (candLen % 2);
            
            for (int i = 0; i < candidate.length() / 2; i++) {
                
                suffix = candidate.substring(i);
                
                
                if (suffix.equals(endPre)) {
                    completed.add(end);
                    break;
                }
                
                for (String word : dict) {
                    
                    if (suffix.equals(word.substring(0, (word.length() / 2) + 
                            (word.length() % 2)))) {
                        
                        completed.add(word);
                        candidate = word;
                    }
                }
            }
        }
        System.out.print(completed.size());
        completed.forEach(word -> System.out.print(" " + word));
        
    }

}
        
        
