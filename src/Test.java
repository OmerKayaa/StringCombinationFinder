import Finder.TreeWithHashSetDictionary;

import java.util.Scanner;

public class Test
{

    public static void main(String[] args)
    {
        System.out.println("Add word to dictionary: '+' <word>\nFind word: '-' <word>\nConditionals: 0 Word Contains Query" +
                ", 1 SubQuery Contains Word, 3 Exact Match\nConditional find:<Condition><Query>\nExit:'E'");
        TreeWithHashSetDictionary A=new TreeWithHashSetDictionary();
        while(true)
        {
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            switch (str.charAt(0))
            {
                case '+':
                    A.AddString(str.substring(1));
                    break;
                case '-':
                    for(String S:A.FindfromDictionary(str.substring(1)).GetWordArray())
                    {
                        System.out.println(S);
                    }
                    break;
                case 'E':
                    return;
                default:
                    if(Character.isDigit(str.charAt(0)))
                    {
                        String[] S = A.ConditionalFind(str.substring(1),
                                Integer.valueOf(String.valueOf(str.charAt(0)))).GetWordArray();
                        for (String s:S)
                        {
                            System.out.println(s);
                        }
                    }
            }

        }
    }

}
