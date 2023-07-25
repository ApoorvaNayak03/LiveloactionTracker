#include <stdio.h>
#include <stdlib.h>
#include<time.h>
int res[100],n,a[100][100],s[100],k=1;
void top(int u,int s[])
{
     int v,i;
    s[u]=1;
    for(int v=1;v<=n;v++)
    {
        if(a[u][v]==1&&s[v]==0)
        {
            top(v,s);
        }
    }
    res[k++]=u;
}








int main()
{
    int n,a[100][100],i,u,j;
    printf("Enter the no of vertices");
    scanf("%d",&n);
    printf("Enter the adjacency matrix\n");
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            scanf("%d",&a[i][j]);
        }
    }
    clock_t  start,stop;
    for(j=1;j<=n;j++)
    {
        s[j]=0;
    }
    start=clock();
    for(int i=1;i<=n;i++)
    {
        if(s[i]==0)
        {
            top(i,s);
        }
    }
    stop=clock();
    printf("Array after sorting is \n");
    for(int i=n;i>=1;i++)
    {
        printf("%d",res[i]);
    }
    printf("\n");
    double t=(double)(start-stop)/CLOCKS_PER_SEC;
    printf("Time taken is %f",t);
    return 0;
}
