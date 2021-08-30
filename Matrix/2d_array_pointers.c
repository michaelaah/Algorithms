
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

	printf("2D Array Printing with Pointers\n");
	int* ptr = &array[0][0];
	printPtrArr(ptr, 4, 4);

	return 0;
}
