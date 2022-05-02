class Assert {
	static final Thread thisThread = Thread.currentThread();
	static int checkCount = 0, checkFail = 0;
	public static void check(Boolean expr) {
		Assert.checkCount++;
		if (!expr) {
			StackTraceElement ste = Assert.thisThread.getStackTrace()[2];
			System.out.printf("*** Check failed at %s (%s) ***\n", ste.getClassName()+"."+ste.getMethodName(), 					ste.getFileName()+":"+ste.getLineNumber());
			Assert.checkFail ++;
		}
	}
	public static void printInfo() {
		System.out.printf("(%d tests done)\n(%d failed)\n", Assert.checkCount, Assert.checkFail);
	}
}

public class Principale {
	static final int[] checkCapacities = { 1, 1, 2, 4, 4, 8, 8, 8, 8, 16 };
	public static void main(String[] args) {
		Stack stack = new Stack();
		for (int i = 1; i < 10; i++) {
			stack.push(i);     Assert.check(stack.getCount() == i);
			Assert.check(stack.getCapacity() == Principale.checkCapacities[stack.getCount()]);
		}
		int res = 1;
		while (!stack.isEmpty()) {
			res *= stack.pop(); Assert.check(stack.getCapacity() == Principale.checkCapacities[stack.getCount()]);
		}
		Assert.check(res == 362880); 
		Assert.check(stack. getCapacity() == 1); Assert.printInfo();
	}
}
