package Model;

import java.util.Set;
import java.util.function.BiConsumer;

public interface Dictionary<k,v>
{
    /**
     * This method can also be used to find if key exist
     *
     * @param integer Key value of map
     * @return List<String> of matches, returns null if no match
     */
    v findKey(k integer);

    /**
     * @param integer Key of the mapping value
     * @return returns new created list so it wont need to refind it
     */
    v createKey(k integer);

    /**
     *
     * @param word
     * @return
     */
    k keyOfWord(String word);

    Set<k> keySet();

    boolean isWordExist(String word);

    void addWord(String word);

    void forEach(BiConsumer<k,v> consumer);
}
