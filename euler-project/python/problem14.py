"""Solves Problem 14 from Project Euler."""

def _gen_sequence(seed, cur_sequence = None):
    """Generates a sequence following the rules from Problem 14.
    
    >>> _gen_sequence(13)
    [13, 40, 20, 10, 5, 16, 8, 4, 2, 1]"""
    if not cur_sequence:
        cur_sequence = []
    cur_sequence.append(seed)
    if seed == 1:
        return cur_sequence
    elif seed % 2:
        return _gen_sequence(3 * seed + 1, cur_sequence)
    else:
        return _gen_sequence(seed / 2, cur_sequence)

def problem_14(upper_bound):
    """Finds the seed (< upper_bound and > 500000) for the longest sequence.

    >>> problem_14(502873)
    502137
    """
    cur_answer = 0, 0  # Track the length too, just out of curiosity.
    for seed in reversed(xrange(500001, upper_bound, 2)):
        cur_length = len(_gen_sequence(seed))
        if cur_length > cur_answer[1]:
            cur_answer = seed, cur_length
    return cur_answer[0]

if __name__ == '__main__':
    print problem_14(1000000)
