package autre;

import premier.Base;

public class Tata  {
	void f() {
		Base b = new Base();
		//b.packageMember = 90;	//	impossible
		//b.privateMember = 12;	//	impossible
		//b.protectedMember = 123;		//	impossible
		b.publicMember = 123;
	}
}
