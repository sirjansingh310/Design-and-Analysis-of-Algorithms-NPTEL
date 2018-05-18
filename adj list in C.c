#include <stdio.h>
#include <stdlib.h>

struct node{
    int val;
    struct node* next;
    struct node *head;
    struct node *last;// head and last pointer member of every adj list, thats why not declared globally in structure
    
};

struct node adj[100];
void addEdge(int a,int b){
    struct node* new = (struct node*)malloc(sizeof(struct node));
    new->val=b;
    new->next = NULL;
    if(adj[a].head==NULL){
        adj[a].head=new;
        adj[a].last=new;
    }
    else{
        adj[a].last->next = new;
        adj[a].last = new;
    }
}
void display(int i){
    struct node* temp =adj[i].head;
    while(temp!=NULL){
        printf("%d -> %d\n",i,temp->val);
        temp=temp->next;
    }
    printf("\n");
}
void printEdges(int n){
    int i=0;
    for(i=0;i<n;i++){
        display(i);
    }
}

int main() {
    int n;
    scanf("%d",&n);
    int m;
    scanf("%d",&m);
    int i=0;
    for(i=0;i<m;i++){
        int a,b;
        scanf("%d",&a);
        scanf("%d",&b);
        addEdge(a,b);
        addEdge(b,a);
    }
    
    printEdges(n);
	return 0;
}