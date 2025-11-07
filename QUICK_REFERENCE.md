# ⚡ Quick Git Reference — Program Collection

A list of the most common commands you’ll use.

---

## 🧱 Basic Workflow

| Step | Command |
|------|----------|
| Clone repo | `git clone https://github.com/<teacher-username>/program-collection.git` |
| Enter folder | `cd program-collection` |
| Switch to develop | `git checkout develop` |
| Create new branch | `git checkout -b feature/<issue-number>-<short-title>` |
| Check branches | `git branch` |
| Add changes | `git add .` |
| Commit changes | `git commit -m "Add <YourName> program"` |
| Push branch | `git push origin feature/<issue-number>-<short-title>` |
| Fetch new updates | `git fetch origin` |
| Pull latest develop | `git pull origin develop` |
| Merge develop into your branch | `git merge develop` |
| Check status | `git status` |
| Run program | `javac Main.java && java Main` |

---

## 🧩 Registering Your Program

In `ProgramLoader.java`, add:
```java
programs.add(new programs.<yourfolder>.<YourProgram>());
```

## 🧱 Basic Workflow

| Step | Command |
|------|----------|
| Clone repo | `git clone https://github.com/<teacher-username>/program-collection.git` |
| Enter folder | `cd program-collection` |
| Switch to develop | `git checkout develop` |
| Create new branch | `git checkout -b feature/<issue-number>-<short-title>` |
| Check branches | `git branch` |
| Add changes | `git add .` |
| Commit changes | `git commit -m "Add <YourName> program"` |
| Push branch | `git push origin feature/<issue-number>-<short-title>` |
| Fetch new updates | `git fetch origin` |
| Pull latest develop | `git pull origin develop` |
| Merge develop into your branch | `git merge develop` |
| Check status | `git status` |
| Run program | `javac Main.java && java Main` |

---

## 🧩 Registering Your Program

In `ProgramLoader.java`, add:
```java
programs.add(new programs.<yourfolder>.<YourProgram>());
```
For example:
```java
programs.add(new programs.martin.MyCoolProgram());
```

## 📁 Folder Structure Example
```bash
programs/martin/MyCoolProgram.javaprograms/martin/MyCoolProgram.java
```

💡 Tips
- Do not edit Main.java or ProgramInterface.java.
- Always create your own folder.
- Keep your branch updated with develop.
- One branch = one pull request.
- Commit messages should be clear (e.g., “Add Martin Program”).
- Use git status often to track changes.
