package com.rest.bshape.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ControllerLogger {

    @Around("execution(* com.rest.bshape.bodytype.BodyTypeController.*(..))") // metody w bodyTypeController są punktami przecięcia
    public Object logData(ProceedingJoinPoint joinPoint) throws Throwable { // metoda jest punktem przeciecia
        Arrays.stream(joinPoint.getArgs()) // pobraliśmy arugemnty metody i wypisalismy na tablicy
                .forEach(o -> System.out.println(o.toString())); // dla każdego parametru wypisuje
        Object proceed = joinPoint.proceed(); // wywołuje punkt przecięcia + zwraca wynik
        System.out.println(proceed); // wypisze adres w pamęci bo nie mamy tostringa w adno
        return proceed; // 7
    }




}
