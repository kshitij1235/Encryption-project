package p1;

public class Enc_box {
    
  public static char p[] =
	{
    	'a' , 'b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
	};
	public static char ch[] =
	{
    	'Q' , 'W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M',
	};
	public static String encrypt(String s)
	{
    	char c[]=new char[(s.length())];
    	for(int i=0;i<s.length();i++)
    	{
        	for (int j=0;j<26;j++)
        	{
            	if(p[j]==s.charAt(i))
            	{
                	c[i]=ch[j];
                	break;
            	}
        	}
    	}
    	return(new String (c));
	}

public  static String encrypt_v(String plaintext,String secretkey)
	{
 	StringBuffer encryptedString=new StringBuffer();
 	int encryptedInt;
 	for(int i=0;i<plaintext.length();i++)
 	{
     	int plaintextInt=(int)(plaintext.charAt(i));
     	int secretkeyInt=(int)(secretkey.charAt(i));
     	encryptedInt=(plaintextInt+secretkeyInt)%26;
       	encryptedString.append((char)((encryptedInt)+(int)'A'));
 	}
    	return encryptedString.toString();
	}  



}

    

