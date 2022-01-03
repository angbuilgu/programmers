import math
def solution(n):
    nn = int(math.sqrt(n))
    if nn * nn == n:
        return (nn+1)*(nn+1)
    else:
        return -1

'''
한줄
import math
def solution(n):
    return (math.sqrt(n)+1)*(math.sqrt(n)+1) if int(math.sqrt(n))*int(math.sqrt(n)) == n else -1

'''