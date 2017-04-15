package effectiveJava.t06;

import java.util.EnumSet;
import java.util.Set;

/**
 * EnumSet替代位域
 * @author Yangyang
 *
 */
public class Demo32 {
  //位域
  public static final int STYLE_BOLD = 1<<0;//1
  public static final int STYLE_ITALIC = 1<<1;//2
  public void applyStyles (int styles){}
  
  //EnumSet
  public enum Style{BOLD,ITALIC,UNDERLINE,STRIKETHROUGH}
  public void applyStyles (Set<Style> styles){}
  
  
  public static void main(String[] args) {
    Demo32 text = new Demo32();
    //位域
    text.applyStyles(STYLE_BOLD|STYLE_ITALIC);
    //EnumSet
    text.applyStyles(EnumSet.of(Style.BOLD,Style.ITALIC));
  }
}
