package com.pk.rpi.com.pk.rpi.gpio.waterpump.api;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
/*import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;*/

@RestController
@RequestMapping(value ="/pump")
class PumpController {
    // Map a pump id to a specific GPIO pin on the breadboard
    private static final Map<Integer, Integer> gpioPumpMapping;
    static {
        gpioPumpMapping = new HashMap<Integer, Integer>();
        gpioPumpMapping.put(1, 17);
        gpioPumpMapping.put(2, 3);
        gpioPumpMapping.put(3, 4);
    }

    private static Integer MaxRunningDuration = 10;
//    final GpioController gpio = GpioFactory.getInstance();

    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("/startPump/{pumpId}/{duration}")
    public String startPump(@PathVariable Integer pumpId, @PathVariable Integer duration) {
        Integer secondsToRun = duration <= MaxRunningDuration ? duration : MaxRunningDuration;
        Integer gpioPing = gpioPumpMapping.get(pumpId);
        return "Running pumpid: " + pumpId + " it's gpio ping: " + gpioPing + " for " + secondsToRun + " seconds.";
    }
}