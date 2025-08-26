# British-Spoken-Time-App
This program in Java outputs the British spoken form of a time given as input.

# Project assumptions:
### Input
* Requested time is passed as a path parameter in "HH:mm" format.
### Output
* The 'number of minutes' is stated first, followed by the 'number of hours', unless the hour is sharp (i.e. five o'clock -in which case the minutes are omitted), or minutes are in the range of 31-34 (i.e. ten thirty three- hour is returned first, followed by the value of minutes).
* If the number of minutes is less than 30, the app returns the number of minutes 'past' the hour (e.g., twenty past seven).
* If the number of minutes is more than 34 (closer to the next hour), the app returns the number of minutes remaining 'to' the next hour (i.e. ten to nine).
* The word 'quarter' is used for 15 minutes, 'half' for 30 minutes.

# How to run it:
### Prerequisites
- **Java 21**
- **Maven 3.8+**
- **Docker**: For containerization and to run the application.

### Build and Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/kanowacki/British-Spoken-Time-App.git
   ```
   ```bash
   cd SpokenTimeApp
   ```
2. **Build with docker-compose.yaml**:
   ```bash
   mvn clean package
   ```
   ```bash
   docker-compose build
   ```
   ```bash
   docker-compose up -d
   ```
   To stop and remove the container run: 
   ```bash
   docker-compose down
   ```
 3.   **Alternatively build the project and run the application using below commands**:
   ```bash
   mvn clean install
```
   ```bash
   mvn spring-boot:run
   ```
### Access endpoints

   Default port: http://localhost:8080

1. **Example**:

   GET http://localhost:8080/spoken-time/04:16

   **Response**:
   ```
   {
      "spokenForm": "sixteen past four"
   }
   ```
2. **Error Example**:

   GET http://localhost:8080/spoken-time/99:99

   **Response**:
   ```
   {
      "statusCode": 400,
      "requestedHour": "99:99",
      "error": "IllegalArgumentException",
      "errorMessage": "Invalid time format. Please use HH:mm (e.g., 14:30, 06:02)"
   }
   ```