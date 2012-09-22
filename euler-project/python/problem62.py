import itertools
 
def cubic_permutations(N):
    sorted_cubes={}
    possible_answers=[]
    for c in (x**3 for x in itertools.count(1)):
        s = ''.join(sorted(str(c)))
        if possible_answers and len(s) > digits:
            # Can now rely on last digit result being complete
            # Need to check no more permuations were added.
            possible_answers = [l for l in possible_answers if len(l)==N]
 
            if possible_answers:
                return min(map(min, possible_answers))
 
        l = sorted_cubes.setdefault(s,[])
        l.append(c)
        if len(l)==N:
            possible_answers.append(l)
            digits=len(s)
 
print cubic_permutations(5)
