package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.Gender;
import com.trius.businessman.dao.repository.GenderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GenderTest {

    @Autowired
    private GenderRepository genderRepository;

    @Test
    public void saveGender(){

        Set<Gender> genderSet = new LinkedHashSet<>(
                Arrays.asList(
                    Gender.builder().genderName("Kadın").build(),
                    Gender.builder().genderName("Erkek").build()
            )
        );
        genderRepository.saveAll(genderSet);
    }
}
