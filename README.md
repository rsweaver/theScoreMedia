# theScoreMedia
Repo for interview take home assessment for theScoreMedia

Link to test scenario covered in assignment: [Verify Team Details on Info Tab](https://docs.google.com/document/d/1SjiK4f8M02ISsKFlbSwg6Ct_hkijnE9PmPDYhkPaao0/edit)

Test requirements:
1. Java11
2. Gradle on the machine that the tests will be executed on - [Installation guide here](https://gradle.org/install/)
3. Appium 2 server up and running on the machine
4. Android device emulator up and running (please have device name and android version on hand)

Run the tests:
Navigate to the root project folder in your cmd or bash terminal.  Enter the following code

`./gradlew test -Dandroid.version={your emulated device version} -Ddevice.name="{your emulated device name}"`
