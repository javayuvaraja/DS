package com.yuva.leetcode.array;

public class CircularGasStation {

	static class PetrolPump {
		 
	    int petrol;
	    int distance;
	 
	    PetrolPump(int a, int b) {
	      this.petrol = a;
	      this.distance = b;
	    }
	  };
	 
	  // The function returns starting point if there is a
	  // possible solution, otherwise returns -1
	  static int printTour(PetrolPump p[], int n)
	  {
	 
	    // deficit is used to store the value of the capacity as
	    // soon as the value of capacity becomes negative so as
	    // not to traverse the array twice in order to get the
	    // solution
	    int start = 0, shortage = 0;
	    int capacity = 0;
	    for (int i = 0; i < n; i++) {
	      capacity += p[i].petrol - p[i].distance;
	      if (capacity < 0) {
	        // If this particular step is not done then the
	        // between steps would be redundant
	        start = i + 1;
	        shortage += capacity;
	        capacity = 0;
	      }
	    }
	    return (capacity + shortage > 0) ? start : -1;
	  }
	
}
