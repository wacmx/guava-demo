package effectiveJava.t06;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import effectiveJava.model.Herb;

/**
 * EnumMap代替序数索引
 * 详见Herb与Phase
 * @author Yangyang
 *
 */
public class Demo33 {
  public static void main(String[] args) {
    Herb[] garden = {};
    Map<Herb.Type,Set<Herb>> herbsByType = new EnumMap<>(Herb.Type.class);
    for(Herb.Type t:Herb.Type.values()){
      herbsByType.put(t, new HashSet<Herb>());
    }
    for(Herb h:garden){
      herbsByType.get(h.getType()).add(h);
    }
    System.out.println(herbsByType);
  }
}
