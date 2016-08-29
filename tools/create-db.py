#!/usr/bin/python
#coding=utf8

import MySQLdb

config = {
	'user' : 'root',
	'host' : '127.0.0.1'
}
print 'Łączenie się z serwerem bazy danych...'
conn = MySQLdb.connect(**config)
print 'Połączono'

cur = conn.cursor()

print 'Tworzenie nowej instancji...'
cur.execute('CREATE DATABASE DTS')
cur.execute('ALTER DATABASE DTS CHARACTER SET utf8')

print 'Tworzenie użytkownika...'
cur.execute('CREATE USER \'dts\'@\'%\' IDENTIFIED BY \'123456\'')

print 'Nadawanie uprawnień...'
cur.execute('GRANT ALL ON DTS.* TO \'dts\'@\'%\'')

print 'Tworzenie tabel...'
cur.execute('USE DTS')

tables = open('sql/init.sql')
script = tables.read()
tables.close()

sql = script.split(';')

for line in sql:
        try:
                line = line.rstrip().replace('\n', '')
                line = line.replace('\r', '')
                line = line.replace('\t','')
		if len(line.strip()) != 0:
                	cur.execute(line)
        except MySQLdb.Error, msg:
                print "Niewłaściwa składnia, pomijanie..."
                print msg

print 'Tworzenie kluczy...'

keys = open('sql/create-fk.sql')
script = keys.read()
keys.close()

sql = script.split(';')

for line in sql:
        try:
                line = line.rstrip().replace('\n', '')
                line = line.replace('\r', '')
                line = line.replace('\t','')
        	if len(line.strip()) != 0:
                        cur.execute(line)
	except MySQLdb.Error, msg:
                print "Niewłaściwa składnia, pomijanie..."
                print msg

print 'Utworzono bazę danych.'
conn.close()
