To execute the Build provide the below Maven Goal:
clean verify serenity:aggregate

Cucumber Feature files:
...src\test\resources\feature\api.feature\api.feature
...src\test\resources\feature\api.feature\ui.feature

Serenity reports will be generated under:
...\target\site\serenity

Test Code under:
...\src\test\java\com\testapp

Cucumber test steps under:
...\src\test\java\com\testapp\cucumber\steps

