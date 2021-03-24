def version = MPLModule('Test Echo', CFG).'artifact.version'
echo "${version}"
OUT.'artifact_info.artifact.version' = version
//MPLPipelineConfigMerge(MPLModule('Test Echo', CFG).artifact_info)
print("global var from Echo "+ globalVars.name + " " + globalVars.nameMaps)