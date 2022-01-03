import math
def solution(n):
    nn = int(math.sqrt(n))
    if nn * nn == n:
        return (nn+1)*(nn+1)
    else:
        return -1