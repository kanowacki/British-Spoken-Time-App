# British-Spoken-Time-App
This program in Java outputs the British spoken form of a time given as input.

# Project assumptions:
* The 'number of minutes' is stated first, followed by the 'number of hours' (i.e. ten past seven), unless the hour is sharp (on the dot - i.e. five o'clock), in which case the minutes are omitted.
* If the number of minutes is more than 30 (closer to the next hour), the app returns the number of minutes remaining 'to' the next hour (i.e. ten to nine).
* The word 'quarter' is used for 15 minutes, and 'half' for 30 minutes.

# How to run it:
### Prerequisites
- **Java 21**
- **Maven 3.8+**
- Internet connection (to download dependencies)

### Build and Run

1. **Clone the repository**:
   ```
   git clone <repo-url>
   cd SpokenTimeApp

2. **Build the project**:
   ```
   mvn clean install
   ```
3. **Run the application**:
   ```
   mvn spring-boot:run
   ```
### Access endpoints

   Default port: http://localhost:8080

1. **Example**:

   GET /spoken-time/04:16

   **Response**:
   ```
   {
      "spokenForm": "sixteen past four"
   }
   ```
2. **Error Example**:

   GET /spoken-time/99:99

   **Response**:
   ```
   {
      "statusCode": 400,
      "requestedHour": "99:99",
      "error": "IllegalArgumentException",
      "errorMessage": "Invalid time format. Please use HH:mm (e.g., 14:30, 06:02)"
   }
   ```