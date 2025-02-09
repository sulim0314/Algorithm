def solution(todo_list, finished):
    answer = []
    
    for idx, val in enumerate(finished):
        if not val:
            answer.append(todo_list[idx])
    
    return answer