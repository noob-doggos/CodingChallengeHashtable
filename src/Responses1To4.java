import java.util.Arrays;
import java.util.HashMap;

public class Responses1To4
{
    // single number I and II solution
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
    public char findTheDifference(String s, String t)
    {
        char[] sA = s.toCharArray();
        Arrays.sort(sA);
        char[] tA = t.toCharArray();
        Arrays.sort(tA);
        String sortedS = new String(sA);
        String sortedT = new String(tA);
        for (int i = 0; i < s.length(); i++)
            if (sortedS.charAt(i) != sortedT.charAt(i))
                return sortedT.charAt(i);
        return sortedT.charAt(s.length());
    }
}

// myhashset solution
class MyHashSet
{
    private HashEntry[] arr;

    /** Initialize your data structure here. */
    public MyHashSet()
    {
        arr = new HashEntry[10];
    }

    private int hash(int val)
    {
        // TODO Clyde
        return -1;
    }

    public void add(int key)
    {
        // TODO Eric

    }

    public void remove(int key)
    {
        // TODO Eric
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key)
    {
        // TODO Clyde
        return false;
    }

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
