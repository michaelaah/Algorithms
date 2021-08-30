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

int main (int argc, char** argv)
{
	int array[4][4];
	RAW = 4;
	CAL = 4;
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

	return 0;
}
