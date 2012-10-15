public class MatrixChecker{
	Boolean isSymmetrical(int[] arr){
		for(int i=0; i<arr.length; i++){
			if(arr[i]!=arr[arr.length-1-i]){
				return false;
			}
		}
		return true;
	}
	
	Boolean isSymmetrical(int[][] mat){
		for(int i=0; i<mat.length; i++){
			if(mat[i].length != mat.length){
				return false;
			}
			for(int j=0; j<mat[i].length; j++){
				if(mat[i][j]!=mat[j][i]){
					return false;
				}
			}
		}
		return true;
	}
	
	Boolean isTriangular(int[][] mat){
		for(int i=0; i<mat.length; i++){
			for(int j=i+1; j<mat[i].length; j++){
				if(mat[i][j]!=0){
					return false;
				}
			}
		}
		return true;
	}
}