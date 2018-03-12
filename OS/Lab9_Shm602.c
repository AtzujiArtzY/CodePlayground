#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <sys/types.h>

void  ClientProcess(int []);

int main(int argc, char const *argv[]) {
    int pid;
   	int	*ShmPTR;
   	int num = atoi(argv[1]);
   	//int Csum = 0;
    /* the identifier for the shared memory segment */
    int	ShmID;

    /** allocate  a shared memory segment */
    ShmID = shmget(IPC_PRIVATE,1*sizeof(int), IPC_CREAT | 0666);

    /** attach the shared memory segment */
    ShmPTR = (int *) shmat(ShmID, NULL, 0);
    
    /* 	populate shared memory */
    // ShmPTR[0] = 0;	    ShmPTR[1] = 0;
    // ShmPTR[2] = 0;		ShmPTR[3] = 0;

    /* fork another process */
    for (int i = 0; i < 3; i++) {
    	pid = fork();
	    if (pid == 0) {	/* child process */
    		if (i == 0) {
    			printf("Child 1\n");
    			int sum = 0;
    			for (i = 1; i <= num; i++) {
					sum += i;
				}
			*(ShmPTR) += sum;
    		}
    		if (i == 1) {
    			printf("Child 2\n");
    			int sum = 0;
    			for (i = 1; i <= 2*num; i++) {
					sum += i;
				}
			*(ShmPTR) += sum;
    		}
    		if (i == 2) {
    			printf("Child 3\n");
    			int sum = 0;
    			for (i = 1; i <= 3*num; i++) {
					sum += i;
				}
			*(ShmPTR) += sum;
    		}
	        /** pass ShmPTR to client   */
			ClientProcess(ShmPTR);
			exit(0);  
	    }  
	}
	/* parent process */
	    //sleep(1);
	    //wait(NULL);
	    printf("Sum = %d\n",*(ShmPTR)); //Print Sum
	    printf("Server has detected the completion of its child...\n");
	    shmdt((void *) ShmPTR);
	    printf("Server has detached its shared memory...\n");
	    shmctl(ShmID, IPC_RMID, NULL);
	    printf("Server has removed its shared memory...\n");
	    printf("Server exits...\n");
	    
	    exit(0);  
   
}

void  ClientProcess(int  SharedMem[]) {
     printf("   Client found %d in shared memory\n",SharedMem[0]);
     printf("   Client is about to exit\n");
} 

