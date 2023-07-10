create database Learning_Site;

use Learning_Site;
-- Create the "Countries" Table
create table Countries(
ID INT auto_increment primary key,
Name VARCHAR(255)
);

-- Create the "Provinces" Table
create table Provinces(
ID INT auto_increment primary key,
Name VARCHAR(255),
CountryId INT,
foreign key (CountryId) references Countries(ID)
);
-- Create the "Cities" Table
create table Cities(
ID INT auto_increment primary key,
Name VARCHAR(255),
ProviceId INT,
foreign key (ProviceId) references Provinces(ID)
);
-- Create the "Districts" Table
create table Districts(
ID INT auto_increment primary key,
Name VARCHAR(255),
CityId INT,
foreign key (CityId) references Cities(ID)
);
-- Create the "Wards" Table
create table Wards(
ID INT auto_increment primary key,
Name VARCHAR(255),
DistrictID INT,
foreign key (DistrictID) references Districts(ID)
);

-- Create the "Residential_Group" Table
create table Residential_Groups(
ID INT auto_increment primary key,
Name VARCHAR(255),
WardId INT,
foreign key (WardId) references Wards(ID)
);

-- Create the "Address" Table
create table Address(
ID INT auto_increment primary key,
Alley VARCHAR(255),
HouseNumber VARCHAR(255),
Residential_GroupsID INT,
foreign key (Residential_GroupsID) references Residential_Groups(ID)
);


-- Create the "Users" Table
create table Users (
    ID INT auto_increment primary key,
    Username VARCHAR(50) not null,
    Password VARCHAR(50) not null,
    FirstName VARCHAR(250),
    LastName VARCHAR(250),
    Email VARCHAR(250),
    Phone VARCHAR(20),   
    AddressId INT unique,
    Image BLOB,
    DOB DATE,
    foreign key (AddressId) references Address(ID)
);

-- Create the 'Roles' table
create table Roles(
ID INT auto_increment primary key,
Name VARCHAR(100)
);
-- Create the UserRole
create table UserRole(
	UserId INT,
	RoleId INT,
	PRIMARY KEY (UserId, RoleId),
 foreign key (Userid) references Users(ID),
 foreign key (RoleId) references Roles(ID)
);


-- Create the "Subject" table
create table Subject (
    SubjectId INT auto_increment primary key,
    SubjectName VARCHAR(250),
    SubjectDescription VARCHAR(500)
);
-- Create the "Course" table
create table Course (
    CourseId INT auto_increment primary key,
    CourseName VARCHAR(250),
    CourseTitle VARCHAR(250),
    Image VARCHAR(250),
    CourseDescription TEXT,
    DateCreate DATETIME default CURRENT_TIMESTAMP
    
);

-- Create the "SubjectCourse" table
CREATE TABLE SubjectCourse (
    SubjectId INT,
    CourseId INT,
    PRIMARY KEY (SubjectId, CourseId),
    FOREIGN KEY (CourseId) REFERENCES Course(CourseId),
    FOREIGN KEY (SubjectId) REFERENCES Subject(SubjectId)
);
-- Create the "Module" table
create table Module (
    ModuleId INT primary key auto_increment,
    CourseId INT,
    ModuleName VARCHAR(100),
    ModuleDescription VARCHAR(255),
    foreign key (CourseId) references Course(CourseId)
);
-- Create the "WeekCourse" table
create table WeekCourse (
    WeekId INT primary key auto_increment,
    ModuleId INT,
    WeekNumber INT,
    WeekTitle VARCHAR(255),
   WeekDescription VARCHAR(255),
    foreign key (ModuleId) references Module(ModuleId)
);

-- ALTER TABLE WeekCourse
-- ADD COLUMN WeekDescription VARCHAR(255);
-- Create the "Lesson" table
create table Lesson (
    LessonId INT primary key auto_increment,
    WeekId INT,
    VideoPath VARCHAR(255),
    Script TEXT,
    foreign key (WeekId) references WeekCourse(WeekId)
);


-- Create the "Quiz" table
create table Quiz (
    QuizId INT primary key auto_increment,
    QuizName VARCHAR(255),
    QuizTopic VARCHAR(255),
    QTime INT,
    WeekId INT,
    foreign key (WeekId) references WeekCourse(WeekId)
);
alter table Quiz add column  QTime INT
-- Create QuestTion Table
create table Questions(
Id INT primary key auto_increment,
QuizId INT not null,
QContent VARCHAR(1000),
OptionA VARCHAR(1000),
AnswerA BIT default 0,
OptionB VARCHAR(1000),
AnswerB  BIT default 0,
OptionC VARCHAR(1000),
AnswerC  BIT default 0,
OptionD VARCHAR(1000),
AnswerD  BIT default 0,
foreign key (QuizId) references Quiz(QuizId)
);

-- Create the "Assignment" table
create table assignment (
    AssignmentId INT primary key auto_increment,
    WeekId INT,
    AssignmentTitle VARCHAR(100),
    Description TEXT,
    foreign key (WeekId) references WeekCourse(WeekId)
);
-- Create the "CourseEnrollment" table
create table CourseEnrollment (
    EnrollmentId INT primary key auto_increment,
    UserId INT,
    CourseId INT,
    EnrollmentDate DATETIME,
    foreign key (Userid) references Users(ID),
    foreign key (CourseId) references Course(CourseId)
);
-- Create the "Certificate" table
create table Certificate(
CertificateId INT primary key auto_increment,
EnrollmentId INT,
Datecomplete Date,
 foreign key (EnrollmentId) references CourseEnrollment(EnrollmentId),
);
-- Create the "QuizProgress" table
create table QuizHistory (
    QuizHistoryId INT primary key auto_increment,
    QuestionId INT ,
    QContent VARCHAR(1000),
	OptionA VARCHAR(1000),
	AnswerA BIT default 0,
	UserAnswerA BIT default 0,
	OptionB VARCHAR(1000),
	AnswerB BIT default 0,
	UserAnswerB BIT default 0,
	OptionC VARCHAR(1000),
	AnswerC BIT default 0,
	UserAnswerC BIT default 0,
	OptionD VARCHAR(1000),
	AnswerD BIT default 0,
	UserAnswerD BIT default 0,
    UserID INT ,
    QuizId INT,
    foreign key (UserID) references Users(ID),
    foreign key (QuizId) references Quiz(QuizId)
    
);
-- Create the "LessonProgress" table
create table LessonProgress (
    LessonProgressId INT primary key auto_increment,
    IsCompleted BOOLEAN default false,
    EnrollmentId INT,
    foreign key (EnrollmentId) references CourseEnrollment(EnrollmentId)
);
-- Create the "AssignmentProgress" table
create table AssignmentProgress (
    AssignmentProgressId INT primary key auto_increment,
    IsCompleted BOOLEAN default false,
    EnrollmentId INT,
    Score DECIMAL(5,
2),
    FileSubmission BLOB,
    Answer TEXT,
    foreign key (EnrollmentId) references CourseEnrollment(EnrollmentId)
);
-- Create the "Class" table
create table Class (
    ClassId INT primary key auto_increment,
    ClassName VARCHAR(50),
    CreateBy INT,
    DateCreate DATETIME
);
-- Create the "ClassCourse" table
create table ClassCourse (
    CourseId INT,
    ClassId INT,
    foreign key (CourseId) references Course(CourseId),
    foreign key (ClassId) references Class(ClassId)
);
-- Create the "ChatSupport" table
create table ChatSupport (
    ChatId INT primary key auto_increment,
    DateCreate DATETIME,
    Content TEXT,
    Userid INT,
    Supporrter INT,
    SentAt DATETIME,
    foreign key (Userid) references Users(ID),
    foreign key (Supporrter) references Users(ID)
);
-- Create the "Application" table
create table Application (
    ApplicationId INT primary key auto_increment,
    Title VARCHAR(100),
    Content TEXT,
    SendTime DATETIME,
    Sender INT,
    foreign key (Sender) references Users(ID)
);
-- Create the "ReplyApplication" table
create table ReplyApplication (
    ReplyApplicationId INT primary key auto_increment,
    ApplicationId INT,
    RepContent TEXT,
    SendTime DATETIME,
    Responder INT,
    foreign key (Responder) references  Users(ID),
    foreign key (ApplicationId) references Application(ApplicationId)
);
