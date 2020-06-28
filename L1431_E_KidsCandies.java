import java.util.ArrayList;
import java.util.List;

public class L1431_E_KidsCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> toReturn = new ArrayList<Boolean>();


        int max = 0;
        for(int i = 0; i < candies.length; i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }

        for(int i = 0; i < candies.length; i++){
            if((candies[i] + extraCandies) >= max){
                toReturn.add(true);
            }
            else{
                toReturn.add(false);
            }
        }
        return toReturn;
    }
}