lst=['abcx','def', 'ghi']
def make(*vargs):
    s=''
    for i in range(len(lst)):
      s= s+lst[i][vargs[i]]
    return s

def dynamic_for_loop(lst, *vargs):
    print(lst, vargs)
    if not lst:
        final.append(make(*vargs))
    else:
        bounds = lst[0]
        for i in range(len(bounds)):
            dynamic_for_loop(lst[1:],  *(vargs + (i,)))

final =[]
dynamic_for_loop(lst)
print(final)


