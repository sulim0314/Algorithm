def solution(wallet, bill):
    answer = 0
    w1 = wallet[0]
    w2 = wallet[1]
    b1 = bill[0]
    b2 = bill[1]
    
    while True:
        if (w1>=b1 and w2>=b2) or (w2>=b1 and w1>=b2):
            break
        else:
            answer = answer+1
            if b1 > b2:
                b1 = b1//2
            else:
                b2 = b2//2
    
    return answer