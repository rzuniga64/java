package stack;

/**
 *  Queue: a data structure that holds a collection of elements of the same type.
 *  - The elements are accessed according to FIFO order: first in, first out
 *  - No random access to other elements
 *
 *  Examples:
 *  - people in line at a theatre box office
 *  - restocking perishable inventory
 *
 * OPERATIONS
 * - enqueue: add a value onto the rear of the queue (the end of the line)
 * - make sure it�s not full first.
 * - dequeue: remove a value from the front of the queue(the front of the line) Next!
 * - make sure it is not empty first.
 * - isFull: true if the queue is currently full, i.e.,has no more space to hold additional elements
 * - isEmpty: true if the queue currently contains no elements
 *
 * These operations should take constant time: O(1)
 *
 * - makeEmpty: removes all the elements his is allowed to take longer than constant time.
 *
 * QUEUE ILLUSTRATED
 *
 * q.enqueue(2)					q.enqueue(3)			q.enqueue(5)		q.dequeue(item)			q.dequeue(time)		q.enqueue(10)
 * item = 2						item = 3
 * front/rear	2	0			front	2	0			front	2	0				x	0					x	0				x	0
 * 1			rear	3	1					3	1		front	3	1					x	1				x	1
 * 2						2			rear	5	2		rear	5	2		front/rear	5	2		front	5	2
 * 3						3					3					3						3			rear	10	3
 *
 * Note: front and rear are variables used by the implementation to carry out the operations
 * int item;
 * q.enqueue(2);
 * q.enqueue(3);
 * q.enqueue(5);
 * item = q.dequeue();	// item is 2
 * item - q.dequeue();	// item is 3
 * q.enqueue(10);
 *
 * QUEUE APPLICATIONS
 *
 * The best examples of applications of queues involve managing multiple processes.
 * - For example, imagine the print queue for a computer lab.
 * - Any computer can add a new print job to the queue (enqueue).
 * - The printer performs the dequeue operation and
 * starts printing that job.
 * - While it is printing, more jobs are added to the Q
 * - When the printer finishes, it pulls the next job from the Q, continuing until the Q is empty
 *
 * IMPLEMENTING A QUEUE CLASS
 * - Just like stacks, queues can be implemented using arrays (fixed size, or resizing dynamic arrays) or linked
 *   lists (dynamic queues), and may be implemented using templates.
 * -	The previous illustration assumed we were using an array to implement the queue
 * -	When an item was dequeued, the items were NOT shifted up to fill the slot vacated by dequeued item (why not?)
 * -	Instead, both front and rear indices move in the array
 *
 * PROBLEM: END OF THE ARRAY
 * - When front and rear indices move in the array:
 * - problem: rear hits end of array quickly
 * - solution: wrap index around to front of array
 * - To 'wrap' the rear index back to the front of the array, you can use this code to increment rear
 * during enqueue:
 * - To 'wrap' the rear index back to the front of the array, you can use this code to increment rear during enqueue:
 * if (rear == queueSize - 1)
 *      rear = 0;
 * else
 *      rear = rear+1;
 * - the fllowing code is equivalent, but shorter (assuming 0 <= rear < queueSize):
 *   rear = (rear + 1) % queueSize;
 * - Do the same for advancing the front index.
 *
 * _	_	_	_	_	7	9	6		3	_	_	_	_	7	9	6		3	4	_	_	_	7	9	6
 * f		r		r					f					r				f
 *
 * - When is it full? (rear+1)%queueSize==front
 * 3	4	_	_	_	7	9	6
 * r				f
 * q.enqueue(5);
 * q.enqueue(2);
 * q.enqueue(1);
 *
 * 3	4	5	2	1	7	9	6
 * r	f
 *
 * - When is it empty? (rear+1)%queueSize==front
 *   int x;
 *   for (int i=0; i < queueSize; i++)
 *   x = q.dequeue();	// dequeue decrements the front
 *
 *  after the first one:				one element left:					no elements left, front passes rear:
 *  3	4	5	2	1	_	9	6		_	_	_	_	1	_	_	_		_	_	_	_	_	_	_	_
 *  r		f						   rf									r	f
 *
 * - How do we define isFull and isEmpty?
 * - Use a counter variable, numItems, to keep track of the total number of items in the queue.
 * - enqueue: numItems++
 * - dequeue: numItems--
 * - isEmpty is true when numItems == 0
 * - isFull is true when numItems == queueSize
 *
 * ARRAY VS LINKED LIST IMPLEMENTATIONS
 *
 * - Both are very fast (O(1)).
 * - Array may be faster (no dynamic allocation)
 *
 * STATIC ARRAYS:
 * - must anticipate maximum size
 * - wasted space: entire array is allocated, even if using small portion
 *
 * DYNAMIC ARRAYS (resize when full):
 * - resizing takes time (copying all the elements)
 * - resizing requires memory that is three times what is needed to store the elements at that time
 *
 * LINKED LIST
 * - code is actually simpler than array with resizing, especially for queues.
 * - space used by elements is always proportional to number of elements (only wasted space is for the pointers)
 *
 * SUMMARY:
 * - array implementation is probably better for small objects.
 * - linked list is probably better for large objects if space is scarce or copying is expensive (resizing)
 */

public class StackLinkedList {
}
