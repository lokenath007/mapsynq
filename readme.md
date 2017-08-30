#To Download the Project, Type the following in command line
 	
     git clone https://github.com/lokenath007/mapsynq.git

#cd mapsynq and To Execute the project, Run the following command 

#For Chrome(Version 60.0.3112.113 (Official Build) (64-bit)) Execute the command from terminal:

	mvn clean test  -Durl="http://www.mapsynq.com/" -Dbrowser="Chrome" -DxmlFileName=testng.xml

#For Firefox(54.0.1 (64-bit)) Execute the command from terminal:

	mvn clean test  -Durl="http://www.mapsynq.com/" -Dbrowser="Firefox" -DxmlFileName=testng.xml

##This project use testng framework, maven buid.

##This Project support POM and structure define below.

##All page class(the basic public methods/operation and its private members)  located at pageclasses package (/mapsynq/src/test/java/com/mapsynq/pageclasses) like Direction Page,Live Page etc

##Separete Test class  located at testclass package (/mapsynq/src/test/java/com/mapsynq/testclass) to test the basic public methods/operation of   Direction Page,Live Page etc


##All utility class located at utility package (/mapsynq/src/test/java/com/mapsynq/utilityclasses) 

1.CheckDomProperties.java - To check dom properties of an element (it is using javascriptexecutor , to check if 	    dom is not rendered, it check properties)
	
2. TestListener.java-It implements ITestListener to capture screenshot at /mapsynq/Screenshots if assertion fail

3.CustomizeReport.java - It customize the report and transaction start and end time of report

4. GetJsonTestData.java - To read the testdata.txt 

5. AlertHandle.java- It handle unexpected alert popup

##Testdata resides at - /mapsynq/src/test/resources/testdata.txt

##All the firefox gecko driver and chrome driver reside at /mapsynq/drivers

Now the test cases supports below scenarios,
1.Open a browser with http://www.mapsynq.com/ url
2.Click Directions Tab
3.Click Clear Route link under Directions Page
4.Click Get Directions button with blank A and B fields under Directions Page
5.Click Get Directions button for  Trafic Aware  Route with valid data in A and B fields under Directions Page
6.Uncheck Trafic Aware and Checked Toll Aware,then Click Get Directions button with valid data in A and B fields under Directions Page
7.Uncheck Toll Aware and Checked Fatest,then Click Get Directions button with valid data in A and B fields under Directions Page
8.Uncheck Fatest and Checked Shortest,then Click Get Directions button with valid data in A and B fields under Directions Page
9.Click Live Tab
10.Check Singapore Live Traffic News
11.Click Camera Tab Under Live Page
12.Check Singapore Live Traffic Cameras
13.Check Malaysia Live Traffic Cameras
14.Check Srilanka Live Traffic Cameras
15.Test Count of links and images
16.Test Count of invalid links and images
17.Click Tolls Tab
18.Verify Singapore Tolls
19.Verify Malaysia Tolls
20.Verify Thiland Tolls
21.Click First Singapore Toll Link
22.Switch To Price List Dropdown
23.Verify Time and Toll Rates Large Vehicle (Weekdays) of Singapore First Toll link
24.Verify Time and Toll Rates Car (Saturday) of Singapore First Toll link
25.Verify Time and Toll Rates MotorCycle (Weekdays) of Singapore First Toll link
26.Verify Time and Toll Rates MotorCycle (Saturday) of Singapore First Toll link
27.Verify Time and Toll Rates Car (Weekdays) of Singapore First Toll link
28.Verify Time and Toll Rates Large Vehicle (Saturday) of Singapore First Toll link
29.Verify Time and Toll Rates Heavy Vehicle (Weekdays) of Singapore First Toll link
30.Verify Time and Toll Rates Heavy Vehicle (Saturday) of Singapore First Toll link
31.Verify Time and Toll Rates Very Heavh Vehicle (Weekdays) of Singapore First Toll link
32.Verify Time and Toll Rates Very Heavh Vehicle (Saturday) of Singapore First Toll link
33.Close Browser


#If above failure occurs it capture screenshot in the  location /mapsynq/Screenshots  

#Report Strucre#

###To see the test result , go to folder Repo/mapsynq/target/surefire-reports/ and then click index.html.then You can see the following tabs

testng.xml
1 test
0 groups
Times
Reporter output
Ignored methods
Chronological view


You can click each tab to get details of Report


###TIME
Total running time: 26 minutes
Number	Method	Class	Time (ms)
0	getPriceAndRatesLargeVehicleSaturday	com.mapsynq.testclass.TestMapsynq	923,223
1	getPriceAndRatesCarSaturday	com.mapsynq.testclass.TestMapsynq	100,175
2	getPriceAndRatesMotorCycleSaturday	com.mapsynq.testclass.TestMapsynq	100,172
3	getPriceAndRatesVeryHeavhVehicleSaturday	com.mapsynq.testclass.TestMapsynq	100,133
4	getPriceAndRatesHeavyVehicleSaturday	com.mapsynq.testclass.TestMapsynq	100,125
5	switchToPriceListDropdown	com.mapsynq.testclass.TestMapsynq	100,103
6	testFatestRoute	com.mapsynq.testclass.TestMapsynq	36,111
7	testTollAwareRoute	com.mapsynq.testclass.TestMapsynq	36,103
8	testShortestRoute	com.mapsynq.testclass.TestMapsynq	35,790
9	testTraficAwareRoute	com.mapsynq.testclass.TestMapsynq	22,064
10	testCountInvalidLink	com.mapsynq.testclass.TestMapsynq	20,039
11	LaunchURL	com.mapsynq.testclass.TestMapsynq	6,613
12	clickDirectiontab	com.mapsynq.testclass.TestMapsynq	5,940
13	clickLiveTab	com.mapsynq.testclass.TestMapsynq	5,415
14	getPriceAndRatesHeavyVehicleWeekdays	com.mapsynq.testclass.TestMapsynq	1,910
15	getPriceAndRatesMotorCycleWeekdays	com.mapsynq.testclass.TestMapsynq	1,857
16	getPriceAndRatesLargeVehicleWeekdays	com.mapsynq.testclass.TestMapsynq	1,810
17	getPriceAndRatesCarWeekdays	com.mapsynq.testclass.TestMapsynq	1,706
18	getPriceAndRatesVeryHeavhVehicleWeekdays	com.mapsynq.testclass.TestMapsynq	1,667
19	checkThialndTolls	com.mapsynq.testclass.TestMapsynq	963
20	checkSingaporeLiveTrafficNews	com.mapsynq.testclass.TestMapsynq	861
21	checkSingaporeTolls	com.mapsynq.testclass.TestMapsynq	846
22	testBlankSourceDesinationTraficAwareRoute	com.mapsynq.testclass.TestMapsynq	803
23	clickFirstSignaporeTollLink	com.mapsynq.testclass.TestMapsynq	614
24	checkMalaysiaTolls	com.mapsynq.testclass.TestMapsynq	539
25	testClearRoute	com.mapsynq.testclass.TestMapsynq	326
26	singaporeLiveTrafficCameras	com.mapsynq.testclass.TestMapsynq	217
27	clickCameraTab	com.mapsynq.testclass.TestMapsynq	154
28	srilankaLiveTrafficCameras	com.mapsynq.testclass.TestMapsynq	151
29	testCountTotalLink	com.mapsynq.testclass.TestMapsynq	138
30	malaysiaLiveTrafficCameras	com.mapsynq.testclass.TestMapsynq	132
31	clickTollsLink	com.mapsynq.testclass.TestMapsynq	126
32	closeBrowser	com.mapsynq.testclass.TestMapsynq	117

##Sample chronological order
com.mapsynq.testclass.TestMapsynq
LaunchURL 0 ms
clickDirectiontab 6614 ms
testClearRoute 12555 ms
testBlankSourceDesinationTraficAwareRoute 12881 ms
testTraficAwareRoute 13684 ms
testTollAwareRoute 35749 ms
testFatestRoute 71852 ms
testShortestRoute 107963 ms
clickLiveTab 143753 ms
checkSingaporeLiveTrafficNews 149168 ms
clickCameraTab 150030 ms
singaporeLiveTrafficCameras 150184 ms
malaysiaLiveTrafficCameras 150402 ms
srilankaLiveTrafficCameras 150534 ms
testCountTotalLink 150685 ms
testCountInvalidLink 150823 ms
clickTollsLink 170863 ms
checkSingaporeTolls 170989 ms
checkMalaysiaTolls 171835 ms
checkThialndTolls 172374 ms
clickFirstSignaporeTollLink 173337 ms
switchToPriceListDropdown 173951 ms
getPriceAndRatesLargeVehicleWeekdays 274054 ms
getPriceAndRatesCarSaturday 275864 ms
getPriceAndRatesMotorCycleWeekdays 376039 ms
getPriceAndRatesMotorCycleSaturday 377896 ms
getPriceAndRatesCarWeekdays 478069 ms
getPriceAndRatesLargeVehicleSaturday 479775 ms
getPriceAndRatesHeavyVehicleWeekdays 1402999 ms
getPriceAndRatesHeavyVehicleSaturday 1404909 ms
getPriceAndRatesVeryHeavhVehicleWeekdays 1505035 ms
getPriceAndRatesVeryHeavhVehicleSaturday 1506702 ms
closeBrowser



#Sample Report Output for all fetch data from mapsynq

getPriceAndRatesMotorCycleSaturday
Motorcycle (Saturday)
checkSingaporeTolls
Anson Road AYE to City before Alexandra Road Bayfront Avenue towards Marina Boulevard Bayfront Avenue towards Raffles Avenue Beach Road Bencoolen Street Bendemeer Road Bt Timah Expressway (Sb betw Dairy Farm Rd & PIE) Buyong Road Cairnhill Road Central Boulevard Citybound AYE After Jurong Town Hall Clemenceau Ave Clementi Avenue 2 into AYE (City) Clementi Avenue 6 into AYE (City) CTE after Braddell Road CTE before Braddell Road CTE from Balestier Road CTE from Serangoon Road CTE Northbound after PIE CTE Northbound before exit to PIE CTE Slip Road to PIE (Changi) / Serangoon Road Dunearn Road / Wayang Satu Flyover Dunearn Road / Whitley Road ECP Eastbound before exit to KPE ECP to City Eu Tong Sen Street Eu Tong Seng Street at Central Fort Canning Tunnel Fullerton Road eastbound at Fullerton Hotel Fullerton Road westbound at One Fullerton Geylang Bahru Geylang Road Havelock Road/Clemenceau Ave Havelock Road/CTE Exit Kallang Bahru Killiney Road KPE Southbound exit to ECP (City) Kramat Road Lim Teck Kim Road Marina Boulevard to MCE Eastbound Maxwell Road MCE Eastbound before exit to Central Boulevard MCE Westbound before exit to Maxwell Road MCE Westbound exit to Marina Coastal Drive Merchant Road/Clemenceau Ave Merchant Road/CTE Exit New Bridge Road before Upper Circular Road Nicoll Highway North Bridge Road Orchard Link Orchard Road Orchard Road after Handy Road Orchard Road after YMCA Orchard Turn Oxley Road PIE after Kallang Bahru on Woodsville Flyover PIE into CTE PIE slip road to Bendemeer Road PIE to Changi / Whitley Road PIE to Changi after Adam Road Exit PIE to CTE Northbound before Braddell Road PIE westbound before Eunos Link Queen Street Republic Boulevard River Valley Road Sheares Avenue towards Sheares Link South Bridge Road before Upper Circular Road Tanjong Pagar Road Temasek Boulevard Thomson Road after Toa Payoh Rise Toa Payoh Lorong 6 Tuasbound AYE After North Buona Vista Upper Boon Keng Road Upper Bt Timah Rd Southbound after Hume Ave Victoria Street Woodsville Tunnel
getPriceAndRatesLargeVehicleSaturday
Large Vehicle (Saturday)
checkSingaporeLiveTrafficNews
17:42 Heavy Traffic on PIE towards Tuas between Toa Payoh Exit and Thomson Rd Exit. 17:41 Heavy Traffic on AYE towards MCE between Buona Vista Exit and Alexandra. 17:38 Heavy Traffic on AYE towards Tuas between Clementi Rd Exit and Clementi Ave 6 Exit. 17:36 Heavy Traffic on SLE towards BKE at Woodlands Ave 12 Exit. 17:35 Accident on Thomson Road towards SLE after PIE. 17:34 Heavy Traffic on PIE towards Changi Airport between Toa Payoh Lor 1 and Kallang Way. 17:33 Heavy Traffic on AYE towards MCE between Yuan Ching Exit and Clementi Ave 6 Exit. 17:24 Vehicle breakdown on AYE towards MCE before Yuan Ching Exit. Avoid lane 3. 17:23 Heavy Traffic on KJE towards BKE at BKE Woodlands Exit. 17:22 Heavy Traffic on CTE towards SLE between Braddell Rd Exit and AMK Ave 3 Exit. 16:40 Heavy Traffic on PIE towards Changi Airport at Lornie Rd Exit. 16:38 Heavy Traffic on CTE towards SLE between Cairnhill Circle Entrance and Moulmein Rd Exit. 16:34 Vehicle breakdown on ECP towards City after East Coast Park Carpark H Exit. 14:32 Heavy Traffic on PIE towards Tuas between Paya Lebar Rd and KPE Exit.
getPriceAndRatesMotorCycleWeekdays
Motorcycle (Weekdays) 00:00 - 06:59 $0.00 07:00 - 08:00 $0.00 08:00 - 08:04 $0.50 08:04 - 08:30 $1.00 08:30 - 09:00 $1.25 09:00 - 09:25 $1.00 09:25 - 09:30 $0.75 09:30 - 09:55 $0.50 09:55 - 10:00 $0.25 10:00 - 12:00 $0.00 12:00 - 12:04 $0.25 12:04 - 14:00 $0.50 14:00 - 14:04 $0.75 14:04 - 14:55 $1.00 14:55 - 15:00 $0.75 15:00 - 17:30 $0.50 17:30 - 18:00 $0.75 18:00 - 18:04 $1.15 18:04 - 18:25 $1.50 18:25 - 18:30 $1.25 18:30 - 18:55 $1.00 18:55 - 19:00 $0.75 19:00 - 19:55 $0.50 19:55 - 20:00 $0.25 20:00 - 22:30 $0.00 22:30 - 23:59 $0.00
malaysiaLiveTrafficCameras
Bangunan DBKL Bulatan Dato Bulatan Kg Pandan Bulatan Segambut DBP Desa Petaling Esso exit Jalan Robson Hentian Putra HKL Istana Budaya Jalan Usahawan Junction Jejambat Jln Kedutaan Perancis Klinik Pergigian Bangsar Pasar Besar Gombak Pavilion Persiaran Titiwangsa Petronas TPM PJ Hilton Sheraton Imperial Taman Bukit Jalil Taman Duta Taman Midah uta Vista
singaporeLiveTrafficCameras
Adam Road (Towards Changi) After Tuas West Road (Towards Tuas) After Tuas West Road (Towards Tuas) Alexandra Road (Towards MCE) Ang Mo Kio Ave 1 Flyover Ang Mo Kio Ave 5 Flyover (Towards City) Bedok North (Towards Jurong) Benjamin Sheares Bridge Braddell Flyover (Towards SLE) Bukit Merah Flyover Bukit Timah Expressway (Towards Changi) Central Boulevard Ramp onto MCE(AYE) Chantek Flyover (Towards PIE) Choa Chu Kang (Towards PIE) Dairy Farm Flyover (Towards PIE) Defu Flyover Entrance from Chin Swee Road (Towards SLE) Entrance from MCE (Towards Changi) Entrance from PIE (Towards Changi) Eunos Flyover (Towards Jurong) Exit 2A to Changi Coast Road (Towards City) Exit 6 to Bukit Timah Road Fort Road Jurong West ST81 (Towards Jurong) Kallang Bahru Kallang Way Flyover Keppel Viaduct Kim Keat (Towards Changi) KPE / Aljunied West Flyover KPE/PIE Laguna Flyover (Towards Changi) Lentor Flyover (Towards TPE) Lower Delta Road (Towards City) Marina Bay (Towards AYE) Marina Blvd Ramp onto MCE(KPE) Marine Parade Flyover (Towards City) MCE(AYE) Start of Expressway MCE(KPE) Before Exit 2 Central Blvd Moulmein Flyover (Towards AYE) Mount Pleasant (Towards Jurong) Near Dover ITE (Towards MCE) Near NUS (Towards Tuas) Pandan Gardens (Towards Tuas) Paya Lebar Flyover (Towards Jurong) Rivervale Drive (Towards SLE) Second Link at Tuas Seletar Flyover (Towards BKE) Sentosa Gateway (Towards Sentosa) Sentosa Gateway (Towards Telok Blangah) St George Road (Towards SLE) Tampines Flyover Tanjong Katong Flyover (Towards Changi) Tanjong Rhu (Towards MCE) Thomson Road Tuas Checkpoint Upper Changi Flyover (Towards PIE) Woodlands Causeway (Towards Johor) Woodlands Checkpoint (Towards BKE) Woodlands Flyover (Towards Checkpoint) Woodlands South Flyover (Towards Woodlands) Woodsville Flyover (Towards Changi) Yio Chu Kang Flyover
testCountTotalLink
534
getPriceAndRatesLargeVehicleWeekdays
Large Vehicle (Weekdays) 00:00 - 06:59 $0.00 07:00 - 08:00 $0.00 08:00 - 08:04 $1.00 08:04 - 08:30 $2.00 08:30 - 09:00 $2.50 09:00 - 09:25 $2.00 09:25 - 09:30 $1.50 09:30 - 09:55 $1.00 09:55 - 10:00 $0.50 10:00 - 12:00 $0.00 12:00 - 12:04 $0.50 12:04 - 14:00 $1.00 14:00 - 14:04 $1.50 14:04 - 14:55 $2.00 14:55 - 15:00 $1.50 15:00 - 17:30 $1.00 17:30 - 18:00 $1.50 18:00 - 18:04 $2.30 18:04 - 18:25 $3.00 18:25 - 18:30 $2.50 18:30 - 18:55 $2.00 18:55 - 19:00 $1.50 19:00 - 19:55 $1.00 19:55 - 20:00 $0.50 20:00 - 22:30 $0.00 22:30 - 23:59 $0.00
checkMalaysiaTolls
Alam Impian Awan Besar (East) Awan Kecil (West) Ayer Hitam Ayer Panas Bagan Ajam Batu Batu 11 Batu 9 Bentong Bukit Jelutong Bukit Kajang Bukit Raja Damansara A Damansara B East-West Link (E) East-West Link (E) Elmina Gombak Kampung Medan Kapar Kapar (E) to Bukit Raja Kapar (E) to Port Klang Kapar (W) to Bukit Raja Kapar (W) to Port Klang Kemuning Keramat Kerinchi Link Kubang Semang Lagong Laluan Terus Lema-Kedai Lukut Lunas Mambau Mines (S) Mines (T) Mont. Kiara Pantai Dalam Pantai Dalam (T) Penang Bridge Penchala Perai Perling PETALING JAYA Pjs 5 Puchong Barat Puchong Selatan Putrajaya Salak Link Salak Selatan Saujana Putra Sentul Pasar Seri Muda Sg. Nyior SMART Tunnel Sungai Balak Sungai Long Sungai Ramal (E) Sungai Ramal (W) Sunway Toll Gelang Patah Toll Kempas
getPriceAndRatesHeavyVehicleSaturday
Heavy Vehicle (Saturday)
getPriceAndRatesCarSaturday
Car (Saturday)
testCountInvalidLink
423
getPriceAndRatesVeryHeavhVehicleSaturday
Very Heavh Vehicle (Saturday)
srilankaLiveTrafficCameras
Ayurveda Junction Bambalapitiya Junction Baseline Road Castle Hospital Jawatte Mosque Kaduwela Junction Kiribathgoda Junction Kollupitiya Kollupitiya Junction Pamankada Junction Papilyana Road Unity Plaza Wellawatta William Junction
getPriceAndRatesHeavyVehicleWeekdays
Heavy Vehicle (Weekdays) 00:00 - 06:59 $0.00 07:00 - 08:00 $0.00 08:00 - 08:04 $1.50 08:04 - 08:30 $3.00 08:30 - 09:00 $3.75 09:00 - 09:25 $3.00 09:25 - 09:30 $2.25 09:30 - 09:55 $1.50 09:55 - 10:00 $0.75 10:00 - 12:00 $0.00 12:00 - 12:04 $0.75 12:04 - 14:00 $1.50 14:00 - 14:04 $2.25 14:04 - 14:55 $3.00 14:55 - 15:00 $2.25 15:00 - 17:30 $1.50 17:30 - 18:00 $2.25 18:00 - 18:04 $3.45 18:04 - 18:25 $4.50 18:25 - 18:30 $3.75 18:30 - 18:55 $3.00 18:55 - 19:00 $2.25 19:00 - 19:55 $1.50 19:55 - 20:00 $0.75 20:00 - 22:30 $0.00 22:30 - 23:59 $0.00
checkThialndTolls
ANUSON SATHAN 1/1 (DON MUEANG TOLL WAY) ANUSON SATHAN 1/2 (DON MUEANG TOLL WAY) ASOK 1 TOLL GATE ASOK 2 TOLL GATE ASOK 3 TOLL GATE ASOK 4 TOLL GATE AT NARONG TOLL GATE AT NARONG 1 TOLL GATE AT NARONG 1 TOLL GATE AT NARONG 2 TOLL GATE BANG KHEN TOLL GATE (DON MUEANG TOLL WAY) BANG KHRU TOLL GATE-OUTBOUND 2 (BANG PLI-SUKSAWAT EXPRESSWAY) BANG NA TOLL GATE BANG PA-IN TOLL GATE-INBOUND BANG PA-IN TOLL GATE-OUTBOUND BANG PHUN TOLL GATE-INBOUND BANG PHUN TOLL GATE-OUTBOUND BANG SUE TOLL GATE BANGCHAK TOLL GATE CHAENG WATTHANA 1 TOLL GATE (DON MUEANG TOLL WAY) CHAENG WATTHANA 2 TOLL GATE (DON MUEANG TOLL WAY) CHAN TOLL GATE CHATUCHOT TOLL GATE CHIANG RAK TOLL GATE-INBOUND CHIANG RAK TOLL GATE-OUTBOUND DAO KHANONG TOLL GATE DIN DAENG 1 TOLL GATE (DON MUEANG TOLL WAY) DIN DAENG 2 TOLL GATE (DON MUEANG TOLL WAY) DIN DAENG TOLL GATE DIN DAENG TOLL GATE DIN DAENG TOLL GATE DON MUEANG 1 TOLL GATE (DON MUEANG TOLL WAY) DON MUEANG 2 TOLL GATE (DON MUEANG TOLL WAY) HUA LAMPHONG TOLL GATE KHLONG PRAPA 1 TOLL GATE KHLONG PRAPA 2 TOLL GATE LAK SI TOLL GATE-INBOUND (DON MUEANG TOLL WAY) LAT KRABANG TOLL GATE-INBOUND (MOTORWAY) LAT KRABANG TOLL GATE-OUTBOUND (MOTORWAY) LAT PHRAO TOLL GATE LAT PHRAO TOLL GATE-INBOUND (DON MUEANG TOLL WAY) LAT PHRAO TOLL GATE-OUTBOUND (DON MUEANG TOLL WAY) LIAB MAENAM TOLL GATE MUEANG THONG THANI TOLL GATE-INBOUND MUEANG THONG THANI TOLL GATE-OUTBOUND NGAM WONGWAN 1 TOLL GATE-OUTBOUND NGAM WONGWAN 2 TOLL GATE-INBOUND PHAHON YOTHIN 1 TOLL GATE PHAHON YOTHIN 2 TOLL GATE PHAN THONG TOLL GATE-INBOUND (MOTORWAY) PHAN THONG TOLL GATE-OUTBOUND (MOTORWAY) PHATTHANAKAN 1 TOLL GATE PHATTHANAKAN 2 TOLL GATE PHETCHABURI TOLL GATE PHRA KHANONG TOLL GATE PRACHA UTHIT TOLL GATE PRACHACHUEN 1 TOLL GATE PRACHACHUEN 2 TOLL GATE PRACHACHUEN TOLL GATE-INBOUND PRACHACHUEN TOLL GATE-OUTBOUND RAM INTHRA 1 TOLL GATE RAM INTHRA TOLL GATE RAMA 3 TOLL GATE RAMA 4-1 TOLL GATE RAMA 4-2 TOLL GATE RAMA 9-1 TOLL GATE RAMA 9-1 TOLL GATE RAMA 9-1 TOLL GATE RAMA 9-1 TOLL GATE RAMA 9-1 TOLL GATE (CHALONG RAT) RAMA 9-1 TOLL GATE (CHALONG RAT) RAMA 9-1 TOLL GATE (CHALONG RAT) RAMA 9-1 TOLL GATE (CHALONG RAT) RAMA 9-2 TOLL GATE RAMA 9 TOLL GATE RAMKHAMHAENG TOLL GATE RATCHADAPHISEK 1 TOLL GATE (DON MUEANG TOLL WAY) RATCHADAPHISEK 2 TOLL GATE (DON MUEANG TOLL WAY) RATCHADAPHISEK TOLL GATE SAPHAN SAWANG TOLL GATE SATHON TOLL GATE SATHU PRADIT 1 TOLL GATE SATHU PRADIT 2 TOLL GATE SATHU PRADIT 3 TOLL GATE SINAKHARIN TOLL GATE SISAMAN TOLL GATE-INBOUND SISAMAN TOLL GATE-OUTBOUND SUKHA PHIBAN 5-1 TOLL GATE SUKHA PHIBAN 5-2 TOLL GATE SUKHUMVIT 62 TOLL GATE SUKHUMVIT TOLL GATE SUKSAWAT TOLL GATE SURAWONG TOLL GATE SUTTHISAN TOLL GATE (DON MUEANG TOLL WAY) THA RUEA 1 TOLL GATE THA RUEA 2 TOLL GATE THANYA BURI TOLL GATE-INBOUND (KANCHANA PHISEK) THANYA BURI TOLL GATE-OUTBOUND (KANCHANA PHISEK) THAP CHANG TOLL GATE-INBOUND (KANCHANA PHISEK) THAP CHANG TOLL GATE-OUTBOUND (KANCHANA PHISEK) THAP CHANG TOLL GATE-OUTBOUND (KANCHANA PHISEK) TOLL GATE TOLL GATE TOLL GATE (GO TO CHALONGRAT) URUPHONG TOLL GATE YAN PHAHON YOTHIN TOLL GATE YOM MARAT TOLL GATE YOTHIN PHATTHANA TOLL GATE
getPriceAndRatesCarWeekdays
Car (Weekdays) 00:00 - 06:59 $0.00 07:00 - 08:00 $0.00 08:00 - 08:04 $1.00 08:04 - 08:30 $2.00 08:30 - 09:00 $2.50 09:00 - 09:25 $2.00 09:25 - 09:30 $1.50 09:30 - 09:55 $1.00 09:55 - 10:00 $0.50 10:00 - 12:00 $0.00 12:00 - 12:04 $0.50 12:04 - 14:00 $1.00 14:00 - 14:04 $1.50 14:04 - 14:55 $2.00 14:55 - 15:00 $1.50 15:00 - 17:30 $1.00 17:30 - 18:00 $1.50 18:00 - 18:04 $2.30 18:04 - 18:25 $3.00 18:25 - 18:30 $2.50 18:30 - 18:55 $2.00 18:55 - 19:00 $1.50 19:00 - 19:55 $1.00 19:55 - 20:00 $0.50 20:00 - 22:30 $0.00 22:30 - 23:59 $0.00
getPriceAndRatesVeryHeavhVehicleWeekdays
Very Heavh Vehicle (Weekdays) 00:00 - 06:59 $0.00 07:00 - 08:00 $0.00 08:00 - 08:04 $2.00 08:04 - 08:30 $4.00 08:30 - 09:00 $5.00 09:00 - 09:25 $4.00 09:25 - 09:30 $3.00 09:30 - 09:55 $2.00 09:55 - 10:00 $1.00 10:00 - 12:00 $0.00 12:00 - 12:04 $1.00 12:04 - 14:00 $2.00 14:00 - 14:04 $3.00 14:04 - 14:55 $4.00 14:55 - 15:00 $3.00 15:00 - 17:30 $2.00 17:30 - 18:00 $3.00 18:00 - 18:04 $4.60 18:04 - 18:25 $6.00 18:25 - 18:30 $5.00 18:30 - 18:55 $4.00 18:55 - 19:00 $3.00 19:00 - 19:55 $2.00 19:55 - 20:00 $1.00 20:00 - 22:30 $0.00 22:30 - 23:59 $0.00


#Console log for Result Summary

Tests run: 33, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 780.371 sec

Results :

Tests run: 33, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 13:04 min
[INFO] Finished at: 2017-08-30T16:25:59+05:30
[INFO] Final Memory: 18M/204M
[INFO] ------------------------------------------------------------------------


