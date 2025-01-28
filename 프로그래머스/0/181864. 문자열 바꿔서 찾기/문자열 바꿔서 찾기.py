def solution(myString, pat):
    answer = 0
    tmp = ''
    
    for c in myString:
        if c == 'A':
            tmp += 'B'
        else :
            tmp += 'A'
    
    if pat in tmp:
        answer = 1
    
    return answer