# RuneMate TypeAdapters
### Gson TypeAdapters for commonly used RuneMate classes

#### Introduction
If you want to push your bot architecture a bit further and move your bot data to an external format such as json, you'll soon find out that crucial data types in the RuneMate API cannot be easily serialized and/or deserialized due to obfuscation.

In order to encourage bot authors to still migrate their data to an external format, I have written this library to help achieve that goal without everyone wasting lots of time writing their own type adapters for the same purpose.

#### Supported types
* `Coordinate`
* Any subtype of `Area`, with polymorphism in mind
  * `Area.Rectangular`
  * `Area.Circular`
  * `Area.Absolute`
  * `Area.Polygonal`

#### Usage
Registering the `RuneMateTypeAdapterFactory` will allow Gson to successfully serialize and deserialize any supported types. All you have left to do is let Gson do its magic.

