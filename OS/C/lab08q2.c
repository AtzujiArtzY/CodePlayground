/* NOT WORKING */
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<unistd.h>
#include <sys/wait.h>
#define SIZE 1024
int main(int argc, char const *argv[]){
	int pfd[2];
	int nread;
	int pid;
	char buf[SIZE];
	int num = atoi(argv[1]);
	if (argc != 2) {
		printf("Usage lab8_pipe <number>\n");
		exit(0);
	}
	num = atoi(argv[1]); //Question 6
	if (pipe(pfd) == -1) {
		perror("pipe failed");
		exit(1);
	}
	if ((pid = fork()) < 0) {
		perror("fork failed");
		exit(2);
	}
	if (pid == 0) {	/*Child*/
		char *str; 
		close(pfd[0]); //Question 7
		printf("Child: I am calculating\n");
		int i, sum =0;
		for (i = 1; i <= num; i++) {
			sum += i;
		}
		sprintf(str,"%d",sum);
		strcpy(buf,str); //Question 8
		printf("Child: I am sending data\n");
		write(pfd[1], buf, strlen(buf)+1); //Question 9
		printf("Child: Goodbye\n");
		close(pfd[1]); //Question 10
	}
	else { 	/*Parent*/
		wait(0); //Question 11
		printf("Parent: waiting for my child\n");
		close(pfd[1]); //Question 12
		while((nread = read (pfd[0],buf,SIZE)) != 0); //Question 13
		int sum;
		sum = atoi(buf);
		printf("Parent: Sum from my child is %d\n",sum );
		printf("Parent: Goodbye\n");
		close(pfd[0]); //Question 14
	}
	exit(0);
}