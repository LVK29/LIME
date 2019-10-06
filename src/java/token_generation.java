import java.util.*;
public class token_generation 
{
    public static String skey()
    {
        String secret_key="";
                                Random r = new Random();
                               for(int i=0;i<3;i++)
                               {
                                   char ch=(char)(r.nextInt(26)+'a');
                                   int digit=r.nextInt(9);
                                   secret_key+=ch+""+digit;
                               }
                               return secret_key;
    }
    
}
