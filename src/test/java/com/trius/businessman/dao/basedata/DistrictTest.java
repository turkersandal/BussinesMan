package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.City;
import com.trius.businessman.dao.entity.District;
import com.trius.businessman.dao.repository.CityRepository;
import com.trius.businessman.dao.repository.DistrictRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@SpringBootTest
public class DistrictTest {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void addDistrict(){
        City city = cityRepository.findByCityName("İstanbul");
        Set<District> districtSet = new LinkedHashSet<>(
                Arrays.asList(
                    District.builder().districtName("Ümraniye").city(city).build(),
                    District.builder().districtName("Şişli").city(city).build(),
                    District.builder().districtName("Beşiktaş").city(city).build(),
                        District.builder().districtName("Pendik").city(city).build(),
                        District.builder().districtName("Beşiktaş").city(city).build()
                )
        );
        districtRepository.saveAll(districtSet);
    }

    @Test
    public void updateCityOfDistrict(){
        City city = cityRepository.findByCityName("İstanbul");
        District district = districtRepository.findByDistrictId(10);
        district.setCity(city);
        districtRepository.save(district);
    }

    
    @Test
    public void saveDistrict(){
        String districtArray[] = {"1!Seyhan",
                "1!Ceyhan",
                "1!Feke",
                "1!Karaisalı",
                "1!Karataş",
                "1!Kozan",
                "1!Pozantı",
                "1!Saimbeyli",
                "1!Tufanbeyli",
                "1!Yumurtalık",
                "1!Yüreğir",
                "1!Aladağ",
                "1!İmamoğlu",
                "1!Sarıçam",
                "1!Çukurova",
                "2!Adıyaman Merkez",
                "2!Besni",
                "2!Çelikhan",
                "2!Gerger",
                "2!Gölbaşı / Adıyaman",
                "2!Kahta",
                "2!Samsat",
                "2!Sincik",
                "2!Tut",
                "3!Afyonkarahisar Merkez",
                "3!Bolvadin",
                "3!Çay",
                "3!Dazkırı",
                "3!Dinar",
                "3!Emirdağ",
                "3!İhsaniye",
                "3!Sandıklı",
                "3!Sinanpaşa",
                "3!Sultandağı",
                "3!Şuhut",
                "3!Başmakçı",
                "3!Bayat / Afyonkarahisar",
                "3!İscehisar",
                "3!Çobanlar",
                "3!Evciler",
                "3!Hocalar",
                "3!Kızılören",
                "4!Ağrı Merkez",
                "4!Diyadin",
                "4!Doğubayazıt",
                "4!Eleşkirt",
                "4!Hamur",
                "4!Patnos",
                "4!Taşlıçay",
                "4!Tutak",
                "5!Amasya Merkez",
                "5!Göynücek",
                "5!Gümüşhacıköy",
                "5!Merzifon",
                "5!Suluova",
                "5!Taşova",
                "5!Hamamözü",
                "6!Altındağ",
                "6!Ayaş",
                "6!Bala",
                "6!Beypazarı",
                "6!Çamlıdere",
                "6!Çankaya",
                "6!Çubuk",
                "6!Elmadağ",
                "6!Güdül",
                "6!Haymana",
                "6!Kalecik",
                "6!Kızılcahamam",
                "6!Nallıhan",
                "6!Polatlı",
                "6!Şereflikoçhisar",
                "6!Yenimahalle",
                "6!Gölbaşı / Ankara",
                "6!Keçiören",
                "6!Mamak",
                "6!Sincan",
                "6!Kazan",
                "6!Akyurt",
                "6!Etimesgut",
                "6!Evren",
                "6!Pursaklar",
                "7!Akseki",
                "7!Alanya",
                "7!Elmalı",
                "7!Finike",
                "7!Gazipaşa",
                "7!Gündoğmuş",
                "7!Kaş",
                "7!Korkuteli",
                "7!Kumluca",
                "7!Manavgat",
                "7!Serik",
                "7!Demre",
                "7!İbradı",
                "7!Kemer / Antalya",
                "7!Aksu / Antalya",
                "7!Döşemealtı",
                "7!Kepez",
                "7!Konyaaltı",
                "7!Muratpaşa",
                "8!Ardanuç",
                "8!Arhavi",
                "8!Artvin Merkez",
                "8!Borçka",
                "8!Hopa",
                "8!Şavşat",
                "8!Yusufeli",
                "8!Murgul",
                "9!Bozdoğan",
                "9!Çine",
                "9!Germencik",
                "9!Karacasu",
                "9!Koçarlı",
                "9!Kuşadası",
                "9!Kuyucak",
                "9!Nazilli",
                "9!Söke",
                "9!Sultanhisar",
                "9!Yenipazar / Aydın",
                "9!Buharkent",
                "9!İncirliova",
                "9!Karpuzlu",
                "9!Köşk",
                "9!Didim",
                "9!Efeler",
                "10!Ayvalık",
                "10!Balya",
                "10!Bandırma",
                "10!Bigadiç",
                "10!Burhaniye",
                "10!Dursunbey",
                "10!Edremit / Balıkesir",
                "10!Erdek",
                "10!Gönen / Balıkesir",
                "10!Havran",
                "10!İvrindi",
                "10!Kepsut",
                "10!Manyas",
                "10!Savaştepe",
                "10!Sındırgı",
                "10!Susurluk",
                "10!Marmara",
                "10!Gömeç",
                "10!Altıeylül",
                "10!Karesi",
                "11!Bilecik Merkez",
                "11!Bozüyük",
                "11!Gölpazarı",
                "11!Osmaneli",
                "11!Pazaryeri",
                "11!Söğüt",
                "11!Yenipazar / Bilecik",
                "11!İnhisar",
                "12!Bingöl Merkez",
                "12!Genç",
                "12!Karlıova",
                "12!Kiğı",
                "12!Solhan",
                "12!Adaklı",
                "12!Yayladere",
                "12!Yedisu",
                "13!Adilcevaz",
                "13!Ahlat",
                "13!Bitlis Merkez",
                "13!Hizan",
                "13!Mutki",
                "13!Tatvan",
                "13!Güroymak",
                "14!Bolu Merkez",
                "14!Gerede",
                "14!Göynük",
                "14!Kıbrıscık",
                "14!Mengen",
                "14!Mudurnu",
                "14!Seben",
                "14!Dörtdivan",
                "14!Yeniçağa",
                "15!Ağlasun",
                "15!Bucak",
                "15!Burdur Merkez",
                "15!Gölhisar",
                "15!Tefenni",
                "15!Yeşilova",
                "15!Karamanlı",
                "15!Kemer / Burdur",
                "15!Altınyayla / Burdur",
                "15!Çavdır",
                "15!Çeltikçi",
                "16!Gemlik",
                "16!İnegöl",
                "16!İznik",
                "16!Karacabey",
                "16!Keles",
                "16!Mudanya",
                "16!Mustafakemalpaşa",
                "16!Orhaneli",
                "16!Orhangazi",
                "16!Yenişehir / Bursa",
                "16!Büyükorhan",
                "16!Harmancık",
                "16!Nilüfer",
                "16!Osmangazi",
                "16!Yıldırım",
                "16!Gürsu",
                "16!Kestel",
                "17!Ayvacık / Çanakkale",
                "17!Bayramiç",
                "17!Biga",
                "17!Bozcaada",
                "17!Çan",
                "17!Çanakkale Merkez",
                "17!Eceabat",
                "17!Ezine",
                "17!Gelibolu",
                "17!Gökçeada",
                "17!Lapseki",
                "17!Yenice / Çanakkale",
                "18!Çankırı Merkez",
                "18!Çerkeş",
                "18!Eldivan",
                "18!Ilgaz",
                "18!Kurşunlu",
                "18!Orta",
                "18!Şabanözü",
                "18!Yapraklı",
                "18!Atkaracalar",
                "18!Kızılırmak",
                "18!Bayramören",
                "18!Korgun",
                "19!Alaca",
                "19!Bayat / Çorum",
                "19!Çorum Merkez",
                "19!İskilip",
                "19!Kargı",
                "19!Mecitözü",
                "19!Ortaköy / Çorum",
                "19!Osmancık",
                "19!Sungurlu",
                "19!Boğazkale",
                "19!Uğurludağ",
                "19!Dodurga",
                "19!Laçin",
                "19!Oğuzlar",
                "20!Acıpayam",
                "20!Buldan",
                "20!Çal",
                "20!Çameli",
                "20!Çardak",
                "20!Çivril",
                "20!Güney",
                "20!Kale / Denizli",
                "20!Sarayköy",
                "20!Tavas",
                "20!Babadağ",
                "20!Bekilli",
                "20!Honaz",
                "20!Serinhisar",
                "20!Pamukkale",
                "20!Baklan",
                "20!Beyağaç",
                "20!Bozkurt / Denizli",
                "20!Merkezefendi",
                "21!Bismil",
                "21!Çermik",
                "21!Çınar",
                "21!Çüngüş",
                "21!Dicle",
                "21!Ergani",
                "21!Hani",
                "21!Hazro",
                "21!Kulp",
                "21!Lice",
                "21!Silvan",
                "21!Eğil",
                "21!Kocaköy",
                "21!Bağlar",
                "21!Kayapınar",
                "21!Sur",
                "21!Yenişehir / Diyarbakır",
                "22!Edirne Merkez",
                "22!Enez",
                "22!Havsa",
                "22!İpsala",
                "22!Keşan",
                "22!Lalapaşa",
                "22!Meriç",
                "22!Uzunköprü",
                "22!Süloğlu",
                "23!Ağın",
                "23!Baskil",
                "23!Elazığ Merkez",
                "23!Karakoçan",
                "23!Keban",
                "23!Maden",
                "23!Palu",
                "23!Sivrice",
                "23!Arıcak",
                "23!Kovancılar",
                "23!Alacakaya",
                "24!Çayırlı",
                "24!Erzincan Merkez",
                "24!İliç",
                "24!Kemah",
                "24!Kemaliye",
                "24!Refahiye",
                "24!Tercan",
                "24!Üzümlü",
                "24!Otlukbeli",
                "25!Aşkale",
                "25!Çat",
                "25!Hınıs",
                "25!Horasan",
                "25!İspir",
                "25!Karayazı",
                "25!Narman",
                "25!Oltu",
                "25!Olur",
                "25!Pasinler",
                "25!Şenkaya",
                "25!Tekman",
                "25!Tortum",
                "25!Karaçoban",
                "25!Uzundere",
                "25!Pazaryolu",
                "25!Aziziye",
                "25!Köprüköy",
                "25!Palandöken",
                "25!Yakutiye",
                "26!Çifteler",
                "26!Mahmudiye",
                "26!Mihalıççık",
                "26!Sarıcakaya",
                "26!Seyitgazi",
                "26!Sivrihisar",
                "26!Alpu",
                "26!Beylikova",
                "26!İnönü",
                "26!Günyüzü",
                "26!Han",
                "26!Mihalgazi",
                "26!Odunpazarı",
                "26!Tepebaşı",
                "27!Araban",
                "27!İslahiye",
                "27!Nizip",
                "27!Oğuzeli",
                "27!Yavuzeli",
                "27!Şahinbey",
                "27!Şehitkamil",
                "27!Karkamış",
                "27!Nurdağı",
                "28!Alucra",
                "28!Bulancak",
                "28!Dereli",
                "28!Espiye",
                "28!Eynesil",
                "28!Giresun Merkez",
                "28!Görele",
                "28!Keşap",
                "28!Şebinkarahisar",
                "28!Tirebolu",
                "28!Piraziz",
                "28!Yağlıdere",
                "28!Çamoluk",
                "28!Çanakçı",
                "28!Doğankent",
                "28!Güce",
                "29!Gümüşhane Merkez",
                "29!Kelkit",
                "29!Şiran",
                "29!Torul",
                "29!Köse",
                "29!Kürtün",
                "30!Çukurca",
                "30!Hakkari Merkez",
                "30!Şemdinli",
                "30!Yüksekova",
                "31!Altınözü",
                "31!Dörtyol",
                "31!Hassa",
                "31!İskenderun",
                "31!Kırıkhan",
                "31!Reyhanlı",
                "31!Samandağ",
                "31!Yayladağı",
                "31!Erzin",
                "31!Belen",
                "31!Kumlu",
                "31!Antakya",
                "31!Arsuz",
                "31!Defne",
                "31!Payas",
                "32!Atabey",
                "32!Eğirdir",
                "32!Gelendost",
                "32!Isparta Merkez",
                "32!Keçiborlu",
                "32!Senirkent",
                "32!Sütçüler",
                "32!Şarkikaraağaç",
                "32!Uluborlu",
                "32!Yalvaç",
                "32!Aksu / Isparta",
                "32!Gönen / Isparta",
                "32!Yenişarbademli",
                "33!Anamur",
                "33!Erdemli",
                "33!Gülnar",
                "33!Mut",
                "33!Silifke",
                "33!Tarsus",
                "33!Aydıncık / Mersin",
                "33!Bozyazı",
                "33!Çamlıyayla",
                "33!Akdeniz",
                "33!Mezitli",
                "33!Toroslar",
                "33!Yenişehir / Mersin",
                "34!Adalar",
                "34!Bakırköy",
                "34!Beşiktaş",
                "34!Beykoz",
                "34!Beyoğlu",
                "34!Çatalca",
                "34!Eyüp",
                "34!Fatih",
                "34!Gaziosmanpaşa",
                "34!Kadıköy",
                "34!Kartal",
                "34!Sarıyer",
                "34!Silivri",
                "34!Şile",
                "34!Şişli",
                "34!Üsküdar",
                "34!Zeytinburnu",
                "34!Büyükçekmece",
                "34!Kağıthane",
                "34!Küçükçekmece",
                "34!Pendik",
                "34!Ümraniye",
                "34!Bayrampaşa",
                "34!Avcılar",
                "34!Bağcılar",
                "34!Bahçelievler",
                "34!Güngören",
                "34!Maltepe",
                "34!Sultanbeyli",
                "34!Tuzla",
                "34!Esenler",
                "34!Arnavutköy",
                "34!Ataşehir",
                "34!Başakşehir",
                "34!Beylikdüzü",
                "34!Çekmeköy",
                "34!Esenyurt",
                "34!Sancaktepe",
                "34!Sultangazi",
                "35!Aliağa",
                "35!Bayındır",
                "35!Bergama",
                "35!Bornova",
                "35!Çeşme",
                "35!Dikili",
                "35!Foça",
                "35!Karaburun",
                "35!Karşıyaka",
                "35!Kemalpaşa / İzmir",
                "35!Kınık",
                "35!Kiraz",
                "35!Menemen",
                "35!Ödemiş",
                "35!Seferihisar",
                "35!Selçuk",
                "35!Tire",
                "35!Torbalı",
                "35!Urla",
                "35!Beydağ",
                "35!Buca",
                "35!Konak",
                "35!Menderes",
                "35!Balçova",
                "35!Çiğli",
                "35!Gaziemir",
                "35!Narlıdere",
                "35!Güzelbahçe",
                "35!Bayraklı",
                "35!Karabağlar",
                "36!Arpaçay",
                "36!Digor",
                "36!Kağızman",
                "36!Kars Merkez",
                "36!Sarıkamış",
                "36!Selim",
                "36!Susuz",
                "36!Akyaka",
                "37!Abana",
                "37!Araç",
                "37!Azdavay",
                "37!Bozkurt / Kastamonu",
                "37!Cide",
                "37!Çatalzeytin",
                "37!Daday",
                "37!Devrekani",
                "37!İnebolu",
                "37!Kastamonu Merkez",
                "37!Küre",
                "37!Taşköprü",
                "37!Tosya",
                "37!İhsangazi",
                "37!Pınarbaşı / Kastamonu",
                "37!Şenpazar",
                "37!Ağlı",
                "37!Doğanyurt",
                "37!Hanönü",
                "37!Seydiler",
                "38!Bünyan",
                "38!Develi",
                "38!Felahiye",
                "38!İncesu",
                "38!Pınarbaşı / Kayseri",
                "38!Sarıoğlan",
                "38!Sarız",
                "38!Tomarza",
                "38!Yahyalı",
                "38!Yeşilhisar",
                "38!Akkışla",
                "38!Talas",
                "38!Kocasinan",
                "38!Melikgazi",
                "38!Hacılar",
                "38!Özvatan",
                "39!Babaeski",
                "39!Demirköy",
                "39!Kırklareli Merkez",
                "39!Kofçaz",
                "39!Lüleburgaz",
                "39!Pehlivanköy",
                "39!Pınarhisar",
                "39!Vize",
                "40!Çiçekdağı",
                "40!Kaman",
                "40!Kırşehir Merkez",
                "40!Mucur",
                "40!Akpınar",
                "40!Akçakent",
                "40!Boztepe",
                "41!Gebze",
                "41!Gölcük",
                "41!Kandıra",
                "41!Karamürsel",
                "41!Körfez",
                "41!Derince",
                "41!Başiskele",
                "41!Çayırova",
                "41!Darıca",
                "41!Dilovası",
                "41!İzmit",
                "41!Kartepe",
                "42!Akşehir",
                "42!Beyşehir",
                "42!Bozkır",
                "42!Cihanbeyli",
                "42!Çumra",
                "42!Doğanhisar",
                "42!Ereğli / Konya",
                "42!Hadim",
                "42!Ilgın",
                "42!Kadınhanı",
                "42!Karapınar",
                "42!Kulu",
                "42!Sarayönü",
                "42!Seydişehir",
                "42!Yunak",
                "42!Akören",
                "42!Altınekin",
                "42!Derebucak",
                "42!Hüyük",
                "42!Karatay",
                "42!Meram",
                "42!Selçuklu",
                "42!Taşkent",
                "42!Ahırlı",
                "42!Çeltik",
                "42!Derbent",
                "42!Emirgazi",
                "42!Güneysınır",
                "42!Halkapınar",
                "42!Tuzlukçu",
                "42!Yalıhüyük",
                "43!Altıntaş",
                "43!Domaniç",
                "43!Emet",
                "43!Gediz",
                "43!Kütahya Merkez",
                "43!Simav",
                "43!Tavşanlı",
                "43!Aslanapa",
                "43!Dumlupınar",
                "43!Hisarcık",
                "43!Şaphane",
                "43!Çavdarhisar",
                "43!Pazarlar",
                "44!Akçadağ",
                "44!Arapgir",
                "44!Arguvan",
                "44!Darende",
                "44!Doğanşehir",
                "44!Hekimhan",
                "44!Pütürge",
                "44!Yeşilyurt / Malatya",
                "44!Battalgazi",
                "44!Doğanyol",
                "44!Kale / Malatya",
                "44!Kuluncak",
                "44!Yazıhan",
                "45!Akhisar",
                "45!Alaşehir",
                "45!Demirci",
                "45!Gördes",
                "45!Kırkağaç",
                "45!Kula",
                "45!Salihli",
                "45!Sarıgöl",
                "45!Saruhanlı",
                "45!Selendi",
                "45!Soma",
                "45!Turgutlu",
                "45!Ahmetli",
                "45!Gölmarmara",
                "45!Köprübaşı / Manisa",
                "45!Şehzadeler",
                "45!Yunusemre",
                "46!Afşin",
                "46!Andırın",
                "46!Elbistan",
                "46!Göksun",
                "46!Pazarcık",
                "46!Türkoğlu",
                "46!Çağlayancerit",
                "46!Ekinözü",
                "46!Nurhak",
                "46!Dulkadiroğlu",
                "46!Onikişubat",
                "47!Derik",
                "47!Kızıltepe",
                "47!Mazıdağı",
                "47!Midyat",
                "47!Nusaybin",
                "47!Ömerli",
                "47!Savur",
                "47!Dargeçit",
                "47!Yeşilli",
                "47!Artuklu",
                "48!Bodrum",
                "48!Datça",
                "48!Fethiye",
                "48!Köyceğiz",
                "48!Marmaris",
                "48!Milas",
                "48!Ula",
                "48!Yatağan",
                "48!Dalaman",
                "48!Ortaca",
                "48!Kavaklıdere",
                "48!Menteşe",
                "48!Seydikemer",
                "49!Bulanık",
                "49!Malazgirt",
                "49!Muş Merkez",
                "49!Varto",
                "49!Hasköy",
                "49!Korkut",
                "50!Avanos",
                "50!Derinkuyu",
                "50!Gülşehir",
                "50!Hacıbektaş",
                "50!Kozaklı",
                "50!Nevşehir Merkez",
                "50!Ürgüp",
                "50!Acıgöl",
                "51!Bor",
                "51!Çamardı",
                "51!Niğde Merkez",
                "51!Ulukışla",
                "51!Altunhisar",
                "51!Çiftlik",
                "52!Akkuş",
                "52!Aybastı",
                "52!Fatsa",
                "52!Gölköy",
                "52!Korgan",
                "52!Kumru",
                "52!Mesudiye",
                "52!Perşembe",
                "52!Ulubey / Ordu",
                "52!Ünye",
                "52!Gülyalı",
                "52!Gürgentepe",
                "52!Çamaş",
                "52!Çatalpınar",
                "52!Çaybaşı",
                "52!İkizce",
                "52!Kabadüz",
                "52!Kabataş",
                "52!Altınordu",
                "53!Ardeşen",
                "53!Çamlıhemşin",
                "53!Çayeli",
                "53!Fındıklı",
                "53!İkizdere",
                "53!Kalkandere",
                "53!Pazar / Rize",
                "53!Rize Merkez",
                "53!Güneysu",
                "53!Derepazarı",
                "53!Hemşin",
                "53!İyidere",
                "54!Akyazı",
                "54!Geyve",
                "54!Hendek",
                "54!Karasu",
                "54!Kaynarca",
                "54!Sapanca",
                "54!Kocaali",
                "54!Pamukova",
                "54!Taraklı",
                "54!Ferizli",
                "54!Karapürçek",
                "54!Söğütlü",
                "54!Adapazarı",
                "54!Arifiye",
                "54!Erenler",
                "54!Serdivan",
                "55!Alaçam",
                "55!Bafra",
                "55!Çarşamba",
                "55!Havza",
                "55!Kavak",
                "55!Ladik",
                "55!Terme",
                "55!Vezirköprü",
                "55!Asarcık",
                "55!19.May",
                "55!Salıpazarı",
                "55!Tekkeköy",
                "55!Ayvacık / Samsun",
                "55!Yakakent",
                "55!Atakum",
                "55!Canik",
                "55!İlkadım",
                "56!Baykan",
                "56!Eruh",
                "56!Kurtalan",
                "56!Pervari",
                "56!Siirt Merkez",
                "56!Şirvan",
                "56!Tillo",
                "57!Ayancık",
                "57!Boyabat",
                "57!Durağan",
                "57!Erfelek",
                "57!Gerze",
                "57!Sinop Merkez",
                "57!Türkeli",
                "57!Dikmen",
                "57!Saraydüzü",
                "58!Divriği",
                "58!Gemerek",
                "58!Gürün",
                "58!Hafik",
                "58!İmranlı",
                "58!Kangal",
                "58!Koyulhisar",
                "58!Sivas Merkez",
                "58!Suşehri",
                "58!Şarkışla",
                "58!Yıldızeli",
                "58!Zara",
                "58!Akıncılar",
                "58!Altınyayla / Sivas",
                "58!Doğanşar",
                "58!Gölova",
                "58!Ulaş",
                "59!Çerkezköy",
                "59!Çorlu",
                "59!Hayrabolu",
                "59!Malkara",
                "59!Muratlı",
                "59!Saray / Tekirdağ",
                "59!Şarköy",
                "59!Marmaraereğlisi",
                "59!Ergene",
                "59!Kapaklı",
                "59!Süleymanpaşa",
                "60!Almus",
                "60!Artova",
                "60!Erbaa",
                "60!Niksar",
                "60!Reşadiye",
                "60!Tokat Merkez",
                "60!Turhal",
                "60!Zile",
                "60!Pazar / Tokat",
                "60!Yeşilyurt / Tokat",
                "60!Başçiftlik",
                "60!Sulusaray",
                "61!Akçaabat",
                "61!Araklı",
                "61!Arsin",
                "61!Çaykara",
                "61!Maçka",
                "61!Of",
                "61!Sürmene",
                "61!Tonya",
                "61!Vakfıkebir",
                "61!Yomra",
                "61!Beşikdüzü",
                "61!Şalpazarı",
                "61!Çarşıbaşı",
                "61!Dernekpazarı",
                "61!Düzköy",
                "61!Hayrat",
                "61!Köprübaşı / Trabzon",
                "61!Ortahisar",
                "62!Çemişgezek",
                "62!Hozat",
                "62!Mazgirt",
                "62!Nazımiye",
                "62!Ovacık / Tunceli",
                "62!Pertek",
                "62!Pülümür",
                "62!Tunceli Merkez",
                "63!Akçakale",
                "63!Birecik",
                "63!Bozova",
                "63!Ceylanpınar",
                "63!Halfeti",
                "63!Hilvan",
                "63!Siverek",
                "63!Suruç",
                "63!Viranşehir",
                "63!Harran",
                "63!Eyyübiye",
                "63!Haliliye",
                "63!Karaköprü",
                "64!Banaz",
                "64!Eşme",
                "64!Karahallı",
                "64!Sivaslı",
                "64!Ulubey / Uşak",
                "64!Uşak Merkez",
                "65!Başkale",
                "65!Çatak",
                "65!Erciş",
                "65!Gevaş",
                "65!Gürpınar",
                "65!Muradiye",
                "65!Özalp",
                "65!Bahçesaray",
                "65!Çaldıran",
                "65!Edremit / Van",
                "65!Saray / Van",
                "65!İpekyolu",
                "65!Tuşba",
                "66!Akdağmadeni",
                "66!Boğazlıyan",
                "66!Çayıralan",
                "66!Çekerek",
                "66!Sarıkaya",
                "66!Sorgun",
                "66!Şefaatli",
                "66!Yerköy",
                "66!Yozgat Merkez",
                "66!Aydıncık / Yozgat",
                "66!Çandır",
                "66!Kadışehri",
                "66!Saraykent",
                "66!Yenifakılı",
                "67!Çaycuma",
                "67!Devrek",
                "67!Ereğli / Zonguldak",
                "67!Zonguldak Merkez",
                "67!Alaplı",
                "67!Gökçebey",
                "67!Kilimli",
                "67!Kozlu",
                "68!Aksaray Merkez",
                "68!Ortaköy / Aksaray",
                "68!Ağaçören",
                "68!Güzelyurt",
                "68!Sarıyahşi",
                "68!Eskil",
                "68!Gülağaç",
                "69!Bayburt Merkez",
                "69!Aydıntepe",
                "69!Demirözü",
                "70!Ermenek",
                "70!Karaman Merkez",
                "70!Ayrancı",
                "70!Kazımkarabekir",
                "70!Başyayla",
                "70!Sarıveliler",
                "71!Delice",
                "71!Keskin",
                "71!Kırıkkale Merkez",
                "71!Sulakyurt",
                "71!Bahşili",
                "71!Balışeyh",
                "71!Çelebi",
                "71!Karakeçili",
                "71!Yahşihan",
                "72!Batman Merkez",
                "72!Beşiri",
                "72!Gercüş",
                "72!Kozluk",
                "72!Sason",
                "72!Hasankeyf",
                "73!Beytüşşebap",
                "73!Cizre",
                "73!İdil",
                "73!Silopi",
                "73!Şırnak Merkez",
                "73!Uludere",
                "73!Güçlükonak",
                "74!Bartın Merkez",
                "74!Kurucaşile",
                "74!Ulus",
                "74!Amasra",
                "75!Ardahan Merkez",
                "75!Çıldır",
                "75!Göle",
                "75!Hanak",
                "75!Posof",
                "75!Damal",
                "76!Aralık",
                "76!Iğdır Merkez",
                "76!Tuzluca",
                "76!Karakoyunlu",
                "77!Yalova Merkez",
                "77!Altınova",
                "77!Armutlu",
                "77!Çınarcık",
                "77!Çiftlikköy",
                "77!Termal",
                "78!Eflani",
                "78!Eskipazar",
                "78!Karabük Merkez",
                "78!Ovacık / Karabük",
                "78!Safranbolu",
                "78!Yenice / Karabük",
                "79!Kilis Merkez",
                "79!Elbeyli",
                "79!Musabeyli",
                "79!Polateli",
                "80!Bahçe",
                "80!Kadirli",
                "80!Osmaniye Merkez",
                "80!Düziçi",
                "80!Hasanbeyli",
                "80!Sumbas",
                "80!Toprakkale",
                "81!Akçakoca",
                "81!Düzce Merkez",
                "81!Yığılca",
                "81!Cumayeri",
                "81!Gölyaka",
                "81!Çilimli",
                "81!Gümüşova",
                "81!Kaynaşlı",
        };

        Arrays.stream(districtArray).forEach(
                s -> {
                    String array[] = s.split("!");
                    City city = cityRepository.findByCityId(Integer.parseInt(array[0]));
                    districtRepository.save(District.builder().districtName(array[1]).city(city).build());
                }
        );
    }
}
