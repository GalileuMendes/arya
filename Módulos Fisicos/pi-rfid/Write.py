#!/usr/bin/env python

import requests, json
import RPi.GPIO as GPIO
from mfrc522 import SimpleMFRC522

def bits2string(b=None):
    return ''.join([chr(int(x, 2)) for x in b])


def transformStringToArray(str):
    
    array = []
    a = 0
    b = 16
    
    for i in range(6):
        
        strTemp = str[a:b]
        print(strTemp)
        array.append(strTemp)
        
        a = a + 16
        b = b + 16
    
    print (len(array))
    return array

reader = SimpleMFRC522()

try:
        epc = input("Digite o ID do EPC: ")
    
        r = requests.get('http://10.0.2.168:8080/api/epcarya/' + epc)
        object = r.json()
        str = object['epcArya']
        
        print("STR Original: " + str)
        
        result = bits2string(transformStringToArray(str))
        
        print("Aproxime sua TAG")
        reader.write(result)
        print(result)
        print("Gravação Realizada com Sucesso!!")

finally:
        GPIO.cleanup()
