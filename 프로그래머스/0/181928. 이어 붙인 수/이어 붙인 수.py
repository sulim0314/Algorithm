def solution(num_list):
    answer = 0
    odd = ""
    even = ""
    
    for num in num_list:
        if num % 2 == 0:
            even = even + str(num)
        else:
            odd = odd + str(num)
    
    answer = int(odd) + int(even)
    return answer