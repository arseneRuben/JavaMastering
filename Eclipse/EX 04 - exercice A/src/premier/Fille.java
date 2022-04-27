package premier;

class Fille extends Base {
	void f() {
		this.packageMember = 90;
		//this.privateMember = 12;	//	impossible
		this.protectedMember = 123;
		this.publicMember = 123;
	}
	
}