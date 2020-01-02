package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.AddressType;
import com.trius.businessman.dao.repository.AddressTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@SpringBootTest
public class AddressTypeTest {

    @Autowired
    private AddressTypeRepository addressTypeRepository;

    @Test
    public void saveAddressType(){
        Set<AddressType> addressTypeSet = new LinkedHashSet<>(
                Arrays.asList(
                        AddressType.builder().addressTypeName("İkamet").build(),
                        AddressType.builder().addressTypeName("Nüfus").build(),
                        AddressType.builder().addressTypeName("İş").build()
                )
        );

        addressTypeRepository.saveAll(addressTypeSet);
    }
}
