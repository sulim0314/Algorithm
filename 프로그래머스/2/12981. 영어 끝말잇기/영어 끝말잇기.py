def solution(n, words):
    answer = [0, 0]

    hs = set()
    cnt = 0
    
    for i in range(len(words)) :
        w = words[i]
        cnt += 1
        
        # 1. 이미 사용된 단어인지 확인
        if w in hs:
            break
        
        # 2. 끝말잇기 규칙이 어긋나는지 확인
        if i > 0 and words[i-1][-1] != w[0]:
            break
        
        # 3. 단어를 set에 추가
        hs.add(w)
    
    else: # for문이 다 실행된다면
        return [0, 0]

    # 탈락한 사람 번호와 차례 계산
    answer[0] = (cnt - 1) % n + 1  # 사람 번호
    answer[1] = (cnt - 1) // n + 1  # 라운드 번호
    
    return answer