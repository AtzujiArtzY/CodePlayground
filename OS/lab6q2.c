#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int csum = 0;
void *runner(void *param);
int main (int argc, char *argv[]) {
	pthread_t tid;
	pthread_attr_t attr;
	pthread_attr_init(&attr);
	pthread_create(&tid,&attr,runner,argv[1]);
	int sum = 0;
	int msum = 0;
	int upper = atoi(argv[1]);
	if (upper > 0) {
		for (int i =1; i <= 2*upper;i++) {
			msum += i;
		}
	}
	printf("msum = %d \n", msum);
	pthread_join(tid,NULL);
	sum = msum - csum;
	printf("sum = %d\n",sum);
}
void *runner(void *param) {
	int upper = atoi(param);
	int i;
	if (upper > 0) {
		for (i = 1; i <= upper; i++) {
                     csum += i;
                }
	}
	printf("csum = %d \n", csum);
	pthread_exit(0);
}
