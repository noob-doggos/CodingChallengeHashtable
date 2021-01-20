import java.util.HashMap;

public class Responses1To4
{
    // single number I and II solution
    // by: Victor
    /**
     * This method returns the entry in an array of integers that only appears
     * once, assuming that all other integers in the array appear at least
     * twice.
     * 
     * Algorithm: For each integer in the given array, record the number of
     * times it occurs in a hashmap. Then, for each integer in that hashmap,
     * return the key which maps to a count of 1.
     * 
     * Time complexity: O(n), where n is the number of elements in the array.
     * 
     * @param nums,
     *            the array of integers to search for the unique element in.
     * @return the entry in the array that only apears once.
     */
    public int singleNumber(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        for (int key : map.keySet())
            if (map.get(key) == 1)
                return key;
        return -1;
    }

    // find the difference solution
    // by: Victor
    /**
     * This method returns the character contained by string t but not by string
     * s, which contains all the characters t contains except for one missing
     * character.
     * 
     * Algorithm: For each character in string s, record the number of times it
     * occurs in a hashmap. Then, for each character in string t, use another
     * hashmap to keep track of how many times it occurs in string t. if the
     * number of occurences for a character in the second hashmap is greater
     * than the number of occurances in the first hashmap, then that character
     * is the extra in string t.
     * 
     * Time complexity: O(n), where n is the number of characters in string t.
     * 
     * 
     * @param s,
     *            the string missing the character contained in string t.
     * @param t,
     *            the other string containing the character missing from string
     *            s.
     * @return
     */
    public char findTheDifference(String s, String t)
    {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            sMap.put(c, sMap.containsKey(c) ? sMap.get(c) + 1 : 1);
        }
        for (int i = 0; i < t.length(); i++)
        {
            char c = t.charAt(i);
            tMap.put(c, tMap.containsKey(c) ? tMap.get(c) + 1 : 1);
            if (!sMap.containsKey(c) || tMap.get(c) > sMap.get(c))
            {
                return c;
            }
        }
        return ' ';
    }
}

// myhashset solution
class MyHashSet
{
    private HashEntry[] elementData;

    /** Initialize your data structure here. */
    public MyHashSet()
    {
        elementData = new HashEntry[200];
    }

    // by: Clyde
    private int hash(int key)
    {
        return Math.abs(key % elementData.length);
    }

    // by: Eric
    /**
     * This method adds an integer key to the hashset if it doesn't exist
     * already.
     * 
     * Algorithm: hash the key and use the hash as the array index to store the
     * hashed value at. Then, find the next available HashEntry in the chain of
     * HashEntrys stored at the array index and store the value there if it
     * doesn't already exist.
     * 
     * Time complexity: O(n), n is the number of elements in the hashset
     * 
     * @param key,
     *            the key to add to the hashset.
     */
    public void add(int key)
    {
        int hash = hash(key);

        if (elementData[hash] == null)
        {
            elementData[hash] = new HashEntry(key);
        }
        else
        {
            HashEntry cur = elementData[hash];
            while (cur != null)
            {
                if (cur.data == key)
                {
                    return;
                }
                if (cur.next == null)
                {
                    cur.next = new HashEntry(key);
                    return;
                }
                cur = cur.next;
            }
        }
    }

    // by: Eric
    /**
     * The method removes an integer key from the hashset if it exists.
     * 
     * Algorithm: hash the key and use the hash as the array index to search for
     * the key to remove at. Then, search through the chain of HashEntrys stored
     * at the array index and remove the HashEntry corresponding to the given
     * key when found by connecting the HashEntry preceding it to the one after
     * it.
     * 
     * Time complexity: O(n), n is the number of elements in the hashset
     * 
     * @param key,
     *            the key to remove from the hashset.
     */
    public void remove(int key)
    {
        int hash = hash(key);
        HashEntry cur = elementData[hash];
        HashEntry prev = null;

        while (cur != null)
        {
            if (cur.data == key)
            {
                if (prev == null)
                {
                    elementData[hash] = cur.next;
                }
                else
                {
                    prev.next = cur.next;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    /** Returns true if this set contains the specified element */
    // by: Clyde
    /**
     * This method returns whether the given integer key exists in the hashset.
     * 
     * Algorithm: hash the key and use the hash as the array index to search for
     * the given key at. Searching is done by iterating through each HashEntry
     * in the chain of HashEntrys stored at the array index.
     * 
     * Time complexity: O(n), n is the number of elmeents in the hashset
     * 
     * @param key
     *            the key to search for in the hashset.
     * @return whether the given key exists in the hashset.
     */
    public boolean contains(int key)
    {
        HashEntry cur = elementData[hash(key)];

        while (cur != null)
        {
            if (cur.data == key)
            {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    // linkedlist-style HashEntry.
    static class HashEntry
    {
        public int data;
        public HashEntry next;

        public HashEntry(int data)
        {
            this(data, null);
        }

        public HashEntry(int data, HashEntry next)
        {
            this.data = data;
            this.next = next;
        }
    }
}