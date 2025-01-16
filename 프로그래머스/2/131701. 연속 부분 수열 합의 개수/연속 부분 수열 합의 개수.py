def solution(elements):
    result_set = set() 
    
    n = len(elements)
    circular_elements = elements * 2 
    
    for length in range(1, n + 1):
        for start in range(n):
            s = sum(circular_elements[start:(start+length)])
            result_set.add(s)
    
    return len(result_set)
