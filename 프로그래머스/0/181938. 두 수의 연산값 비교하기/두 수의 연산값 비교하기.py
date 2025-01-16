def solution(a, b):
    
    strX = str(a) + str(b)
    x = int(strX)
    y = 2 * a * b
    answer = max(x, y)
    
    return answer