Matrix ma = new Matrix(3,4);
ma.prettyPrint();
ma.setElement(2,2);
ma.prettyPrint();
ma.setElement(3,3);
ma.prettyPrint();
ma.setRow(2,"6,7,8,9");
ma.prettyPrint();
ma.setRow(3,"6,7,8,9");
ma.prettyPrint();
ma.setColumn(2,"3,4,5");
ma.prettyPrint();
println "String version: " + ma.toString();
ma.setMatrix("1,2,3,4;5,6,7,8;9,10,11,12");
ma.prettyPrint();

int[] wa = [0,1,2,3,4,4,3,2,1,0];
MatrixChecker mc = new MatrixChecker();
println "Symmetric array? " + mc.isSymmetrical(wa);

Matrix ma2 = new Matrix(4,4);
ma2.setMatrix("0,1,2,3;1,6,6,2;2,6,6,1;3,2,1,0");
ma2.prettyPrint();
println "Symmetric matrix? " + mc.isSymmetrical(ma2.getMatrix())

Matrix ma3 = new Matrix(4,4);
ma3.setMatrix("1,0,0,0;1,2,0,0;1,2,3,0;1,2,3,4");
ma3.prettyPrint();
println "Triangular matrix? " + mc.isTriangular(ma3.getMatrix())

