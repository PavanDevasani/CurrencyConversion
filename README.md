 Currency Conversion Spring Boot Application  

This is a Spring Boot application that provides real-time currency conversion services. It allows users to convert amounts between different currencies using exchange rates from an API or predefined values.  

** Features ** 
- Convert currency between multiple currencies  
- REST API support for seamless integration  
- Uses external APIs or static exchange rates  
- Spring Boot, Spring REST, and JPA for backend processing  
- Exception handling and logging with SLF4J  

##  Technologies Used  
- **Java 11
- **Spring Boot**  
- **Spring REST**  



3. Run the Application 
mvn spring-boot:run
4️ API Endpoints
🔹 Convert Currency
GET /convert?from=USD&to=INR&amount=100
📌 Response:

json
{
  "from": "USD",
  "to": "INR",
  "amount": 100,
  "convertedAmount": 8300
}
🔹 Get All Supported Currencies
http
GET /currencies
