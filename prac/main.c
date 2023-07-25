#include <stdio.h>
#include<time.h>
#include <stdlib.h>
 void select()
 {

     int n,min;
     printf("Enter the size of array");
     scanf("%d",&n);
     int a[n];
     printf("\nEnter the elemnts");
     for(int i=0;i<n;i++)
        scanf("%d",&a[i]);
     int temp;
     for(int i=0;i<n-2;i++)
     {
         for(int j=i+1;j<n-1;j++)
         {
             if(a[i]>a[j])
             {
                 min=j;
                 temp=a[i];
                 a[i]=a[min];
                 a[min]=temp;
             }
         }
     }
     printf("Sorted array is:\t");
     for(int i=0;i<n;i++)
        printf("%d\n",a[i]);
 }
 int main()
 {
     clock_t start,stop;
     double tot;
     start=clock();
     select();
     stop=clock();
     tot=(double)(stop-start)/CLOCKS_PER_SEC;
     printf("%f",tot);
     return 0;
 }
