# 🧭 Student Guide — Program Collection
This guide will help you submit your own program while learning how to use Git and GitHub properly.

---
# 🧰 Prerequisites: Git and SSH Setup
Before you clone the repository, make sure your Git and SSH are correctly configured.
1. Verify Git Installation
    Check if Git is installed:
    ```bash
    git --version
    ```
    If not installed, download from: [git downloads](https://git-scm.com/downloads).

2. Configure Your Git Identity
    Set your Git username and email — this will appear on your commits.
    ```bash
    git config --global user.name "Your Full Name"
    git config --global user.email "your_email@example.com"
    ```
    Confirm your settings:
    ```bash
    git config --global --list
    ```
3. Set Up SSH Key for GitHub
    1. Generate a new SSH key:
        ```bash
        ssh-keygen -t ed25519 -C "your_email@example.com"ssh-keygen -t ed25519 -C "your_email@example.com"
        ```
        (If asked for a file location, just press Enter.)
    2. Start the SSH agent:
        ```bash
        eval "$(ssh-agent -s)"
        ```
    3. Add your new SSH key:
        ```bash
        ssh-add ~/.ssh/id_ed25519
        ```
    4. Display your public key:
        ```bash
        cat ~/.ssh/id_ed25519.pub
        ```
    5. Copy the entire key and add it to your GitHub account:
        - Go to GitHub → Settings → SSH and GPG Keys → New SSH KeyGo to GitHub → Settings → SSH and GPG Keys → New SSH Key
        - Paste your key and save
    6. Test the connection:
        ```bash
        ssh -T git@github.com
        ```
        You should see: 
        `"Hi <username>! You've successfully authenticated."`
4. Clone Using SSH (Recommended)
    Once SSH is set up, clone the repository using your SSH link:
    ```bash
    git clone git@github.com:<teacher-username>/program-collection.git
    cd program-collection
    ```
    ⚠️ If SSH doesn’t work, you can fall back to HTTPS:
    ```bash
    git clone https://github.com/<teacher-username>/program-collection.git
    ```
---

## 🧱 1. Setup

### Clone the Repository
```bash
git clone https://github.com/<teacher-username>/program-collection.git
cd program-collection
```

### Switch to the develop Branch
```bash
git checkout develop
```


## 🪪 2. Create an Issue on GitHub
Open the repository in GitHub.

Go to the Issues tab → click New Issue.

Title example:
Add <YourName> Program (e.g., Add Martin Program)

Briefly describe what your program will do.

Submit the issue.

## 🌿 3. Create a Branch from the Issue
After creating the issue, make a new branch linked to it:
```bash
git fetch origin
git checkout develop
git pull

git checkout -b feature/<issue-number>-<short-title>

# Example:
# git checkout -b feature/12-fibonacci-upgrade
```

## 💾 4. Create Your Program
1. Copy this file:
```
TEMPLATE_YourProgram.java
```
2. Paste it inside a new folder in programs/, example:
```
programs/martin/MyCoolProgram.java
```
3. Edit your file:
- Change the class name
- Update `getName()`, `getDescription()`, `getAuthor()`
- Add your logic in the `run()` method

## 🧩 5. Register Your Program
```java
programs.add(new programs.martin.MyCoolProgram());
```
Do not remove or edit existing entries.

## 🧪 6. Test Your Program
```bash
javac Main.java
java Main
```
You should see your program in the list.
Try selecting it to confirm it works.

## 🚀 7. Commit and Push
``` bash
git add .
git commit -m "Add <YourName> program"
git push origin feature/<issue-number>-<short-title>
```

## 🔁 8. Create a Pull Request (PR)
1. Go to GitHub → You’ll see a banner for your new branch.
2. Click Compare & pull request.
3. Set base branch: develop.
4. Write a short description and link your issue.
5. Click Create pull request.

## 🔄 9. Sync with Latest Code
If the teacher updates the repository, fetch and merge:
```bash
git fetch origin
git checkout develop
git pull
git checkout feature/<your-branch>
git merge develop
``` 

## ✅ 10. After Approval
Once your PR is merged — congratulations! 🎉
Your work becomes part of the official collection.
