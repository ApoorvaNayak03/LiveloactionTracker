
#include <stdio.h>
#include <time.h>
void swap(int* a, int* b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}
void heap(int a[], int N, int i)
{

    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (left < N && a[left] > a[largest])
        largest = left;
    if (right < N && a[right] > a[largest])
        largest = right;
    if (largest != i) {
        swap(&a[i], &a[largest]);
        heap(a, N, largest);
    }
}
void heapSort(int a[], int N)
{


    for (int i = N / 2 - 1; i >= 0; i--)

        heap(a, N, i);

    for (int i = N - 1; i >= 0; i--) {

        swap(&a[0], &a[i]);
        heap(a, i, 0);
    }
}
void printArray(int a[], int N)
{
    for (int i = 0; i < N; i++)
        printf("%d ", a[i]);
    printf("\n");
}
int main()
{
clock_t start,end;
double t;

	int a[100] , N;

	printf("Enter the size : ");
	scanf("%d",&N);

	printf("Enter the elements :\n");
	for(int i = 0 ; i < N ; i++)
	{
		scanf("%d", &a[i]);
	}
	start=clock();
    heapSort(a, N);
    end=clock();
    printf("Sorted array is\n");
    printArray(a, N);
    t=(double)(end-start)/CLOCKS_PER_SEC;
    printf("time taken is:\n %f sec",t);

}

