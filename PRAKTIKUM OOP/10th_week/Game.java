import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;


class Game {
  public static void run(String[] hojun, String[] qila) {
    Map<Integer, String> hojunWord = new HashMap<Integer, String>();
    for(int i = 0 ; i < hojun.length ; i++) {
      hojunWord.put(i , hojun[i]);
    }
    Map<Integer, String> qilaWord = new HashMap<Integer, String>();
    for(int i = 0 ; i < qila.length ; i++) {
      qilaWord.put(i, qila[i]);
    }
    Iterator hmIterator;

    for(int i = 0 ; i < qila.length ; i++) {
      hmIterator = hojunWord.entrySet().iterator();
      while(hmIterator.hasNext()) {
        Map.Entry mapElement = (Map.Entry) hmIterator.next();
        if(qilaWord.get(i).equals(mapElement.getValue())) {
          hojunWord.remove(mapElement.getKey());
          break;
        }
      }
    }

    hmIterator  = hojunWord.entrySet().iterator();
    while(hmIterator.hasNext()) {
        Map.Entry mapElement = (Map.Entry) hmIterator.next();
        System.out.println(mapElement.getValue());
    }
  }

  public static void main(String[] args) {
    String[] hojunWord = {"aaa", "iii"};
    String[] qilaWord = {"aaa", "iaaii"};
    Game.run(hojunWord, qilaWord);
  }
}
