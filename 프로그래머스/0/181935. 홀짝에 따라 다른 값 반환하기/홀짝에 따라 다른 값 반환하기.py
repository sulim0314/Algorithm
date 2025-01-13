def solution(n):
    answer = 0
    
    if n % 2 == 0 :
        # 짝수일 때
        for i in range(n+1):
            if(i % 2 == 0):
                answer += i**2
    else :
        # 홀수일 때
        for i in range(1, n+1):
            if(i % 2 == 1):
                answer += i
    
    
    return answer