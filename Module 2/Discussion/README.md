# Understanding GUI Frameworks in Java: AWT, Swing, and JavaFX

# Overview

- Graphic User Interfaces otherwise know as GUIs are an essential peice to most client facing applications, as they provide a simpler way for the end-user to interact with the softeare. As a software deveoping tool frameworks were developed to make crafting GUIs easier and quicker. Several major modules however stand out from the rest, AWT, Swing, and JavaFX. In Read Me I will be discussing the history, major components, strengths and weakness of these frameworks.

# Part I: Analysis

## AWT (Abstract Window Toolkit)

### History/Timeframe:

- AWT was introduced with Java Version: 1.0 in 1995.
- It was the first GUI toolkit provided by Java.

### Major Components:

- **Containers:** Frame, Panel, Applet
- **Components:** Button, Label, TextField, Checkbox
- **Layout Managers:** FlowLayout, BorderLayout, GridLayout

### Strengths:

- **Simplicity:** As it was the original toolkit, it is not very complicated and extermely well documented.
- **Platform Independence:** It truely incorporated the original Java slogan "Code Once, Use Everywhere" and provides a completely consistent feel across almost all platforms.

### Weaknesses:

- **Limited Functionality:** Due to it being the original toolkit, it did not evolve well with time so it lack some of the modern day sleek functionality compared to other modules.
- **Heavyweight Components:** In efficencies occur sometimes due to modern systems, creating efficency problems both in memory and execution time.

## Swing

### History/Timeframe:

- Swing was introduced with Java 1.2 in 1997 as part of the Java Foundation Classes (JFC).

### Major Components:

- **Top-Level Containers:** JFrame, JDialog, JApplet
- **Basic Controls:** JButton, JLabel, JTextField, JCheckBox
- **Complex Controls:** JTable, JTree, JList

### Strengths:

- **Components:** It does not rely on native system GUI components, ensuring consistency and some reactivity across platforms.
- **Features:** Offers Developers more customization options creating a more independent feel to the original GUI systems.
- **Architecture:** Separates the data model, presentation, and control logic, creating more modularity, reusability and long term maintainability in projects.

### Weaknesses:

- **Performance:** Can be slower than AWT depending on how complex a Developer makes the components.
- **Complexity:** Has a steeper learning curve increasing devloping time depending on experience level.

## JavaFX

### History/Timeframe:

- JavaFX was first introduced in 2008 as a replacement for Swing and became part of the JDK (Java Development Kit) with Java version: 8 in 2014.

### Major Components:

- **Stage and Scene:** Core elements for JavaFX applications.
- **Controls:** Button, Label, TextField, CheckBox
- **Layouts:** HBox, VBox, BorderPane, GridPane
- **Media and Web Integration:** Built-in support for multimedia content and web components.

### Strengths:

- **Modern UI:** Provides modern UI controls and styling similar to CSS for enhanced visual customization and styles.
- **Hardware Utilization:** Leverages GPU for better performance.
- **FXML:** Allows UI layout to be designed separately using XML and XML tooling software, improving the separation of design and logic creating a better experience for developers.

### Weaknesses:

- **Adoption:** Not as widely adopted as Swing, with fewer documentation support and community support compared to other opensource modules.
- **Learning Curve:** Requires learning new concepts and paradigms compared to more industry standard aligning modules.

# Summary

- Each of the Java GUI frameworks: **AWT, Swing, and JavaFX** strengths, and weaknesses. AWT is more simple and has increased platform-independence but limited in functionality and modernality. Swing offers a more customizable set of features and while maintaining its consistency across platforms but can be slower and more complex to utilize depending on the depth of the target software. JavaFX provides modern, visually appealing UIs with better performance but has a steeper learning curve and less support. Understanding frameworks and their strength and weakness can allow a developer to choose the right tool for the job _(Dont use power tools to build a linkin log house, and dont use a spoon to dig a drainage ditch)_.

# Part II: Application

## Problem 1: Balance Calculator

- **Framework Choice:** Swing

## Reasoning:

- For developing the Balance Calculator application, Swing is the most suitable framework in my opinion. Swing provides a modular and customizable set of components and is well-suited for desktop applications that require a simple yet flexible style of GUI. Here are more indepth reasons for why I choose Swing:

  - **Component Variety:** Swing offers a wide range of components, such as labels, text fields, and buttons, which are nessary for creating the input fields and labels required for the Balance Calculator.

  - **Layout Management:** Swing’s layout managers (like GridBagLayout) allow for precise control over the placement and sizing of components, making it easier to design a both user-friendly and developer-friendly interface, providing visually appealing and code-base maintainability.

  - **Ease of Use:** Swing is relatively easy to use and widely documented, making it a practical choice for quickly standing up a GUI.

  - **Cross-Platform Consistency:** Swing's lightweight components ensure that the application looks consistent across different OS _(Operating Systems)_, enhancing the user experience.

  - **Event Handling:** Swing provides a robust event-handling mechanism, which simplifies capturing user actions (like button clicks) and updating the GUI accordingly.

- Given these advantages, I believe Swing is the ideal framework for developing a Balance Calculator application for level of complexity needed by the class and the time constraint put on the project.

# References

- Horstmann, C. (2017). _Big Java: Late Objects (2nd Ed.)_. Wiley.
