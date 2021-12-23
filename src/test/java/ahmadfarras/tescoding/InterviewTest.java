package ahmadfarras.tescoding;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterviewTest {

    public void maxDistinctGems(Integer weight, List<List<Integer>> gems){
        Integer total = 0;
        List<Integer> distinctGems = new ArrayList<>();

        for (int i = 0; i < gems.size(); i++){
            List<Integer> temp = new ArrayList<>();
            List<Integer> gem = gems.get(i);

            //cek jika sudah melebihi weight, lanjut ke element selanjutnya
            if (gem.get(1) > weight){
                continue;
            }

            //total akan direset di perulangan i
            total = gem.get(1);
            temp.add(gem.get(0));

            for (int j = i+1; j < gems.size(); j++){
                List<Integer> gem2 = gems.get(j);

                //cek jika sudah melebihi weight, lanjut ke element selanjutnya
                if (gem2.get(1) > weight){
                    continue;
                }

                //jika total tidak melebihi weight, akan di masukan ke list temp dan totalnya akan diupdate untuk di proses ke element selanjutnya
                if (total + gem2.get(1) < weight){
                    total = total + gem2.get(1);
                    temp.add(gem2.get(0));
                }
            }

            //cek apakah ada kombinasi yang lebih baik untuk memaksimalkan jumlah batu yang didapat (maximum distinct type)
            if (temp.size() > distinctGems.size()){
                distinctGems = new ArrayList<>(temp);
            }
        }

        if (distinctGems.size() < 1){
            System.out.println(-1);
        }else{
            System.out.println(Arrays.toString(distinctGems.toArray()).replace("[", "").replace("]", ""));
        }
    }

    @Test
    void testMaxDistinctGems1(){
        List<Integer> gem = new ArrayList<>();
        List<List<Integer>> gems = new ArrayList<>();

        gem.add(1);
        gem.add(1);
        gems.add(gem);

        gem = new ArrayList<>();
        gem.add(2);
        gem.add(4);
        gems.add(gem);

        gem = new ArrayList<>();
        gem.add(3);
        gem.add(3);
        gems.add(gem);

        maxDistinctGems(6, gems);
    }

    @Test
    void testMaxDistinctGems2(){
        List<Integer> gem = new ArrayList<>();
        List<List<Integer>> gems = new ArrayList<>();

        gem.add(1);
        gem.add(4);
        gems.add(gem);

        gem = new ArrayList<>();
        gem.add(2);
        gem.add(4);
        gems.add(gem);

        gem = new ArrayList<>();
        gem.add(3);
        gem.add(5);
        gems.add(gem);

        maxDistinctGems(3, gems);
    }

    @Test
    void testMaxDistinctGems3(){
        List<Integer> gem = new ArrayList<>();
        List<List<Integer>> gems = new ArrayList<>();

        gem.add(1);
        gem.add(4);
        gems.add(gem);

        gem = new ArrayList<>();
        gem.add(2);
        gem.add(4);
        gems.add(gem);

        gem = new ArrayList<>();
        gem.add(3);
        gem.add(5);
        gems.add(gem);

        gem = new ArrayList<>();
        gem.add(4);
        gem.add(2);
        gems.add(gem);

        gem = new ArrayList<>();
        gem.add(5);
        gem.add(2);
        gems.add(gem);

        gem = new ArrayList<>();
        gem.add(6);
        gem.add(1);
        gems.add(gem);

        maxDistinctGems(8, gems);
    }
}
