// binary search tree traversals
#include<stdio.h>
#include<stdlib.h>
struct node{
	int value;
	struct node* left;
	struct node* right;
};
struct node* newNode(int v){
	struct node* newNode = (struct node*)malloc(sizeof(struct node));
	newNode->value=v;
	newNode->left=NULL;
	newNode->right=NULL;
}
void insert(struct node* k,int v){
   if(v<k->value){
   	if(k->left==NULL)
   		k->left = newNode(v);
   	else
   		insert(k->left,v);
   }
   else if(v>k->value){
      if(k->right==NULL)
      	k->right=newNode(v);
      else
      	insert(k->right,v);
   }
   else
   	return;
}
void inorder(struct node* k){
	if(k==NULL)
		return;
     inorder(k->left);
     printf("%d ",k->value);
     inorder(k->right);
}
void preorder(struct node* k){
    if(k==NULL)
    	return;
    printf("%d ",k->value);
    preorder(k->left);
    preorder(k->right);
}
void postorder(struct node* k){
	if(k==NULL)
		return;
	postorder(k->left);
	postorder(k->right);
	printf("%d ",k->value);
}
int main(){ 
	struct node* root=newNode(50);
	insert(root,60);
	insert(root,30);
    insert(root,10);
    insert(root,40);
    insert(root,55);
    insert(root,70);
    inorder(root);
    printf("\n");
    preorder(root);
    printf("\n");
    postorder(root);

}