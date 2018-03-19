/*10*/	#include <pthread.h> 	// for pthread_create, pthread_join, pthread_exit
/*20*/	#include <stdio.h>   	// for printf 
/*30*/	#include <stdlib.h>  	// for exit
/*40*/	#include <semaphore.h> 	// for POSIX semaphore

/*50*/	#define NITER 1000000

/*60*/	int cnt = 0;
/*70*/	sem_t myMutex;		//tid1 and tid2 will race obtaining this semaphore
		
/*80*/	void * Count(void * a) {
/*90*/	    int i, tmp;
			int sem_wait(sem_t *myMutex);
/*100*/	    for(i = 0; i < NITER; i++)   {
/*110*/	        tmp = cnt;      /* copy the global cnt locally */
/*120*/	        tmp = tmp+1;    /* increment the local copy */
/*130*/	        cnt = tmp;      /* store the local value into the global cnt */ 
/*140*/	    }
			int sem_post(sem_t *myMutex);
/*150*/	}

/*160*/	int main(int argc, char * argv[]) {
			int sem_init(sem_t *myMutex, int pshared, unsigned int value);
/*170*/	    pthread_t tid1, tid2;
			
/*180*/	    if(pthread_create(&tid1, NULL, Count, NULL)) {
/*190*/	        printf("\n ERROR creating thread 1");	    exit(1);
/*210*/	    }

/*220*/	    if(pthread_create(&tid2, NULL, Count, NULL)) {
/*230*/	        printf("\n ERROR creating thread 2");	    exit(1);
/*250*/	    }

/*260*/	    if(pthread_join(tid1, NULL)) {       /* wait for the thread 1 to finish */
/*270*/	        printf("\n ERROR joining thread");	        exit(1);
/*290*/	    }

/*300*/	    if(pthread_join(tid2, NULL)) {       /* wait for the thread 2 to finish */
/*310*/	        printf("\n ERROR joining thread");	        exit(1);
/*330*/	    }

/*340*/	    if (cnt < 2 * NITER) 
/*350*/	        printf("\n BOOM! cnt is [%d], should be %d\n", cnt, 2*NITER);
/*360*/	    else
/*370*/	        printf("\n OK! cnt is [%d]\n", cnt);
  
/*380*/	    pthread_exit(NULL);
			int sem_destroy(sem_t *myMutex);
/*390*/	}


