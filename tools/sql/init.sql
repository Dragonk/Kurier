CREATE TABLE IF NOT EXISTS USER_ACCOUNT(
	ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	LOGIN VARCHAR(64) NOT NULL UNIQUE,
	PASSWORD VARCHAR(512) NOT NULL,
	EMAIL VARCHAR(64) NOT NULL UNIQUE,
	ACTIVE BOOLEAN NOT NULL DEFAULT FALSE,
	CREATION_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS USER_DATA(
	ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(64) NOT NULL,
	SECOND_NAME VARCHAR(64) NULL,
	SURNAME VARCHAR(64) NOT NULL,
	ADDRESS VARCHAR(128) NOT NULL,
	POSTAL_CODE VARCHAR(11) NOT NULL,
	PHONE VARCHAR(11) NOT NULL
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS USER_PROFILE(
	ID INT PRIMARY KEY NOT NULL,
	CODE VARCHAR(32) NOT NULL UNIQUE,
	INTERNAL_NAME VARCHAR(64) NOT NULL UNIQUE
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS PACKAGE(
	ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	ADDRESS_FROM TEXT NOT NULL COMMENT 'sender address in xml format',
	ADDRESS_TO TEXT NOT NULL COMMENT 'receiver address in xml format',
	RECEIVED DATE NOT NULL COMMENT 'date of receiving the package',
	LAST_UPDATE TIMESTAMP NOT NULL
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS PACKAGE_STATE(
	ID INT PRIMARY KEY NOT NULL,
	CODE VARCHAR(32) NOT NULL UNIQUE,
	INTERNAL_NAME VARCHAR(64) NOT NULL UNIQUE
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS EMPLOYEE_DATA(
	ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(64) NOT NULL,
	SECOND_NAME VARCHAR(64) NULL,
	SURNAME VARCHAR(64) NOT NULL,
	ADDRESS VARCHAR(128) NOT NULL,
	POSTAL_CODE VARCHAR(11) NOT NULL,
	PHONE VARCHAR(11) NOT NULL,
	AGREEMENT_DATE DATE NOT NULL
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS EMPLOYEE_POSITION(
	ID INT PRIMARY KEY NOT NULL,
	CODE VARCHAR(32) NOT NULL UNIQUE,
	INTERNAL_NAME VARCHAR(64) NOT NULL UNIQUE
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS LEAVE_DATA(
	ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	DATE_FROM DATE NOT NULL,
	DATE_TO DATE NOT NULL,
	ADD_INFO TEXT NULL COMMENT 'additional info for leave, sick leave etc.'
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS CAR(
	ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	REGISTRATION_NUMBER VARCHAR(10) NOT NULL UNIQUE,
	BRAND VARCHAR(32) NOT NULL,
	MODEL VARCHAR(64) NOT NULL
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS CAR_STATE(
	ID INT PRIMARY KEY NOT NULL,
	CODE VARCHAR(32) NOT NULL UNIQUE,
	INTERNAL_NAME VARCHAR(64) NOT NULL UNIQUE
)CHARACTER SET utf8 COLLATE utf8_general_ci;
