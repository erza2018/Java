public class L1281_E_SubtractProductSum {
    public int subtractProductAndSum(int n) {
        String number = "" + n;
        int product = Integer.parseInt("" + number.charAt(0));
        int sum = Integer.parseInt("" + number.charAt(0));

        for(int i = 1; i < number.length(); i++){
            int newDigit = Integer.parseInt("" + number.charAt(i));
            product *= newDigit;
            sum += newDigit;
        }

        return product - sum;
    }
}