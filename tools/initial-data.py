#!/usr/bin/python
#coding=utf8

import MySQLdb
import csv

config = {
    'user' : 'root',
    'host' : '127.0.0.1'
}

def insert_data_into_db (tablename, filename):
	with open (filename, 'r') as f:
		print "Wstawianie danych do tabeli " + tablename
		reader = csv.reader(f)
		columns = next(reader)
		query = 'INSERT INTO ' + tablename + ' ({0}) VALUES ({1})'
		query = query.format(','.join(columns), ','.join("?" * len(columns)))
	        query = query.replace("?", "%s")
        	for data in reader:
                	cursor.execute(query, data)
		conn.commit()

print 'Łączenie się z serwerem bazy danych...'
conn = MySQLdb.connect(**config)
print 'Połączono'
cursor = conn.cursor()
cursor.execute('USE DTS')

insert_data_into_db ('PACKAGE_STATE', 'initial-data/package_state.csv')
insert_data_into_db ('EMPLOYEE_POSITION', 'initial-data/employee_position.csv')
insert_data_into_db ('USER_PROFILE', 'initial-data/user_profile.csv')
insert_data_into_db ('CAR_STATE', 'initial-data/car_state.csv')

conn.close()
