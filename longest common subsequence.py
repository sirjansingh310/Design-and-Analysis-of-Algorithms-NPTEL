#longest common subsequence dp
def longestCommonSubsequence(a,b):
	row=len(a)+1
	col=len(b)+1
	lcs=[]
	for i in range(row):
		lcs.append([0]*col)
	for i in range(len(a)-1,-1,-1):
		for j in range(len(b)-1,-1,-1):
			if a[i]==b[j]:
				lcs[i][j]=1+lcs[i+1][j+1]
			else:
				lcs[i][j]=max(lcs[i+1][j],lcs[i][j+1])
	print (lcs[0][0])
	iptr=0
	jptr=0
	subsequence=""
	while iptr<row-1 and jptr<col-1:
		if lcs[iptr][jptr]==lcs[iptr][jptr+1]:
			jptr+=1
		elif lcs[iptr][jptr]==lcs[iptr+1][jptr]:
			iptr+=1
		elif lcs[iptr][jptr]==1+lcs[iptr+1][jptr+1]:
			subsequence+=a[iptr]
			iptr+=1
			jptr+=1
	print (subsequence)

a=input()
b=input()
longestCommonSubsequence(a,b)
