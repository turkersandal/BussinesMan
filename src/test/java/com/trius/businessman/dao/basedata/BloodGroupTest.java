package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.BloodGroup;
import com.trius.businessman.dao.repository.BloodGroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@SpringBootTest
public class BloodGroupTest {

    @Autowired
    private BloodGroupRepository bloodGroupRepository;

    @Test
    public void saveBloodGroup(){
        Set<BloodGroup> bloodGroupSet = new LinkedHashSet<>(
                Arrays.asList(
                    BloodGroup.builder().bloodGroupName("A Rh(+)").build(),
                    BloodGroup.builder().bloodGroupName("A Rh(-)").build(),
                    BloodGroup.builder().bloodGroupName("B Rh(+)").build(),
                    BloodGroup.builder().bloodGroupName("B Rh(-)").build(),
                    BloodGroup.builder().bloodGroupName("AB Rh(+)").build(),
                    BloodGroup.builder().bloodGroupName("AB Rh(-)").build(),
                    BloodGroup.builder().bloodGroupName("0 Rh(+)").build(),
                    BloodGroup.builder().bloodGroupName("0 Rh(-)").build()
                )
        );

        bloodGroupRepository.saveAll(bloodGroupSet);
    }
}
