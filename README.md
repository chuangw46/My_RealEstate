# SWEN90007_Project - Realestate
### **Website**
---
[My Realestate](https://swen90007-2019-realestate.herokuapp.com/)

### **Project Description**
---
- In this project, we are aiming to build a web-based and enterprise-scale property resource application which connects real estate agents with highly engaged and informed consumers right across the buying and renting cycle. Properties on this platform include residential and commercial properties. 
- The application serves as a way that real estate agents can publish housing estates on it for sale or rent. Meanwhile, it provides a centralized resource platform where consumers can seek for properties to buy or rent and book inspections for ones they like.
- This project is done by [Chuang Wang](https://www.linkedin.com/in/chuangw/) and [Junhan Yang](https://www.linkedin.com/in/junhan-yang-269213190/)

### **System Features**
---
1. By using the platform, registered real estate agents can publish housing estates on it for sale or rent. Use cases are described as following
    - account registration
    - **C** - publishing properties for either sale or rent
    - **R** - checking a list of properties he or she published
    - **U** - updating their personal profile & updating property information i.e price, inspection date etc.
    - **D** - removing a property from the platform if the property is not availbale anymore

2. Users registered as ‘customers’ are able to look for properties that are currently available for renting or selling. To be more specific, use cases for a customer are described as following
    - account registration
    - **C** - adding a preferable property from searching results into their ‘Favorites’ list.
    - **R** - searching properties based on filters under the search bar including price range, room size, location and real estate agencies, searching agents based on names under the agent search bar, looking into detailed information about properties or agents.
    - **U** - updating their personal profile
    - **D** - removing a property from their ‘Favorites’ property list

### **Architecture**
---
#### 1. High level Layered Architecture Diagram

1. Presentation Layer\
This layer contains the user-oriented functionality responsible for managing user interaction with the backend. It also consists of components that provide a communication channel into the core domain(business) logic encapsulated in the domain logic layer.

2. Domain Logic Layer\
This layer decouples the data source layer and the presentation layer. It implements the core functionality of the main features for agents and encapsulates the main business logic.
    * Service Layer
        * This layer defines a set of available operations for user account management and property management
        * It also coordinates the requests sent from presentation layer and the response from the data source layer. From the lecture and lecture notes, in order to make domain model classes clearer and for the sake of simplicity of the system, service layer has been designed to communicate with data source layer directly by calling unit of work or specific mapper to retrieve data, rather than delegating the tasks to domain model classes, which increases the complexity of domain model classes and makes our architecture messed.
    * Domain Model
        * Domain model layer basically contains all classes that encapsulates data only corresponding each table in the database.
        
3. Data Source Layer\
This layer provides access to data hosted in PostgreSQL database including create, read, update and delete operations. To facilitate the data access and queries sent from client, unit of work pattern and mapper pattern are used in this layer.

![](https://github.com/chuangw46/SWEN90007_Project/blob/master/diagrams/SDA%20architechture%20diagram.png)

#### 2. Component Diagram 
In this modified component diagram, components in the web server are classified according to which layers they are at. In particular, the client side communicates with the server side through the FrontServlet component in terms of GET/POST requests, and the data mappers such as Property Mapper performs CRUD actions to manage the data stored in PostgreSQL.
![](https://github.com/chuangw46/SWEN90007_Project/blob/master/diagrams/SDA%20Component%20Diagram.png)

#### 3. Database Design
This diagram shows how we built the database tables in PostgreSQL. Each property has one address only. The reason why `address` has a separate table instead of storing all the address in property table is to avoid storing too many fields in property table. Although client and agent are the intended end users of the system, we design a separate table for each of them because they perform different actions while using our system. For instance, an agent is the main person who manages a list of properties including publishing a new property, updating or deleting an existing property he or she published before. Therefore, `agent` and `property` have one-to-many relationship. On the other hand, a client (property seeker) will mainly search properties based on some filters and save a particular property into his or her favourite property list. In that sense, `property` and `client` have many-to-many relationship. As such, an association table called `client_likes_properties` is created to solve many-to-many relationship.
![](https://github.com/chuangw46/SWEN90007_Project/blob/master/diagrams/database%20architecture%20.png)

### **Project Documentation**
---
> For more detailed information about the project, please check out the project documentation file [here](https://github.com/chuangw46/SWEN90007_Project/blob/master/SWEN90007_Project%20Documentation.pdf)


### **Contributors**
---

| **Name** | Contributions | **Email** | **Profile** |
|:-----------------:|:-------------:|:---------------:|:---------------:|
|  Chuang Wang |Database + Backend (datasource layer, domain layer)| chuangw@student.unimelb.edu.au| [LinkedIn](https://www.linkedin.com/in/chuangw/)|
| Junhan Yang | Frontend development + Domain layer | junhany@student.unimelb.edu.au | [LinkedIn](https://www.linkedin.com/in/junhan-yang-269213190/) |


### **License**
---
[![MIT license](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/chuangw46/SWEN90007_Project/blob/master/LICENSE)




