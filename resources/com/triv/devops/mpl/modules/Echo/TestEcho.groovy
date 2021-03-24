echo "testing sub module"
print("global var from Test Echo "+ globalVars.name + " " + globalVars.nameMaps)

globalVars.name = "newValue"
globalVars.nameMaps = ['name': "Test"]

OUT.'artifact.version' = 1
