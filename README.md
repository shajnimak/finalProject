# FinalProject
# Online Pharmacy Management System

## Group: SE-2217

### Team Members:
- Shadyman Mutigolla
- Nurbol Zhaksylyk

## Project Overview:

The **Online Pharmacy Management System** is a web-based application designed to streamline and digitize the management and operations of a pharmacy. The system caters to two main user types: Administrators and Regular Users. It provides a virtual marketplace for browsing medications, placing orders, and staying informed about new arrivals. The primary goal is to enhance the overall efficiency and accessibility of pharmacy services.

### Project Idea:

The idea behind the Online Pharmacy Management System is to create a convenient and user-friendly platform for both administrators and regular users to manage pharmaceutical activities digitally. The system aims to provide a virtual marketplace where users can explore a diverse range of medications, place orders, and stay informed about new pharmaceutical products, ultimately improving the efficiency and user experience of pharmacy services.

### Purpose:

The primary purpose of this project is to transition traditional pharmacy services into the digital realm, offering a centralized and easily accessible platform. The system automates various aspects of pharmacy management, including order processing, inventory management, and user communication. The ultimate goal is to provide a more convenient and modernized experience for users.

## Objectives:

1. **User-Friendly Interface:**
   - Develop an intuitive and easy-to-navigate interface for administrators and regular users.

2. **Order Management:**
   - Implement a robust order management system for seamless browsing, cart management, and order placement.

3. **Inventory Control:**
   - Create an inventory management system for tracking stock levels, managing expiration dates, and updating the product database.

4. **User Notifications:**
   - Implement a notification system for order status, shipment details, and new arrivals.

5. **User Authentication and Authorization:**
   - Ensure secure user authentication and authorization mechanisms for data protection and system integrity.

6. **Administrative Dashboard:**
   - Develop a comprehensive dashboard for administrators to monitor and manage orders, track inventory, and gain insights into user activities.

7. **Scalability:**
   - Design the system with scalability in mind to accommodate user growth and catalog expansion.

8. **Security:**
   - Implement robust security measures for data protection, secure transactions, and prevention of unauthorized access.

9. **Performance Optimization:**
   - Optimize system performance to ensure quick response times, even during peak usage.

## Main Body:
![image](https://github.com/shajnimak/finalProject/assets/79740295/62ba03f5-5b9b-4d1b-ad19-5cc8550660a8)

### Key Points about the Project and Design Patterns:

1. **Singleton Pattern:**
   - Implemented for critical components like database connectivity and logging monitoring to ensure a single instance across the entire application.

2. **Strategy Pattern:**
   - Used for user authorization, allowing users to select different options based on preferences or requirements.

3. **Factory Pattern:**
   - Implemented for instantiating drug objects, providing a centralized and consistent way to produce different types of drugs.

4. **Decorator Pattern:**
   - Used to dynamically change the price without altering the structure itself.

5. **Adapter Pattern:**
   - Included an adapter template for encrypting and decrypting data in the database.

6. **Observer Model:**
   - Implemented the Observer pattern for users to subscribe to updates about new solutions, process requests, and other relevant events.

## Conclusion:

### Future Improvements:

1. **Advanced Search and Filtering of Drugs:**
   - Implement advanced search and filtering capabilities for more effective medication administration.

2. **Personalized User Profiles:**
   - Implement personalized user profiles, allowing users to maintain order history, preferences, and receive recommendations.

3. **Advanced Reporting and Analytics:**
   - Develop comprehensive communication and analytics capabilities for administrators to gain deeper insights into user behavior, popular practices, and overall system performance.

4. **Integration of Telemedicine Services:**
   - Explore integration of telehealth services to provide users with online consultations from healthcare professionals.

5. **Internationalization and Localization:**
   - Implement features for internationalization and localization to make the platform accessible to users in different regions, supporting multiple languages and currencies.

### References:

- Refactoring.Guru / Рефакторинг.Гуру. (n.d.). [Рефакторинг и Паттерны проектирования](https://refactoring.guru/ru)
- Download | PGJDBC. (n.d.). [PGJDBC](https://jdbc.postgresql.org/download/)
