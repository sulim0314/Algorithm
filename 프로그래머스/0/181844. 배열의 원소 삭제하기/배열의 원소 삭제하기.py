def solution(arr, delete_list):
    answer = arr
    
    for d in delete_list:
        if d in arr:
            answer.remove(d)
    
    return answer