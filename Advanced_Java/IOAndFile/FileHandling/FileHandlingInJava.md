# File Handling in Java

File handling in Java involves reading from and writing to files using streams, which are abstractions for handling data as a sequence of bytes or characters. This document provides an in-depth exploration of file handling, focusing on the **Stream** concept, types of streams (Byte Streams and Character Streams), and detailed information on key classes. It is designed for Data Structures and Algorithms (DSA) preparation, emphasizing practical applications, class hierarchies, and best practices. The **important classes** (`File`, `FileReader`, `FileWriter`, `FileInputStream`, `FileOutputStream`, `ObjectInputStream`, `ObjectOutputStream`) are covered in detail with their constructors, methods, and pros and cons, while other classes are described minimally.

## 1. Streams in File Handling
A **stream** in Java is a sequence of data (bytes or characters) that can be read from or written to a source/destination, such as a file, network, or memory. Streams are the backbone of Java’s I/O (Input/Output) system, enabling efficient data transfer.

### Types of Streams
Java categorizes streams into two main types:
1. **Byte Streams**:
   - Handle raw binary data (bytes).
   - Used for reading/writing binary files (e.g., images, videos, serialized objects).
   - Key Classes: `InputStream`, `OutputStream`, and their subclasses (e.g., `FileInputStream`, `FileOutputStream`).
   - Use Case: Reading/writing raw data, such as binary files or serialized objects in DSA problems (e.g., saving graph data).
2. **Character Streams**:
   - Handle Unicode characters (text data).
   - Used for reading/writing text files (e.g., `.txt`, `.csv`).
   - Key Classes: `Reader`, `Writer`, and their subclasses (e.g., `FileReader`, `FileWriter`).
   - Use Case: Processing text-based input/output in algorithms (e.g., parsing configuration files).

### Difference Between Byte Streams and Character Streams
| Feature                | Byte Stream                              | Character Stream                        |
|------------------------|------------------------------------------|-----------------------------------------|
| **Data Type**          | Handles raw bytes (binary data)          | Handles Unicode characters (text data)  |
| **Classes**            | `InputStream`, `OutputStream` subclasses | `Reader`, `Writer` subclasses           |
| **Use Case**           | Binary files (e.g., images, serialized objects) | Text files (e.g., `.txt`, `.csv`)       |
| **Encoding**           | No encoding/decoding                    | Handles character encoding (e.g., UTF-8) |
| **Performance**        | Faster for raw data                     | Slightly slower due to encoding         |
| **Example**            | Reading a `.jpg` file with `FileInputStream` | Reading a `.txt` file with `FileReader` |

### Classes in Streams
- **Byte Stream Classes** (in `java.io`):
  - **Abstract Base Classes**: `InputStream`, `OutputStream`
  - **Important Subclasses**: `FileInputStream`, `FileOutputStream`, `ObjectInputStream`, `ObjectOutputStream`
  - **Other Subclasses** (minimal info):
    - `BufferedInputStream`, `BufferedOutputStream`: Add buffering to reduce direct disk access.
    - `DataInputStream`, `DataOutputStream`: Read/write primitive data types (e.g., `int`, `double`).
    - `ByteArrayInputStream`, `ByteArrayOutputStream`: Read/write to byte arrays in memory.
- **Character Stream Classes** (in `java.io`):
  - **Abstract Base Classes**: `Reader`, `Writer`
  - **Important Subclasses**: `FileReader`, `FileWriter`
  - **Other Subclasses** (minimal info):
    - `BufferedReader`, `BufferedWriter`: Add buffering for efficient text reading/writing.
    - `InputStreamReader`, `OutputStreamWriter`: Bridge byte streams to character streams with encoding.
    - `PrintWriter`: Convenient for formatted text output.
- **Utility Class**:
  - **File**: Represents a file or directory path, used across both stream types.

### Stream Usage in DSA
- **Byte Streams**: Serialize data structures (e.g., trees, graphs) for persistence or transfer.
- **Character Streams**: Read algorithm inputs from text files or write outputs (e.g., parsing test cases in competitive programming).
- **File**: Manage file paths and metadata in file-based algorithms.

## 2. Important Classes (Detailed)

### 2.1 File
#### What is it
The `File` class (`java.io.File`) represents a file or directory path in the file system. It does not handle file content but provides methods for file/directory manipulation (e.g., creating, deleting, checking existence).

#### Constructors (with Exceptions)
- `File(String pathname)`: Creates a File instance for the given pathname.
  - **Throws**: `NullPointerException` if `pathname` is null.
- `File(String parent, String child)`: Creates a File instance with a parent directory and child path.
  - **Throws**: `NullPointerException` if `parent` or `child` is null.
- `File(File parent, String child)`: Creates a File instance with a parent File and child path.
  - **Throws**: `NullPointerException` if `child` is null.
- `File(URI uri)`: Creates a File instance from a file URI.
  - **Throws**: `IllegalArgumentException` if URI is not a file scheme; `NullPointerException` if `uri` is null.

#### Methods
- **Implemented Methods**:
  - `boolean createNewFile()`: Creates a new empty file if it doesn’t exist. Throws `IOException`.
  - `boolean delete()`: Deletes the file or directory.
  - `boolean exists()`: Checks if the file/directory exists.
  - `boolean isFile()`: Checks if it’s a file (not a directory).
  - `boolean isDirectory()`: Checks if it’s a directory.
  - `boolean mkdir()`: Creates a directory.
  - `boolean mkdirs()`: Creates a directory and parent directories if needed.
  - `String getName()`: Returns the file/directory name.
  - `String getAbsolutePath()`: Returns the absolute pathname.
  - `long length()`: Returns the file size in bytes.
  - `String[] list()`: Lists directory contents (null for files).
  - `File[] listFiles()`: Lists directory contents as File objects.
  - `boolean canRead()`, `canWrite()`, `canExecute()`: Checks permissions.
  - `boolean setReadOnly()`, `setWritable(boolean)`, `setExecutable(boolean)`: Sets permissions.
- **Inherited Methods** (from `Object`):
  - `toString()`, `equals(Object)`, `hashCode()`, `compareTo(File)` (implements `Comparable<File>`).

#### Pros and Cons
- **Pros**:
  - Versatile for file/directory manipulation (e.g., checking existence, creating directories).
  - Platform-independent path handling.
  - Useful for metadata operations in DSA (e.g., validating input file paths).
- **Cons**:
  - Does not handle file content; requires streams for reading/writing.
  - Limited error details in exceptions (e.g., `IOException` may lack specifics).
  - Path manipulation can be error-prone; `java.nio.file.Path` (Java 7+) is often preferred.

### 2.2 FileReader
#### What is it
The `FileReader` class (`java.io.FileReader`) is a character stream for reading text files. It reads characters using the platform’s default encoding.

#### Constructors (with Exceptions)
- `FileReader(String fileName)`: Creates a FileReader for the specified file path.
  - **Throws**: `FileNotFoundException` if the file doesn’t exist or is inaccessible.
- `FileReader(File file)`: Creates a FileReader for the given File object.
  - **Throws**: `FileNotFoundException` if the file doesn’t exist or is inaccessible.
- `FileReader(FileDescriptor fd)`: Creates a FileReader from a file descriptor.
  - **Throws**: None directly, but may fail if the descriptor is invalid.

#### Methods
- **Implemented Methods**:
  - `int read()`: Reads a single character (or -1 if end of file). Throws `IOException`.
  - `int read(char[] cbuf, int off, int len)`: Reads characters into a char array. Throws `IOException`.
  - `void close()`: Closes the stream, releasing resources. Throws `IOException`.
- **Inherited Methods** (from `Reader`):
  - `int read(char[] cbuf)`: Reads characters into an array.
  - `long skip(long n)`: Skips characters.
  - `boolean ready()`: Checks if the stream is ready to read.
  - `void mark(int readAheadLimit)`, `boolean markSupported()`: Mark/reset stream (not supported in FileReader).
  - `void reset()`: Not supported, throws `IOException`.
- **Inherited from `Object`**: `toString()`, `equals(Object)`, `hashCode()`.

#### Pros and Cons
- **Pros**:
  - Simple for reading text files in DSA (e.g., parsing input for algorithms).
  - Easy to use for small text files.
- **Cons**:
  - Uses platform default encoding, which may cause issues with non-ASCII files.
  - No buffering, leading to poor performance for large files; `BufferedReader` is preferred.
  - Limited functionality compared to `InputStreamReader`.

### 2.3 FileWriter
#### What is it
The `FileWriter` class (`java.io.FileWriter`) is a character stream for writing text files. It writes characters using the platform’s default encoding.

#### Constructors (with Exceptions)
- `FileWriter(String fileName)`: Creates a FileWriter for the specified file path, overwriting the file.
  - **Throws**: `FileNotFoundException` if the file cannot be opened (e.g., no write permission).
- `FileWriter(String fileName, boolean append)`: Creates a FileWriter, optionally appending.
  - **Throws**: `FileNotFoundException`.
- `FileWriter(File file)`: Creates a FileWriter for the given File object.
  - **Throws**: `FileNotFoundException`.
- `FileWriter(File file, boolean append)`: Creates a FileWriter, optionally appending.
  - **Throws**: `FileNotFoundException`.
- `FileWriter(FileDescriptor fd)`: Creates a FileWriter from a file descriptor.
  - **Throws**: None directly, but may fail if the descriptor is invalid.

#### Methods
- **Implemented Methods**:
  - `void write(int c)`: Writes a single character. Throws `IOException`.
  - `void write(char[] cbuf, int off, int len)`: Writes a portion of a char array. Throws `IOException`.
  - `void write(String str, int off, int len)`: Writes a portion of a string. Throws `IOException`.
  - `void flush()`: Flushes the stream. Throws `IOException`.
  - `void close()`: Closes the stream, flushing first. Throws `IOException`.
- **Inherited Methods** (from `Writer`):
  - `void write(char[] cbuf)`: Writes a char array.
  - `void write(String str)`: Writes a string.
  - `Writer append(CharSequence csq)`: Appends a sequence.
  - `Writer append(char c)`: Appends a character.
- **Inherited from `Object`**: `toString()`, `equals(Object)`, `hashCode()`.

#### Pros and Cons
- **Pros**:
  - Simple for writing text files in DSA (e.g., outputting algorithm results).
  - Supports appending mode for log files.
- **Cons**:
  - Uses platform default encoding, which may cause encoding issues.
  - No buffering, leading to poor performance; `BufferedWriter` is preferred.
  - Limited compared to `OutputStreamWriter` for custom encodings.

### 2.4 FileInputStream
#### What is it
The `FileInputStream` class (`java.io.FileInputStream`) is a byte stream for reading raw bytes from files, suitable for binary data (e.g., images, serialized objects).

#### Constructors (with Exceptions)
- `FileInputStream(String name)`: Creates a FileInputStream for the specified file path.
  - **Throws**: `FileNotFoundException` if the file doesn’t exist or is inaccessible.
- `FileInputStream(File file)`: Creates a FileInputStream for the given File object.
  - **Throws**: `FileNotFoundException`.
- `FileInputStream(FileDescriptor fdObj)`: Creates a FileInputStream from a file descriptor.
  - **Throws**: None directly, but may fail if the descriptor is invalid.

#### Methods
- **Implemented Methods**:
  - `int read()`: Reads a single byte (or -1 if end of file). Throws `IOException`.
  - `int read(byte[] b, int off, int len)`: Reads bytes into a byte array. Throws `IOException`.
  - `void close()`: Closes the stream. Throws `IOException`.
  - `int available()`: Returns an estimate of bytes available to read. Throws `IOException`.
  - `long skip(long n)`: Skips bytes. Throws `IOException`.
- **Inherited Methods** (from `InputStream`):
  - `int read(byte[] b)`: Reads bytes into an array.
  - `void mark(int readlimit)`, `boolean markSupported()`: Mark/reset (not supported).
  - `void reset()`: Not supported, throws `IOException`.
- **Inherited from `Object`**: `toString()`, `equals(Object)`, `hashCode()`.

#### Pros and Cons
- **Pros**:
  - Efficient for reading binary files in DSA (e.g., serialized graphs).
  - Simple for raw byte access.
- **Cons**:
  - No buffering, leading to poor performance; `BufferedInputStream` is preferred.
  - Not suitable for text files due to lack of encoding support.
  - Limited error handling in exceptions.

### 2.5 FileOutputStream
#### What is it
The `FileOutputStream` class (`java.io.FileOutputStream`) is a byte stream for writing raw bytes to files, suitable for binary data.

#### Constructors (with Exceptions)
- `FileOutputStream(String name)`: Creates a FileOutputStream, overwriting the file.
  - **Throws**: `FileNotFoundException` if the file cannot be opened.
- `FileOutputStream(String name, boolean append)`: Creates a FileOutputStream, optionally appending.
  - **Throws**: `FileNotFoundException`.
- `FileOutputStream(File file)`: Creates a FileOutputStream for the given File.
  - **Throws**: `FileNotFoundException`.
- `FileOutputStream(File file, boolean append)`: Creates a FileOutputStream, optionally appending.
  - **Throws**: `FileNotFoundException`.
- `FileOutputStream(FileDescriptor fdObj)`: Creates a FileOutputStream from a file descriptor.
  - **Throws**: None directly, but may fail if the descriptor is invalid.

#### Methods
- **Implemented Methods**:
  - `void write(int b)`: Writes a single byte. Throws `IOException`.
  - `void write(byte[] b, int off, int len)`: Writes a portion of a byte array. Throws `IOException`.
  - `void close()`: Closes the stream, flushing first. Throws `IOException`.
  - `void flush()`: Flushes the stream. Throws `IOException`.
- **Inherited Methods** (from `OutputStream`):
  - `void write(byte[] b)`: Writes a byte array.
- **Inherited from `Object`**: `toString()`, `equals(Object)`, `hashCode()`.

#### Pros and Cons
- **Pros**:
  - Efficient for writing binary files in DSA (e.g., saving algorithm outputs).
  - Supports appending mode for incremental writes.
- **Cons**:
  - No buffering, leading to poor performance; `BufferedOutputStream` is preferred.
  - Not suitable for text files due to lack of encoding.
  - Limited error details in exceptions.

### 2.6 ObjectInputStream
#### What is it
The `ObjectInputStream` class (`java.io.ObjectInputStream`) is a byte stream for deserializing Java objects from files or streams, used for reading serialized objects.

#### Constructors (with Exceptions)
- `ObjectInputStream(InputStream in)`: Creates an ObjectInputStream from an underlying InputStream.
  - **Throws**: `IOException` if an I/O error occurs; `StreamCorruptedException` if the stream is invalid.

#### Methods
- **Implemented Methods**:
  - `Object readObject()`: Reads a serialized object. Throws `IOException`, `ClassNotFoundException`.
  - `int read()`: Reads a byte. Throws `IOException`.
  - `int read(byte[] buf, int off, int len)`: Reads bytes into an array. Throws `IOException`.
  - `void close()`: Closes the stream. Throws `IOException`.
  - `int available()`: Returns bytes available. Throws `IOException`.
  - `long skip(long n)`: Skips bytes. Throws `IOException`.
- **Inherited Methods** (from `InputStream`): Same as `FileInputStream`.
- **Inherited from `Object`**: `toString()`, `equals(Object)`, `hashCode()`.

#### Pros and Cons
- **Pros**:
  - Essential for deserializing complex data structures in DSA (e.g., trees, graphs).
  - Supports custom object serialization.
- **Cons**:
  - Security risks (e.g., deserialization vulnerabilities); requires careful validation.
  - Performance overhead due to object reconstruction.
  - Requires objects to implement `Serializable`.

### 2.7 ObjectOutputStream
#### What is it
The `ObjectOutputStream` class (`java.io.ObjectOutputStream`) is a byte stream for serializing Java objects to files or streams.

#### Constructors (with Exceptions)
- `ObjectOutputStream(OutputStream out)`: Creates an ObjectOutputStream from an underlying OutputStream.
  - **Throws**: `IOException` if an I/O error occurs.

#### Methods
- **Implemented Methods**:
  - `void writeObject(Object obj)`: Writes a serialized object. Throws `IOException`.
  - `void write(int b)`: Writes a byte. Throws `IOException`.
  - `void write(byte[] buf, int off, int len)`: Writes bytes from an array. Throws `IOException`.
  - `void flush()`: Flushes the stream. Throws `IOException`.
  - `void close()`: Closes the stream. Throws `IOException`.
- **Inherited Methods** (from `OutputStream`): Same as `FileOutputStream`.
- **Inherited from `Object`**: `toString()`, `equals(Object)`, `hashCode()`.

#### Pros and Cons
- **Pros**:
  - Simplifies saving complex data structures in DSA (e.g., serialized graphs).
  - Supports custom object serialization.
- **Cons**:
  - Performance overhead due to serialization.
  - Requires objects to implement `Serializable`.
  - Not human-readable; unsuitable for text output.

### 2.8 Other Classes (Minimal Info)
- **BufferedInputStream**, **BufferedOutputStream**: Add buffering to byte streams, improving performance by reducing disk access.
- **DataInputStream**, **DataOutputStream**: Read/write primitive data types (e.g., `readInt()`, `writeDouble()`).
- **ByteArrayInputStream**, **ByteArrayOutputStream**: Operate on in-memory byte arrays, useful for testing.
- **BufferedReader**, **BufferedWriter**: Add buffering to character streams, improving text I/O performance.
- **InputStreamReader**, **OutputStreamWriter**: Bridge byte streams to character streams with specified encoding.
- **PrintWriter**: Simplifies formatted text output with methods like `println()`.

## 3. Best Practices
- **Use Buffered Streams**: Wrap `FileInputStream`/`FileOutputStream` with `BufferedInputStream`/`BufferedOutputStream` and `FileReader`/`FileWriter` with `BufferedReader`/`BufferedWriter` for performance.
- **Close Streams**: Always close streams using try-with-resources to prevent resource leaks.
- **Handle Exceptions**: Catch `IOException` and specific exceptions (e.g., `FileNotFoundException`) for robust error handling.
- **Encoding**: Use `InputStreamReader`/`OutputStreamWriter` for explicit encoding in character streams.
- **Serialization Security**: Validate objects during deserialization with `ObjectInputStream` to avoid security risks.
- **Use `java.nio.file`**: For advanced file operations, prefer `Path` and `Files` classes (Java 7+).

## 4. Common Pitfalls
- **Resource Leaks**: Forgetting to close streams, leading to file locks or memory issues.
- **Encoding Issues**: Using `FileReader`/`FileWriter` with default encoding, causing problems with non-ASCII files.
- **Serialization Risks**: Deserializing untrusted data with `ObjectInputStream` can lead to vulnerabilities.
- **Performance**: Using unbuffered streams (`FileInputStream`, `FileReader`) for large files is inefficient.
- **File Path Errors**: Incorrect paths in `File` can cause `FileNotFoundException`.

## 5. DSA Relevance
- **File**: Validate file paths for input/output in algorithms (e.g., reading graph adjacency lists).
- **Byte Streams**: Serialize data structures (e.g., saving a trie to disk).
- **Character Streams**: Read/write text-based algorithm inputs/outputs (e.g., parsing test cases).
- **Serialization**: Store complex data structures (e.g., graphs) for reuse in DSA problems.

This document is accompanied by Java example files for each important class, demonstrating usage, violations, and solutions with detailed comments.