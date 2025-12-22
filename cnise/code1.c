//server

#include<stdio.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<sys/fcntl.h>
#include<stdlib.h>
int main(int argc,char *argv[])
{
int fd,sockfd,newsockfd,clilen,portno,n;
struct sockaddr_in seradd,cliadd;
char buffer[4096];
if(argc<2)
{
fprintf(stderr,"\n\n No port\n");
exit(1);
}
portno=atoi(argv[1]);
sockfd=socket(AF_INET,SOCK_STREAM,0);
if(sockfd<0)
error("\n error opening socket.\n");
bzero((char *)&seradd,sizeof(seradd));
seradd.sin_family=AF_INET;
seradd.sin_addr.s_addr=(htonl)INADDR_ANY;
seradd.sin_port=htons(portno);
if(bind(sockfd,(struct sockaddr *)&seradd,sizeof(seradd))<0)
perror("\n IP addr cannt bind");
listen(sockfd,5);
clilen=sizeof(cliadd);
printf("\n Server waiting for clint request\n");
while(1)
{
newsockfd=accept(sockfd,(struct sockaddr *)&cliadd,&clilen);
if(newsockfd<0)
perror("\n Server cannot accept connection request ");
bzero(buffer,4096);
read(newsockfd,buffer,4096);
fd=open(buffer,O_RDONLY);
if(fd<0)
perror("\n File  doesnot exist");
while(1)
{
n=read(fd,buffer,4096);
if(n<=0)
exit(0);
write(newsockfd,buffer,n);
printf("\n File transfer completet\n");
}
close(fd);
close(newsockfd);
}
return 0;}

//1st

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char data[100], frame[120], concat[120];
char divisor[18], divident[18], crc[17];
char zero[17] = "0000000000000000";

void crc_cal(char *input)
{
    int i, j;

    for (i = 0; i <= 16; i++)
        divident[i] = input[i];
    divident[17] = '\0';

    for (j = 17; j <= strlen(input); j++)
    {
        if (divident[0] == '1')
            for (i = 1; i <= 16; i++)
                divident[i - 1] = (divident[i] != divisor[i]) ? '1' : '0';
        else
            for (i = 1; i <= 16; i++)
                divident[i - 1] = divident[i];

        divident[16] = input[j];
    }

    strcpy(crc, divident);
    printf("\ncrc is %s\n", crc);
}

int main()
{
    printf("enter the generator bits\n");
    gets(divisor);

    if (strlen(divisor) != 17)
    {
        printf("please enter the generator length min of 17 bits\n");
        exit(0);
    }

    printf("\n At src node :\n Enter the msg to be sent :");
    gets(data);

    strcpy(concat, data);
    strcat(concat, zero);

    crc_cal(concat);

    printf("\ndata is:\t%s", data);
    printf("\n The frame transmitted is :\n%s%s", data, crc);
    printf("\n\t\tSOURCE NODE TRANSMITTED THE FRAME---->");

    printf("\n\n\n\n\t\t\tAT DESTINATION NODE\nenter the recived frame:\t");
    gets(frame);

    crc_cal(frame);

    if (strcmp(crc, zero) == 0)
        printf("\nRecived frame is error free .\n");
    else
        printf("\nRecived frame containes one or more error ");

    return 1;
}

//2nd
#include<stdio.h> 
struct rtable 
{ 	
int dist[20],nextnode[20]; 
}table[20];
 int cost[10][10],n; 
 void distvector() 
{ 	
int i,j,k,count=0; 	
for(i=0;i<n;i++) 	
{ 		
for(j=0;j<n;j++) 		
{ 			
table[i].dist[j]=cost[i][j]; 			
table[i].nextnode[j]=j; 		
} 	}   
do   
{ 	  
count=0; 		
for(i=0;i<n;i++) 		
{ 			
for(j=0;j<n;j++) 			
{ 			
for(k=0;k<n;k++) 				
{ 					
if(table[i].dist[j]>cost[i][k]+table[k].dist[j]) 			
{ 						
table[i].dist[j]=table[i].dist[k]+table[k].dist[j]; 			
table[i].nextnode[j]=k; 								
count++; 					
} 				
} 			
} 		
} 
}while(count!=0); 
} 
int main() 
{ 	
int i,j; 	
printf("\nenter the no of vertices:\t"); 
scanf("%d",&n); 
printf("\nenter the cost matrix\n"); 	
for(i=0;i<n;i++) 			
for(j=0;j<n;j++) 				
scanf("%d",&cost[i][j]); 	
distvector(); 	
for(i=0;i<n;i++) 	
{ 		
printf("\nstate value for router %c \n",i+65);
printf("\ndestnode\tnextnode\tdistance\n"); 
for(j=0;j<n;j++) 		
{ 			
if(table[i].dist[j]==99) 	
printf("%c\t\t-\t\t infinite\n",j+65); 
else 				
printf("%c\t\t%c\t\t%d\n",j+65,table[i].nextnode[j]+65,table[i].dist[j]); 	
}      
} 
return 0;     

 }
