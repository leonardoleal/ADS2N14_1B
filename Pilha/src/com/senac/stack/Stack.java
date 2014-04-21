package com.senac.stack;

import java.lang.reflect.Array;

import com.senac.vector.Vector;

public class Stack<T> {

	private Vector<T> vector;

	public Stack() {
		this.vector = new Vector<T>();
	}

	public int getSize() {
	    return vector.getSize();
	}

	public boolean push(T value) {
	    this.vector.append(value);

	    return true;
	}

	public boolean pop() {
		this.vector.remove(this.getSize() - 1);

		return true;
	}

	public T peek() {
	    return this.vector.getValueOf(this.getSize() - 1);
	}

	public boolean isEmpty() {
	    return this.vector.isEmpty();
	}

	@SuppressWarnings("unchecked")
	public T[] asArray() {
	    if (this.vector == null) {
	        return null;
	    }

	    T t = this.peek();
	    T[] newArray = (T[]) Array.newInstance(t.getClass(), this.getSize());

		for (int i = 0; i < this.getSize(); i++) {
			newArray[i] = this.vector.getValueOf(this.getSize() -i -1);
		}

		return newArray;
	}
}