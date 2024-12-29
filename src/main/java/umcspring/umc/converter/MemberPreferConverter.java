package umcspring.umc.converter;

import umcspring.umc.domain.FoodCategory;
import umcspring.umc.domain.PreferenceFood;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<PreferenceFood> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        PreferenceFood.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
