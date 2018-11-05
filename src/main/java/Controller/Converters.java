package Controller;

import java.math.BigInteger;
import static Model.PrimeNumbers.PrimeNumberArray;

public interface Converters
{
    static BigInteger KeyGenerator(String s)
    {
        BigInteger Result = BigInteger.ONE;
        for(char c: s.toCharArray())
            Result = Result.multiply(BigInteger.valueOf(PrimeNumberArray[CharConverter(c)]));
        return Result;
    }

    static int CharConverter(char c)
    {
        if(!Character.isLetter(c))
            return (byte)(25);
        return (Character.toUpperCase(c))-(65);
    }
}
