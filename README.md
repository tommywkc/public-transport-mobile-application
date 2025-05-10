# KMTR: Integrated Public Transport Application

## About
An integrated transportation application combining real-time information systems for Hong Kong's KMB (Kowloon Motor Bus) and MTR (Mass Transit Railway) services.

## Project Overview
### Objective
Developing a unified platform that enhances commuter efficiency by integrating KMB and MTR real-time data into a single application.

### Problem Addressed
Currently, passengers need separate applications for KMB and MTR services. KMTR solves this by providing a single, comprehensive platform for both services.

## Key Features

### 🚉 Transportation Information
- Real-time KMB and MTR route displays
- Live arrival time estimates
- Comprehensive route information
- Advanced route search functionality

### 🌓 Theme Options
- Dark/Light mode support
- Easy theme switching via sun icon
- Enhanced visibility in different conditions

### 🌏 Bilingual Support
- Complete English/Chinese language support
- Seamless language switching
- Localized station names and descriptions

### ⭐ Personalization
- Route bookmarking
- Quick access to favorite routes
- Customizable user preferences

## Technical Details

### API Integration
#### KMB APIs:
- Route Information: `https://data.etabus.gov.hk/v1/transport/kmb/route/`
- Retrieves bus stop data: `https://data.etabus.gov.hk/v1/transport/kmb/route-stop/`, `https://data.etabus.gov.hk/v1/transport/kmb/stop/`
- Real-time ETA: `https://data.etabus.gov.hk/v1/transport/kmb/eta/`

#### MTR APIs:
- Real-time Train Data: `https://data.gov.hk/en-data/dataset/mtr-data2-nexttrain-data`(user guide),`https://rt.data.gov.hk/v1/transport/mtr/getSchedule.php`(API adress)
- MTR Lines (except Light Rail) & Stations(in csv format): `https://data.gov.hk/en-data/dataset/mtr-data-routes-fares-barrier-free-facilities/resource/73895cac-ac2e-4fec-8525-4f5f1be0a718![image](https://github.com/user-attachments/assets/e11a8cd5-2e65-4afc-a529-be6b7ec59c40)
`

### Development Stack
- Platform: Native Android
- Language: Java
- IDE: Android Studio
- Minimum SDK: Android 10.0


=========================================================</br>
KMB Routes</br>
<img width="128" alt="圖片 1" src="https://github.com/user-attachments/assets/708cd979-303b-4b6f-8809-39aab334a7bf" />



KMB Stops</br>
<img width="128" alt="圖片 2" src="https://github.com/user-attachments/assets/03eeecd7-e0bf-4fb8-b34f-2f6e94c0069d" />




MTR Routes</br>
<img width="128" alt="圖片 3" src="https://github.com/user-attachments/assets/0e2074cb-ace9-43c8-bc8b-3c09865c7a9a" />



MTR Stops</br>
<img width="128" alt="4" src="https://github.com/user-attachments/assets/b023acc7-bf84-47fb-90f9-553fd61e23bc" />



Favorite Page</br>
<img width="128" alt="1212" src="https://github.com/user-attachments/assets/0fa38112-1fe2-4a27-a52f-b31be9aa1aea" />




Searching</br>
<img width="128" alt="1111122" src="https://github.com/user-attachments/assets/18b5f539-b028-4d43-bfa8-3fafbd2da78c" />


Dark Mode</br>
<img width="128" alt="2222" src="https://github.com/user-attachments/assets/007d2974-e381-4277-ab80-90535f09db5d" />


English Mode</br>
<img width="128" alt="111111" src="https://github.com/user-attachments/assets/7836fb2b-193c-432d-b61d-15360cda5f38" />


