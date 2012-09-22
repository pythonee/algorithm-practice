import random
import datetime
import copy

def bubblesort(data):
    for i in range(len(data) - 1, 0, -1):
        for j in range(0, i):
            if data[j] > data[j + 1]:
                data[j], data[j + 1] = data[j + 1], data[j]


def quicksort(data):
    ll = []
    lr = []
    if len(data) <= 1:
        return data
    else:
        for i in data[1:]:
            if i < data[0]:
                ll.append(i)
            else:
                lr.append(i)
        return quicksort(ll) + data[0:1] + quicksort(lr)

def selectsort(data):
    for i in range(0, len(data)):
        min = i
        for j in range(i+1, len(data)):
            if data[j] < data[min]:
                min = j
        data[i],data[min] = data[min],data[i]


def heap_adjust(data, s, m):
    if 2 * s > m:
        return
    temp = s - 1
    if data[2*s - 1] > data[temp]:
        temp = 2 * s - 1
    if 2 * s <= m - 1 and data[2*s] > data[temp]:
        temp = 2 * s
    if temp <> s - 1:
        data[s - 1], data[temp] = data[temp], data[s - 1]
        heap_adjust(data, temp + 1, m)
def heap_sort(data):
    m = len(data) / 2
    for i in range(m, 0, -1):
        heap_adjust(data, i, len(data))
    data[0], data[-1] = data[-1], data[0]
    for n in range(len(data) - 1, 1, -1):
        heap_adjust(data, 1, n)
        data[0], data[n - 1] = data[n - 1], data[0]

def sort_perfmorn(sortfunc, data):
    sort_data = copy.deepcopy(data)
    t1 = datetime.datetime.now()
    sortfunc(sort_data)
    t2 = datetime.datetime.now()
    print sortfunc.__name__, t2 - t1
    #print sort_data

data = [random.randint(0, 65536) for i in range(2000)]
sort_perfmorn(bubblesort,data)
sort_perfmorn(quicksort,data)
sort_perfmorn(selectsort,data)
sort_perfmorn(heap_sort,data)


