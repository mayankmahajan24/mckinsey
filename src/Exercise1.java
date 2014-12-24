import java.util.*;
import java.lang.*;


public class Exercise1
{
    public static HashMap<String, String> opp = new HashMap<String, String>();
    public static HashSet<String> open = new HashSet<String>();
    public static void main (String[] args)
    {
        setupTables();

        String[] ar  = {"[{}]","[{(})]","[(]"};
        for (String x : ar)
        {
        boolean b = checkString(x);
        if (b) {
            System.out.println("true");
        } else System.out.println("false");
        }
    }

    public static void setupTables()
    {
        opp.put("}", "{");
        opp.put("]", "[");
        opp.put(")", "(");
        open.add("(");
        open.add("{");
        open.add("[");
    }

    public static boolean checkString(String str)
    {
        Stack<String> st = new Stack<String>();
        char[] ch = str.toCharArray();
        for (char c : ch)
        {
            String s = c+"";
            if (open.contains(s))
            {
                st.push(s);
            }

            else if (!opp.get(s).equals(st.peek()))
            {
                return false;
            }
            else {
                st.pop();
            }
        }

        if (!st.empty())
        {
            return false;
        }

        return true;
    }
}
