# File Analysis - Real Time

This project was developed to analysing and summarise, in real time, csv files to statistical reports.

# How the project works

## Introduction

The project can identify four types of classes: 

1. **Seller**
2. **Client**
3. **Sale**
4. **Item**

The watch service is going to look for a path called ``in`` on your ``user path``. For example:
``C:/Usuários/vinicius/in`` and when some csv is pulled into this folder, then an output csv file with 
the analysis is going to be inserted on ```C:/Usuários/vinicius/out```.

The input file should have the following structures and separated by ``ç``:

## Classes

* **Seller**
    - Identifier - (001)
    - Identifier Number - String
    - Name - String
    - Salary - Double
* **Client**
    - Identifier - (002)
    - Identifier Number - String
    - Name - String
    - Business Area - String
* **Sale**
    - Identifier - (003)
    - SaleId - Long
    - Items - List<Items>
    - SalesManName - String
* **Item**
    - Id - Long
    - Quantity - Long
    - Price - Double

## File Input Example

``
001ç1234567891234çPedroç50000
001ç3245678865434çPauloç40000.99
002ç2345675434544345çJose da SilvaçRural
002ç2345675433444345çEduardoPereiraçRural
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo
``

# How to run the project

You have to start the DirectoryWatcher.java.

Then, just put any csv file, with the certain structures, into the input directory folder explained above and see the magic happens.

# Technologies

This project was developed using:
 * [Java 14](https://openjdk.java.net/projects/jdk/14/)
 * [Lombok](https://projectlombok.org/)
 * [OpenCSV](http://opencsv.sourceforge.net/)
 * [WatchService](https://docs.oracle.com/javase/7/docs/api/java/nio/file/WatchService.html)
 
 # Social Medias
 
 If you want to ask something, please contact me on my Social Media.
 * **Instagram** - [@pajebr](https://www.instagram.com/pajebr/)
 * **Linkedin** - [josephdsbr](https://www.linkedin.com/in/josephdsbr)
 * **Github** - [josephdsbr](https://github.com/josephdsbr)
 
 Made with <3 by José Vinícius.