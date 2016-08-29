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
cur.execute('USE DTS')
print 'Czyszczenie bazy danych...'

clean = open('sql/clean.sql')
script = clean.read()
clean.close()

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

print 'Wyczyszczono dane.'
conn.commit()
conn.close()
