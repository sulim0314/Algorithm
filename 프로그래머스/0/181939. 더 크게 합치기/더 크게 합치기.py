def solution(a, b):
    answer = 0
    
    str1 = str(a)+str(b)
    int1 = int(str1)
    str2 = str(b)+str(a)
    int2 = int(str2)
    answer = max(int1, int2)
    
    return answer