public class L007_E_ReverseInteger {
    public static int reverse(int x) {
        boolean isPositive = true;
        if(x < 0){
            isPositive = false;
            x = x * -1;
        }

        String number = x + "";
        String reversedNumber = "";
        for(int i = number.length() - 1 ; i >= 0; i--){
            reversedNumber += number.charAt(i);
        }
        
        int toReturn;
        try{
            toReturn = Integer.parseInt(reversedNumber);
            if(!isPositive){
                toReturn *= -1;
            }
            return toReturn;
        }
        catch(Exception e){
            return 0;
        }

        
        
    }

    public static void main(String[] args) {
    }

}