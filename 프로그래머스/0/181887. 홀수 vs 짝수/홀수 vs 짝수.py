def solution(num_list):
    sum1 = 0
    sum2 = 0
    
    for idx, val in enumerate(num_list):
        if idx % 2 == 0:
            sum2 += val
        else:
            sum1 += val
            
    answer = sum2
        
    if sum1 > sum2:
        answer = sum1
    
    return answer