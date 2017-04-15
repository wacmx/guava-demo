package effectiveJava.t04;

import effectiveJava.model.Singer;
import effectiveJava.model.SongWriter;

/**
 * interface优于abstract class
 * 单继承    多实现
 * 
 * 定义多个实现的类型最佳途径
 * 但当演变的容易性比灵活性和功能更重要时,用abstract class
 * @author Yangyang
 *
 */
public interface Demo18 extends Singer,SongWriter{

}
