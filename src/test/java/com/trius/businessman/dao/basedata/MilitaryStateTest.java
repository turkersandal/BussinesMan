package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.MilitaryState;
import com.trius.businessman.dao.repository.MilitaryStateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@SpringBootTest
public class MilitaryStateTest {

    @Autowired
    private MilitaryStateRepository militaryStateRepository;

    @Test
    public void saveMilitaryState(){
        Set<MilitaryState> militaryStateSet = new LinkedHashSet<>(
                Arrays.asList(
                        MilitaryState.builder().militaryStateName("Muaf").build(),
                        MilitaryState.builder().militaryStateName("Tecilli").build()
                )
        );

        militaryStateRepository.saveAll(militaryStateSet);
    }

}
