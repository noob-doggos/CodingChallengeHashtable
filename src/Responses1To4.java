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
        elementData = new HashEntry[200];
    }

    // by: Clyde
    private int hash(int key)
    {
        return Math.abs(key % elementData.length);
    }

    // by: Eric
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