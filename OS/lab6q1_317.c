#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

void *runner(void *param);
int main (int argc, char *argv[]) {
    int msum = 0; 
	pthread_t tid;
	pthread_attr_t attr;
	pthread_attr_init(&attr);
	int upper = atoi(argv[1]);
	if (upper > 0) {
		for (int i =1; i <= 2*upper;i++) {
			msum += i;
		}
	}
	printf("msum = %d \n", msum);
	pthread_create(&tid,&attr,runner,argv[1]);
	pthread_join(tid,NULL);
}
void *runner(void *param) {
	int upper = atoi(param);
	int i;
	int csum = 0;
	if (upper > 0) {
		for (i = 1; i <= upper; i++) {
                     csum += i;
                }
	}
	printf("csum = %d \n", csum);
pthread_exit(0);
}
