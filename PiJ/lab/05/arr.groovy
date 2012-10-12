ArrayCopier cp = new ArrayCopier();

int[] a = [1,2,3,4,5];
int[] b = new int[4];
int[] c = new int[5];
int[] d = new int[6];

cp.copy(a,b)
println b;

cp.copy(a,c)
println c;

cp.copy(a,d)
println d;