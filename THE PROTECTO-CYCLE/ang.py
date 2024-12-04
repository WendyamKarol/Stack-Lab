import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)

##angle

ang=18
anD=21

GPIO.setup(ang, GPIO.IN)
GPIO.setup(anD, GPIO.IN)

##clignotant

L1=4
L2=3
L3=2

GPIO.setup(L1, GPIO.OUT)
GPIO.setup(L2, GPIO.OUT)
GPIO.setup(L3, GPIO.OUT)

L10=17
L20=27
L30=22    

GPIO.setup(L10, GPIO.OUT)
GPIO.setup(L20, GPIO.OUT)
GPIO.setup(L30, GPIO.OUT)

##feux

delayt = .1 
value = 0 # this variable will be used to store the ldr value
ldr = 20 #ldr is connected with pin number 7
led = 10 #led is connected with pin number 11
feu = 26 #feux centre

GPIO.setup(led, GPIO.OUT)
GPIO.setup(feu, GPIO.OUT)
GPIO.output(led, False) # keep led off by default 
GPIO.output(feu, False)

def rc_time (ldr):
    count = 0

    #Output on the pin for
    GPIO.setup(ldr, GPIO.OUT)
    GPIO.output(ldr, False)
    time.sleep(delayt)

    #Change the pin back to input
    GPIO.setup(ldr, GPIO.IN)

    #Count until the pin goes high
    while (GPIO.input(ldr) == 0):
        count += 1

    return count

################################

while True:
	c1=GPIO.input(ang)
	c2=GPIO.input(anD)

	if c1 == 1 and c2 == 0:
        GPIO.output(L1, GPIO.HIGH)
        time.sleep(0.1)
        GPIO.output(L1, GPIO.LOW)
        GPIO.output(L2, GPIO.HIGH)
        time.sleep(0.1)
        GPIO.output(L2, GPIO.LOW)
        GPIO.output(L3, GPIO.HIGH)
        time.sleep(0.1)
        GPIO.output(L3, GPIO.LOW)
        time.sleep(0.2)

    elif c1 == 0 and c2	== 1:
        GPIO.output(L10, GPIO.HIGH)
        time.sleep(0.1)
        GPIO.output(L10, GPIO.LOW)
        GPIO.output(L20, GPIO.HIGH)
        time.sleep(0.1)
        GPIO.output(L20, GPIO.LOW)
        GPIO.output(L30, GPIO.HIGH)
        time.sleep(0.1)
        GPIO.output(L30, GPIO.LOW)
        time.sleep(0.2)
    else:
    	GPIO.output(L1, GPIO.LOW)
        GPIO.output(L2, GPIO.LOW)
        GPIO.output(L3, GPIO.LOW)

        GPIO.output(L10, GPIO.LOW)
        GPIO.output(L20, GPIO.LOW)
        GPIO.output(L30, GPIO.LOW)

##### feux
    print("Ldr Value:")
    value = rc_time(ldr)
    print(value)
    if ( value <= 10000 ):
        print("Lights are OFF")
        GPIO.output(led, False)
    if (value > 10000):
        print("Lights are ON")
        GPIO.output(led, True)
        GPIO.output(feu, True)
        time.sleep(0.1)
        GPIO.output(feu, False)
        time.sleep(0.1)
        GPIO.output(feu, True)
        time.sleep(0.1)
        GPIO.output(feu, False)
        time.sleep(0.5)
