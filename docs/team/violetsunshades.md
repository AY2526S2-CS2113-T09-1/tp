# Kim Minsun - Project Portfolio Page

## Project: ModTrack

ModTrack is a CLI (Command Line Interface) application designed for students to manage modules, track completion status, and organize prerequisite and graduation requirements. It is optimized for efficiency and clarity, leveraging a command-based architecture implemented in Java.

## Summary of Contributions

### 1. Core System Architecture (Parser, Storage, Execution Pipeline)

I was responsible for implementing the core execution backbone of the system, including the Parser, Storage system, and command execution pipeline. These components form the foundation upon which all features operate.

#### Parser System Design & Implementation

- Designed and implemented the full Parser responsible for interpreting user input  
- Converts raw input strings into structured `Command` objects  
- Differentiates between command types and extracts arguments  
- Enforces strict input validation rules  
- Impact: Enabled scalable addition of commands without modifying core logic, prevented malformed inputs from propagating into execution flow, established a consistent command-handling pattern across the application  

#### Command Execution Pipeline Integration

- Integrated Parser output into the main application loop  

**Pipeline:**
User Input → Parser → Command → Model → UI  
- Impact: Enforced a command-driven architecture, standardized execution flow across all features, reduced coupling between system components  

#### Persistent Storage System
- Implemented file-based storage (load/save)  

**Technical Details:**
- Handles serialization and deserialization of module data  
- Ensures consistency between runtime state and stored state  
- Safeguards against missing or malformed data  
- Impact: Enabled persistence across sessions, prevented data loss, supported real-world usability of the application  

#### Data Integrity: Duplicate Module Prevention
- Implemented validation to prevent duplicate module entries  
- Impact: Maintained a consistent and reliable data model, prevented downstream logical errors  

#### System Integration & Conflict Resolution
- Led integration of independently developed components into a stable system  

**Key Contributions:**
- Resolved merge conflicts across Parser, Command, UI, and Storage layers  
- Refactored code to ensure compatibility between implementations  
- Adapted logic to align with evolving system design  
- Impact: Delivered a fully functional and stable Version 1.0, ensured end-to-end system reliability  

### 2. Feature Development (Version 2.0 Enhancements)

Implemented multiple commands as below, that extend ModTrack into a structured academic planning tool:
- AddPrereqCommand, ExemptCommand, FindCommand, ShowPrereqCommand, TransferCommand

#### Prerequisite Management System (AddPrereq & ShowPrereq)

- Introduced module dependency relationships  
- Supports assigning multiple prerequisites to a module  
- Enables retrieval and display of dependency information  
- Impact: Transformed ModTrack from a flat list into a structured academic planner, Allow users to visualize module dependencies

#### TransferCommand
- Enables modules to be moved across categories or states, which required safe state transitions and consistency checks  
#### ExemptCommand
- Allows modules to be marked as exempted, which reflected real-world academic scenarios such as credit transfers  
#### FindCommand
- Implements keyword-based search, which improved usability for large datasets  

### 3. Developer Guide Contributions

#### Command Documentation (Primary Author)

Authored Developer Guide sections for: AddPrereqCommand, ShowPrereqCommand, TransferCommand, Mark, Unmark.
Included details of: Parsing logic, Execution flow, Design rationale, and Limitations  for every command.

#### Parser Architecture Documentation

- Documented how the Parser processes input, dispatches commands, and handles invalid cases, improving maintainability and extensibility. 

#### UML & Sequence Diagrams

- Contributed diagrams for:
  - Command execution flow  
  - Parser-command interaction  
  - Features such as `mark`, `unmark`, `showgradreq`, and prerequisite commands  

- Improved:
  - UML correctness (inheritance, dependencies)  
  - Diagram clarity and layout  

#### Edge Cases & Limitations

- Added: “Current Limitations” sections  
- Documented: Invalid input handling, Edge-case behaviors, and System constraints  

### 4. User Guide Contributions

- Authored and refined sections for:
  - `mark`, `unmark`,`showgradreq`, along with prerequisite-related features  
- My Key Contributions are: Clear command formatting, Realistic usage examples, Explanation of edge cases  

### 5. Software Quality & Testing Support

- Contributed to command-level testing design  
- Verified functionality through realistic input scenarios  

### 6. Team Contribution & Engineering Ownership

- Took responsibility for delivering a stable Version 1.0 system
- Ensured integration across Parser, Commands, Storage, and UI by bridging individual contributions into a cohesive product, and maintaining consistency across system components 

## Code Contributed

- [RepoSense Dashboard](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=violetsunshades&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2026-02-20T00%3A00%3A00&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&filteredFileName=)

## Overall Contribution

My contributions focused on both system-level architecture and feature-level development. I implemented the core infrastructure (Parser, Storage, execution pipeline), ensured successful system integration for Version 1.0, and expanded functionality through multiple Version 2.0 features.
In addition, I contributed extensively to the Developer Guide and User Guide, strengthening the clarity, maintainability, and technical rigor of the project. Through these efforts, I helped transform ModTrack into a cohesive, well-documented, and extensible software system.
