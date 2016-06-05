### The problem

Given an array of integers, print the leaders in the array. A leader is an element which is larger than all the elements in the array to its right.


### Solution

Is was my first attempt at coming up with a solution. Naturally I used recursion and simply walked down the array seeing if every element after it was the same.

The time complexity of this is O(n!) which isn't great.

```clojure
;; My code goes here.
```

To see if I could get this any better I decided to try and find a non recursive method that does it in O(n) time. To do that we traverse backwards across the array keeping track of the largest element and when we find something smaller then we pop it into an accumulator. Then at the end we simply return the accumulator. 

```clojure
;; My code goes here.
```