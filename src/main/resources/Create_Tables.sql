CREATE TABLE User(
	id INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255),
    address VARCHAR(255),
    email VARCHAR(255),
    phone INT(10),
    isAdmin BOOLEAN,
    isActive BOOLEAN,
	PRIMARY KEY (id)
);


CREATE TABLE QuizSubject(
	id INT NOT NULL AUTO_INCREMENT,
    quizSubject VARCHAR(255),
    description VARCHAR(255),
    timeLimit INT,
    quizImage BLOB,
    PRIMARY KEY (id)
);


CREATE TABLE Question(
	id INT NOT NULL AUTO_INCREMENT,
    quizSubjectId INT,
    description VARCHAR(255),
    correctAnswer VARCHAR(255),
    questionType VARCHAR(255),
    PRIMARY KEY(id),
    FOREIGN KEY(quizSubjectId) REFERENCES QuizSubject
);

CREATE TABLE Options(
	id INT NOT NULL AUTO_INCREMENT,
	questionId INT,
    description VARCHAR(255),
    PRIMARY KEY(id),
    FOREIGN KEY (questionID) REFERENCES Question
);


CREATE TABLE Submission(
	id INT NOT NULL AUTO_INCREMENT,
    userId INT,
    takenDate DATE,
    startTime TIME,
    endTime TIME,
    quizId INT,
    Score INT,
    PRIMARY KEY(id),
    FOREIGN KEY(userId) REFERENCES User
);

CREATE TABLE SubmissionDetails(
	id INT NOT NULL AUTO_INCREMENT,
    submissionId INT,
    questionId INT,
    userChoice VARCHAR(255),
    PRIMARY KEY(id),
    FOREIGN KEY(submissionId) REFERENCES Submission,
    FOREIGN KEY(questionId) REFERENCES Question
);

CREATE TABLE Feedback(
	id INT NOT NULL AUTO_INCREMENT,
    rate INT,
    comment VARCHAR(255),
    quizSubjectId INT,
    PRIMARY KEY(id),
    FOREIGN KEY(quizSubjectId) REFERENCES quizSubject
);


