def solution(s):
    cnt = 0  # 올바른 괄호 문자열의 개수
    
    # 문자열을 왼쪽으로 한 칸씩 회전
    def rotate(s):
        return s[1:] + s[0]
    
    # 괄호 문자열 유효성 검사
    def count(s):
        stack = []
        
        for char in s:
            if char in "([{":  # 열린 괄호면 스택에 추가
                stack.append(char)
                
            else:  # 닫힌 괄호면 스택에서 짝 검사
                if not stack:
                    return False
                
                top = stack.pop()
                # 괄호 짝이 맞는지 확인
                if (top == '(' and char != ')') or \
                   (top == '[' and char != ']') or \
                   (top == '{' and char != '}'):
                    return False
        return not stack  # 스택이 비어 있어야 올바른 문자열
    
    # s를 회전시키며 검증
    for _ in range(len(s)):
        if count(s):  # 올바른 괄호 문자열인지 확인
            cnt += 1
        s = rotate(s)  # 문자열 회전
    
    return cnt
