def solution(num_list, n):
    answer = []
    
    for idx, val in enumerate(num_list):
        if idx % n == 0:
            answer.append(val)
    
    return answer