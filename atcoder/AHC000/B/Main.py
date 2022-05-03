from sys import stdin
input = stdin.readline

D = input()
c = list(map(int, input().rstrip().split(" ")))
s = []
for i in range(D):
    s.append(list(map(int, input().split())))
t = []
for i in range(D):
    t.append(int(input()))

last = [0 for i in range(26)]

v = 0

for i in range(D):
    v = v + s[D][t[i]]
    v = v - sum([c[j]*(i-last[j]) for j in range(26)])
    last[t[i]] = i
    print(v)
