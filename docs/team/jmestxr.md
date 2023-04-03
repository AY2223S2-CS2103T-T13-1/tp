---
layout: page
title: James's Project Portfolio Page
---

### Project: MODTrek

ModTrek is a desktop application for managing a typical NUS Computer Science student’s modules and degree progression, optimised for use via a Command Line Interface (CLI). The app is provides a convenient platform for students to easily access and update their modules within presses of a keyboard.

Given below are my contributions to the project.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2223s2.github.io/tp-dashboard/?search=jmestxr&breakdown=true)

* **Enhancements implemented**:
  * **New feature**: GUI Implementation
    * What it does: MODTrek GUI provides a user-centric interface for users to add and track their modules using keyboard commands. The GUI consists of the CLI Section (right panel of app) that accepts user input and displays the visual output of the execution of commands in the Results Section (left panel of app).
    * Highlights: Implemented the GUI by creating controllers (Java classes) for MODTrek UI components (e.g. CliSection, ResultsSection, ModuleCard etc) for MODTrek and methods for dynamic rendering of data. Constructed MODTrek UI components from primary components provided by JavaFX library using FXML and styled them with CSS. Footer buttons implemented in the Results Section to toggle between the different subsections (Degree Progress, Module List, Module Search) and show the current active subsection.

  * **New feature:** Degree Progress Section
    * What it does: Displays a summary of the degree progression which includes the total MCs completed, current CAP and a detailed breakdown of the completion status of each requirement.
    * Justification: This feature fulfils the app's main function of tracking a typical Computer Science student's degree progress. It calculates and displays important details of the degree progress and graduation requirements.
    * Highlights: Created the donut chart which provides a meaningful and impressionable view of the user's degree progress, capturing essential data concerning the degree progress in an easily understandable and digestible manner.
    * Credits: Skeleton implementation of donut chart taken from [this stackoverflow post](https://stackoverflow.com/questions/24121580/can-piechart-from-javafx-be-displayed-as-a-doughnut), authored by _@jewelsea_.

  * **New feature:** Module List Section
    * What it does: Displays all the modules added by the user and tracked by the app thus far.
    * Justification: A must-have in a module tracker. The app generates statistics concerning the user's current degree progress based on the modules added in the module list.
    * Highlights: Modules are displayed in groups based on the current active sorting criteria (year, code, credits, grade or tag). Each module is displayed as a card showing all the attributes of the module (code, year-semester, credits, grade, tags). Dynamic display of completed/incomplete modules. Implemented dropdown menu to toggle between the different sorting criteria and show the current active sorting criteria.

  * **New feature:** Module Search Section 
    * What it does: Displays modules satisfying a certain set of filters provided by the user in the `find` command.
    * Justification: This feature enables users to locate specific modules without having to go through the entire module list.
    * Highlights: Displays a set of filters that is currently applied to the list of modules for ease of reference, following by the set of filtered modules displayed as cards.
    
  * **Additional work (out of scope of CS2103T):** GUI Mockups, Logo Design
    * Highlights: Enhances the UI/UX experience, aesthetics and credibility of the app. Mockups provide a blueprint for FXML/CSS implementation of the GUI.
    
* **Documentation**:
  * User Guide:
    * Collated series of bugs to fix (Examples: [1](https://github.com/AY2223S2-CS2103T-T13-1/tp/issues/90), [2](https://github.com/AY2223S2-CS2103T-T13-1/tp/issues/89))
  * Developer Guide:
    * to be added soon

* **Contributions to team-based tasks**:
  * Managed [JAR file releases](https://github.com/AY2223S2-CS2103T-T13-1/tp/releases) for v1.2 and v1.3
  * Created [video demo](https://drive.google.com/file/d/1lBHdc5UN_4B30-9FWedEo36OZ-psfIBS/view?usp=share_link) for v1.2
  * Created demo screenshots for v1.3
  * Created [GUI screenshots]() for UG

* **Review/mentoring contributions**:
  * Reviewed PRs (Examples: [1](https://github.com/AY2223S2-CS2103T-T13-1/tp/pull/107), [2](https://github.com/AY2223S2-CS2103T-T13-1/tp/pull/62))
  * Suggestions on implementation and improvement of features (Examples: [1](https://github.com/AY2223S2-CS2103T-T13-1/tp/issues/65), [2](https://github.com/AY2223S2-CS2103T-T13-1/tp/issues/66), [3](https://github.com/AY2223S2-CS2103T-T13-1/tp/issues/46), [4](https://github.com/AY2223S2-CS2103T-T13-1/tp/issues/88))
  * Bug catching (Examples: [1](https://github.com/AY2223S2-CS2103T-T13-1/tp/issues/117),)

* **Contributions beyond the project team**:
  * Contributed to forum discussions (Examples: [1](https://github.com/nus-cs2103-AY2223S2/forum/issues/95#issuecomment-1408448245), [2](https://github.com/nus-cs2103-AY2223S2/forum/issues/198#issuecomment-1434092528))
  * Contributed to [PE-D bug catching](https://github.com/jmestxr/ped/issues)

* **Tools**:
  * JavaFX, FXML, CSS (for GUI implementation)
  * Figma (for GUI mockups)
