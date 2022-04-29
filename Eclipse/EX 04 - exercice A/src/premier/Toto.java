package premier;

class Toto {
	void f() {
		Base p = new Base();
		p.packageMember = 90;
		// p.privateMember = 12; // impossible
		p.protectedMember = 123;
		p.publicMember = 123;
	}

}