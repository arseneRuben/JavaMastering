
public class Stack {
	private int[] data;
	private int count;

	public Stack() {
		this.data = new int[1];
		this.count = 0;
	}

	public int getCount() {
		return this.count;
	}

	public int getCapacity() {
		return this.data.length;
	}

	public boolean isEmpty() {
		return this.count == 0;
	}

	private void resize(int newSize) {
		if (this.count > newSize) {
			System.out.println("Nouvelle taille trop petite dans resize!!!");
			System.exit(-1);
		}

		// allocation nouvelle zone memoire
		int[] tmp = new int[newSize];

		// copies des donnees presentes dans la pile actuelle
		for (int i = 0; i < this.count; i++) {
			tmp[i] = this.data[i];
		}

		this.data = tmp;
	}

	public void push(int value) {
		// a-t'on assez de place sur la pile ?
		if (this.count == this.data.length) { // non
			resize(this.count * 2);
		}

		this.data[this.count] = value;
		this.count++;
	}

	public int pop() {
		if (this.count == 0) {
			System.out.println("On ne peut pas depiler une pile vide!");
			System.exit(-2);
		}

		int removed = this.data[this.count - 1];
		this.count--;

		if (this.getCapacity() > 1 && this.getCapacity() / 2 == this.count) {
			resize(this.count);
		}

		return removed;
	}

	public static void main(String[] args) {
		Stack myStack = new Stack();
		System.out.println("count = " + myStack.getCount());
		System.out.println("capacity = " + myStack.getCapacity());
		for(int i=0; i<5; i++) {
			myStack.push(i);
		}
		System.out.println("count = " + myStack.getCount());
		System.out.println("capacity = " + myStack.getCapacity());
		for(int i=0; i<5; i++) {
			System.out.println(myStack.pop());
		}
		System.out.println("count = " + myStack.getCount());
		System.out.println("capacity = " + myStack.getCapacity());
		
		//myStack.pop();
		
		System.out.println("Fin du main!");
	}
}





