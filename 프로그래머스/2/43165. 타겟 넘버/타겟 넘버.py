def solution(numbers, target):
    count = 0
    results = [0]
    
    for n in numbers:
        tmp = []
        
        for r in results:
            tmp.append(r + n)
            tmp.append(r - n)
        
        results = tmp
    
    for r in results:
        if r == target:
            count += 1
    
    return count

