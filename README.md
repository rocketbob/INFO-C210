# INFO-C210

Project files for INFO-C211 Calendar assignment.

Test.java contains the main entry point for the progam.

bug: eventlisteners in Test.java fire twice, whenever a radio button is selected
or the drop down menu is selected. The causes the program to double it's work. Inside Test.java there are System.out.Print statements that show this.  The program works fine but in the real world this would be unacceptable overhead.

code efficiency issue:  The GregorianCalendar object is rebuilt every time the user
uses a widget.  For this little program the overhead is not noticeable but for a larger
program it would be bad.  It should only rebuild the object whenever the year is 
changed, not when other months are selected, or the month view changed.

