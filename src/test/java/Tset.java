import com.asser.dao.HunterDao;
import com.asser.dao.Impl.HunterDaoImpl;
import com.asser.dao.Impl.MissionDaoImpl;
import com.asser.dao.Impl.RewardDaoImpl;
import com.asser.dao.MissionDao;
import com.asser.dao.RewardDao;
import com.asser.entity.Hunter;
import com.asser.entity.Mission;
import com.asser.entity.Reward;

import java.util.List;

public class Tset {
    public static void main(String[] args){
        int[] mylist={1,2,3,4,5};
        reverse1(mylist);
        for(int ele:mylist){
            System.out.print(ele+" ");
        }}
    public static void reverse1(int[] list){
        for(int i=0,j=list.length-1;i<list.length;i++,j--){
            System.out.println("list[i] "+list[i] + " list[j] " + list[j]);
            int temp=list[i];
            list[i]=list[j];
            list[j]=temp;
        }
    }
}

