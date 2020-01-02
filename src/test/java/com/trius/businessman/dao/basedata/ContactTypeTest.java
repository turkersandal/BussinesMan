package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.ContactType;
import com.trius.businessman.dao.repository.ContactTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@SpringBootTest
public class ContactTypeTest {

    @Autowired
    private ContactTypeRepository contactTypeRepository;

    @Test
    public void saveContactType(){
        Set<ContactType> contactTypeSet = new LinkedHashSet<>(
                Arrays.asList(
                        ContactType.builder().contactTypeName("Ev").build(),
                        ContactType.builder().contactTypeName("İş").build(),
                        ContactType.builder().contactTypeName("Fax").build()
                )
        );

        contactTypeRepository.saveAll(contactTypeSet);
    }
}
