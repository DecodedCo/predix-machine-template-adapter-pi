# predix-workshop-machine

Machine bundle for Predix workshop

# com.ge.predix.workshop.nodeconfig.json

Usage:

  JSON file for defining Raspberry Pi sensor configuration

Format:
Each object must have the following schema:
```json
{
  "nodeName": "<String>",
  "nodeType": "<String>",
  "nodePin": <Integer>
}
```

The String value for `nodeName` will be part of the sensor tag name.

The full tag name will be the `nodeName` value appended with `-<TagId>` from configuration file `com.ge.predix.solsvc.workshop.adapter.config`

The String value for `nodeType` can be one of the following: `Light, RotaryAngle, Button, Temperature, Humidity`

The Integer value for `nodePin` denotes the pin that the sensor is connected to on the Pi. The pin number corresponds to the number next to A or D for each analog or digital input on the GrovePi+ board. For analog sensors (Light & RotaryAngle), if the `nodePin` value is 1, the sensor should be connected to pin A1 on the board.

For digital sensors (Button, Temperature, & Humidity), if the `nodePin` value is 4, the sensor should be connected to pin D4 on the board. There should not be a value for `nodePin` that doesn't exist on the board - for example,
there are only A0, A1, and A2 as analog inputs and therefore for any analog sensors, there should only be `nodePin` values of 0, 1, or 2.

The `nodePin` values must be unique within all analog or all digital sensors. For example, two sensors, 1 analog and 1 digital, connecting to A2 and D2 both require "nodePin" value of 2, which is acceptable.

Two sensors that are both analog or both digital must have unique `nodePin` values unless you are using a combined Temperature and Humidity digital sensor.

Combined Temp & Humidity digital sensor must have the same `nodePin` value.