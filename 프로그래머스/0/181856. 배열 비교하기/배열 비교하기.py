def solution(arr1, arr2):
    answer = 0
    
    if len(arr1) < len(arr2):
        answer = -1
    elif len(arr1) > len(arr2):
        answer = 1
    else:
        sum1 = 0
        sum2 = 0
        for n in arr1:
            sum1 += n
        for m in arr2:
            sum2 += m
        
        if sum1 > sum2 :
            answer = 1
        elif sum1 < sum2 :
            answer = -1
    
    return answer