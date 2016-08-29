#!/usr/bin/python
#coding=utf8
import mysql.connector

config = {
        'user' : 'root',
        'host' : '127.0.0.1'
}
print 'Łączenie się z serwerem bazy danych...'
conn = mysql.connector.connect(**config)
print 'Połączono'

cur = conn.cursor()

print 'Usuwanie użytkownika...'
cur.execute('DROP USER \'dts\'@\'%\'')

print 'Usuwanie bazy danych...'
cur.execute('DROP DATABASE DTS')

print 'Usunięto bazę.'
conn.close()
