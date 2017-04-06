package effectiveJava.util;

/**
 * 区分字符串大小写
 * @author Yangyang
 *
 */
public final class CaseInsensitiveString {
	private final String s;

	public CaseInsensitiveString(String s) {
		if(s==null)
			throw new NullPointerException();
		this.s = s;
	}
	
	@Override public boolean equals(Object o){
		/*if(o instanceof Object)
			return s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
		if(o instanceof String)
			return s.equalsIgnoreCase((String) o);
		return false;*/
		return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
	}
	
}
