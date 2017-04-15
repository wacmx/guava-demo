package effectiveJava.enums;

import java.util.EnumMap;
import java.util.Map;

public enum Phase {
  SOLID,LIQUID,GAS;
  public enum Transition{
    MELT(SOLID,LIQUID),FREEZE(LIQUID,SOLID),
    BOIL(LIQUID,GAS),CONDENSE(GAS,LIQUID),
    SUBLIME(SOLID,GAS),DEPOSIT(GAS,SOLID);
    
    private final Phase src;
    private final Phase dst;
    private Transition(Phase src, Phase dst) {
      this.src = src;
      this.dst = dst;
    }
    //Map<起始阶段,Map<目标阶段,阶段过渡>>,然后过渡枚举初始化嵌套的EnumMap
    private static final Map<Phase,Map<Phase,Transition>> m = new EnumMap<>(Phase.class);
    static{
      for(Phase p:Phase.values()){
        m.put(p, new EnumMap<Phase,Transition>(Phase.class));
      }
      for(Transition trans:Transition.values()){
        m.get(trans.src).put(trans.dst,trans);
      }
    }
    
    public static Transition from(Phase src,Phase dst){
      return m.get(src).get(dst);
    }
    
    public Phase getSrc() {
      return src;
    }
    public Phase getDst() {
      return dst;
    }
    
  }
}
