def solution(numbers):
    answer = 0
    
    numbers.sort(reverse = True)
    a = numbers[0]
    b = numbers[1]
    
    answer = a * b
    
    return answer