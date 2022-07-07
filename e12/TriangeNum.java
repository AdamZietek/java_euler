import java.util.HashMap;
import java.util.Map;

public abstract class TriangeNum {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        fun();
        long endTime   = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println(totalTime/1_000_000_000);
    }

    public static Integer fun(){
        Integer i = 1;
        Integer divisorsNum = 0;
        Integer triangNum = 0;

        while (divisorsNum <= 500){
            triangNum = countTriangNumWhere_r_is1(i);
            i++;
            divisorsNum = divisorsNum(divisorsMap(triangNum));
        }

        System.out.println(triangNum);
        return triangNum;
    }

    public static int countTriangNumWhere_r_is1(int n){
        return (n+1)*n/2;
    }

    public static Map<Integer, Integer> divisorsMap(int n){
        Map<Integer, Integer> divisorsMap = new HashMap<>();

        int div=2;
        while (n != 1){
            if (n%div == 0){
                n /= div;
                divisorsMap.merge(div, 1, Integer::sum);
            } else {
                div++;
            }
        }
        
        // System.out.println(divisorsMap);

        return divisorsMap;
    }

    public static Integer divisorsNum(Map<Integer,Integer> map){
        Integer divisorsNum = 1;
        
        for (Integer g : map.values()){
            divisorsNum *= (g+1);
        }

        // System.out.println(divisorsNum);

        return divisorsNum;
    }
}