# ACME
## Exercise🚀

The company ACME offers their employees the flexibility to work the hours they want. They will pay for the hours worked based on the day of the week and time of day, according to the following table:

Monday - Friday

* [00:01 - 09:00] 25 USD

* [09:01 - 18:00] 15 USD

* [18:01 - 00:00] 20 USD

Saturday and Sunday

* [00:01 - 09:00] 30 USD

* [09:01 - 18:00] 20 USD

* [18:01 - 00:00] 25 USD

The goal of this exercise is to calculate the total that the company has to pay an employee, based on the hours they worked and the times during which they worked. The following abbreviations will be used for entering data:

* MO: Monday

* TU: Tuesday

* WE: Wednesday

* TH: Thursday

* FR: Friday

* SA: Saturday

* SU: Sunday

Input: the name of an employee and the schedule they worked, indicating the time and hours. This should be a .txt file with at least five sets of data. You can include the data from our two examples below.

Output: indicate how much the employee has to be paid

The solution includes classes of constants, which will have the information of schedules and the values ​​of the days, such as:

* [00:01 - 09:00] : is the first schedule, the schedules were put in the ScheduleConstant class

* [MO] : it is Monday, the days were put in the DayConstant class.

Constant classes will extend from an abstract class AbstractConstant, which defines the value attribute and implements the TypedConstant interface which has the method to get the value.

I created utility classes (each with a singleton) each with specific functions depending on what it handles.

The most representative methods are:

* The one to validate the time format, which is a recursive method in order to show whether or not the time format is valid.

* The method of obtaining a map of hours according to the schedule, it is necessary to say that in case 30 minutes of the hour are passed, it will be taken as an additional hour, decided to put a rounding half up.

* And the method of obtaining the total by adding the values ​​according to the hours, the calculations are made using BigDecimal.

You should clone the project and with a Java IDE, import as Java Project and also running as a Java project.