public class ArrayCopier{
	public void copy(int[] src,int[] dst){
		int i;
		for(i=0; i<src.length&&i<dst.length; i++){
			dst[i]=src[i];
		}
		while(i<dst.length){
			dst[i]=0;
			i++;
		}
	}
}