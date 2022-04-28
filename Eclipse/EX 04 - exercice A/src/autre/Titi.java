package autre;

import premier.Base;

public class Titi extends Base {
	void g() {
		//this.packageMember = 90;	//	impossible
		//this.privateMember = 12;	//	impossible
		this.protectedMember = 123;
		this.publicMember = 123;
	}
}
