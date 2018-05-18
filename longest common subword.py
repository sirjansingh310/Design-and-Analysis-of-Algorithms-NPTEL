#longest common subword dynamic programming solution
def longestCommonSubword(a,b):
	lcw=[]
	row=len(a)+1
	col=len(b)+1
	maxLcw=-1
	index=len(a)+1# index will track the position of longest common subword in string a
	for i in range(row):
		lcw.append([0]*col)
	for i in range(len(a)-1,-1,-1):
		for j in range(len(b)-1,-1,-1):
			if a[i]==b[j]:
			     lcw[i][j]=lcw[i+1][j+1]+1
			if lcw[i][j]>maxLcw:
				maxLcw=lcw[i][j]
				index=i 
	print (maxLcw)
	subword=""
	while maxLcw>=1:
		subword+=a[index]
		index+=1
		maxLcw-=1
	print (subword)

a=input()
b=input()
longestCommonSubword(a,b)