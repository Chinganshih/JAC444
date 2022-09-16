/* JAC444 - workshop 1 */
/* Member 1 - 148221195 Ching an shih */
/* Member 2 -  */
/* Member 3 -  */

 
class NestLoop
{
	public static void main (String[] args)
	{
		int rows = 8;
		
		for (int i=1; i<rows*2; i+=2){
            for (int k=0; k < ((rows-1) - i / 2); k++){
                 System.out.print(String.format("%4s"," "));
            }
            int number = 1;
            for (int j=0; j < (i/2); j++){
                System.out.print(String.format("%4s",number));
                number *= 2;
            }
            for (int j= (i/2); j < i; j++){
                System.out.print(String.format("%4s",number));
                number /= 2;
            }
            System.out.println("");
        }
    }
}