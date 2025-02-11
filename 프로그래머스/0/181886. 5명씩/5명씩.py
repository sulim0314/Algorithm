def solution(names):
    answer = []
    
    for idx, val in enumerate(names):
        if idx % 5 == 0:
            answer.append(val)
    
    return answer