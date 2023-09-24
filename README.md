# Email Client Project

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)


## Introduction

Welcome to the Email Client project! This Java-based application allows you to send custom emails, automate birthday wishes, and receive emails. Additionally, it offers a feature to save the history of sent emails through serialization.

## Features

1. **Custom Email Sending:** Send personalized emails to recipients with a custom message and subject.

2. **Automated Birthday Wishes:** Automatically send birthday wishes to contacts on their special day.

3. **Email Receiving:** Receive and view emails from your configured email accounts.

4. **Email History:** Maintain a history of sent emails by serializing them, making it easy to review past correspondence.

## Technologies Used

- **Java:** The primary programming language for this project.
- **[JavaMail API](https://javaee.github.io/javamail/):** Used for handling email operations.
- **[Serialization](https://docs.oracle.com/javase/8/docs/technotes/guides/serialization/index.html):** Utilized to save and load sent emails.

## Installation

1. Clone this repository to your local machine:
git clone https://github.com/NadunSanjeevana/Email-Client.git


## Usage

1. **Sending Custom Emails:**

- Launch the application.
- Select the "Compose Email" option.
- Enter recipient details, subject, and message.
- Click "Send."

2. **Automated Birthday Wishes:**

- Configure the application to track contacts' birthdays.
- Set up a cron job or scheduler to send birthday wishes automatically.

3. **Receiving Emails:**

- Configure your email accounts in the application.
- Select the "Receive Emails" option to check for new emails.

4. **Email History:**

- Sent emails will be automatically serialized and saved.
- You can view the email history from the application's history section.

## Configuration

To configure email accounts and other settings, please refer to the `config.properties` file. Make sure to provide the required credentials and settings.




