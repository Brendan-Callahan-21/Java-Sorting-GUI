/**
 *
 * @author Ouda
 */

//importing the libraries that will be needed in this program
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Random;

//The class that has all the sorts in it
public class SortShow extends JPanel { 

	
		// An array to hold the lines_lengths to be sorted
		public int[] lines_lengths;
		//The amount of lines needed
		public final int total_number_of_lines = 256;
		 // An array to holds the scrambled lines_lengths
		public int[] scramble_lines;
		//A temp Array that is used later for sorts
		public int[] tempArray;
		
		//the default constructor for the SortShow class
		public SortShow(){
			//assigning the size for the lines_lengths below
			lines_lengths = new int[total_number_of_lines];
			for(int i = 0; i < total_number_of_lines; i++) 
				lines_lengths[i] =  i+5;
			
		}
		

		//A method that scrambles the lines
		public void scramble_the_lines(){
			//A random generator
			Random num = new Random(); 
			//Randomly switching the lines
			for(int i = 0; i < total_number_of_lines; i++){
				//getting a random number using the nextInt method (a number between 0 to i + 1)
				int j = num.nextInt(i + 1); 
				//swapping The element at i and j 
				swap(i, j);
			}
			//assigning the size for the scramble_lines below
			scramble_lines = new int[total_number_of_lines];
			//copying the now scrambled lines_lengths array into the scramble_lines array 
			//to store for reuse for other sort methods
			//so that all sort methods will use the same scrambled lines for fair comparison 
			for (int i = 0; i < total_number_of_lines; i++)
			{
				scramble_lines[i] = lines_lengths[i];
			}
			//Drawing the now scrambled lines_lengths
			paintComponent(this.getGraphics());
		}
		
		//Swapping method that swaps two elements in the lines_lengths array
		public void swap(int i, int j){
			//storing the i element in lines_lengths in temp
			int temp = lines_lengths[i];
			//giving i element in lines_lengths the value of j element in lines_lengths
			lines_lengths[i] = lines_lengths[j];
			//giving j element in lines_lengths the value of temp
			lines_lengths[j] = temp;
		}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //The bubbleSort method
        public void BubbleSort(){
            //getting the date and time when the bubble sort starts
            Calendar start = Calendar.getInstance();
            //Using the bubble sort to sort the array lines_lengths

            //You need to complete this part.
            for(int i = 0; i < total_number_of_lines-1; i++){ //makes it iterate through the array total_number_of_lines times
                for(int j=0; j<total_number_of_lines-i-1; j++){   //iterates through the array. Each iteration it brings the largets to the back.
                    if(lines_lengths[j] > lines_lengths[j+1]) {     //if on element is larger than the one after, it swaps.
                        swap(j, j + 1);
                    }
                }
                //redrawing the lines_lengths
                paintComponent(this.getGraphics());
                //Causing a delay for 10ms
                delay(10);
            }



            //getting the date and time when the selection sort ends
            Calendar end = Calendar.getInstance();
            //getting the time it took for the selection sort to execute
            //subtracting the end time with the start time
            SortGUI.bubbleTime = end.getTime().getTime() - start.getTime().getTime();
        }

////////////////////////////////////////////////////////////////////////////////////////////////////////

        //The selectionSort method
		public void SelectionSort(){
			//getting the date and time when the selection sort starts
			Calendar start = Calendar.getInstance();
			//Using the selection sort to sort the array lines_lengths

			//You need to complete this part.
            int n = lines_lengths.length;
            for(int current = 0; current < n - 1; current++){ //current is the index of the current element
                //int nextSmallestIndex=current;
                //gets the smallest index from current position through the end of the array
                int nextSmallestIndex=getIndexOfSmallest(current, n-1);
                if(nextSmallestIndex!=current) {
                    //moves the next smallest Element to the current position then the program moves on from the current element
                    swap(current, nextSmallestIndex);
                }
                //redrawing the lines_lengths
                paintComponent(this.getGraphics());
                //Causing a delay for 10ms
                delay(10);
            }



			//getting the date and time when the selection sort ends
			Calendar end = Calendar.getInstance();
			//getting the time it took for the selection sort to execute 
			//subtracting the end time with the start time
	        SortGUI.selectionTime = end.getTime().getTime() - start.getTime().getTime();
		}
		
		//this method gets the smallest element in the array of lines_lengths
		public int getIndexOfSmallest(int first, int last){

			//You need to complete this part.
            int minIndex=first;
            for(int j = first+1; j <= last; j++){     //loops through the array
                //if it finds an el smaller than the first element it marks its index with nextSmallestIndex
                if(lines_lengths[j] < lines_lengths[minIndex]){
                    minIndex = j;
                }
            }

            //returns the smallest index
			return minIndex; //modify this line
		}





	///////////////////////////////////////////////////////////////////////////////////


        //The insertionSort method
        public void InsertionSort(){
            //getting the date and time when the selection sort starts
            Calendar start = Calendar.getInstance();
            //Using the selection sort to sort the array lines_lengths

            //You need to complete this part.
            InsertionSort(0,total_number_of_lines-1);

            //getting the date and time when the selection sort ends
            Calendar end = Calendar.getInstance();
            //getting the time it took for the selection sort to execute
            //subtracting the end time with the start time
            SortGUI.insertionTime = end.getTime().getTime() - start.getTime().getTime();
        }

        public void InsertionSort(int first, int last){
            int unsortedElement;
            int unsortedIndex;
            for(int i = first+1; i <= last; i++ ){
                unsortedIndex=i;
                unsortedElement = lines_lengths[unsortedIndex];

                while((first < unsortedIndex) && (unsortedElement < lines_lengths[unsortedIndex-1])) {
                    lines_lengths[unsortedIndex] = lines_lengths[unsortedIndex - 1];
                    unsortedIndex--;
                }
                lines_lengths[unsortedIndex] = unsortedElement;
                paintComponent(this.getGraphics());
                //Causing a delay for 10ms
                delay(10);
            }
        }


    ////////////////////////////////////////////////////////////////////////////////////////

        //The ShellSort method
        public void ShellSort(){
            //getting the date and time when the selection sort starts
            Calendar start = Calendar.getInstance();
            //Using the selection sort to sort the array lines_lengths

            //You need to complete this part.
            //calls ShellSort method with parameters of indices of the first and last element.
            ShellSort(0, total_number_of_lines-1);

            //getting the date and time when the selection sort ends
            Calendar end = Calendar.getInstance();
            //getting the time it took for the selection sort to execute
            //subtracting the end time with the start time
            SortGUI.shellTime = end.getTime().getTime() - start.getTime().getTime();
        }


        public void ShellSort(int first, int last){
            int n = total_number_of_lines;   //number of array elements
            //splitting array into subarrays with length of half the array
            for(int space = n/2; space > 0; space = space/2){
                //sorting each sub array by sending each one to IncrementalInsertionSort() and then moving to the next
                for(int begin = first; begin < first+space; begin++){
                    IncrementalInsertionSort(begin, last, space);
                    paintComponent(this.getGraphics());
                    //Causing a delay for 10ms
                    delay(10);
                }
            }
        }

        // this performs insertion sort on the subarrays passed to it by ShellSort.
        // @param first = index of the first element in the subarray
        // @param last = index of the last element in the subarray
        // @param space = the difference between each index of the elements in the subarray
        public void IncrementalInsertionSort(int first, int last, int space){
            int index;
            int unsorted;
            //increments the subarray to select the next element in the subarray
            // ** Once I is incremented past last, the condition statement is violated and it doens't run
            for(unsorted = first+space; unsorted <= last; unsorted=unsorted+space){
                //inserts into sorted part of subarray
                int firstUnsorted = lines_lengths[unsorted];
                for(index = unsorted-space; index >=first && firstUnsorted < lines_lengths[index]; index = index-space){
                    lines_lengths[index+space] = lines_lengths[index];
                }
                lines_lengths[index+space] = firstUnsorted;

            }
        }

    ///////////////////////////////////////////////////////////////////////////////////////////////


		//recursive merge sort method
		public void R_MergeSort(){
			//getting the date and time when the recursive merge sort starts
			Calendar start = Calendar.getInstance();
			//assigning the size for the tempArray below

			//You need to complete this part.
            tempArray = new int[total_number_of_lines];
            R_MergeSort(0, total_number_of_lines-1);

			Calendar end = Calendar.getInstance();
			//getting the time it took for the iterative merge sort to execute
			//subtracting the end time with the start time
	        SortGUI.rmergeTime = end.getTime().getTime() - start.getTime().getTime();
			
		}
		
		//recursive merge sort method
		public void R_MergeSort(int first, int last){
			if(first < last){

				//You need to complete this part.
                int mid = (first + last)/2;
                R_MergeSort(first, mid);
                R_MergeSort(mid+1, last);
                R_Merge(first, mid, last);

				//Causing a delay for 10ms
				//delay(10);

                //do I put this whole thing?
                //redrawing the lines_lengths
                paintComponent(this.getGraphics());
                //Causing a delay for 10ms
                delay(10);

			}
		}

		
		//recursive merge sort method
		public void R_Merge(int first, int mid, int last){
            //System.out.println("In the R_Merge() function");
			//You need to complete this part.
            int begin1=first;
            int end1=mid;
            int begin2=mid+1;
            int end2=last;

            int index = begin1;
            for(; (begin1<=end1) && (begin2<=end2); index++){
                //System.out.println("Testing1");
                if(lines_lengths[begin1] <= lines_lengths[begin2]){
                    //System.out.println("Testing2");
                    tempArray[index] = lines_lengths[begin1];
                    begin1++;
                }
                else{
                    //System.out.println("Testing1");
                    tempArray[index] = lines_lengths[begin2];
                    begin2++;
                    //System.out.println("Testing2");
                }
            }

            //filling out the rest of tempArray from leftovers of either first half or second half
            for(; begin1 <= end1; index++, begin1++) {
                tempArray[index] = lines_lengths[begin1];
            }
            for(; begin2 <= end2; index++, begin2++) {
                tempArray[index] = lines_lengths[begin2];
            }


            //inserting tempArray[] into lines_lengths[];
            for(index=first; index<=last; index++){
                lines_lengths[index] = tempArray[index];
            }

		}
		
		//

	//////////////////////////////////////////////////////////////////////////////////////////
		
		//iterative merge sort method
		public void I_MergeSort()
		{
		//getting the date and time when the iterative merge sort starts
		Calendar start = Calendar.getInstance();
		//assigning the size for the tempArray below
		tempArray = new int[total_number_of_lines]; 
		//saving the value of total_number_of_lines
		int beginLeftovers = total_number_of_lines;

		
		for (int segmentLength = 1; segmentLength <= total_number_of_lines/2; segmentLength = 2*segmentLength)
		{
			beginLeftovers = I_MergeSegmentPairs(total_number_of_lines, segmentLength);
			int endSegment = beginLeftovers + segmentLength - 1;
			if (endSegment < total_number_of_lines - 1) 
			{
			I_Merge(beginLeftovers, endSegment, total_number_of_lines - 1);
			}
		} 

		// merge the sorted leftovers with the rest of the sorted array
		if (beginLeftovers < total_number_of_lines) {
			I_Merge(0, beginLeftovers-1, total_number_of_lines - 1);
		}
		//getting the date and time when the iterative merge sort ends
		Calendar end = Calendar.getInstance();
		//getting the time it took for the iterative merge sort to execute 
		//subtracting the end time with the start time
	    SortGUI.imergeTime = end.getTime().getTime() - start.getTime().getTime();
	} 

        // Merges segments pairs (certain length) within an array
        public int I_MergeSegmentPairs(int l, int segmentLength)
        {
            //The length of the two merged segments

            //You suppose  to complete this part (Given).
            int mergedPairLength = 2 * segmentLength;
            int numberOfPairs = l / mergedPairLength;

            int beginSegment1 = 0;
            for (int count = 1; count <= numberOfPairs; count++)
            {
                int endSegment1 = beginSegment1 + segmentLength - 1;

                int beginSegment2 = endSegment1 + 1;
                int endSegment2 = beginSegment2 + segmentLength - 1;
                I_Merge(beginSegment1, endSegment1, endSegment2);

                beginSegment1 = endSegment2 + 1;
                //redrawing the lines_lengths
                paintComponent(this.getGraphics());
                //Causing a delay for 10ms
                delay(10);
            }
            // Returns index of last merged pair
            return beginSegment1;
            //return 1;//modify this line
        }

        public void I_Merge(int first, int mid, int last)
        {
            //You suppose  to complete this part (Given).
            // Two adjacent sub-arrays
            int beginHalf1 = first;
            int endHalf1 = mid;
            int beginHalf2 = mid + 1;
            int endHalf2 = last;

            // While both sub-arrays are not empty, copy the
            // smaller item into the temporary array
            int index = beginHalf1; // Next available location in tempArray
            for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++)
            {
                // Invariant: tempArray[beginHalf1..index-1] is in order
                if (lines_lengths[beginHalf1] < lines_lengths[beginHalf2])
                {
                    tempArray[index] = lines_lengths[beginHalf1];
                    beginHalf1++;
                }
                else
                {
                    tempArray[index] = lines_lengths[beginHalf2];
                    beginHalf2++;
                }
            }
            //redrawing the lines_lengths
            //paintComponent(this.getGraphics());

            // Finish off the nonempty sub-array

            // Finish off the first sub-array, if necessary
            for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
                // Invariant: tempArray[beginHalf1..index-1] is in order
                tempArray[index] = lines_lengths[beginHalf1];

            // Finish off the second sub-array, if necessary
            for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
                // Invariant: tempa[beginHalf1..index-1] is in order
                tempArray[index] = lines_lengths[beginHalf2];

            // Copy the result back into the original array
            for (index = first; index <= last; index++)
                lines_lengths[index] = tempArray[index];
        }

    //////////////////////////////////////////////////////////////////////

        //Quick sort method
        public void QuickSort(){
            //getting the date and time when the recursive merge sort starts
            Calendar start = Calendar.getInstance();
            //assigning the size for the tempArray below

            //You need to complete this part.
            QuickSort(0, total_number_of_lines-1);

            Calendar end = Calendar.getInstance();
            //getting the time it took for the iterative merge sort to execute
            //subtracting the end time with the start time
            SortGUI.quickTime = end.getTime().getTime() - start.getTime().getTime();

        }

        public void QuickSort(int first, int last){
                if(first < last) {
                    int pivotIndex=PartitionSort(first, last);
                    //array is not partitioned, each side can be sorted now

                    QuickSort(first, pivotIndex-1);
                    QuickSort(pivotIndex+1, last);
                    paintComponent(this.getGraphics());
                    //Causing a delay for 10ms
                    delay(10);
                }
        }

        //This function partitions the array using a pivot for QuickSort and returns a pivot index
        //basically moves all the elements < pivot to the left of pivot, and > pivot to the right of pivot
        public int PartitionSort(int first, int last){
                //sort the first, mid and last indexes
                //handles case where your partitioning 2 or 1 element(s)
                if(last-first<=1){
                    if(first<last && lines_lengths[first] > lines_lengths[last]){//only 2 elements
                        swap(first, last);
                    }
                    return (first+last)/2;
                }
                //else normal case
                int pivot = first + ((last - first) / 2);
                SortMarkedElements(first, pivot, last);
                int pivotVal=lines_lengths[pivot];

                //move the pivot to last-1
                swap(pivot, last-1);
                pivot=last-1;

                //select an l index that is the first one after first
                //this element will iterate through the smaller side of the array
                int l = first+1;
                //select an r index that is 2 before last
                //this element will iterate through the larger side of the array
                int r = last-2;

                boolean flag = false;
                while(!flag) {
                    //With l, look for the first el that is > pivotVal
                    while(l<last-1 && lines_lengths[l] < pivotVal) {
                        l++;
                    }
                    //With r, look for the first el that is <= pivotVal
                    while(r>first && lines_lengths[r] > pivotVal) {
                        r--;
                    }
                    //if l is still < r, swap the elements
                    if(l < r) {
                        swap(l, r);
                    }
                    //else stop repeating
                    else{
                        flag=true;
                    }
                    //repeat these steps until l > r
                }

                //swap the elements at pivot and l to get pivot element back to the center
                //(l is still >= pivotVal
                swap(pivot, l);
                pivot=l;

                //return pivot index
                return pivot;
        }

        //helper function for PartitionSort() that sorts the first, pivot and last element of the subarray so the array can be partitioned
        //parameters are the indeces of the first, pivot, and last element
        public void SortMarkedElements(int first, int pivot, int last){
                if(lines_lengths[first] > lines_lengths[pivot])
                    swap(first, pivot);
                if(lines_lengths[last] < lines_lengths[pivot])
                    swap(last, pivot);
                if(lines_lengths[first] > lines_lengths[pivot])
                    swap(first, pivot);

        }

	//////////////////////////////////////////////////////////////////////
		
		//This method resets the window to the scrambled lines display
		public void reset(){
			if(scramble_lines != null)
			{
				//copying the old scrambled lines into lines_lengths
				for (int i = 0; i < total_number_of_lines; i++)
				{
					lines_lengths[i] = scramble_lines[i] ;
				}
			//Drawing the now scrambled lines_lengths
			paintComponent(this.getGraphics());
		}
			}
		
	
		//This method colours the lines and prints the lines
		public void paintComponent(Graphics g){
 			super.paintComponent(g);
			//A loop to assign a colour to each line
			for(int i = 0; i < total_number_of_lines; i++){
				//using eight colours for the lines
				if(i % 8 == 0){
					g.setColor(Color.green);
				} else if(i % 8 == 1){
					g.setColor(Color.blue);
				} else if(i % 8 == 2){
					g.setColor(Color.yellow);
				} else if(i%8 == 3){
					g.setColor(Color.red);
				} else if(i%8 == 4){
					g.setColor(Color.black);
				} else if(i%8 == 5){
					g.setColor(Color.orange);
				} else if(i%8 == 6){
					g.setColor(Color.magenta);
				} else
					g.setColor(Color.gray);
				
				//Drawing the lines using the x and y-components 
				g.drawLine(4*i + 25, 300, 4*i + 25, 300 - lines_lengths[i]);
			}
			
		}
		
		//A delay method that pauses the execution for the milliseconds time given as a parameter
		public void delay(int time){
			try{
	        	Thread.sleep(time);
	        }catch(InterruptedException ie){
	        	Thread.currentThread().interrupt();
	        }
		}
		
	}

