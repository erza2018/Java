/**
 * When you run java code from VS Code, the running .class file is generated in:
 * C:\<user_folder>\AppData\Roaming\Code\User\workspaceStorage\<guid>\redhat.java\jdt_ws\jdt.ls-java-project
 * To use library pacakge files in VS Code, you will need to run each library .java file to build their .class files
 * under the workspace library folder.
 *
 * To create your own java code snippet, File | Preferences | User Snippets, select java.json
 * which maps to C:\Users\taozh\AppData\Roaming\Code\User\snippets\java.json file.
 * Add the following. Then you can type "sout" and TAB to complete the "System.out.println();" for you.
  	"System.out.println": {
		"prefix": "sout",
		"body": [
			"System.out.println('$1');"
		],
		"description": "sout - System.out.println"
	}

*/
//package LeetCode;

import static java.lang.System.*;
import java.util.*;
import java.util.stream.*;

public class A001_Language {
    //
    // Very good Java Language material: https://www.geeksforgeeks.org/java/
    //

    private static void EightPrimitiveTypes() {
        // byte -- 8 bits
        byte myByteValue = -128;
        byte myNewByteValue = (byte) (myByteValue / 2); // must cast result from int (32bits) to byte (8bits)
        System.out.println("myNewByteValue = " + myNewByteValue);

        // short -- 16 bits
        short myShortValue = 32767;
        short myNewShortValue = (short) (myShortValue / 2); // must cast result from int (32bits) to short
                                                                  // (16bits)
        System.out.println("myNewShortValue = " + myNewShortValue);

        // int -- 32 bits
        int myMinValue = -2_147_483_648; // you can use _ to clearly show long numbers
        int myMaxValue = 2147483647;
        int myTotal = (myMinValue / 2);
        System.out.println("myTotal = " + myTotal);
        out.println(myMaxValue);

        // long -- 64 bits
        // use 'L' at the end to specify long
        long myLongValue = 9_223_372_036_854_775_807L;
        System.out.println("myLongValue = " + myLongValue);

        // float -- single precision -- 32 bits
        float myFloatValue = 5.25f; // use f as postfix to specify float
        System.out.println("myFloatValue = " + myFloatValue);

        // double -- double precision -- 64 bits
        double myDoubleValue = 5.25d; // use d as postfix to specify double. By default it's double without d.
        System.out.println("myDoubleValue = " + myDoubleValue);
        double myDoubleValue1 = 3_000_000.123456789012345678901; // 16 digit precision - 3000000.123456789
        System.out.println("myDoubleValue1 = " + myDoubleValue1);

        // char - unicode - unicode-table.com
        char myChar = 'D';
        char copyRightChar = '\u00A9'; // unicode of copyright character ©
        System.out.println("Unicode char is: " + copyRightChar);
        out.println(myChar);

        // boolean
        boolean myBooleanValue = false;
        System.out.println("myBooleanValue = " + myBooleanValue); // "false"

        // NOTE: String is a class, not a primitive type
        String s = "0123456789";
        char c = s.charAt(0);
        int i1 = s.indexOf("345");
        System.out.println(c);
        System.out.println(i1);
    }

    private static void Collections() {
        //
        // Check this out: https://www.geeksforgeeks.org/java-util-package-java/
        //

        // Createing an instance of array, vector and hashtable
        int arr[] = new int[] { 1, 2, 3, 4 };
        out.println(arr[0]); // should be '1'
        out.println(Arrays.toString(arr)); // [1, 2, 3, 4]

        int i1 = Arrays.binarySearch(arr, 3); // should be 2
        int j1 = Arrays.binarySearch(arr, 10); // should be negative (< 0)
        out.println(i1 + " " + j1);

        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 1, arr.length);
        out.println(newArr[0]); // should be '0'
        out.println(Arrays.toString(newArr)); // [0, 1, 2, 3, 4]

        out.println(Arrays.equals(arr, newArr)); // false
        out.println(Arrays.deepEquals(new Object[] { arr }, new Object[] { newArr })); // false

        Arrays.fill(arr, 1, 2, -1); // from_index=1 (inclusive), to_index=2 (exclusive)
        out.println(Arrays.toString(arr)); // [1, -1, 3, 4]

        Arrays.sort(arr);
        out.println(Arrays.toString(arr)); // [-1, 1, 3, 4]
        Integer[] arr3 = new Integer[] { -1, 1, 3, 4 };
        Arrays.sort(arr3, Collections.reverseOrder()); // only works against Object[]
        out.println(Arrays.toString(arr3)); // [4, 3, 1, -1]

        // Jagged Array
        int arr1[][] = new int[2][];
        arr1[0] = new int[3];
        arr1[1] = new int[2];
        out.println(arr1[1][1]); // should be 0 - default value
        out.println(Arrays.toString(arr1)); // [[I@5679c6c6, [I@27ddd392]
        out.println(Arrays.deepToString(arr1)); // [[0, 0, 0], [0, 0]]

        // Hashtable
        Hashtable<Integer, String> h = new Hashtable<>();
        h.put(1, "geeks");
        h.put(2, "4geeks");
        out.println(h.get(1));

        // ArrayList and Iterator
        // ArrayList is not synchronized (not thread-safe), and dynamically grow by 50%
        // capacity
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            al.add(i);
        }
        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()) {
            int i = (Integer) itr.next();
            System.out.print(i + " ");
            if (i % 2 != 0)
                itr.remove();
        }
        out.println();
        out.println(al.toString()); // should be "[0, 2, 4, 6, 8]"
        Collections.sort(al, Collections.reverseOrder()); // in-place reverse sort
        out.println(al.toString()); // [8, 6, 4, 2, 0]

        Object[] arr2 = al.toArray();
        out.println(arr2[4]); // should be '8' of type Integer

        // Vector<Integer> v = new Vector();
        // Vector is synchonized (thread-safe), and dynamically grow by 100% capacity
        Vector<Integer> v = new Vector<>();
        v.addElement(2);
        v.addElement(1);
        out.println(v.elementAt(0));

        // Vector - is an array, but growable/shrinkable.
        Vector<Integer> v1 = new Vector<Integer>();
        for (int i = 0; i < 10; i++) {
            v1.addElement(i);
        }
        out.println(v1);

        // There is no built-in support to convert Integer[] to int[]
        List<Integer> al5 = new ArrayList<Integer>();
        al5.add(1);
        al5.add(2);
        al5.add(3);
        int[] ret = al5.stream().mapToInt(Integer::intValue).toArray();
        out.println(Arrays.toString(ret)); // [1, 2, 3]

        // There is no built-in support to conver int[] to Integer[]
        Integer[] arrInteger = Arrays.stream(ret).boxed().toArray(Integer[]::new);
        out.println(Arrays.toString(arrInteger));

        List<Integer> alInteger = Arrays.stream(ret).boxed().collect(Collectors.toList());
        out.println(alInteger.toString());

        //
        // HashMap<>
        // C# equivalent is Dictionary<>()
        // C# Dictionary has much better Indexer support, where you can directly access
        // element by dict[key]
        // while HashMap has to use function map.get(key)
        //
        HashMap<String, Integer> map = new HashMap<>();
        int len = map.size();
        boolean isEmpty = map.isEmpty();
        map.put("Tao", 50);
        map.put("Yan", 49);
        len = map.size();
        int item = map.get("Tao");
        isEmpty = map.isEmpty();
        if (isEmpty) // Not true
            item = map.get("AAA"); // throw Exception
        out.println(len);
        out.println(item);
    }

    public static void main(String[] args) {
        A001_Language.EightPrimitiveTypes();
        A001_Language.Collections();
    }
}
