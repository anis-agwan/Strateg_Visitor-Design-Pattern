# cs542-fall-22-assign4

## Team
## Name: Abhishek Soni
## Email: asoni1@binghamton.edu

## Name: Mohmed Anis Agwan
## Email: magwan1@binghamton.edu

-----------------------------------------------------------------------
### Instruction for running the project
-----------------------------------------------------------------------
Go to cs542-fall-22-assign4-team-asoni1-magwan directory and then run following command in order:

-----------------------------------------------------------------------
## Instruction to clean:

Command: ant -buildfile sentenceAnalysis/src/build.xml clean

-----------------------------------------------------------------------
## Instruction to compile:

Command: ant -buildfile sentenceAnalysis/src/build.xml all

-----------------------------------------------------------------------
## Instruction to create a .tar.gz file:

Command: ant -buildfile sentenceAnalysis/src/build.xml tar

-----------------------------------------------------------------------
## Instruction to run:

Command: ant -buildfile sentenceAnalysis/src/build.xml run -Darg0=inputFile.txt -Darg1=english_american_spellings.txt -Darg2=10 -Darg3=KMostFrequentWords.txt -Darg4=spellCheckOutput.txt -Darg5=2

-----------------------------------------------------------------------
## Description about the functionalities:
-----------------------------------------------------------------------

- We have created 2 visitor to perform different functionalitites on different types of data

1. KMostFrequentWords Visitor - to find out K words that have occur most of the time.
    - We have used HashMaps, priority queue and omparators to implement this logic

2. SpellCheckAmerican Visitor - to find out the word that are mentioned in a special English->American.txt file and convert them accordingly.
    - This visitor has 2 startegies to implement on a similar kind of data
        1. Case sensitive - in which we check the words as it is.
        2. Case In-sensitive - in which we check words in different permutation and combinaton of upper case and lower case using regex.


-----------------------------------------------------------------------
## Citation:
-----------------------------------------------------------------------
- https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: -- 12/08/2022
