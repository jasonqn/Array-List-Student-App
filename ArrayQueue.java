package queues;

import java.util.NoSuchElementException;

public class ArrayQueue {
	
	private Employee[] queue;
	private int front;
	private int back;
	
	public ArrayQueue(int size) {
		queue = new Employee [size];
	}
	
	public void add(Employee employee) {
		//checks if the back of the queue is equal to the queue's length
		//if so, we are extending the queue's length by multiple of 2
		//we create a new array and add the old array to the new one
		if(back == queue.length) {
			Employee[] newArray = new Employee[2 * queue.length];
			//copy array "queue", start from beginning "0" into the new array
			//"newArray" copy to the beginning of "newArray" index "0"
			//copy the queue.lengths elements so all elements in old queue over
			System.arraycopy(queue,  0,  newArray,  0, queue.length);
			queue = newArray;
		}
		//assign new employee to back of queue once new array is made
		//increment back by 1
		queue[back] = employee;
		back++;
	}
	
	
	//back is always pointing to the index behind the last element in the queue
	//if an index has 2 elements {0, 1} then back is pointing at index {2}
	//this is because for a new element to enter the queue it will come in at
	//index 2 so back always has to be behind the last element. To get a queue's
	//length we subtract the back from front so index 2 - 0 = 2 and that tells us
	//there are 2 elements in the queue {0, 1} because back is always behind the
	//last element {2}
	
	
	public Employee remove() {
		if(size() == 0) {
			throw new NoSuchElementException();
		}
		
		//we remove the employee at front of queue by making front null and incrementing
		//the array +1
		Employee employee = queue[front];
		queue[front] = null;
		front++;
		//if we've removed the only element in the queue then we reset the queue 
		if(size() == 0) {
			front = 0;
			back = 0;
		}
		
		return employee;
	}
	
	public Employee peek() {
		if(size() == 0) {
			throw new NoSuchElementException();
		}
		
		return queue[front];
	}
	
	public int size() {
		return back - front;
	}
	
	//remember back is outside of the queue behind the last element
	//thats why front "<" back and not "="
	//Queue can start at any point in the array so we use "front" rather than "0"  
	public void printQueue() {
		for(int i = front; i < back; i++) {
			System.out.println(queue[i]);
		}
	}

}















