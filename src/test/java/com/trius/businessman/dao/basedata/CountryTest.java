package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.Country;
import com.trius.businessman.dao.repository.CityRepository;
import com.trius.businessman.dao.repository.CountryRepository;
import com.trius.businessman.dao.repository.DistrictRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;

@SpringBootTest
public class CountryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Test
    public void saveCountry(){

        String countryArray[] = {"Rusya",
                "Kanada",
                "Çin",
                "ABD",
                "Brezilya",
                "Avustralya",
                "Hindistan",
                "Arjantin",
                "Kazakistan",
                "Cezayir",
                "Demokratik Kongo Cumhuriyeti",
                "Grönland (Danimarka)",
                "Suudi Arabistan",
                "Meksika",
                "Endonezya",
                "Sudan",
                "Libya",
                "İran",
                "Moğolistan",
                "Peru",
                "Çad",
                "Nijer",
                "Angola",
                "Mali",
                "Güney Afrika",
                "Kolombiya",
                "Etiyopya",
                "Bolivya",
                "Moritanya",
                "Mısır",
                "Tanzanya",
                "Nijerya",
                "Venezuela",
                "Pakistan",
                "Namibya",
                "Mozambik",
                "Türkiye",
                "Şili",
                "Zambiya",
                "Burma",
                "Afganistan",
                "Güney Sudan",
                "Fransa",
                "Somali",
                "Orta Afrika Cumhuriyeti",
                "Ukrayna",
                "Madagaskar",
                "Botsvana",
                "Kenya",
                "Yemen",
                "Tayland",
                "İspanya",
                "Türkmenistan",
                "Kamerun",
                "Papua Yeni Gine",
                "İsveç",
                "Özbekistan",
                "Fas",
                "Irak",
                "Paraguay",
                "Zimbabve",
                "Japonya",
                "Almanya",
                "Filipinler",
                "Kongo Cumhuriyeti",
                "Finlandiya",
                "Vietnam",
                "Malezya",
                "Norveç",
                "Fildişi Sahili",
                "Polonya",
                "Umman",
                "İtalya",
                "Burkina Faso",
                "Yeni Zelanda",
                "Gabon",
                "Batı Sahra",
                "Ekvador",
                "Gine",
                "Birleşik Krallık",
                "Uganda",
                "Gana",
                "Romanya",
                "Laos",
                "Guyana",
                "Beyaz Rusya",
                "Kırgızistan",
                "Senegal",
                "Suriye",
                "Kamboçya",
                "Uruguay",
                "Surinam",
                "Tunus",
                "Bangladeş",
                "Nepal",
                "Tacikistan",
                "Yunanistan",
                "Nikaragua",
                "Kuzey Kore",
                "Malavi",
                "Eritre",
                "Benin",
                "Honduras",
                "Liberya",
                "Bulgaristan",
                "Küba",
                "Guatemala",
                "İzlanda",
                "Güney Kore",
                "Macaristan",
                "Portekiz",
                "Ürdün",
                "Sırbistan",
                "Azerbaycan",
                "Avusturya",
                "Birleşik Arap Emirlikleri",
                "Çek Cumhuriyeti",
                "Panama",
                "Sierra Leone",
                "İrlanda",
                "Gürcistan",
                "Sri Lanka",
                "Litvanya",
                "Letonya",
                "Svalbard ve Jan Mayen (Norveç)",
                "Togo",
                "Hırvatistan",
                "Bosna-Hersek",
                "Kosta Rika",
                "Slovakya",
                "Dominik Cumhuriyeti",
                "Estonya",
                "Danimarka",
                "Hollanda",
                "İsviçre",
                "Bhutan",
                "Tayvan",
                "Gine Bissau",
                "Moldova",
                "Belçika",
                "Lesoto",
                "Ermenistan",
                "Solomon Adaları",
                "Arnavutluk",
                "Ekvator Ginesi",
                "Burundi",
                "Haiti",
                "Ruanda",
                "Makedonya",
                "Cibuti",
                "Belize",
                "El Salvador",
                "İsrail",
                "Slovenya",
                "Yeni Kaledonya (Fransa)",
                "Fiji",
                "Kuveyt",
                "Svaziland",
                "Doğu Timor",
                "Bahamalar",
                "Karadağ",
                "Vanuatu",
                "Falkland Adaları (Birleşik Krallık)",
                "Katar",
                "Gambiya",
                "Jamaika",
                "Lübnan",
                "Kıbrıs Cumhuriyeti",
                "Porto Riko (ABD)",
                "Fransız Güney ve Antarktika Toprakları (Fransa)",
                "Pasifik Uzak Adaları Deniz Ulusal Anıtı",
                "Filistin",
                "Brunei",
                "Trinidad ve Tobago",
                "Yeşil Burun Adaları",
                "Fransız Polinezyası (Fransa)",
                "Güney Georgia ve Güney Sandwich Adaları (Birleşik Krallık)",
                "Lüksemburg",
                "Mauritius",
                "Komorlar",
                "Faroe Adaları (Danimarka)",
                "Hong Kong (Çin)",
                "São Tomé ve Príncipe",
                "Turks ve Caicos Adaları (Birleşik Krallık)",
                "Kiribati",
                "Bahreyn",
                "Dominika",
                "Tonga",
                "Singapur",
                "Mikronezya Federal Devletleri",
                "Saint Lucia",
                "Man Adası (Birleşik Krallık)",
                "Guam (ABD)",
                "Andorra",
                "Kuzey Mariana Adaları (ABD)",
                "Palau",
                "Seyşeller",
                "Curaçao (Hollanda)",
                "Antigua ve Barbuda",
                "Barbados",
                "Heard Adası ve McDonald Adaları (Avustralya)",
                "Saint Vincent ve Grenadinler",
                "Svalbard ve Jan Mayen (Norveç)",
                "ABD Virjin Adaları (ABD)",
                "Grenada",
                "Malta",
                "Saint Helena (Birleşik Krallık)",
                "Maldivler",
                "Cayman Adaları (Birleşik Krallık)",
                "Saint Kitts ve Nevis",
                "Niue (Yeni Zelanda)",
                "Ağrotur ve Dikelya (Birleşik Krallık)",
                "Saint Pierre ve Miquelon (Fransa)",
                "Cook Adaları (Yeni Zelanda)",
                "Amerikan Samoası (ABD)",
                "Marshall Adaları",
                "Aruba (Hollanda)",
                "Lihtenştayn",
                "Britanya Virjin Adaları (Birleşik Krallık)",
                "Wallis ve Futuna (Fransa)",
                "Christmas Adası (Avustralya)",
                "Jersey (Birleşik Krallık)",
                "Montserrat (Birleşik Krallık)",
                "Anguilla (Birleşik Krallık)",
                "Guernsey (Birleşik Krallık)",
                "San Marino",
                "Britanya Hint Okyanusu Toprakları (Birleşik Krallık)",
                "Saint Martin (Fransa)",
                "Bermuda (Birleşik Krallık)",
                "Bouvet Adası (Norway)",
                "Pitcairn Adaları (Birleşik Krallık)",
                "Norfolk Adası (Avustralya)",
                "Sint Maarten (Hollanda)",
                "Makao (Çin)",
                "Tuvalu",
                "Nauru",
                "Saint Barthélemy (Fransa)",
                "Cocos Adaları (Avustralya)",
                "Tokelau (Yeni Zelanda)",
                "Cebelitarık (Birleşik Krallık)",
                "Wake Adası (ABD)",
                "Clipperton Adası (Fransa)",
                "Navassa Adası (ABD)",
                "Ashmore ve Cartier Adaları (Avustralya)",
                "Spratly Adaları (tartışmalı)",
                "Mercan Denizi Adaları (Avustralya)",
                "Monako",
                "Vatikan"
        };

        Arrays.stream(countryArray).forEach(
                s -> countryRepository.save(Country.builder().countryName(s).build())
        );
    }

}