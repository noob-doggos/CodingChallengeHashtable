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
        elementData = new HashEntry[10];
    }

    private int hash(int elementData)
    {
        return Math.abs(value % elementData.length);
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
    public boolean contains(int value)
    {
        HashEntry cur = elementData[hashFunction(value)];

        while (cur != null)
        {
            if (cur.data == value)
            {
                return true;
            }
            cur = cur.next;
        }
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
