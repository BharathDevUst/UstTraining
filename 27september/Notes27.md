# Spring boot actuator

to measure the health metrics we use the spring boot actuator.

## Circuit breaker design pattern

Three States
- Open
- Closed
- Half-Open

we can state how many times the requests are to be made when it is failing to get a response
dependcies to be added
```XML
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
</dependency>
```

circuit breaking is of 2 types
1. Count based sliding window
   - No. of times the requests should be made.
2. Time based sliding window
   - Total time it has to wait for the responses when the requests are made.

refer to [Resilience4j](https://resilience4j.readme.io/docs/getting-started)


> Completed Spring Microservices

---

## Apache Kafka

- Refer to the website: [kafka docs](https://kafka.apache.org/documentation)

### Points
- Promises
    - it is similar to swiggy and zomato where there exists a mediator to process the request that has been made.
- Observables
    - now if there are 100 items being ordered then sending 10,10 items one at a time.
- Then there is kafka
    - it ensures that there is a response from the server where above don't.
- synchronous vs asynchronous vs message based (subject to change or you can call it `Event Streaming`)
 

### Event Streaming

Event streaming thus ensures a continuous flow and interpretation of data so that the right information is at the right place, at the right time.

**Uses:**

1. To process payments and financial transactions in real-time, such as in stock exchanges, banks, and insurances.
To track and monitor cars, trucks, fleets, and shipments in real-time, such as in logistics and the automotive industry.
2. To continuously capture and analyze sensor data from IoT devices or other equipment, such as in factories and wind parks.
3. To collect and immediately react to customer interactions and orders, such as in retail, the hotel and travel industry, and mobile applications.
4. To monitor patients in hospital care and predict changes in condition to ensure timely treatment in emergencies.
5. To connect, store, and make available data produced by different divisions of a company.
6. To serve as the foundation for data platforms, event-driven architectures, and microservices.

**Terminology**

1. Apache Kafka Exosystem
2. Kafka Cluster
3. Zookeeper
4. Consumer
5. Producer
6. Kafka Broker
7. Apache Kafka Architecture
8. Topics
9. Partition


**How does kafka work?**

events are organized and durable stored in topics. we can configure for how long kafka should retian your events through a per-topic configuration setting.

> **Partition** - Topics are partitioned.

**Steps to develop with kafka**

step-1: get kafka

step-2: start the kafka environment
- use commands on `CMD` (only applicable for `CMD`)

  ```bash
  PS C:\kafka> call bin/windows/zookeeper-server-start.bat config/zookeeper.properties
  ```
  next we need to run
  ```bash
  PS C:\kafka> call bin/windows/kafka-server-start.bat config/server.properties
  ```
  next we need to run
  ```bash
  PS C:\kafka> call bin/windows/kafka-topics.bat --create --topic <your-topic-name> --bootstrap-server localhost:9092
  ```
  next we need to run
  ```bash
  PS C:\kafka> call bin/windows/kafka-console-producer.bat --topic <your-topic-name> --bootstrap-server localhost:9092
  ```
  next we need to run
  ```bash
  PS C:\kafka> call bin/windows/kafka-console-consumer.bat --topic <your-topic-name> --from-beginning --bootstrap-server localhost:9092
  ```

> **Note:** to start the kafka broker services, we use zookeeper.

step-3: create a topic to store your events

step-4: Write some events into the topic

step-5: Read the events

step-6: terminate the server

**Kafka Application**

Step 1 : Create two applications

Step 2 : Code the swiggy-driver app(Producer app)

Step 3: Test the created topic from Kafka CLI

Step 4: Code the swiggy-user app(Consumer app)


# Task

1. 2 memeber team to create a project

2. create, develop and deploy an complete full stack application using java spring boot.

3. create atleast 10 user stories which include logging in the website, registering in the website, basic CRUD operations. we need atleast 5 user stories other than the afore mentioned.