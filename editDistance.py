#edit distance dp
def editDistance(a,b):
	row=len(a)+1
	col=len(b)+1
	ed=[]
	for i in range(row):
	    ed.append([0]*col)
	ed[row-1]=[len(b)-j for j in range(col)]
	for i in range(row):
	    ed[i][col-1]=len(a)-i
	for i in range(len(a)-1,-1,-1):
		for j in range(len(b)-1,-1,-1):
			if a[i]==b[j]:
				ed[i][j]=ed[i+1][j+1]
			else:
				ed[i][j]=1+min(ed[i+1][j+1],min(ed[i+1][j],ed[i][j+1]))
	print (ed[0][0])
	iptr=0
	jptr=0
	while iptr<row-1 and jptr<col-1:
	    if ed[iptr][jptr]==1+ed[iptr+1][jptr]:
	        print ("delete",a[iptr])
	        iptr+=1
	    elif ed[iptr][jptr]==1+ed[iptr][jptr+1]:
	        print ("insert",b[jptr])
	        jptr+=1
	    elif ed[iptr][jptr]==1+ed[iptr+1][jptr+1]:
	        print ("substitute",b[jptr],"for",a[iptr])
	        iptr+=1
	        jptr+=1
	    elif ed[iptr][jptr]==ed[iptr+1][jptr+1]:
	        iptr+=1 
	        jptr+=1
	        


a=input()
b=input()
editDistance(a,b)