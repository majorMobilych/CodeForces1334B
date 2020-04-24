package solutions;

import java.util.Arrays;

public class SolutionsInterfaceImpl implements SolutionsInterface {
    private Integer[] findFirstRichAndSumWealth(int[] sortedByWealth, int minToBeRich) {
        Integer[] posOfFirstRichAndSumAllWealth = new Integer[2];
        for (int i = 0; i < sortedByWealth.length; i++) {
            if (sortedByWealth[i] >= minToBeRich) {
                posOfFirstRichAndSumAllWealth[0] = i;
                break;
            }
        }
        if (posOfFirstRichAndSumAllWealth[0] != null) {
            int sumAllWealth = 0;
            for (int i = posOfFirstRichAndSumAllWealth[0]; i < sortedByWealth.length; i++) {
                sumAllWealth += sortedByWealth[i];
            }
            posOfFirstRichAndSumAllWealth[1] = sumAllWealth;
        }
        return posOfFirstRichAndSumAllWealth;
    }

    @Override
    public int maxRichPeople(int[] people, int minToBeRich) {
        int[] sortedByWealth = Arrays.stream(people).sorted().toArray();
        Integer[] firstRichAndSumWealth = findFirstRichAndSumWealth(sortedByWealth, minToBeRich);
        Integer counter = firstRichAndSumWealth[0];
        if (counter != null) {
            if (counter.equals(0)) {
                return people.length;
            } else {
                int sumNotWealth = 0;
                while (counter > 0) {
                    counter--;
                    sumNotWealth += sortedByWealth[counter];
                    if ((sumNotWealth + firstRichAndSumWealth[1]) /
                            (sortedByWealth.length - firstRichAndSumWealth[0] + counter) < minToBeRich) {
                        return sortedByWealth.length - firstRichAndSumWealth[0] + counter;
                    }
                }
            }
        } else return 0;
        return minToBeRich;
    }
}
