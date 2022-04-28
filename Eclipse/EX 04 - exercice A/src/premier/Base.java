package premier;
//	modificateurs d'acces (public, private, protect, 'default')
//	modificateurs d'etat (final, static, abstract)

@SuppressWarnings("unused")
public class Base {
	public int publicMember;
	protected int protectedMember;
	int packageMember;
	private int privateMember;
	
	void f() {
		this.packageMember = 90;
		this.privateMember = 12;
		this.protectedMember = 123;
		this.publicMember = 123;
	}
	
	public static void main(String[] args) {
		System.out.println("main Principale");
		Base p = new Base();
		p.packageMember = 90;
		p.privateMember = 12;
		p.protectedMember = 123;
		p.publicMember = 123;
	}
}

