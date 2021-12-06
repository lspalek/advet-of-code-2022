# Advent of Code 2021

This project holds solutions for competion [Advent of Code 2021](https://adventofcode.com/).

### Project Structure
* 1st task of each day:
  * solution is stored in class: `Day<XX>.java`, where `<XX>` is day number.
  * tests are in class: `Day<XX>Test.java`, where `<XX>` is day number.
  * example input are stored in `day<XX>-example.txt`
  * final task input is stored in `day<XX>.txt`
* Solution for 2nd task of each day is stored in class: `Day<XX>b.java`.
  * all files are named similarly. (With sufix `b` after `<XX>`)

### Code generator
Code structure for next day can be created **automatically** via: [CodeGenerator.java](src/main/java/CodeGenerator.java).
You can copy any day, just by changing `originalDayNumber` and `originalDayNumber`.