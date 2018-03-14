# RuneMate TypeAdapters
### Gson TypeAdapters for commonly used RuneMate classes, brought to you by Team Prime

#### Introduction
If you want to push your bot architecture a bit further and move your bot data to an external format such as json, you'll soon find out that crucial data types in the RuneMate API cannot be easily serialized and/or deserialized.

In order to encourage bot authors to still migrate their data to an external format, I have written this library to help achieve that goal without everyone wasting lots of time writing their own type adapters for the same purpose.

#### Supported types
* `Coordinate`
* Any subtype of `Area`, with polymorphism in mind
  * `Area.Rectangular`
  * `Area.Circular`
  * `Area.Absolute`
  * `Area.Polygonal`

Feel free to hit me up if you'd like to see additional types supported!

#### Usage
```kotlin
val gson = GsonBuilder()
        // Additional options
        .registerTypeAdapterFactory(RuneMateTypeAdapterFactory)
        .create()
```
Registering the `RuneMateTypeAdapterFactory` will allow Gson to successfully serialize and deserialize any supported types. All you have left to do is let Gson do its magic.

#### Kotlin btw
As you have probably already noticed, this project is written purely in Kotlin, and when taking a look at the code you'll quickly see why. To further encourage authors to use Kotlin as their main programming language for bots, this project shall be an example for how elegantly many problems can be solved in comparison to the widely used Java.

__Have fun, your friend and helper Savior__