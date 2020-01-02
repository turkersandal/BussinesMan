package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.City;
import com.trius.businessman.dao.entity.Country;
import com.trius.businessman.dao.repository.CityRepository;
import com.trius.businessman.dao.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;

@SpringBootTest
public class CityTest {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void saveCity(){
        String cityArray[] = {
                "1;Adana",
                "2;Adıyaman",
                "3;Afyonkarahisar",
                "4;Ağrı",
                "5;Amasya",
                "6;Ankara",
                "7;Antalya",
                "8;Artvin",
                "9;Aydın",
                "10;Balıkesir",
                "11;Bilecik",
                "12;Bingöl",
                "13;Bitlis",
                "14;Bolu",
                "15;Burdur",
                "16;Bursa",
                "17;Çanakkale",
                "18;Çankırı",
                "19;Çorum",
                "20;Denizli",
                "21;Diyarbakır",
                "22;Edirne",
                "23;Elazığ",
                "24;Erzincan",
                "25;Erzurum",
                "26;Eskişehir",
                "27;Gaziantep",
                "28;Giresun",
                "29;Gümüşhane",
                "30;Hakkâri",
                "31;Hatay",
                "32;Isparta",
                "33;İçel (Mersin)",
                "34;İstanbul",
                "35;İzmir",
                "36;Kars",
                "37;Kastamonu",
                "38;Kayseri",
                "39;Kırklareli",
                "40;Kırşehir",
                "41;Kocaeli",
                "42;Konya",
                "43;Kütahya",
                "44;Malatya",
                "45;Manisa",
                "46;Kahramanmaraş",
                "47;Mardin",
                "48;Muğla",
                "49;Muş",
                "50;Nevşehir",
                "51;Niğde",
                "52;Ordu",
                "53;Rize",
                "54;Sakarya",
                "55;Samsun",
                "56;Siirt",
                "57;Sinop",
                "58;Sivas",
                "59;Tekirdağ",
                "60;Tokat",
                "61;Trabzon",
                "62;Tunceli",
                "63;Şanlıurfa",
                "64;Uşak",
                "65;Van",
                "66;Yozgat",
                "67;Zonguldak",
                "68;Aksaray",
                "69;Bayburt",
                "70;Karaman",
                "71;Kırıkkale",
                "72;Batman",
                "73;Şırnak",
                "74;Bartın",
                "75;Ardahan",
                "76;Iğdır",
                "77;Yalova",
                "78;Karabük",
                "79;Kilis",
                "80;Osmaniye",
                "81;Düzce"
        };

        Country country = countryRepository.findByCountryName("Türkiye");
        Arrays.stream(cityArray).forEach(
                s -> {
                    String array[] = s.split(";");
                    cityRepository.save(City.builder().cityName(array[1]).country(country).cityCode(array[0]).cityPlateCode(array[0]).build());
                }
        );
    }
}
