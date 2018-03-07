#include<stdlib.h>
#include<unistd.h>
#include<stdio.h>
#include<signal.h>
void ding (int);
int done = 1;
int main(void){
	//Question1
	signal(SIGALRM, ding);
	pid_t pid;
	pid = fork();
	if (pid==0) {
		printf("Child: Sleeping for 5 seconds\n");
		sleep(2);
		//Question2
		printf("Child sending SIGALRM\n");
		kill(getppid(), SIGALRM);
		//Question3
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
	//Question4
	printf("Parent: OK SIGALRM has been received\n");
	//Question5
	signal(SIGALRM, ding);
	exit(0);
}