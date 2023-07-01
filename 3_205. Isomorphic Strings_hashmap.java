// Complexity
// Time complexity:
// The time complexity of the above solution is O(n), where n is the length of the input strings. This is because we are iterating through the strings character by character only once.

// Space complexity:
// The space complexity of the above solution is O(k), where k is the number of unique characters in the input strings. This is because we are using a HashMap to store the mappings between characters in the two strings and the size of the HashMap can grow up to the number of unique characters in the input strings.

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null)
        {
            return false;
        }
        if (s.length() == 0 && t.length() == 0)
        {
            return true;
        }
        if (s.length() != t.length())
        {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++)
        {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            Character c = getKey(map, c2);
            if (c != null && c != c1)
            {
                return false;
            }
            else if (map.containsKey(c1))
            {
                if(c2 != map.get(c1))
                {
                    return  false;
                }
            }
            else
            {
                map.put(c1, c2);
            }
        }
        return true;
    }

    

public Character getKey(HashMap<Character, Character> map, Character target)
{
    for(Map.Entry<Character, Character> entry : map.entrySet())
    {
        if(entry.getValue().equals(target))
        {
            return entry.getKey();
        }
    }
    return null;
}
    
}