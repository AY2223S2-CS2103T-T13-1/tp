---
layout: page
title: User Guide
---

<br>
<img src="images/logo.png" width="200px"><br>

**MODTrek** is a desktop application for managing a typical NUS Computer Science student’s modules and degree progression, optimised for use via a Command Line Interface (CLI). The app provides a convenient platform for students to easily access and update their modules within presses of a keyboard.<br><br>
This application is currently geared towards NUS Computer Science Students of the AY2021-2022 cohort only. We hope to expand our application's scope in the coming years.

--------------------------------------------------------------------------------------------------------------------

## Table of Contents <a name="toc"></a>

1. [How To Use This Guide](#how-to)
2. [Quick Start](#quick-start)
3. [GUI Overview](#gui-overview)
4. [Features](#features)<br>
   4.1 [Add a module:](#add-module) `add`<br>
   4.2 [Remove a/all module:](#delete-module) `delete`<br>
   4.3 [Change module details:](#edit-module) `edit`<br>
   4.4 [Tag a module:](#tag-module) `tag`<br>
   4.5 [Find modules by keyword:](#find-module) `find`<br>
   4.6 [Sort all modules:](#sort-module) `sort`<br>
   4.7 [Toggle between module lists and progress:](#change-view) `view`<br>
   4.8 [Exiting the program:](#exit-app) `exit`<br>
   4.9 [Saving the data](#save-data)<br>
   4.10 [Editing the data file](#edit-data)
5. [Frequently Asked Questions (FAQ)](#faq)
6. [Command Summary](#command-summary)

--------------------------------------------------------------------------------------------------------------------

<div style="page-break-after: always;"></div>

## 1. How to Use This Guide <a name="how-to"></a>

Not sure how you can begin using **MODTrek**? This user guide will give you all the information you will need so
that you can utilise **MODTrek** to its full potential.

To get started, we have prepared a [Quick Start](#quick-start) section in this user guide to ensure that you will
have a seamless setting up process.

You can also familiarize yourself with the GUI in our [GUI Overview](#gui-overview) section where you will get a quick breakdown of our GUI.

Not sure what features **MODTrek** has or how to use them? Our [Features](#features) section provides an in depth
explanation of **MODTrek** can do and how you can use them effectively. Alternatively, you can go to our [Command Summary](#command-summary)
section for a quick overview of all the commands.

Commonly asked questions and answers can be found in our [FAQ](#faq) but if you are still unable to find what you are
looking for, feel free to contact us at our [GitHub](https://github.com/AY2223S2-CS2103T-T13-1/tp).

Before going any further, here are some useful notations that you should know.

**Tips**

Tips are useful suggestions that will help you become a seasoned **MODTrek** user more quickly.

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** Tips are useful information. They can give you a better experience with **MODTrek**.
</div>

**Notes**

Notes are important information that you should pay attention to when using **MODTrek**.

<div markdown="span" class="alert alert-info">

:information_source: **Note:** Take notes when you see this icon.
</div>

**Caution**

Cautions are in place to warn you of potential pitfalls new users may encounter.

<div markdown="span" class="alert alert-warning">

:exclamation: **Caution:** Stop and read carefully when you see this!
</div>

[Back to Table of Contents](#toc)

--------------------------------------------------------------------------------------------------------------------

<div style="page-break-after: always;"></div>

## 2. Quick Start <a name="quick-start"></a>

1. Ensure you have Java 11 or above installed in your Computer.
2. Download `modtrek.jar` [here](https://github.com/AY2223S2-CS2103T-T13-1/tp/releases).
3. Copy the file to the folder you want to use as the _home folder_ for **MODTrek**.
4. Lauch the app by double-clicking the file or by navigating to the file using your command terminal, and running `java -jar modtrek.jar` in your terminal.
5. A GUI similar to the one below should appear in a few seconds.
![Ui QuickStart](images/Ui-quickstart2.png)
<p align="center"><em>GUI of MODTrek</em><br></p>

6. Type commands within the CLI and press enter to execute it. For a list of executable commands, refer to the [Features](#features) section.

[Back to Table of Contents](#toc)

--------------------------------------------------------------------------------------------------------------------

<div style="page-break-after: always;"></div>

## 3. GUI Overview <a name="gui-overview"></a>

The following is an annotated breakdown of **MODTrek's** GUI:
![UI Breakdown](images/Ui-breakdown.png)
<p align="center"><em>Breakdown of GUI</em><br></p>

1. **Command Input:** User inputs commands here.
2. **Command Screen:** Relevant messages from the application will be displayed here. This includes success messages, error
messages and resul
3. **Results Section:** This panel shows the degree progression of the user by default. This panel can be changed using the `view` command to toggle between the module list in **MODTrek** or the user's degree progression. Using the `find` command when making a query on the module list will navigate you to the module search screen.

The following is the annotated breakdown of the Results Section of **MODTrek's** GUI:
![UI subsection](images/Ui-subsections-detailed.png)
<p align="center"><em>Breakdown of Results Section</em><br></p>

1. **Doughnut Chart:** This will be shown on the degree progress section. It shows the completion progress of the degree
and individual sub requirements of the degree. Your total MCS completed and CAP are also displayed.
2. **Module List:** This will be shown in both the module list section and module search section. It shows all the module in the list.
3. **Module Group:** This will be shown in both the module list section and module search section. It shows the modules in
each sub category when sorted.
4. **Module Card:** This will be shown in both the module list section and module search section. Each module card shows the detail of each module.

[Back to Table of Contents](#toc)

--------------------------------------------------------------------------------------------------------------------

<div style="page-break-after: always;"></div>

## 4. Features <a name="features"></a>

<div markdown="block" class="alert alert-info">

:information_source: **Notes about command format:**<br>

* Words enclosed by `<>` are the parameters to be supplied by the user.<br>
E.g. in `add /m <code>`, `<code>` is a parameter which can be replaced by `CS2030S` to give the command `add /m CS2030S`.

* Parameters encapsulated in between round brackets are optional.<br>
E.g. in `delete /m <code1> (/m <code2>)` can be used as `delete /m CS1101S /m CS1231` or as `delete /m CS1101S`.

* Parameters with `...` after them can be used 1 or more times.<br>
E.g. in `(/t <tag>...)` can be used as `/t ULR /t CSF`, `/t ULR`.

* Extraneous parameters for commands that do not take in parameters (such as `exit` and `delete all`) will be ignored.
E.g. if the command specifies `exit 123`, it will be interpreted as `exit.`
</div>

### MODTrek supports the following features:

#### 4.1 Add a Module : `add` <a name="add-module"></a>

Adds a module to the module list in **MODTrek**. This will kick start your **MODTrek** journey.

**Syntax:** `add /m <code> /c <credits> /y <year-semester> (/g <grade>) (/t <tag>...)`

Additional details:
* `<code>` refers to the module code. Format of module code should be <2-4 alphabets><4 numbers>(<1 alphabet>). Refer to [NUSMODS](https://nusmods.com/modules?sem[0]=1&sem[1]=2&sem[2]=3&sem[3]=4) for a list of valid module codes.
* `<credits>` refers to the module's modular credits
* `<year-semester>` refers to the year and semester the module is taken. We only support years from 0 to 5 and semesters s1, s2, st1 and st2.
* `<grade>` refers to the grade obtained for the module. Range from A+ to U excluding W grade.
* `<tag>` refers to the requirement the modules fulfils. This includes:
   * `ULR` University Level Requirements
   * `CSF` Computer Science Foundations
   * `CSBD` Computer Science Breadth & Depth
   * `UE` Unrestricted Electives
   * `ITP` IT Professionalism
   * `MS` Math & Science

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** A module can have more than 1 tags (including 0).
</div>

<div markdown="span" class="alert alert-info">

:information_source: **Note:** You cannot add 2 modules with the same module code into **MODTrek**. Modules must have distinct module codes.
If there are reasons you need to add a module with the same module code (e.g. retaken module, MOOCs) refer to this [faq](#faq3) for suggested fixes.
</div>

**Example:**
* `add /m CS2103T /c 4 /y y2s2 /g A /t ULR`
* `add /m GESS1025 /c 4 /y y1s2`

[Back to Table of Contents](#toc)

#### 4.2 Delete a Module : `delete` <a name="delete-module"></a>

Deletes the specified module(s) from the module list. You can also choose to delete all the modules from the module list.

**Syntax:**
* _To delete specific modules:_ `delete /m <code1> (/m <code2>...)`
* _To delete all modules:_ `delete all`

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** You can use the same instance of the delete command to delete more than 1 module at a time but at least
1 module to be deleted must be specified.
</div>

**Example:**
* `delete /m CS2100 /m CS2040S`
* `delete /m MA1521`
* `delete all`

[Back to Table of Contents](#toc)

#### 4.3 Edit a Module : `edit` <a name="edit-module"></a>

Edits an existing module in the module list. Use this command to rectify any mistakes or add in any details you have omitted.

**Syntax:** `edit <existing code> <toEdit>...`

Specify one or more parameters in `<toEdit>` that you want to edit. This can be:
* `/m <new code>`
* `/c <credit>`
* `/y <year-semester>`
* `/g <grade>`
* `/t <tag>`

<div markdown="span" class="alert alert-warning">

:exclamation: **Caution:** Past data will be overridden and not be saved
</div>

**Example:**
* `edit ES2660 /m CS2101 /g B+ /t MS`
* `edit CS2107 /y y3s1`

[Back to Table of Contents](#toc)

#### 4.4 Tag a Module : `tag` <a name="tag-module"></a>

Tags a module to include or remove one or more degree requirements (e.g. University Level Requirements, Computer Science Foundation etc) that the module fulfils.<br>
Refer to [Add a module](#add-module) for the tags that you can use.

**Syntax:**
* _To include tags:_ `tag <code> include /t <tag1> (/t <tag2>...)`
* _To remove tags:_ `tag <code> remove /t <tag1> (/t <tag2>...)`

**Example:**
* `tag CS2030S include /t CSF`
* `tag ES2660 remove /t ULR /t ITP`

[Back to Table of Contents](#toc)

#### 4.5 Find modules by keyword(s) : `find` <a name="find-module"></a>

Displays specific module(s) and their details previously logged by the user which satisfies the keyword(s) queried.
Use this command to find modules that match the keywords are interested in without needing to manually scroll through the list of modules.

**Syntax:** `find <keyword>...` or `find <module-code>`

Specify one or more parameters in `<keywords>` that you want to find your modules by. This parameter can be from the following category:
* `/m <code prefix>`
* `/c <credit>`
* `/y <year-semester>`
* `/g <grade>`
* `/t <tag>`

Alternatively, you may find a specific module by its module code.

<div markdown="span" class="alert alert-info">

:information_source: **Note:** Code prefix refers to the first alphabetic part of a module code.
E.g. CS is the code prefix of Computer Science modules like CS1101S and CS2106.
</div>

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** Using more keywords from different categories will filter the results you want to find further.
Using more keywords from the same category will return you all the modules that satisfy at least one of those keywords in that parameter.
</div>

**Example:**
* `find /c 4 /g A+`
* `find /y y2s2`
* `find cs1101s`
* `find /m cs /m ma /m ge` ![Ui Find](images/Ui-find3.png)
<p align="center"><em>Result of find command</em><br></p>

[Back to Table of Contents](#toc)

#### 4.6 Sort all modules : `sort` <a name="sort-module"></a>

Sort the modules according to the category indicated by the user. Use this command if you want to know what modules are
in each level of the category you are interested in.

**Syntax:** `sort <category>`

Categories that modules can be sorted by are:
* `/m` to sort by module code
* `/c` to sort by credit
* `/y` to sort by year-semester
* `/g` to sort by grade
* `/t` to sort by tag

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** You can also use the drop-down menu on the top-right hand corner of the results panel to choose what
category to sort by when **MODTrek** is in the module list screen.
</div>

**Example:** `sort /g`
![Ui Sort](images/Ui-sort.png)
<p align="center"><em>Result of sort command</em><br></p>

[Back to Table of Contents](#toc)

#### 4.7 Toggle screens : `view` <a name="change-view"></a>

Toggles between the display of degree progress or module list.

**Syntax:**
* _To view degree progression:_ `view progress` ![Ui progress](images/Ui-viewprogress.png)
<p align="center"><em>Degree progression screen</em><br></p>

* _To view module list:_ `view modules` ![Ui modules](images/Ui-viewmodules.png)
<p align="center"><em>Module list screen</em><br></p>

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** You can also click the different screen names at the bottom of the results panel to navigate between the different screens.

:bulb: **Interpreting data:** You might find that the total MC you have included may not match with the MC total as shown. The MC total shown indicates the "meaningful" credits, which are those that are counted towards your degree progression, based on the degree requirements. Any credits beyond the limit by the requirement is not "meaningful", and therefore not counted into the total.

For more detailed information on the calculations, please refer to this [section](DeveloperGuide.md#generation-of-degree-progression-data) in our developer guide.
</div>

[Back to Table of Contents](#toc)

#### 4.8 Exit MODTrek : `exit` <a name="exit-app"></a>

Exits the program. Alternatively you can exit the program by clicking the top-right X button to close the window.

**Syntax:** `exit`

[Back to Table of Contents](#toc)

#### 4.9 Saving MODTrek data <a name="save-data"></a>

Saves the modified data regarding the modules into the hard disk automatically after any command that changes the data. There is no need to save manually.

[Back to Table of Contents](#toc)

#### 4.10 Editing MODTrek data <a name="edit-data"></a>

ModTrek data is saved as a JSON file [JAR file location]/data/modtrek.json. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">

:exclamation: **Note:** This can only be done when the application is not running. Otherwise, changes to JSON file will be overridden by the application!
</div>

<div markdown="span" class="alert alert-warning">

:exclamation: **Caution:** If your changes to the data file makes its format invalid, **MODTrek** will discard all data and start with an empty data file at the next run.
</div>

[Back to Table of Contents](#toc)

--------------------------------------------------------------------------------------------------------------------

<div style="page-break-after: always;"></div>

## 5. Frequently Asked Questions (FAQ) <a name="faq"></a>

**Q**: Why is it that I can add in modules not offered in NUS?<br>
**A**: Unfortunately we do not have a database to store all the available modules in NUS.
We can only check if the module code is formatted correctly, and we trust users to key in modules that
are provided only by NUS.

**Q**: Why are the old terms (modules, CAP, MCs) used when referring to modules information?<br>
**A**: We used these terms to specifically cater to our target audience, who are CS students matriculated in AY 21/22.

**Q**: Why is it that I cannot add a module I intend to retake in upcoming semester?<br> <a name="faq3"></a>
**A**: Unfortunately as per our add command, we do no allow 2 modules with the same module code to be present in our app
as of now. We understand that the NUS curriculum is **very** flexible so application tries to accomodate as any different curriculums as possible.
Any deviations from these constraints for any reason (eg. Exchange modules, Retaken modules or MOOCs) should be mapped to modules within the application's constraints.
For example, one may use dummy module codes like TEST1001 to include these modules in their degree progression and CAP calculation.

**Q**: Why is "W" grade not allowed?<br>
**A**: We do not think adding "W" grade will be of any value. It is equivalent to deleting the module from the
record since credits will no longer count towards degree progression.

[Back to Table of Contents](#toc)

--------------------------------------------------------------------------------------------------------------------

<div style="page-break-after: always;"></div>

## 6. Command Summary <a name="command-summary"></a>

| Action   | Format, Examples                                                                                                                                                      |
|----------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**  | `add /m <code> /c <credits> /y <year-semester> (/g <grade>) (/t <tag>...)`<br> e.g., `add /m CS2103T /c 4 /y y2s2 /g A /t ULR`                                        |
| **Delete** | `delete /m <code1> (/m <code2>...)` or `delete all`<br> e.g. `delete /m CS2100 /m CS2040S`                                                                            |
| **Edit** | `edit <existing code> (/m <new code>) (/c <credits>) (/y <year-semester>) (/g <grade>) (/t <tag>...)` <br> e.g., `edit ES2660 /m CS2101`                              |
| **Tag**  | `tag /m <code> include /t <tag1> (/t <tag2>...)` or `tag /m <code> remove /t <tag1> (/t <tag2>...)` <br> e.g., `tag CS2030S include CSF`, `tag ES2660 remove ULR ITP` |
| **Find** | `find (/m <code>) (/c <credits>) (/y <year-semester>) (/g <grade>)` <br> e.g., `find /g A+`                                                                           |
| **Sort** | `sort <category>`<br> e.g. `sort /m`                                                                                                                                  |
| **View** | `view progress` or `view modules`                                                                                                                                     |
| **Exit** | `exit`                                                                                                                                                                |

<div markdown="span" class="alert alert-info">

:information_source: **Note:** Parameters encapsulated in between brackets `()` are optional.

For `edit`, at least one optional parameter has to be specified.
</div>

[Back to Table of Contents](#toc)
