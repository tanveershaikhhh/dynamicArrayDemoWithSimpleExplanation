package Array;

 public class dynamicArray {
	
	int arr[];
	int size;                 //  ----------> size = max number of elements in the array
	int capacity;        //   ----------> capacity = max number of elements the array can hold
	
	
//	constructor initialize object 
	dynamicArray(int capacity) {
		this.capacity = capacity;
		
		arr = new int[capacity];
		size = 0;
		
	}
	
// insert method 
//	check if size of array is equal to its capacity (check if its full)
//	call growArray method to increase capacity of the array. 
//	the element is inserted into the array at the index size
//	and the size is incremented by one.
	
	void insert(int element) {
		if (size == capacity) {
			growArray();
		}
		arr[size++] = element;
	}
	
	
//	growArray method 
//	 create new tempArray which is twice the size
// copy all the elements from original arr to temArray using for loop to preserve it while resizing
//	update arr to tempArr
//	increase capacity
	void growArray() {
		int [] tempArr = new int [2*size];
		for (int i=0; i<size; i++)
			tempArr[i] = arr[i];
		
		arr = tempArr;
		capacity = 2*size;
	
	}
	
//	The delete method takes an index as a parameter.
//	It first checks if the index is greater than or equal to the size of the array. If it is, it means the index is out of bounds, and the method returns -1.
//	If the index is valid, the method stores the element to be deleted in the deletedElement variable.
//	Then, it starts a loop from index + 1 to size - 1 and shifts each element one position to the left by assigning the value of the next element to the current element.
//	After the loop, the method decreases the size of the array by 1.
//	Finally, it returns the deletedElement.
	int delete (int index) {
		if  (index>= size)
			return -1;
		int deletedElement = arr[index];
		for(int i =index+1; i<size; i++)
			arr[i-1] = arr[i];
		size--;
		return deletedElement;
	}
	
	
	
//	Printing Array with Size: The first loop iterates over the array from index 0 to size-1 and prints each element. This represents the actual elements present in the array.

//	Printing Array with Capacity: The second loop iterates over the array from index 0 to capacity-1 and prints each element. This represents the potential capacity of the array, including any uninitialized elements.

	
	void display() {
		System.out.print("\n Array with size");
		for (int i=0; i<size;i++)
			System.out.print(arr[i]+" ");
		
		System.out.print("\n Array with capacity");
		for (int i=0; i<capacity;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		dynamicArray ob = new dynamicArray(3);
		
		ob.insert(12);
		ob.insert(13);
		ob.insert(15);
		ob.insert(18);
		ob.display();
		
		System.out.println("\n Deleted Element "+ ob.delete(2));
		ob.display();
		
	}
	

}
