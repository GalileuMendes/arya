#!/usr/bin/env python

import requests, json, re, uuid
import RPi.GPIO as GPIO
from mfrc522 import SimpleMFRC522

def string2bits(s=''):
     array = [bin(ord(x))[2:].zfill(16) for x in s]
     result = []
     
     for i in array:
         result.append(finalString(i))
     
     return result

def finalString(str):
    
    size = 16 - len(str)    
    result = ""
    
    for i in range(size):
        result = result + '0'
    
    return result + str

def transformArrayToString(array):
    result = ""
    
    for i in array:
        result += i
    
    return result

reader = SimpleMFRC522()
request = None

try:
    print("Aproxime sua TAG: ")
    id, text = reader.read()
    
    endMac = ':'.join(re.findall('..', '%012x' % uuid.getnode()))
    
    payload = {'mac': endMac}
    request1 = requests.get('http://10.0.2.168:8080/api/device/mac', params=payload)
    
    objeto = request1.json()
    resultIdAdress = objeto[0]
    
    #str(resultIdAdress['id'])
    
    s = string2bits(text[0:6])    
    result = transformArrayToString(s)
    
    
    adress = 'http://10.0.2.168:8080/api/location/' + '1' + '/epc'
    
    request2 = requests.post(adress, data=result)
        
    print("Lido com Sucesso!")
    print("ID da TAG: " + str(id))
    print("EPC da TAG em modo String: " + text)
    print("EPC Arya: ")
    print(result)

finally:
    GPIO.cleanup()
