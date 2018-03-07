#include<stdlib.h>
#include<unistd.h>
#include<stdio.h>
#include<sys/types.h>
#include<sys/wait.h>
int main(){
int sel;
pid_t pid;
while(sel != 0){
	printf("---Menu---\n");
	printf("  1: ls \n  2: ps \n  3: who \n  0 to Exit\n");
	scanf("%d",&sel);
	pid = fork();
		if (pid == 0) { //Chlid
			if (sel == 1){
				execlp("ls","ls",NULL);
			}
			else if(sel == 2){
				execlp("ps","ps",NULL);
			}
			else if(sel == 3){
				execlp("who","who",NULL);
			}
		}
		else  {   //Parent
      		wait(NULL);
		}
	}
}
