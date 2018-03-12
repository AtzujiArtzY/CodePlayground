#include<stdlib.h>
#include<unistd.h>
#include<stdio.h>
#include<signal.h>
void ding (int);
int done = 1;
int main(void){
	signal(SIGALRM, ding); //Question1
	pid_t pid;
	pid = fork();
	if (pid==0) {
		printf("Child: Sleeping for 5 seconds\n");
		sleep(5); //Question2
		printf("Child sending SIGALRM\n");  
		kill(getppid(), SIGALRM);  //Question3
		printf("Child: Bye bye\n");
	}
	else {
		printf("Parent: waiting for my child to send SIGALRM\n");
		while(done);
		printf("Parent: Bye bye\n");
	}
	return 0;
}
void ding(int sig) {
	signal(sig, SIG_IGN); //Question4
	printf("Parent: OK SIGALRM has been received\n");
	done = 0; //Question5
	signal(SIGALRM, ding);
}