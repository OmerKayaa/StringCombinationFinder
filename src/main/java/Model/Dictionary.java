package Model;

import java.math.BigInteger;
import java.util.List;

public interface Dictionary
{
    /**
     *
     * @param integer
     * @return returns list of String if exist else returns null
     */

    List<String> isKeyExist(BigInteger integer);
    List<String> createKey(BigInteger integer);
    void findKey(BigInteger integer);
    void findWord(String word);
    void forEach();
}
