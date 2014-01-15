#include <stdio.h>

int main() {
  int a,b;
  int MAX = 4000000;
  
  int sum = 0;
  a = 1;
  b = 2;

  while(a < MAX) {
    // increment sum if a (term 1) is even
    if(a % 2 == 0) sum += a;
    // hold value of b (term 2)
    int temp = b;
    // calculate new term 2
    b = a+b;
    // make a the new term 1
    a = temp;
  }

  printf("%d", sum);
    return 0;
}
