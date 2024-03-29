/*
 * This file demonstrates how to pass a 2D array as a parameter to a function in the C programming language.
 */

#include <stdio.h>

int RAW = 0;
int CAL = 0;

void printArr(int array[RAW][CAL])
{
	for(int i = 0; i < RAW; i++)
	{
		for(int j = 0; j < CAL; j++)
		{
			printf("%d ", array[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

/*
 * This printPtrArr function takes a pointer to an integer array (the int* parameter) and the 
 * rows and columns of that array and prints the contents within those rows and columns to the
 * console.
 */
void printPtrArr(int* array, int rows, int cols)
{
	for(int i = 0; i < rows; i++)
	{
		for(int j = 0; j < cols; j++)
		{
			printf("%d ", *(array + i * cols + j));
		}
		printf("\n");
	}
	printf("\n");

}

/*
 * This double_array function takes an int*, allocates memeory for a 2D array of size
 * rows by cols and inserts 2 times the value in the array parameter at index [i][j]
 * into index [i][j] of the allocated doubled array. A pointer to the first row of
 * the doubled 2D array is then returned to the caller.
 */
int** double_array(int* array, int rows, int cols)
{
	// If array is NULL or either rows or cols is less than 1, return NULL immediately.
	if(array == NULL || rows < 1 || cols < 1)
			return NULL;
	
	// Allocate the number of rows in the doubled variable.
	int** doubled = (int**) malloc(rows * sizeof(int*));
	
	// For each row, allocate the number of columns needed to store values.
	for(int i = 0; i < rows; i++)
		doubled[i] = (int*) malloc(cols * sizeof(int));
	
	// For each row.
	for(int i = 0; i < rows; i++)
	{
		// For each column.
		for(int j = 0; j < cols; j++)
		{
			// Assign the value from array[i][j] * 2 to the doubled 2D array at index [i][j].
			doubled[i][j] = *(array + i * cols + j) * 2;	
		}
	}
	
	// Return the address to the first index of the doubles 2D array.
	return &doubled[0];
	
}

int main (int argc, char** argv)
{
	int array[4][4];
	RAW       = 4;
	CAL       = 4;
	int count = 0;
	
	for(int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			array[i][j] = count;
			count++;
		}
	}

	printf("2D Array Printing Normal\n");
	printArr(array);

	/*
	 * This section of code creates a pointer to the [0,0] index of the integer array
	 * and passes this pointer (along with the number of rows and columns in the matrix) 
	 * to the printPtrArr function.
	 */ 
	printf("2D Array Printing with Pointers\n");
	int* ptr = &array[0][0];
	printPtrArr(ptr, 4, 4);

	/*
	 * This section retrieves an allocaed 2D array (a doubling of all values in the array 
	 * parameter). 
	 */
	int** doubled = double_array(ptr, 4, 4);
	
	printf("Doubled array is holding:\n");
	
	for(int i = 0; i < 4; i++)
	{
		for(int j = 0; j < 4; j++)
		{
			printf("%d ", doubled[i][j]);	
		}
		printf("\n");
	}
	
	
	return 0;
}
