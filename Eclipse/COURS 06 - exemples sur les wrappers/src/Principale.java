class MyInteger {
	private int value;
	
	public void setValue(int value) {
		this.value = value;		
	}
	
	public int getValue() {
		return this.value;
	}
	
	public MyInteger(int value) {
		this.value= value;
	}
	
	@Override
	public String toString() {
        return "" + this.value;
    }
	
}

public class Principale {
	public static void f(Object o) {
		if (o instanceof Integer) {
			System.out.println("C'est un Integer!");
		}
		System.out.println(o);
	}
	
	public static void inc(Integer i) {
		i++;
	}
	
	public static void inc(MyInteger i) {
		 i.setValue(i.getValue() + 1);
	}
	
	public static void main(String[] args) {
		f(56);
		f(Integer.valueOf(56));
		
		Integer i = 13;
		System.out.println("i = " + i);
		i++;
		i = i /* unboxing */ + 1;
		i = Integer.valueOf(i.intValue() + 1);
		System.out.println("i = " + i);
		
		System.out.println("avant inc, i = " + i);
		Principale.inc(i);
		System.out.println("apres inc, i = " + i);
		
		MyInteger mi = new MyInteger(13);
		System.out.println(mi);
		
		System.out.println("avant inc, mi = " + mi);
		Principale.inc(mi);
		System.out.println("apres inc, mi = " + mi);
		
		
	}
}
