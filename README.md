# Office Document Archive

A lightweight Java console utility for managing office documents and records through file and I/O operations.

The project demonstrates practical Java I/O workflows including text logging, binary file backup, sequential report combination, file-system inspection, and object serialization.

## Features

- Write and read memo records using character streams
- Copy binary documents using byte streams
- Compare direct and buffered stream approaches
- Combine multiple text reports sequentially
- Inspect file-system properties
- Serialize and deserialize employee records
- Use try-with-resources for safe resource management
- Verify binary file integrity with SHA-256 checksums

## Architecture

```text
office-document-archive/
│
├── src/
│   ├── MemoLogger.java
│   ├── DocumentBackup.java
│   ├── CombineReports.java
│   ├── DocumentInspector.java
│   ├── Employee.java
│   ├── SaveEmployees.java
│   └── LoadEmployees.java
│
├── data/
│   ├── memos.txt
│   ├── morningShift.txt
│   ├── eveningShift.txt
│   ├── dailyAttendance.txt
│   └── employeeRecords.dat
│
├── source/
│   └── sample.pdf
│
├── backup/
│   ├── sample-filestreams.pdf
│   └── sample-buffered.pdf
│
├── docs/
│   └── screenshots/
│
├── report/
│   └── OfficeDocumentArchive_Report.pdf
│
└── out/
```

## I/O Workflows

### Memo Logging

```text
FileWriter
    ↓
PrintWriter
    ↓
memos.txt
    ↓
FileReader
    ↓
BufferedReader
    ↓
Console
```

### Document Backup

```text
source/sample.pdf
       ↓
FileInputStream
       ↓
FileOutputStream
       ↓
backup/sample-filestreams.pdf
```

The same document is also copied using:

```text
BufferedInputStream
        ↓
BufferedOutputStream
```

### Report Combination

```text
morningShift.txt
       +
eveningShift.txt
       ↓
SequenceInputStream
       ↓
dailyAttendance.txt
```

### Employee Records

```text
Employee objects
       ↓
ObjectOutputStream
       ↓
employeeRecords.dat
       ↓
ObjectInputStream
       ↓
Employee objects
```

## Technologies

- Java
- Java I/O
- Character Streams
- Byte Streams
- Buffered Streams
- Object Serialization
- File System APIs
- Git

## Requirements

- Java 21 or later
- Git

Check your Java installation:

```bash
java -version
javac -version
```

## Getting Started

Clone the repository:

```bash
git clone git@github.com:tamirattezera/office-document-archive.git
cd office-document-archive
```

Compile the source files:

```bash
rm -rf out
mkdir out
javac -d out src/*.java
```

## Running

### Memo Logger

```bash
java -cp out MemoLogger
```

### Document Backup

```bash
java -cp out DocumentBackup
```

### Combine Reports

```bash
java -cp out CombineReports
```

### Document Inspector

```bash
java -cp out DocumentInspector data/dailyAttendance.txt
```

### Save Employee Records

```bash
java -cp out SaveEmployees
```

### Load Employee Records

```bash
java -cp out LoadEmployees
```

## Verification

The binary backup workflow was verified by comparing SHA-256 checksums between the original document and both backup copies.

```text
source/sample.pdf
backup/sample-filestreams.pdf
backup/sample-buffered.pdf
```

All three files produced the same checksum during verification.

## Design Principles

The project intentionally keeps the implementation lightweight and focused on the Java I/O APIs being demonstrated.

Key practices include:

- Explicit resource management with try-with-resources
- Meaningful constants for file paths
- Small, focused methods
- Buffered processing for file operations
- Clear exception handling
- Command-line input where appropriate
- Verification of generated file output

## Project Status

Complete and verified.

All core programs compile and execute successfully, and the generated file artifacts have been verified.

## Author

**Tamirat Tezera**

Software Engineering
GitHub: `tamirattezera`
