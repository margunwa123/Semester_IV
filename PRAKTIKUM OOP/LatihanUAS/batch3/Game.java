import java.util.HashMap;
import java.util.Map;

public class Game {
    public static void run(String[] hojun, String[] qila) {
        Map<String, Integer> result = new HashMap<>();
        for(String word : hojun) {
            if(result.containsKey(word)) {
                result.replace(word, result.get(word) + 1); 
            }
            else {
                result.put(word, 1);
            }
        }
        for(String word : qila) {
            if(result.containsKey(word)) {
                result.replace(word, result.get(word) - 1);
                if(result.get(word) == 0) {
                    result.remove(word);
                } 
            }
        }

        result.forEach((key, value) -> {
            for(int i = 0 ; i < value ; i++) {
                System.out.println(key);
            }
        });
    }

    // public static void main(String[] args) {
    //     String[] qila = {"budi", "budi", "budi", "adalah"} ;
    //     String[] hojun = {"budi", "bermain", "bola", "Adalah"};
        
    //     Game.run(hojun, qila);
    // }
}