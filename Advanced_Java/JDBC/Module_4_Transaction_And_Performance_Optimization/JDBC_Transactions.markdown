# Transactions

## Overview
**JDBC Transactions** are a fundamental mechanism that ensures multiple database operations are executed as a single, indivisible unit, thereby maintaining **data integrity**. Transactions are governed by the **ACID properties**: **A**tomicity, **C**onsistency, **I**solation, and **D**urability.

* **Purpose**: Group SQL statements to ensure **all or none** are permanently applied to the database, preventing partial updates.
* **Core Principle**: **Atomicity**, meaning the entire series of operations is treated as a single command.
* **DSA Relevance**: Involves state management (commit/rollback), similar to undo operations in computational logic, and guarantees data integrity.

---

## Auto-Commit Mode

The auto-commit mode determines when a SQL operation becomes permanent.

* **Default State**: By default, a `Connection` has auto-commit enabled (`con.getAutoCommit() == true`).
* **Default Behavior**: Each SQL statement is treated as its own transaction and is committed immediately after successful execution.
* **Transaction Start**: To begin a custom, multi-statement transaction, you must **disable** the auto-commit mode:
  * `con.setAutoCommit(false)`
* **Restoration**: The original auto-commit setting should always be restored after the transaction finishes (typically in a `finally` block).

---

## commit() and rollback()

These methods provide explicit control over the transactional boundary.

* **`commit()`**:
  * **Action**: Makes all pending changes executed since the last commit (or since `setAutoCommit(false)`) permanent in the database.
  * **Usage**: Called only when all operations within the transaction succeed.
* **`rollback()`**:
  * **Action**: Undoes (reverts) all pending changes in the current transaction, restoring the database to the state it was in when the transaction began.
  * **Usage**: Called when any operation within the transaction fails (typically within a `catch` block) to ensure atomicity.

---

## Savepoints

**Savepoints** provide a mechanism for finer control within long or complex transactions.

* **Purpose**: Mark intermediate points in a transaction, allowing for a **partial rollback** without undoing the entire transaction.
* **Methods**:
  * **`setSavepoint()`**: Creates a named or unnamed savepoint object.
    * Example: `Savepoint sp = con.setSavepoint("Checkpoint1");`
  * **`rollback(Savepoint sp)`**: Rolls back the transaction to the state captured by the specified savepoint. Operations *after* the savepoint are undone; operations *before* the savepoint remain pending.
  * **`releaseSavepoint(Savepoint sp)`**: Removes the savepoint object, freeing resources.
* **Usage Note**: Savepoints are often vendor-specific and should be used judiciously to avoid complicating transaction recovery logic.

---

## Best Practices and Pitfalls

| Category | Best Practice | Common Pitfall |
| :--- | :--- | :--- |
| **Transaction Control** | Disable auto-commit with **`con.setAutoCommit(false)`** to start a transaction. | Forgetting to disable auto-commit, causing **partial commits**. |
| **Integrity** | Call **`con.commit()`** only upon success and **`con.rollback()`** on failure. | Not calling `rollback()` on failure, leading to **inconsistent data**. |
| **Cleanup** | Restore the original auto-commit mode in a **`finally`** block. | Forgetting to restore auto-commit, causing subsequent statements to fail. |
| **Complexity** | Use savepoints sparingly for **complex, multi-stage procedures** where partial recovery is needed. | Overusing savepoints, which complicates transaction logic and consumes resources. |

---

## Practice Task
* **Task**: Implement a Java program that executes two dependent database modifications (DML operations) atomically, ensuring both succeed or both fail.
* **Solution Approach**:
  1.  Obtain a `Connection` and call **`con.setAutoCommit(false)`**.
  2.  Execute two sequential DML statements (e.g., `INSERT` or `UPDATE`) using `PreparedStatement`.
  3.  Wrap the DML execution in a `try` block.
  4.  Call **`con.commit()`** at the end of the `try` block.
  5.  Catch `SQLException` and call **`con.rollback()`** to revert changes.
  6.  Ensure **`con.setAutoCommit(true)`** is called in a `finally` block.